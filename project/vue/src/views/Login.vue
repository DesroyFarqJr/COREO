<template>

  <!--  -->
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
          </div>
          <!-- Google login OAuth button  -->
          <div class="googleBtnDiv">
            <div v-google-signin-button="clientId" class="google-signin-button">
                <img alt="Google sign-in"
                    src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png" />
                <span>Continue Login with Google</span>
            </div>
         </div>
         <!-- Google login OAuth button -->
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
import authService from "../services/AuthService"
import GoogleSignInButton from 'vue-google-signin-button-directive'


export default {
  directives: {
    GoogleSignInButton
  },
  
  name: "login", 
  components: {},
  data() {

    return {
      user: {},
        username: "",
        password: "",
        clientId: '825377734470-6ltc51va8eqarc6cg5ilt8qun3mk7416.apps.googleusercontent.com',
      invalidCredentials: false
      
    };
  },
  methods: {
    OnGoogleAuthSuccess (idToken) {
      console.log("Received idToken:", idToken);
      // Receive the idToken and make your magic with the backend
      if (!idToken) {
                    this.errorMesg = "Problem login to google."
                    return;
    }},
    OnGoogleAuthFail (error) {
      console.log(error)
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
.google-signin-button {
        width: inherit;
        padding: 3px;
        margin-left: auto;
        margin-right: auto;
        position: relative;
        display: inline-block;
        border: 1px solid #888;
        border-radius: 3px;
        background-color: transparent;
        outline: none;
        font-family: inherit;
        font-size: 13px;
        font-weight: normal;
        line-height: 1.15384615;
        text-align: center;
        text-decoration: none;
        cursor: pointer;
        user-select: none;
    }
.google-signin-button img {
        margin: 2px 15px 2px 20px;
        width: 20px;
        vertical-align: middle;
    }

    .googleBtnDiv {
        padding: 0;
        height: 50px;
        text-align: center;
    }

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
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  text-align: left;
}

.auth-inner {
  max-width: 450px;
  width: 100%;
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
  width: auto;
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
