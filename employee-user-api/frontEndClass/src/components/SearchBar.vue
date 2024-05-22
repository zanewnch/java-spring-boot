<script setup lang="ts">

import {
  Check,
  Delete,
  Edit,
  Message,
  Search,
  Star
} from "@element-plus/icons-vue";
import { ref } from "vue";
import {GetApi} from "@/api/Api";
import {useRouter} from "vue-router";
import * as path from "path";
import * as querystring from "querystring";

let hospitalNameRef = ref<string>('');
let $router = useRouter();
const getApi = new GetApi();
function fetchData  (keyword:string,callBack:any){
//   When using finish typing search content, this function will be triggered, so we can request data in this function.
//   The keyword is user typing content, which is equal to hospitalNameRef(v-model).
//   and the callback function, callback: 一个回调函数，用于将匹配的选项返回给 el-autocomplete 组件，从而在下拉列表中展示供用户选择。
  getApi.getHospitalName(keyword,callBack);

}
// When click one of recommend option in search bar, trigger this function
function goDetail(item:any){
  console.log(item);
  $router.push({path:'/hospital/reservation',query:{hoscode:item.hoscode}});
}

</script>

<template>
  <div class="search">
    <el-autocomplete
        v-model="hospitalNameRef"
        :fetch-suggestions="fetchData"
        :trigger-on-focus="false"
        clearable
        class="el-input_wrapper"
        placeholder="Input Data to Search"
        @select="goDetail"
    />
    <el-button type="primary" :icon="Search" plain>Search</el-button>

  </div>
</template>

<!--scoped 的用意 就是scss 只在此component生效 不會影響global-->
<style scoped lang="scss">
.search {
  width: 100%;
  height: 50px;
  display: flex;
  // x-axis
  justify-content: center;
  // y-axis
  align-items: center;
  margin-top: 10px 0px;

  //  深度選擇器 deep selector
//  which is use to cross the scoped limit to change element css
  :deep(.el-input_wrapper){
    width: 600px;
    margin-right:10px;
  }

}

</style>