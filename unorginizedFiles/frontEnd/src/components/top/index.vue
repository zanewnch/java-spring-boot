<template>
  <div class="top">

    <div class="content">
      <div class="left" @click="goHomePage">
        <img src="public/hotel-bell.ico" alt="">
        <p>Integrated Reservation Platform</p>
      </div>

      <div class="right">
        <p class="help">Help</p>
        <p class="login">Login/Register</p>
      </div>
    </div>


  </div>
</template>

<script setup lang="ts">
import {useRouter} from "vue-router";

let $router = useRouter();
function goHomePage(){
  $router.push({path:'/'})
}
</script>

<style scoped lang="scss">

.top{
  width: 100%;
  height: 10%;
  background-color: #FFFFFF;
  // unknown
  display: flex;
  justify-content: center;
  position: fixed;
  z-index: 999;

  // .top.content (inner element)
  .content{
    width: 100%;
    height: 100%;
    background-color: #f0f2f5;
    font-size: 20px;
    //
    display: flex;
    justify-content: space-between;

    .left{
      //
      display: flex;
      justify-content: center;
      align-items: center;
      img{
        height: 50px;
        width: 50px;

        margin-right: 10px;
      }
      p{
        font-size: 20px;
        color: #55a6fe;
      }
    }
    .right{
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 16px;
      color: #bbb;

      .help{
        margin-right: 10px;
      }
    }
  }


}
</style>