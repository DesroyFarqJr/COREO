import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'


Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

const app = Vue(App);
import gAuthPlugin from 'vue3-google-oauth2';
 let gauthClientId = '825377734470-6ltc51va8eqarc6cg5ilt8qun3mk7416.apps.googleusercontent.com';
 app.use(gAuthPlugin,{
  clientID: gauthClientId,
  scope:'email',
  prompt:'consent',
  })
app.mount('#app')