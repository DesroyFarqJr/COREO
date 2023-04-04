import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import ForYou from '../views/ForYou.vue'
import Profile from '../views/Profile.vue'
import Friends from '../views/Friends.vue'
import Trending from '../views/Trending.vue'
import TopPosts from '../views/TopPosts.vue'
import SuggestedAccounts from '../views/SuggestedAccounts.vue'
import Following from '../views/Following.vue'
import Followers from '../views/Followers.vue'
import CloudinaryComp from '../components/CloudinaryComp.vue'
import Homes from '../views/Homes.vue'




Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    }, 
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },  
    { 
    path: "/for-you",
    name: "for-you",
    component: ForYou,
    meta: {
      requiresAuth: true
    }
   },
    { 
    path: "/profile",
    name: "profile",
    component: Profile,
    meta: {
      requiresAuth: false
    }
   },

    {
      path: '/friends',
      name: 'friends-posts',
      component: Friends,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/trending',
      name: 'trending',
      component: Trending,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/top-posts',
      name: 'top-posts',
      component: TopPosts,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/suggested-accounts',
      name: 'suggested-accounts',
      component: SuggestedAccounts,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/following',
      name: 'following',
      component: Following,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/followers',
      name: 'followers',
      component: Followers,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/cloudinaryComp',
      name: 'CloudinaryComp',
      component: CloudinaryComp,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/homes',
      name: 'Homes',
      component: Homes,
      meta: {
        requiresAuth: false
      }
    },
  
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
