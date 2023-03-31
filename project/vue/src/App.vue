<template>
  
  <div id="app">
    <div class="login">
    <div class="navbar">
    <a class="navbar-brand" href="#">
      <img src="../public/images/Coreo logo.png" alt="Logo">
    </a>
    <div class="search-container">
      <input type="text" placeholder="Search" />
     
      <img  class="searchIcon" src="../public/images/searchButton.png" alt="Search Icon">
    </div>
  
    <div class="button-container">
      <button class="btn btn-primary">Upload</button>
      <router-link class="btn btn-secondary" to="/login">Login</router-link>
    </div>
    </div>
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    
    <router-view />
    </div>
  </div>
</template>
<script>
export default {
  
  name: "login", 
  components: {
    
    
  },
  data() {
    return {
      invalidCredentials: false,
      
    };
  },
 
};
</script>
<style>
/* Top nav bar design settings */
.navbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 1rem;
  background-color: #fff;
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1), 0 0 0 transparent;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 999;
  height: 60px;
}
/* Logo customization */
.navbar-brand {
  display: flex;
  align-items: center;
  font-size: 1.5rem;
  font-weight: bold;
  text-decoration: none;
  
}

.navbar-brand img {
  height: 50px;
  margin-right: 0.5rem;
}
/* Search bar (npm installed fontawesome for search icon) */
.search-container {
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 20px;
  background-color: #f2f2f2;
  padding: 0.5rem;
  width: 40%;
  box-sizing: border-box;
}

.searchIcon{
  height: 18px;

}
.search-container input[type="text"] {
  flex: 1;
  border: none;
  outline: none;
  background-color: transparent;
  margin-left: 0.5rem;
  width: 100%;
}

.search-container .fa-search {
  margin-right: 0.5rem;
  color: #ccc;
}
/* Upload and Login button design */
.button-container {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding-right: 20px;
}
.btn {
  margin-left: 1rem;
}

.btn-primary {
  background-color: #e8e7e7;
  color: #333;
  cursor: pointer;
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  margin: 0 10px;
  width: 100px;
  padding: 10px 0;
  /* box-shadow: 0 0 20px rgba(104, 85, 224, 0.2); */
  transition: 0.4s;
}

.btn-secondary {
  background-color: #7e28ff;
  font-style: strong;
  color: #f7f7f7;
  border: none;
  cursor: pointer;
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  margin: 0 10px;
  width: 100px;
  padding: 10px 0;
  /* box-shadow: 0 0 20px rgba(104, 85, 224, 0.2); */
  transition: 0.4s;
  
}

.btn:hover {
  cursor: pointer;
}
/* Responsive CSS  */
@media (max-width: 768px) {
  .login {
    flex-direction: column;
    align-items: flex-start;
    padding: 1rem;
  }

  .search-container {
    margin: 1rem 0;
  }
}
</style>