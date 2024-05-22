<script setup lang="ts">
import {usePaginationStore} from "@/stores/PaginationStore";
const paginationStore = usePaginationStore();
</script>

<template>
  <el-row>
    <el-col :span="24" class="paginationCol">

      <!--         原理是這樣 v-model 綁定了current-page and page-size, 也就代表這兩個parameter would dynamic change, 然後我的request method也是根據這兩個parameter去request, 然後當current-page change的時候就再次request,and page-size change的時候也是再次request 就可以達到分頁查詢的效果 -->
      <!--          page-sizes 那個選單 點選不同的level 會直接改變page-size parameter, 這也就是為什麼要用v-model-->
      <!--          當parameter would dynamic change的時候就要用v-model-->
      <el-pagination v-model:current-page="paginationStore.pageNum"
                      v-model:page-size="paginationStore.pageSize"
                     :page-sizes="[10, 20, 30, 40]"
                     :small="false"
                     :disabled="false"
                     :background="false"
                     layout="total, sizes, prev, pager, next, jumper"
                     :total="paginationStore.requestData?.data.totalDataAmounts"
                     @size-change="paginationStore.getEmployeesByPage()"
                     @current-change="paginationStore.getEmployeesByPage()"

                     class="pagination"
      />

    </el-col>
  </el-row>
</template>

<style scoped lang="scss">
.paginationCol {
  display: flex;
  justify-content: center;
  align-items: center;
}

:deep(.pagination) {
  width: 700px;


}
</style>