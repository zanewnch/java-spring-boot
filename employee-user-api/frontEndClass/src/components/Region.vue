<script setup lang="ts">
import {onMounted, ref} from "vue";
import request from "@/utils/request";
import Index from "@/components/bottom/index.vue";
import {GetApi} from "@/api/Api";
const getApi = new GetApi();
let regionArrRef = ref([]);
  onMounted(() => {
  // getRegionTem();
    getApi.getRegion(regionArrRef);
})

const regionArr = ref([]);
// const getRegionTem = async () => {
//   let result: any = await request.get(`/cmn/dict/findByDictCode/Beijin`);
//   console.log(result);
//   if(result.status === 200){
//       regionArr.value = result.data.data;
//   }
// }
const activeFlag = ref<string>('');
function changeRegion(regionValue:string){
  activeFlag.value = regionValue;
  $emit('getRegion',regionValue);
}

let $emit = defineEmits(['getRegion']);
</script>

<template>
  <div class="region">
    <h1>Region</h1>

    <div class="content">
      <div class="left">Region :</div>

      <ul class="RegionOption">
        <li :class="{active:activeFlag == ''}"
            @click="changeRegion('')"
        >All</li>
        <li
            v-for="(region,index) in regionArrRef"
            :key="region.value"
            :class="{active:activeFlag== region.value}"
            @click="changeRegion(region.value)"
        >
          {{ region.name }}
        </li>
      </ul>
    </div>
  </div>
</template>

<style scoped lang="scss">

.region {
  h1 {
    color: #7f7f7f;
    font-weight: 900;
    margin: 10px 0px;
  }

  .content {
    display: flex;

    .left {
      margin-right: 10px;
      width: 50px;

    }

    .RegionOption {
      display: flex;
      // 填滿後換行
      flex-wrap: wrap;

      li {

        margin-right: 10px;
        margin-bottom: 10px;

        &.active {
          color: #55a6fe;
        }
      }

      li:hover {
        color: #55a6fe;
        cursor: pointer;
      }
    }
  }
}
</style>