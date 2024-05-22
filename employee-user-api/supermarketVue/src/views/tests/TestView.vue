<script lang="ts" setup>
// @ts-ignore
import {useSuperMarketSaleStore} from "@/stores/SupermarketSaleStore";
import {onMounted} from "vue";

// @ts-ignore
import SupermarketSale from "@/model/entity/SupermarketSale";

const superMarketSaleStore = useSuperMarketSaleStore();

onMounted(() => {
  superMarketSaleStore.pageNum = 1;
  superMarketSaleStore.pageSize = 10;

});

// todo: login frontend test

let supermarketSale1 =
    new SupermarketSale(
        null,
        "Z",
        "Z",
        "aaa",
        "aaa",
        "aaa",
        3.0,
        80,
        10.0,
        50.34,
        "2019-01-01T13:00:00",
        "2019-01-01T13:00:00",
        "aaa",
        100.0,
        5.34,
        5.21,
        5.13
    );

let supermarketSale2 =
    new SupermarketSale(
        1002,
        "Y",
        "Y",
        "aaa",
        "aaa",
        "aaa",
        3.0,
        80,
        10.0,
        50.34,
        "2019-01-01T13:00:00",
        "2019-01-01T13:00:00",
        "aaa",
        100.0,
        5.34,
        5.21,
        5.13
    );
</script>

<template>
  <div>
    <div>
      <button type="button" @click="superMarketSaleStore.get()">get</button>
      <button type="button" @click="superMarketSaleStore.create(supermarketSale1)">create</button>
      <button type="button" @click="superMarketSaleStore.update(supermarketSale2)">update</button>
      <button type="button" @click="superMarketSaleStore.delete(1002)">delete</button>
    </div>
  </div>
</template>

<style scoped lang="scss">

</style>