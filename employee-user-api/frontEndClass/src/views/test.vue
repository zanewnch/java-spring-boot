<script setup lang="ts">

import {onMounted, ref} from "vue";
import {GetApi} from "@/api/Api";

const getApi = new GetApi();
let dataArr = ref([]);

onMounted(()=>{
  getApi.getLevel(dataArr);
})

</script>

<template>
<div>test content</div>
</template>

<style scoped>

</style>