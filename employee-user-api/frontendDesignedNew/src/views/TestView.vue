<script setup lang="ts">
import { usePaginationStore } from '@/stores/PaginationStore';
const paginationStore = usePaginationStore();


</script>

<template>
<div>{{paginationStore.requestData?.data}}</div>
<button @click='paginationStore.getEmployeesByPage'>test</button>
</template>

<style scoped lang="scss">



</style>