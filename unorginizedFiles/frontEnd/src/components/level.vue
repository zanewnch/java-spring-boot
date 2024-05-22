<script setup lang="ts">
import {reqHospitalLevelAndRegion} from "@/api/Home";
import {onMounted, ref} from "vue";
import type {HospitalLevelAndRegionResData, HospitalLevelAndRegionArr} from "@/api/type";
import request from "@/utils/request";
import {GetApi} from "@/api/Api";

const getApi = new GetApi();
let levelArrRef = ref([]);
onMounted(() => {
  // getLevel();
  // getLevelTem()
  getApi.getLevel(levelArrRef);
})

// emit v-on  props v-bind $router

// const getLevelTem = async () => {
//   let result: any = await request.get(`/cmn/dict/findByDictCode/HosType`);
//   console.log(result)
//   if (result.status === 200) {
//     levelArr.value = result.data.data;
//   }
// }

/*
const getLevel = async () =>{
  let result:HospitalLevelAndRegionResData =  await reqHospitalLevelAndRegion('HosType')

  console.log(result);

  if(result.data.code === 200){
    levelArr.value = result.data.data
  }
}
 */


// let levelArr:any = ref<HospitalLevelAndRegionArr>([]);
let levelArr: any = ref([]);

// control hospital level responsive highlight
let activeFlag = ref<string>('');

const changeLevel = (levelValue: string) => {
  // store the value of level to activeFlag.value
  // levelValue : 1,2,3,4,5
  activeFlag.value = levelValue;

//   trigger customize event: return level to parent component
  $emit('getLevel',levelValue);
}

let $emit = defineEmits(['getLevel']);

</script>

<template>
  <div class="level">
    <h1>Hospital</h1>

    <div class="content">
      <div class="left">Level :</div>

      <ul class="hospitalLevel">
        <li
            :class="{active:activeFlag==''}"
            @click="changeLevel('')"
        >
          ALL
        </li>
        <li
            :class="{active:activeFlag == level.value}"
            v-for="(level,index) in levelArrRef" :key="level.value"
             @click="changeLevel(level.value)">
          {{ level.name }}
        </li>


      </ul>
    </div>

  </div>
</template>

<style scoped lang="scss">
.level {
  h1 {
    color: #7f7f7f;
    font-weight: 900;
    margin: 10px 0px;
  }

  .content {
    display: flex;

    .left {
      margin-right: 10px;

    }

    .hospitalLevel {
      display: flex;

      li {
        margin-right: 10px;

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