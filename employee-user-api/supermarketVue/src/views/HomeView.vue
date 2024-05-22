<script lang="ts" setup>
// @ts-ignore
import Footer from '@/components/HomeView/Footer.vue'
// @ts-ignore
import Introduction from '@/components/HomeView/Content.vue'
// @ts-ignore
import Navigation from '@/components/HomeView/Navigation.vue'
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <Navigation />
      </el-header>

      <el-main>
        <Introduction />
      </el-main>

      <el-footer>
        <Footer />
      </el-footer>
    </el-container>
  </div>


</template>

<style scoped lang="scss">

</style>
