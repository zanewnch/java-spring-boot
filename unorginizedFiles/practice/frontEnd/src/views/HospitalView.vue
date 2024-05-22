<script setup lang="ts">
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'

import {onMounted} from "vue";
import useDetailStore from '../stores/modules/hospitalDetail';
import {useRoute} from "vue-router";

// When finish mounted, ask pinia store to request the data, and store the data in store
let detailStore = useDetailStore();
let $route = useRoute();
onMounted(()=>{
  detailStore.getHospital($route.query.hoscode);
})

</script>
<template>



<el-row :justify="'space-between'" class="elRow">

  <el-col :span="4" >
  <div>
    <el-menu
        default-active="/hospital/reservation"
        class="el-menu-vertical-demo"
        :router="true"
    >
      <div class="top">
        <el-icon><icon-menu /></el-icon>
       <span>/ Navigation</span>
      </div>


      <el-menu-item index="/hospital/reservation">
        <el-icon><icon-menu /></el-icon>
        <span>Reservation</span>
      </el-menu-item>

      <el-menu-item index="/hospital/detail">
        <el-icon><document /></el-icon>
        <span>Hospital Detail</span>
      </el-menu-item>

      <el-menu-item index="/hospital/Notification">
        <el-icon><setting /></el-icon>
        <span>Reserving Notification</span>
      </el-menu-item>

      <el-menu-item index="/hospital/maintenance">
        <el-icon><setting /></el-icon>
        <span>Maintenance</span>
      </el-menu-item>

      <el-menu-item index="/hospital/query">
      <el-icon><setting /></el-icon>
      <span>Query</span>
    </el-menu-item>

    </el-menu>

  </div>
  </el-col>

  <el-col :span="20">
  <router-view></router-view>
  </el-col>
</el-row>
</template>

<style scoped>
.elRow{
  width: 100%;

  .top{
    display: flex;
    justify-content: center;
    color:#7f7f7f;

    span{
      margin-left: 10px;
    }
  }
}
</style>