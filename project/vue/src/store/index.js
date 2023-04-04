import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import apiService from "../services/APIService.js"

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    likes: Number,
    allPosts: [],
    favoritePosts: [],
    favoriteIds: [],
    profileImageUrl: '',
    allComments: [],
    ratings: [],
    currentPost: {},
    profile: {},
    userVideos:[],
    favoriteVideos: []
  },
  mutations: {
    ADD_FAV_VIDEOS(state, videoUrl){
      state.favoriteVideos.push(videoUrl)
    },

    REMOVE_FAV_VIDEOS(state, videoUrl){
      state.favoriteVideos=state.favoriteVideos.filter(video => video !=videoUrl)
    },

    SET_FAV_VIDEOS(state, videos){
      state.favoriteVideos = videos;
    },
    SET_USER_VIDEOS(state, videos){
      state.userVideos = videos;
    },

    ADD_VIDEO(state, videoUrl){
      state.userVideos.push(videoUrl);
    },

    REMOVE_VIDEO(state, videoUrl){
      state.userVideos=state.userVideos.filter(video => video !=videoUrl)
    },

    SET_COMMENTS(state, comments) {
      state.allComments = comments;
    },
    ADD_COMMENT(state, comment){
      state.allComments.push(comment);
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADD_LIKE(state, post) {
      apiService.displayPost(post.post_id).then(response => {
        if (response.status == 200) {
          post.likes = response.data.likes;
        }
      })
    },
    REMOVE_LIKE(state, post) {
      apiService.displayPost(post.post_id).then(response => {
        if (response.status == 200) {
          post.likes = response.data.likes;
        }
      })
    },
    SET_FAVORITES(state, favorites) {
      state.favoritePosts = favorites;
    },
    SET_ALL_POSTS(state, posts){
      state.allPosts = posts;
    },
    SET_FAV_IDS(state, favoriteIds) {
      state.favoriteIds = favoriteIds;
    },
    ADD_FAVORITE_POST(state, post) {
      state.favoritePosts.unshift(post);
      state.favoriteIds.unshift(post.post_id);
    },
    REMOVE_FAVORITE_POST(state, post) {
      const filtered = state.favoritePosts.filter(eachPost =>
        eachPost.post_id != post.post_id);
      state.favoritePosts = filtered;
      const index1 = state.favoriteIds.indexOf(post.post_id);
      if (index1 > -1) {
        state.favoriteIds.splice(index1, 1);
      }
    },
    SET_PROFILE_IMAGE_URL(state, newUrl) {
      state.profileImageUrl = newUrl
    },

    SET_PROFILE(state, profile){
      state.profile=profile;
    }
  },
})