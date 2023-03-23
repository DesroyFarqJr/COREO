<template>
    <div>
        <form id="form">
            <!-- container for side navigation buttons -->
            <div class="sideNav-container">
                <div class="one">
                <a href="/forYouPage" class="homeBtn">
                <img class="homeBtn" src="../../public/images/icons8-home-24.png" alt="homeBtn" />
                </a> <h2> For You</h2>
                </div>
            
            <div class="one">
            <a href="/friends" class="hugBtn">
            <img class="friendsPosts" src="../../public/images/icons8-hug-50.png" alt="friendsBtn" />
            </a><h2> Friends</h2>
            </div>
            <div class="one">
            <a href="/trending" class="starBtn">
            <img class="trending" src="../../public/images/icons8-pixel-star-50.png" alt="friendsBtn" />
            </a><h2> Top Posts</h2></div>
</div>
<hr class="lineBreak" > 
<h4> Log in to follow creators, like videos, and view comments</h4>

<!--  hr adds line breaks between sections -->
<button class="btn-secondary" type="submit">Login</button>
<!-- hr adds line breaks between sections -->

<hr class="lineBreak"> 
<h4> Suggested Accounts</h4>
<!-- Logic goes here to show popular accounts -->
<div>
<a href="/friends" class="hugBtn">
<img class="placeholder" src="../../public/images/placeholderimg.png" alt="placeholder"/></a>
</div>
<h3>See all</h3>
<hr class="lineBreak"> 
<h3> Discover</h3>
        </form>

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
@import url("https://fonts.googleleapis.com/css?family=Fira+Sans:400,500,600,700,800");

.sideNav-container img {
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
  height: auto;
  width: auto;
  padding: 0;
  margin: 0;
  left: 0;
  padding: 1em;;;
}
.sideNav-container{
    padding-top: 100px;
    
    margin: 0;
    font-family: sans-serif;

    display: flex;
  flex-direction: column;
}
h4{
    font-weight: 70;
    font-family: sans-serif;
    color: lightslategrey;
}
.one{
    display: inline-flex;

}
hr {
    text-align: left;
    max-width: 800px
}
hr.lineBreak{
    
  border: 0;
  border-top: 3px solid rgb(202, 202, 202);
  width: 400px;
  font-weight: lighter;
  margin: 0;
  padding-top: 5px;
  padding-bottom: 10px;

}
h2{
    color: rgb(71, 71, 71);
    font-weight: normal;
}
.btn-secondary {
  background-color: #7e28ff;
  font-style: strong;
  color: #f7f7f7;
  border: none;
  cursor: pointer;
  border: 0;
  font-family: sans-serif;
  border-radius: 4px;
  font-weight: 600;
  margin: 0 10px;
  width: 200px;
  height: 50px;
  padding: 10px 0;
  
  
  /* box-shadow: 0 0 20px rgba(104, 85, 224, 0.2); */
  transition: 0.4s;
  
}

button{
    padding-bottom: 20px;
}
.homeBtn img{
    height: 50px;
    width: 50px;
    padding: 1em;

}
h3{
   color: #7e28ff;
    font-weight: 600px;
    font-family: sans-serif;
}
</style>
