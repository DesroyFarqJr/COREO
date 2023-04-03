<template>
  <div id="side-nav">
    <router-link v-bind:to="{ name: 'for-you' }" class="main-three">
      <img class="homeBtn" src="/images/home.png" alt="homeBtn"/> For You
    </router-link>
    <router-link v-bind:to="{ name: 'friends-posts' }" class="main-three">
      <img class="friendsPosts" src="/images/hug.png" alt="friendsBtn"/> Friends
    </router-link>
    <router-link v-bind:to="{ name: 'top-posts' }" class="main-three">
      <img class="trending" src="/images/star.png" alt="topPostsBtn"/> Top Posts
    </router-link>    
    <hr class="lineBreak"> 
    <h3>Log in to follow creators, like videos, and view comments</h3>
    <router-link v-bind:to="{ name: 'login' }" class="btn-secondary">Log In</router-link>
    <hr class="lineBreak"> 
    <router-link v-bind:to="{ name: 'suggested-accounts' }" class="suggested" >Suggested Accounts</router-link>
    <hr class="lineBreak"> 
    <router-link v-bind:to="{ name: 'discover' }" class="suggested">Discover</router-link>
  </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  setup() {
  },
})
</script>

<style scoped>
#side-nav {
  position: relative;
  top: 35px;
  margin: 0;
  display: flex;
  flex-direction: column;
  max-width: 300px;
  font-size: 18px;
}


#side-nav > * {
  display: flex;
  align-items: center;
  text-decoration: none;
  color: #333;
  padding: 8px 16px;
}

#side-nav > hr {
  margin: 0;
  border: none;
  border-top: 3px solid #eee;
}


#side-nav > h3 {
  margin: 0;
  margin-top: -10px;
  margin-bottom: 15px;
  color: #7e28ff;
  font-size: 16px;
}

#side-nav > .suggested{
  margin: 0;
  margin-top: -10px;
  margin-bottom: 15px;
  color: #333;
  font-size: 15px;
}

.btn-secondary {
  background-color: #e1dfdf;
  color: #080609;
  border: 2px solid #7e28ff;
  cursor: pointer;
  padding-top: 15px;
  padding-bottom: 15px;
  font-size: 15px;
  transition: background-color 0.3s ease, color 0.3s ease;
  margin: 0 auto;
  margin-bottom: 15px;
  border-radius: 0px;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 150px;
}


#side-nav .btn-secondary:hover {  
  background-color: #7e28ff;
  color: #ffffff;
}

#side-nav > a > img {
  height: 33px;
  width: 33px;
  margin-right: 8px;
}

#side-nav > .main-three:hover{ 
  background-color: #6564640f;
}
</style>
