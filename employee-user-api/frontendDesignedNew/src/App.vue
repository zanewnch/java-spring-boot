<script setup lang="ts">

import Header from "@/components/Home/Header.vue";
import Footer from "@/components/Home/Footer.vue";
</script>

<template>

  <router-view/>

</template>

<style lang="scss">
body{
  margin: 0;
  padding: 0;
}

*{
  border: solid 1px black;

  // Setting box-sizing to border-box ensures that the padding and border are included in the element's total width and height.
  box-sizing: border-box;
}



</style>