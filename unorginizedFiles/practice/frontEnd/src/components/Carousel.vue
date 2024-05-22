<script setup lang="ts">

</script>

<template>
  <!--    carousel-->
  <el-carousel height="350px">
    <el-carousel-item v-for="item in 4" :key="item">
      <!--        <h3 class="small justify-center" text="2xl">{{ item }}</h3>-->
      <img src="../../public/project-management-header.png" alt="">
    </el-carousel-item>
  </el-carousel>

</template>

<style scoped lang="scss">
img{
  width: 100%;
  //height: 350px;
}

</style>