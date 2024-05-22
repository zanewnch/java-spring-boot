<script setup lang="ts">
import {useEmployeeStore} from "@/stores/EmployeeStore";
import {usePaginationStore} from "@/stores/PaginationStore";
import {onMounted} from "vue";
import Filter from "@/components/Home/Filter.vue";
import Pagination from "@/components/Home/Pagination.vue";
import Card from "@/components/Home/Card.vue";

const paginationStore = usePaginationStore();



// 在尚醫通p19 08:46分的時候給出了解答
// 之前一直遇到問題就是fetch data and fetch method 都寫在pinia store, 但fetch data initial value is null, system就會一直報錯(can't read the properties of undefined)，然後直到使用optional chaining的方式，才終於成功
// for example: <div>{{ employeeStore.employeeNew?.[0].id }}</div>

// optional chaining(可選鏈) 跟 ternary operator(三元運算符)是不一樣的
// 可選鏈 (Optional Chaining):
// 目的：允許你安全地從深層次的物件結構中讀取屬性，而不必擔心中間的某個層級可能是 null 或 undefined。
// 語法：使用 ?. 來進行鏈接。
// 範例：let zip = person?.address?.zip;
// 如果 person 或 person.address 為 null 或 undefined，zip 將被設置為 undefined。
// 三元運算子 (Ternary Operator):
//
// 目的：基於某個條件返回兩個不同的值之一。
// 語法：condition ? valueIfTrue : valueIfFalse
// 範例：let status = (age >= 18) ? 'adult' : 'minor';
// 如果 age 大於或等於 18，status 將被設置為 'adult'；否則，它將被設置為 'minor'。

</script>

<template>


  <el-row class="detail">

    <el-col :span="24">

      <Filter/>
      <Card/>
      <pagination/>

    </el-col>

  </el-row>


</template>

<style scoped lang="scss">

.detail {
  margin-top: 20px;
}

</style>