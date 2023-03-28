<template>

  <!-- Login box  -->
    <div class="auth-wrapper">
      <div class="auth-inner">
        <div id="login" class="text-center">
          <form class="form-signin" @submit.prevent="login">
            <h1 class="h3 mb-3 font-weight-normal">Log into Coreo</h1>
            <div
              class="alert alert-danger"
              role="alert"
              v-if="invalidCredentials" 
            >
              Invalid username and password!
            </div>
          <div class="authBox">
            <label for="username" class="sr-only">Username</label>
            <input
              type="text"
              id="username"
              class="form-control"
              placeholder="Username"
              v-model="user.username"
              required
              autofocus
            />
            <label for="password" class="sr-only">Password</label>
            <input
              type="password"
              id="password"
              class="form-control"
              placeholder="Password"
              v-model="user.password"
              required
            />
          
            <button class="reg" type="submit">Sign in</button>
          <div>
            <button>

            </button>
          </div>
          </div>
         
          <div class="button-container">
<router-link id="registration-link" :to="{ name: 'register' }"
              >Don't have an account?</router-link>
              <button class="signup" type="submit">Sign up</button>

          </div>
          
          
          </form>
        </div>
      </div>
    </div>



</template>

<script>
import authService from "../services/AuthService";
import { inject } from 'vue';


export default {
  
  name: "login", 
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
      
    };
  },
  setup() {
    const Vue3GoogleOauth = inject('Vue3GoogleOauth');

    return {
      Vue3GoogleOauth,
    };
  },

data() {
  return {
    user: '',
  }
},

  methods: {

    async handleSignIn() {
      const googleUser = await this.$Auth.signIn();


      if(!googleUser) {
        return null;
      }

      this.user = googleUser.getBasicProfile().getEmail();
    },

    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
@import url("https://fonts.googleleapis.com/css?family=Fira+Sans:400,500,600,700,800");
/*  */

/*  */
* {
  box-sizing: border-box;
}
body {
  background: #ffffff !important;
  min-height: 100vh;
  display: flex;
  font-weight: 400;
  font-family: "Fira Sans", sans-serif;
}

.authBox{
  display: flex;
  flex-direction: column;
  

}

input {
  margin-bottom: 12px
}

h1,
h2 h3,
h4,
h5,
h6,
label,
span {
  font-weight: bold;
  font-family: "Fira Sans", sans-serif;
  color: rgba(0, 0, 0, 0.685);
}

body,
html,
#app,
.auth-wrapper {
  width: 100%;
  height: 100%;
  display: flex;
  align-content: center;
  padding-top: 100px;
}

a {
  box-shadow: inset 0 0 0 0 #000000;
  color: #999999;
  padding: 0 0.25rem;
  margin: 0 -0.25rem;

}
/* a:hover {
  box-shadow: inset 179px 0 0 0 #ff0000;
  color: white;
} */

/* Presentational styles */
.forgotPass{
  
  display: flex;
  align-items: center;
  justify-content: center;
  color:#000000;
  font-size: small;
  font-weight: lighter;
  padding-top: 10px;
 

}
a {
  color: rgb(140, 139, 140);
  display: flex;
  align-items: center;
  justify-content: center;
  font-family: "Fira Sans", sans-serif;
  
  font-weight: 100;
  line-height: 1.5;
  text-decoration: none;
  flex-direction: row;
  flex-wrap: wrap;

  
}
.auth-wrapper {
  display: flex;
  justify-content: center;
  flex-direction: column;
  text-align: left;
}

.auth-inner {
  width: 450px;
  margin: auto;
  background: #ffffff;
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1), 0 0 0 transparent;  padding: 40px 55px 45px 55px;
  border-radius: 15px;
  transition: all 0.3s;
}

.auth-wrapper .form-control:focus {
  border-color: #a02021;
  box-shadow: none;
}

.auth-wrapper h3 {
  text-align: center;
  margin: 0;
  line-height: 1;
  padding-bottom: 20px;
}


/* .forgot-password,
.forgot-password a {
  text-align: right;
  font-size: 13px;
  padding-top: 10px;
  color: #7f7d7e;
  margin: 0;
}

.forgot-password a {
  color: #a02021;
} */

.button-container {
  display: flex;
  align-items: center;
  justify-content: center;
  padding-top: 30px;
}
.reg {
  
  background-color: #e8e7e7;
  color: #333;
  
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  margin: 0 0px;
  /* width: 100px; */
  padding: 10px 0;
  /* box-shadow: 0 0 20px rgba(104, 85, 224, 0.2); */
  
}
.signup {
  background-color: #7e28ff;
  font-style: strong;
  color: #f7f7f7;
  border: none;
  
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  margin: 0 10px;
  width: 100px;
  padding: 10px 0;
  /* box-shadow: 0 0 20px rgba(104, 85, 224, 0.2); */
  
}

.log {
  color: rgb(104, 85, 224);
  background-color: rgba(255, 255, 255, 1);
  border: 1px solid rgb(255, 0, 0);
  padding: 10px;
}

button:hover {
  color: white;
  
  box-shadow: 0 0 20px rgba(182, 0, 0, 0);
  background-color: rgb(122, 4, 240);
}
a:hover {
  color: white;
  
  box-shadow: 0 0 20px rgba(182, 0, 0, 0);
  color: rgb(122, 4, 240);
}


</style>
