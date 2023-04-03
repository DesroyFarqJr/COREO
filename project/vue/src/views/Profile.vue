<template>
  <div class="container">
    <div class="profile">
      <div class="profile-image">
        <img src="/images/user.png" alt="Profile" />
      </div>
      <div class="profile-info">
        <div class="user-info">
          <h2 class="username">User</h2>
          <h1 class="name">User's Full Name</h1>
          <!-- <router-link to="/edit-profile" class="edit-profile">Edit profile</router-link> -->
        </div>
        <button class="follow-button" @click="toggleFollow" ref="followButton">{{ followButtonText }}</button>
        <div class="user-stats">
          <router-link to="/following" class="stat">
            <span class="count">40 </span>
            <span class="title">Following</span>
          </router-link>
          <router-link to="/followers" class="stat">
            <span class="count">150k </span>
            <span class="title">Followers</span>
          </router-link>
          <span class="stat">
            <span class="count">100B </span>
            <span class="title">Likes</span>
          </span>
        </div>
        <div class="user-description">
          <p>
            bio here link etc etc</p>
        </div>
        <div class="user-links">
          <router-link to="/videos" class="link">Videos</router-link>
          <router-link to="/liked-videos" class="link">Liked</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Profile",
  data() {
    return {
      isFollowing: false,
    };
  },
  methods: {
  toggleFollow() {
    this.isFollowing = !this.isFollowing;
    if (this.isFollowing) {
      this.$refs.followButton.classList.add("clicked");
    } else {
      this.$refs.followButton.classList.remove("clicked");
    }
  },
},

  computed: {
    followButtonClass() {
      if (this.isFollowing) {
        return "follow-button following";
      } else {
        return "follow-button";
      }
    },
    followButtonText() {
      if (this.isFollowing) {
        return "Following";
      } else {
        return "Follow";
      }
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #f7f7f7;
  height: 100vh;
  overflow: auto;
}

.profile {
  display: flex;
  align-items: center;
  padding: 20px;
  background-color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  width: 100%;
}

.profile-info {
  margin-left: 15px;
}

.profile-image {
  height: 75px;
  width: 80px;
  border-radius: 100%;
  overflow: hidden;
  border: 3px solid rgba(135, 135, 135, 0.381);
  margin-bottom: 120px;
  display: flex;
  justify-content: center;
}

.profile-image img {
  max-width: 150px;
  width: 100%;
}

.username{
  margin-bottom: 5px;
}

.name {
  font-size: 15px;
  margin: 0;
  font-weight: normal;
  margin-top: 0;
}

.follow-button {
  cursor: pointer;
  text-decoration: none;
  border: 0;
  border-radius: 0px;
  font-weight: 600;
  margin: 0 10px;
  padding: 10px 0;
  transition: 0.4s;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 135px; 
  background-color: #7e28ff;
  color: #f7f7f7;
  margin-top: 10px;
  margin-left: 0px;
}

.follow-button.following {
  background-color: #f7f7f7;
  color: #080609;
}

.follow-button.following:hover {
  background-color: #f7f7f7;
  color: #080609;
}

.user-stats {
display: flex;
justify-content: space-between;
margin-bottom: 10px;
width: 100%;
max-width: 400px;
margin-left: -15px;
margin-top: 30px;
}

.user-stats .stat {
text-align: center;
flex: 1;
margin-right: 16px;
}

.user-stats .following {
color: #080609;
}

.user-links {
display: flex;
justify-content: center;
margin-bottom: 32px;
}

.user-links a, .user-stats .stat {
color: inherit;
text-decoration: none;
}

.profile-description {
font-size: 16px;
text-align: center;
line-height: 1.5;
margin-bottom: 24px;
}

</style> 