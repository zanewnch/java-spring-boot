<script setup lang="ts">

//@ts-ignore
import Level from "@/components/level.vue";
import Region from "@/components/Region.vue";
import Card from "@/components/Card.vue";
import {ref, onMounted} from "vue";
import {reqHospital} from "@/api/Home";
import type {HospitalDetail, HospitalDetailArr, HospitalResData} from "@/api/type";
import request from "@/utils/request";
import {GetApi} from "@/api/Api";
import Tips from "@/components/Tips.vue";
// The page number for pagination
let pageNum = ref<number>(1);
// How many page showed in same page
let pageSize = ref<number>(10);
// store the exist data with array
let hospitalArr = ref<HospitalDetailArr>([]);
// store the total number of data
let hospitalTotalNum= ref<number>(0);



const getApi = new GetApi();
let pageNumRef = ref<number>(1);
let pageSizeRef = ref<number>(10);
let hospitalArrRef = ref([]);
let hospitalTotalNumRef = ref<number>(0);
let hostypeRef = ref<string>('');
let districtCode = ref<string>('');

/*
When page is loaded, we need to get data
 */
onMounted(() => {
  // getHospitalInfo();
  // getHospitalInfoTem();
  getApi.getCardInfo(pageNumRef,pageSizeRef,hospitalArrRef,hospitalTotalNumRef);
  console.log(hospitalArr)

})

// const getHospitalInfoTem = async () => {
//   let result:any = await request.get("/hosp/hospital/" + `${pageNum.value}/${pageSize.value}?hostype=${hostype}&districtCode=${districtCode}`)
//   console.log(result)
//
//   if (result.data.code === 200) {
//     hospitalArr.value = result.data.data.content;
//     hospitalTotalNum.value = result.data.data.totalElements;
//   }
//
// }

// const getHospitalInfo = async () => {
// //   get hospital information, the default page is 1
// //   which return the promise object, so need to add await and async
//
// //   let result:HospitalResData = await reqHospital(pageNum.value, pageSize.value);
//   let result:any = await reqHospital(pageNum.value, pageSize.value);
//
//
//   console.log(result.data);
//
//   if (result.data.code === 200) {
//     hospitalArr.value = result.data.data.content;
//     hospitalTotalNum.value = result.data.data.totalElements;
//   }
// }

/*
This callback function be invoked when page number of pagination has changed
 */
const currentChange = () => {
  getApi.getCardInfo(pageNumRef,pageSizeRef,hospitalArrRef,hospitalTotalNumRef);
}

/*
This callback function be invoked when 下拉選單 of pagination has changed
 */
const sizeChange = () =>{
  getApi.getCardInfo(pageNumRef,pageSizeRef,hospitalArrRef,hospitalTotalNumRef);
}
function getLevel(level:string){
  console.log(level); // 1 2 3 4 5
  hostypeRef.value = level;
  console.log(hostypeRef.value)
  getApi.getCardInfo(pageNumRef,pageSizeRef,hospitalArrRef,hospitalTotalNumRef,hostypeRef.value);
  console.log(hospitalArrRef.value)
}

function getRegion(region:string){
  districtCode.value = region;
  getApi.getCardInfo(pageNumRef,pageSizeRef,hospitalArrRef,hospitalTotalNumRef,'',districtCode.value);
}
</script>

<template>
  <!--  gutter: the space between element-->
  <!--  if don't use v-bind, vue.js will treat the value as a static string instead of an expression-->
  <el-row :gutter=20>

    <el-col :span="20">
      <!--      The hospital level-->
      <Level @getLevel="getLevel"/>
      <!--      The hospital region-->
      <Region
      @getRegion="getRegion"/>
      <!--      Show each hospital-->
      <div class="hospital" v-if="hospitalArrRef.length>0">
        <Card class="item" v-for="(item,index) in hospitalArrRef" :key="index" :hospitalInfo="item"/>
      </div>
      <div v-else>
        <el-empty description="No relative data"/>
      </div>

      <!--     pagination control -->
<!--      Through v-model, when element event is trigger, the ref value will auto change-->

      <!--      :small : (boolean) control whether use the small size pagination-->
      <!--      :disable : control whether make pagination invisible-->
      <!--      layout : this component is consist of lots of component, can order these component-->
      <!--      @size-change="handleSizeChange"-->
      <!-- @current-change="handleCurrentChange"-->
      <el-pagination
          v-model:current-page="pageNumRef"
          v-model:page-size="pageSizeRef"
          :page-sizes="[5, 20, 30, 40]"
          :small="false"
          :disabled="false"
          :background="true"
          layout="total, sizes, prev, pager, next, -> , jumper"
          :total="hospitalTotalNumRef"
          @current-change="currentChange()"
          @size-change="sizeChange()"

      />

    </el-col>

    <el-col :span="4">
      <Tips/>
    </el-col>

  </el-row>
</template>


<style scoped>

.hospital {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;

  .item {
    width: 48%;
    margin: 10px 0px;
  }
}

</style>