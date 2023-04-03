<template>
  <div class="search-container">    
    <img class="searchIcon" src="/images/searchButton.png" alt="Search Icon" @click="search" />
    <input type="text" placeholder="Search" v-model="searchQuery" />
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchQuery: "",
    };
  },
  methods: {
    search() {
      // Execute the search based on the value of `searchQuery`
      console.log(`Searching for "${this.searchQuery}"...`);
    },
  },
};
</script>

<style scoped>
.search-container {
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 20px;
  background-color: #f2f2f2;
  padding: 0.5rem;
  width: 35%;
  box-sizing: border-box;
  border: 2px solid black;
}

.searchIcon {
  height: 18px;
  margin-left: 5px;
}

.search-container input[type="text"] {
  flex: 1;
  border: none;
  outline: none;
  background-color: transparent;
  margin-left: 0.5rem;
  width: 100%;
  font-size: 14px;
}

.search-container .fa-search {
  margin-right: 0.5rem;
  color: #ccc;
}
</style>
