<script setup lang="ts">
// The new mean using the element-plus layout
</script>

<template>
  <el-row :justify="'start'" align="middle" class="footer">
    <el-col :span="4" :push="1">
      <p>Copyright © 2023 Zane Wang.</p>

    </el-col>

    <el-col :span="2" :push="12">
      <p>Contact Us</p>
    </el-col>

    <el-col :span="2" :push="12">
      <p>Self-Introduction</p>
    </el-col>
  </el-row>
</template>

<style scoped lang="scss">
.footer {
  background-color: #0c69c6;
  width: 100%;

  p {
    display: flex;
    justify-content: center;
    align-items: center;
    color: #f6f53c;
  }

}

</style>