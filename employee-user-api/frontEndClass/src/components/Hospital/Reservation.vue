<script setup lang="ts">

import {Avatar, Location} from "@element-plus/icons-vue";
import useDetailStore from "@/stores/modules/hospitalDetail";

let hospitalDetail = useDetailStore();

</script>

<template>
  <div class="top">
    <div class="title">{{ hospitalDetail.hospitalInfo.hospital?.hosname }}</div>
    <div class="level">
      <el-icon>
        <Avatar/>
      </el-icon>
      <span>{{ hospitalDetail.hospitalInfo.hospital.param?.hostypeString }}</span>
    </div>
  </div>

  <div class="content">
    <div class="left">
      <img :src="`data:image/jpeg;base64,`+hospitalDetail.hospitalInfo.hospital.logoData" alt="">
    </div>
    <div class="right">
      <div>Reservation Rule</div>
      <div class="time">
        <el-icon>
          <Clock/>
        </el-icon>
        <span>Release Time : {{ hospitalDetail.hospitalInfo.hospital.bookingRule?.releaseTime }}</span>
        <span>Quit Time : {{ hospitalDetail.hospitalInfo.hospital.bookingRule?.quitTime }}</span>
      </div>
      <div class="address">
        <span>Address : {{hospitalDetail.hospitalInfo.hospital.param?.fullAddress}}</span>
      </div>
      <div class="route">
        <span>Route : {{
          hospitalDetail.hospitalInfo.hospitail?.route}}</span>
      </div>
      <div class="cancel">
        <span>Cancel Deadline : {{ hospitalDetail.hospitalInfo.bookingRule?.quitTime}}</span>
      </div>
      <div class="rule" v-for="(item,index) in hospitalDetail.hospitalInfo.bookingRule?.rule" :key="index">{{ item }}</div>

    </div>
  </div>
</template>

<style scoped lang="scss">

.top {
  display: flex;
  justify-content: left;
  align-items: center;

  .title {

  }
}

.content {
  display: flex;
  justify-content: left;

  .left {
    margin-right: 30px;
    width: 80px;

    img {
      width: 80px;
      height: 80px;
    }
  }

  .right {
    flex: 1;
  }
}

</style>