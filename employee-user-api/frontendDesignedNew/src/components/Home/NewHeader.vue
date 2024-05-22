<script setup lang="ts">

import { useRouter } from 'vue-router';


const router = useRouter();
const routerPush = (path:string) =>{
    router.push({
      path:`${path}`

    })
}


</script>

<template>
  <!--  用el-row 等於就是取代自己創建div 然後要設為display: flex and justify-content and align-items setting-->
  <el-row :justify="'start'" align="middle" class="header" >
    <el-col :span="1" :push="1">

      <img src="../../assets/management.png" alt="The company Logo" class="companyLogo" >

    </el-col>

    <el-col :span="4" :push="1">
      <p class="companyName">Management System</p>
    </el-col>

    <el-col :span="6" :push="12" class="right">
      
      <p>Help</p>
      <p @click="routerPush('/signIn')">Register</p>

      <div class='select'>
        <span>aaa</span>
        <span>bbb</span>

      </div>

    

      
        

    </el-col>




  </el-row>
</template>

<style scoped lang="scss">
.header{
  background-color: #0c69c6;



  .companyLogo{
    width: 50px;
    height: 50px;
  }

  p{
    font-size: 16px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    color: #f6f53c;
  }

  .right{
    display: flex;
    justify-content: space-around;
    align-items: center;
  }
}

.select{
  position:absolute;
  top: 100px;
  bottom: 0px;
  right: 0px;
  left: 0px;
}






</style>