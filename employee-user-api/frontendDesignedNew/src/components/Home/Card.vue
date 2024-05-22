<script setup lang="ts">
import {usePaginationStore} from "@/stores/PaginationStore";
import { onMounted } from 'vue';

import {useRouter} from "vue-router";

const paginationStore = usePaginationStore();

onMounted(() => {
  paginationStore.getEmployeesByPage();
})

// router 不能設立在pinia store 也不能設立在method裡面，一定要設立在.vue script
const router = useRouter();

const routerPush = (employeeNumber:number) =>{

  router.push({
    path: '/employees/information',
    query:{
      employeeNumber: employeeNumber
    }
  })
}


</script>

<template>
  <el-row class="detailContent" :gutter="20">

    <!--        因為backend response 是PageBean, which has two field,the exact data is selectEmployees-->
    <!--    我現在要做路由跳轉，然後我那時候一直想要如何傳入employee.number as parameter of query string, 後來查到可以直接透過v-for建立的variable to do-->
    <el-col :span="12"
            v-for="employee in paginationStore.requestData?.data.selectEmployees" :key="employee"

    >

      <el-card class="box-card"
               shadow="always"
               @click="routerPush(employee.number)">
        <template #header>
          <div class="card-header">
            <span class="cardText">{{ employee?.name }}</span>
            <el-button class="cardText" text>Operation button</el-button>
          </div>
        </template>
        <div class="cardText">
          Number: {{ employee?.number }}
        </div>
        <div class="cardText">
          age: {{ employee?.age }}
        </div>
        <div class="cardText">
          CreateTime: {{ employee?.createTime }}
        </div>
        <div class="cardText">
          UpdataTime:{{ employee?.updateTime }}
        </div>


      </el-card>

    </el-col>

  </el-row>

</template>

<style scoped lang="scss">
.detailContent {
  margin-top: 20px;


  width: 100%;

  .cardText {
    font-family: 'Roboto Condensed', sans-serif;
  }


}
</style>