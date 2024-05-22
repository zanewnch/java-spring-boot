<script setup lang="ts">
import TopComponent from './components/top/index.vue'
import BottomComponent from './components/bottom/index.vue'


import Request from './utils/request';
import { onMounted } from "vue";

onMounted(()=>{
  // Request.get("/hosp/hospital/1/10").then(res=>{
  //   console.log("app Component request test",res);
  // })
})

</script>

<template>
  <!--  課程default-->
  <!--  <div class="container">-->
  <!--    &lt;!&ndash;    global top component&ndash;&gt;-->
  <!--    <TopComponent/>-->
  <!--    &lt;!&ndash;    router component&ndash;&gt;-->
  <!--    <div class="content">-->
  <!--      <router-view></router-view>-->
  <!--    </div>-->

  <!--    &lt;!&ndash;    global bottom component&ndash;&gt;-->
  <!--    <BottomComponent/>-->

  <!--  </div>-->

<!--  element-plus-->
  <div class="common-layout">
    <el-container>
      <el-header>
        <TopComponent/>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>

      <el-footer>
        <BottomComponent/>
      </el-footer>
      
    </el-container>
  </div>
</template>

<style scoped lang="scss">
// deep selector to set completely global css style
:deep * {
  border: solid 1px black;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;

  .content {
    width: 1200px;
    height: 700px;
    background-color: #f0f2f5;
    // The total height must divide the navigate bar height
    margin-top: 80px;
  }
}
</style>
