<script setup lang="ts">
/*
accept parameter passed from parent component
hospitalInfo's value is each element in hospitalArr of parent component, which mean one hospital object
 */

import { useRouter } from "vue-router";

let props = defineProps(
    ['hospitalInfo']
);

let $router = useRouter();
function goDetail(){
  $router.push({path:'/hospital/reservation',query:{hoscode:props.hospitalInfo.hoscode}});
  console.log(props.hospitalInfo);
}
</script>

<template>
<!--  When click the card, turn out to hospital detail page(/hospital)-->
  <el-card class="box-card" shadow="hover" @click="goDetail">

    <div class="content">
      <div class="left">

        <div class="hospital_name">{{ hospitalInfo.hosname }}</div>

        <div class="tip">

          <div class="level">
            <el-icon :size="15" color="#7f7f7f" class="level_icon">
              <Notification/>
            </el-icon>
            <span>{{ hospitalInfo.param.hostypeString }}</span>
          </div>

          <div class="time">
            <el-icon :size="15" color="#7f7f7f" class="time_icon">
              <Clock/>
            </el-icon>
<!--            when hospitalInfo.bookingRule is not null then return .releaseTime-->
            <span>Release Time : {{ hospitalInfo.bookingRule?.releaseTime }}</span>
          </div>
        </div>

      </div>

      <div class="right">
        <img
            class="hospitalImg" :src="`data:image/jpeg;base64,${hospitalInfo.logoData}`"
            alt="The hospital image">
      </div>
    </div>
    <!--    <template #header>-->
    <!--      <div class="card-header">-->
    <!--        <span>Card name</span>-->
    <!--        <el-button class="button" text>Operation button</el-button>-->
    <!--      </div>-->
    <!--    </template>-->
    <!--    <div v-for="o in 4" :key="o" class="text item">{{ 'List item ' + o }}</div>-->
  </el-card>
</template>

<style scoped lang="scss">

.content {
  display: flex;
  justify-content: space-between;

  .left {
    width: 60%;

    .tip {
      color: #7f7f7f;
      margin-top: 30px;
      display: flex;
      /*
      justify-content 是x-axis(左右)對齊
       */
      justify-content: space-between;

      .level {
        display: flex;
        /*
        align-items 是y-axis(上下)對齊
         */
        align-items: center;

        span {
          margin-left: 5px;
        }
      }

      .time {
        display: flex;
        align-items: center;

        span {
          margin-left: 5px;
        }
      }


    }
  }

  .right {

    .hospitalImg {
      width: 50px;
      height: 50px;
    }
  }
}

</style>