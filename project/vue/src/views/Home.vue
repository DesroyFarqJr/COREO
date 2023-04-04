<template>
 
  <div class="home"> 
    <div class="content">
    <div v-for="(video, index) in videos" :key="index">
     
    </div>
    <div ref="observer"></div>
  </div>
  </div>
</template>

<script>


export default {
  name: "Home", 
  

data() {
    return {
      videos: [],
      page: 1, // the initial page number
    };
  },
  created() {
    // Call an API to get the first set of videos on page load
    this.fetchVideos();
  },
  methods: {
    fetchVideos() {
      // Call an API to get more videos
      // with a page parameter indicating which page to load
      // and append the results to the current video list
      // e.g.:
      fetch(`/api/videos?page=${this.page}`)
        .then((response) => response.json())
        .then((data) => {
          this.videos = [...this.videos, ...data.videos];
          this.page++;
        });
    },
  },
  mounted() {
    // Set up an IntersectionObserver to detect when the user has scrolled to the bottom of the page
    const options = {
      rootMargin: "0px",
      threshold: 1.0,
    };
    const observer = new IntersectionObserver(([entry]) => {
      if (entry.isIntersecting) {
        this.fetchVideos();
      }
    }, options);
    observer.observe(this.$refs.observer);
  },
};
</script>

<style> 


</style>
