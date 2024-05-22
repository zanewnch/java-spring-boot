<script setup lang="ts">


import NewHeader from "@/components/Home/NewHeader.vue";
import NewFooter from "@/components/Home/NewFooter.vue";
import Home from "@/components/Home/Home.vue";
import {useEmployeeStore} from "@/stores/EmployeeStore";
import {onMounted, toRaw} from "vue";


onMounted(
    () =>{

    }
)



</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header class="header"><NewHeader/></el-header>
      <el-main class="content"><Home/></el-main>
      <el-footer class="footer"><NewFooter/></el-footer>
    </el-container>
  </div>




</template>

<style scoped lang="scss">

.common-layout{
  .header{
    background-color: #0c69c6;

    position: fixed;
    z-index: 999;

    // the position:fixed would take it out of regular document flow,
    // so it is necessary to explicitly specify the width, otherwise all element of el-row would squeeze together.
    // the specific height is for router-view to make margin-top: 60px
    width: 100%;
    height: 60px;

  }

  .content{
    margin-top: 60px;
  }

  .footer{
    background-color: #0c69c6;
  }
}





</style>