<template>
    <div class="upload-main">
      <button class="upload-picture-button" type="button" v-on:click="upload">Upload a Video</button><br />
      <!-- <p v-if="urlPosted">Upload Complete!</p> -->
      <textarea
        v-if="this.$route.name != 'edit-profile'"
        class="mt-3"
        v-model="post.caption"
        placeholder="Add a caption..."
        id="caption-input"
        rows="3"
      ></textarea>
      <br />
      <button
        v-if="this.$route.name != 'edit-profile'"
        type="button"
        id="save-changes-button"
        class="btn btn-primary"
        data-dismiss="modal"
        v-on:click="addPost"
      >
        Save changes
      </button>
    </div>
  </template>
  
  <script>
  import apiService from "../services/APIService.js";
  export default {
    name: "CloudinaryComp",
    data() {
      return {
        myWidget: {},
        post: {
          video_url: "",
          username: "",
          likes: 0,
          caption: "",
        },
        urlPosted: false,
      };
    },
    methods: {
      upload() {
        if (this.myWidget) {
        this.myWidget.open();
      }
    },
      addPost() {
        if (this.post.video_url !== "") {
          this.post.username = this.$store.state.user.username;
          apiService.createPost(this.post).then((response) => {
            if (response.status == 200) {
              this.$store.commit("ADD_VIDEO", this.post.video_url)
              this.post.caption = "";
              this.post.video_url = "";
              this.$router.push(`/profile/${this.post.username}`);
              this.urlPosted = false;
            }
          });
        }
      },
    },
    mounted() {
      this.myWidget = window.cloudinary.createUploadWidget(
        {
          // Insert your cloud name and presets here,
          // see the documentation
          cloudName: "dzm5ior6h",
          uploadPreset: "ayuqrocz",
          max_files: 1,
        thumbnails: "#thumbnails",
        defaultSource: "local",
        keep_widget_open: true,

        styles: {
          // Make everything red to match red roost branding
          palette: {
            window: "#ffffff",
            sourceBg: "#EAEAEA",
            windowBorder: "#FF0000",
            tabIcon: "#000000",
            inactiveTabIcon: "#555a5f",
            menuIcons: "#555a5f",
            link: "#FF0000",
            action: "#339933",
            inProgress: "#FF0000",
            complete: "#339933",
            error: "#cc0000",
            textDark: "#000000",
            textLight: "#fcfffd",
          },
          fonts: {
            default: null,
            "'Fira Sans', sans-serif": {
              url: "https://fonts.googleapis.com/css?family=Fira+Sans",
              active: true,
            },
          },
        },
      },
        (error, result) => {
          if (!error && result && result.event === "success") {
            if (this.$route.name != "edit-profile") {
              this.post.video_url = result.info.url;
            } else {
              this.$store.commit("SET_PROFILE_IMAGE_URL", result.info.url);
            }
  
            this.urlPosted = true;
            this.message = "Image upload successful !!";
          }
        }
      );
    },
  };
  </script>
  
  <style>
  .upload-main {
    
  
  display: flex;
  align-content: end;
  justify-content: center;
  padding-top: 100px;
  padding-lefT: 200px;

  }
  .upload-picture-button {
    background-image: linear-gradient(to right, #7e28ff, #de46fc);
    color: white;
    border: none;
    border-radius: 8px;
    margin-left:auto;
    margin-right:auto;
    width:50%;
  }
  
  #save-changes-button {
    background-image: linear-gradient(to right, #7e28ff, #de46fc);
    border: none;
    color:aliceblue;
    margin-left:auto;
    margin-right:auto;
    width:50%;
  }
  </style>