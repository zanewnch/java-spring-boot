<script setup lang="ts">
import Carousel from "@/components/Carousel.vue";
import SearchBar from "@/components/SearchBar.vue";
import MainContent from "@/components/MainContent.vue";
</script>

<template>
  <div>
    <Carousel/>
    <SearchBar/>
    <MainContent/>
  </div>
</template>

<style scoped>
*{
  border: solid 1px black;
}
</style>