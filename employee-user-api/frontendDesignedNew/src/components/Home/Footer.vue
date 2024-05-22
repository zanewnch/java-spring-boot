<script setup lang="ts">

</script>

<template>

  <div class="Footer">

    <div class="left">
      <p class="copyRightText">Copyright © 2023 Zane Wang.</p>
    </div>

    <div class="right">
      <p class="Text">Contact Us</p>
      <p>Self-Introduction</p>
    </div>
  </div>

</template>

<style scoped lang="scss">
.Footer {
  width: 100%;
  height: 50px;

  background-color: #0c69c6;

  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;

  .left {
    width: 50%;
    color: #f6f53c;

    .copyRightText {
      display: flex;
      justify-content: center; /* 水平置中 */
      align-items: center; /* 垂直置中 */
    }

  }

  .right {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;

    width: 30%;
    color: #f6f53c;

    .Text{
      display: flex;
      justify-content: center; /* 水平置中 */
      align-items: center; /* 垂直置中 */
    }
  }
}
</style>