<script setup lang="ts">

</script>

<template>
  <div class="top">

    <div class="content">

      <div class="left">

        <img src="../../assets/management.png" alt="The company logo" class="companyLogo">

        <p class="companyName">Management System</p>

      </div>
      <div class="right">

        <p class="help">Help</p>

        <p class="login">Register</p>

      </div>

    </div>

  </div>
</template>

<style scoped lang="scss">

.top {
  // fixed 定位將元素固定在螢幕的一個位置，無論你是否滾動頁面，元素都會保持在同一位置。
  // z-index 屬性用於控制元素在疊放次序上的位置。
  //數值越大，元素越會出現在其他元素的上方。
  //此屬性只有在元素的 position 屬性設置為 fixed、absolute 或 relative 時才會生效。
  position: fixed;
  z-index: 999;

  width: 100%;
  height: 70px;
  //background-color: #FFFFFF;
  background-color: #0c69c6;

  .content {
    width: 100%;
    height: 70px;


    // make child-element flexible
    // justify-content: control the y-axis, space-between mean divided two child-element into left and right
    display: flex;
    justify-content: space-between;

    .left{

      // display 讓sub-element漂浮，justify-content做y-axis對齊，align-items做x-axis對齊
      display: flex;
      justify-content: space-around;
      align-items: center;
      width: 30%;

      .companyLogo{
        width: 50px;
        height: 50px;

        // 讓圖片跟文字拉開一點距離
        //margin-right: 10px;
      }

      .companyName{
        font-size: 20px;
        //color: #55a6fe;
        color: #f6f53c;
      }
    }
    .right{
      display: flex;
      justify-content: space-around;
      align-items: center;

      width: 40%;
      color: #f6f53c;
    }
  }
}

</style>