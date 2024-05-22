<script lang="ts" setup>
// @ts-ignore
import Navigation from '@/components/DataView/Navigation.vue'
// @ts-ignore
import Content from '@/components/DataView/Content.vue'
</script>

<template>
  <div class="container">
    <el-container>
      <el-aside width="200px" class="elAside">
        <Navigation />
      </el-aside>

      <el-main>
        <Content />
      </el-main>
    </el-container>
  </div>
</template>

<style scoped lang="scss">
.container {
  height: 700px;
  width: 100%;
}
</style>
