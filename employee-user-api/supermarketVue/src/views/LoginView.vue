<script lang="ts" setup>

// @ts-ignore
import {useLoginStore} from "@/stores/LoginStore";
import {Edit} from '@element-plus/icons-vue'

const loginStore = useLoginStore();


</script>

<template>
  <div class="container">
    <div class="content">
      <el-row class="elRow">
        <el-col :span="24" class="elCol">
          <p>Login</p>
          <el-input
              v-model="loginStore.username"
              class="input"
              size="large"
              :prefix-icon="Edit"
              clearable
          />
          <el-input
              v-model="loginStore.password"
              class="input"
              size="large"
              :prefix-icon="Edit"

              clearable
          />

          <button type="submit" @click="loginStore.login(loginStore.username,loginStore.password)">Submit</button>

        </el-col>
      </el-row>
    </div>
  </div>

</template>

<style scoped lang="scss">

.container {
  display: flex;
  justify-content: center;
  align-items: center;

  width: 100%;
  height: 100vh;
  background-color: #0c69c6;

  .content {
    width: 95%;
    height: 90%;

    display: flex;
    justify-content: center;
    align-items: center;
  }
}

</style>