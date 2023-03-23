<template>
    
<!-- Display video full screen -->
<div class="video-item"></div>
    
</template>
<script>

//Display video --> Upload videos --> Scroll thru videos //

//implement logic for infinite scroll on videos//

//implement logic to like/save videos (database)//

//implement logic to see/read comments (database)//


export default {
  name: "VideoItem",
  props: {
    // Pass in the video data as a prop
    video: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>

</style>
