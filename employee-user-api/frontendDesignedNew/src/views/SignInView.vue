<script setup lang="ts">
import {useSignStore} from "@/stores/SignStore";

const signStore = useSignStore();

</script>

<template>
  <div class="container">
    <el-row class="elRow">

      <el-col :span="24">
        

        <form @submit.prevent="signStore.signInAuthenticate(signStore.username,signStore.password)" class="form">
          <label class="warn" v-if="signStore.isVisible">The account or password is wrong !</label>
          <label class="text">Username:</label>
          <br>
          <input v-model="signStore.username" placeholder="Username..." type="text" class="input">
          <br>
          <label class="text">Password:</label>
          <br>
          <input v-model="signStore.password" placeholder="Password..." type="password" class="input">
          <br>

          <div class="button">

          <el-button type="info" native-type="submit"
          class="elButton">Submit</el-button>
          </div>


        </form>

      </el-col>

    </el-row>
  </div>
</template>

<style scoped lang="scss">
.container{
  display: flex;
  justify-content: center;
  align-items: center;

  height: 100vh;
  width: 100%;

  .elRow{
    //background-color: red;
    width: 50%;
    height: 60%;

    .form{
      display: flex;
      flex-direction: column;
      justify-content: center;

      .warn{
        font-size: 24px;
        font-weight: normal;
        height: 30px;

        display: flex;
        justify-content: center;
        color: red;
      }

      .text{
        font-size: 24px;
        font-weight: normal;
        height: 30px;

        display: flex;
        justify-content: center;

      }
      .input{
        width: 60%;
        height: 30px;

        font-size: 20px;



      }

      .button{
        display: flex;
        justify-content: center;

        margin-top:200px;

        :deep(.elButton){
          height: 50px;
        }
      }
    }
  }


}
</style>@/stores/SignStore