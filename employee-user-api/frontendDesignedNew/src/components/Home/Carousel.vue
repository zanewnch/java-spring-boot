<script setup lang="ts">

</script>

<template>
  <!--  carousel 輪播圖-->
  <el-row>
    <el-col :span="24">
      <el-carousel height="600px" :trigger="'click'" :indicator-position="'inside'">
        <el-carousel-item v-for="item in 4" :key="item">
          <img src="../../assets/what-is-management.webp" class="carouselImage" alt="The promotion image">
        </el-carousel-item>
      </el-carousel>
    </el-col>
  </el-row>
</template>

<style scoped lang="scss">
.carouselImage {
  height: 600px;
  width: 100%;
}
</style>