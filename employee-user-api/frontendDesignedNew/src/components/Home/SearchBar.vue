<script setup lang="ts">
// The relative course is p.15 首頁根據關鍵字查詢

import {Search} from "@element-plus/icons-vue";
import {useSearchBarStore} from "@/stores/SearchBarStore";
import {onMounted} from "vue";

const searchBarStore = useSearchBarStore();
onMounted(() => {

})

const querySearch = (queryString: string, cb: any) => {
  // fetch data by queryString provided by user through v-model
  searchBarStore.getEmployeesBySearch(searchBarStore.searchBarContent);

  // extract the name key of request data
  // because the requestData could be null, so need to use if condition at the first
  // map method,because each element in fetchData array is an object, but I just need one key of the object, so need to use map method to manipulate the data
  if (searchBarStore.requestData != null) {
    //
    let result = searchBarStore.requestData.map(data => {
      return {
        value: data.name,
      }
    });

    console.log(result)
    // the parameter callback function need is an array
    cb(result);
  }

}


</script>

<template>
  <!--  form 搜索表單區-->
  <el-row :justify="'center'" :align="'middle'" class="form">

    <el-col :span="8" class="searchBar">
      <!--  因為是第三方組件，直接創建class然後使用scss是沒辦法套用的，所以要用deep selector-->

      <!--      這邊是寫完了，但是會有一個bug,如果有更改search bar content但是沒有click delete button, the suggestion would still the same,需要按下刪除鍵才會根據新的輸入內容去做suggestion-->
      <el-autocomplete
          v-model="searchBarStore.searchBarContent"
          :fetch-suggestions="querySearch"
          :trigger-on-focus="false"
          clearable
          placeholder="Please Input the search content..."
          class="search"
      />
    </el-col>

    <el-col :span="2">
      <el-button type="primary" size="large" :icon="Search">Search</el-button>
    </el-col>

  </el-row>
</template>

<style scoped lang="scss">
.form {
  height: 40px;
  width: 100%;

  margin-top: 20px;

  .searchBar {
    display: flex;
    justify-content: right;
    align-items: center;

    :deep(.search) {
      width: 400px;
    }
  }


}
</style>