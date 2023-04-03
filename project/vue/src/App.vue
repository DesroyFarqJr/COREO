<template>
  <div id="app">
    <div class="header">
      <router-link v-bind:to="{ name: 'home' }" class="logo">
        <img src="../public/images/Coreo logo.png" alt="logo" id="logo">
      </router-link>
      <!-- call the SearchBar component -->
      <SearchBar></SearchBar>
      <!-- this will be a router -->
      <div class="button-container">
        <button class="btn btn-primary">Upload</button>
        <router-link class="btn btn-secondary" to="/login">Login</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
    <div class="side-nav" v-if="$route.path !== '/login' && $route.path !== '/register'">
      <HomeSideNav></HomeSideNav>
    </div>
    <div class="content" id="content">
     <router-view /> 
    </div>
  </div>
</template>

<script>
import HomeSideNav from './components/HomeSideNav.vue';
import SearchBar from './components/SearchBar.vue';

export default {
  name: "app",
  components: {
    HomeSideNav,
    SearchBar,
  },
  data() {
    return {
      invalidCredentials: false,
    };
  },
};
</script>

<style>
@import url("https://fonts.googleleapis.com/css?family=Fira+Sans:400,500,600,700,800");

#app {
  display: grid; 
  grid-template-columns: 1fr 4fr; 
  grid-template-rows: 1fr 8fr; 
  gap: 0px 0px; 
  grid-template-areas: 
    "header header"
    "side-nav content"; 
}

.header {
  grid-area: header;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 10; 
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 1rem;
  background-color: #fff;
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1), 0 0 0 transparent;
  height: 60px;
}

.content {
  grid-area: content;
  position: relative;
  height: calc(100vh - 60px);
  overflow: auto;
} 

.side-nav{
  grid-area: side-nav;
  position: fixed;
  top: 60px;
}

/* Logo customization */
.logo{
  display: flex;
  align-items: center;
  font-size: 1.5rem;
  font-weight: bold;
  text-decoration: none;
}

.logo img {
  height: 50px;
  margin-right: 0.5rem;
}

/* Upload and Login button design */
.button-container {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding-right: 20px;
  width: 240px; /* add this */
}

.btn-primary, .btn-secondary {
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
  width: 100px; 
}

.btn-primary{
  background-color: #e8e7e7;
  color: #333;
}
.btn-secondary {
  background-color: #7e28ff;
  color: #f7f7f7;
}

.btn-primary:hover {
  background-color: #7e28ff;
  color: #ffffff;
}

.btn-secondary:hover {
  background-color: #e1dfdf;
  color: #080609;
}

/* Responsive CSS */
@media (max-width: 768px) {
.header {
flex-direction: column;
align-items: flex-start;
padding: 1rem;
}

.search-container {
margin: 1rem 0;
}
}

</style>