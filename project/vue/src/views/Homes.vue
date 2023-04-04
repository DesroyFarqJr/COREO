<template>
    
    <div class="home d-flex">

    <div class="posts-container">
      <div class="post-container">
        <post
          class="each-post"
          v-for="post in this.$store.state.allPosts"
          v-bind:key="post.post_id"
          v-bind:post="post"
        />
      </div>
    </div>
    </div>
</template>

<script>
import apiService from "../services/APIService.js";
import post from "../components/Post.vue";

export default {
  name: "homes",
  components: {
    post,
  },
  data() {
    return {
      listOfPosts: [],
      userCurrent: this.$store.state.user.username,
    };
  },
  created() {
    apiService.displayPosts().then((response) => {
      this.listOfPosts = response.data;
      this.$store.commit("SET_ALL_POSTS", response.data);
    });
    apiService
      .displayFavoritePosts(this.$store.state.user.username)
      .then((response) => {
        this.$store.commit("SET_FAVORITES", response.data);
      });
    apiService.displayFavoritePhotos(this.$store.state.user.username).then(response=>{
      if(response.status==200){
        this.$store.commit("SET_FAV_VIDEOS", response.data)
      }
    });  
    apiService
      .displayFavoriteIds(this.$store.state.user.username)
      .then((response) => {
        this.$store.commit("SET_FAV_IDS", response.data);
      });
  },
}
</script>

<style>

.posts-container {
  margin-right: auto;
  margin-left: 22.5%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-items: center;
  /* border:1px black solid; */
}

.each-post {
  margin-top: 20px;
  margin-bottom: 40px;
  border-bottom: 1px solid rgb(223, 218, 218);
}
</style>
