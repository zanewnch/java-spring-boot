<template>
  <div class="bottom">
    <div class="content">
      <div class="left">
        Copyright by Zane
      </div>
      <div class="right">
        <span>Contact Us</span>
        <span>Our Partner</span>
        <span>User Policy</span>
        <span>Private Policy</span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">

</script>

<style scoped lang="scss">
.bottom{
  width: 100%;
  height: 50px;
  background-color: #f0f2f5;
  //
  display: flex;
  //align-items: center;
  justify-content: center;
  .content{
    width: 1200px;
    height: 100%;
    background-color: #f0f2f5;
    font-size: 14px;
    //
    display: flex;
    justify-content: space-between;
    align-items: center;

    .right{
      span{
        // left and right
        margin: 0px 5px;
      }
    }
  }
}

</style>