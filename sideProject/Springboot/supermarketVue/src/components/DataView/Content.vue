<!--suppress ALL -->
<script lang="ts" setup>
import { ref } from 'vue'
import { Search } from '@element-plus/icons-vue'
import {useSuperMarketSaleStore} from "@/stores/SupermarketSale";

const superMarketSaleStore = useSuperMarketSaleStore();

const input = ref('')

const value = ref('')

const options = [
  {
    value: 'Option1',
    label: 'Option1',
  },
  {
    value: 'Option2',
    label: 'Option2',
  },
  {
    value: 'Option3',
    label: 'Option3',
  },
  {
    value: 'Option4',
    label: 'Option4',
  },
  {
    value: 'Option5',
    label: 'Option5',
  },
]

const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
</script>

<template>
  <div class="container">
    <div class="content">
      <el-row class="elRowUp">

        <el-col :span="24" class="elColUp">
          <div class="column">
            <span class="searchTitle">Branch</span>
            <el-card shadow="hover" class="card">
              <el-input
                v-model="input"
                class="input"
                :prefix-icon="Search"
                size="large"
                clearable
              />
            </el-card>
          </div>

          <div class="column">
            <span class="searchTitle">City</span>
            <el-card shadow="hover" class="card">
              <el-input
                  v-model="input"
                  class="input"
                  :prefix-icon="Search"
                  size="large"
                  clearable
              />
            </el-card>
          </div>
          <div class="column">
            <span class="searchTitle">Customer Type</span>
            <el-select v-model="value" class="m-2" placeholder="Select" size="large">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
              />
            </el-select>
          </div>

          <div class="column">
            <button type="button" @click="superMarketSaleStore.read()">Search</button>
          </div>
        </el-col>

      </el-row>

      <el-row class="elRowDown">
        <el-col :span="24" class="elColDown">
          <el-table
              :data="tableData"
              style="width: 100%"
              height="500"
              class="table"
          >
            <el-table-column fixed
                             prop="date" label="Date" width="180" />
            <el-table-column prop="name" label="Name" width="180" />
            <el-table-column prop="address" label="Address" />
          </el-table>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<style scoped lang="scss">
.container {
  display: flex;
  justify-content: center;
  align-items: center;

  .content {
    width: 95%;
    height: 90%;


    .elRowUp{
      .elColUp {
        display: flex;
        align-items: center;
        justify-content: left;

        .column {
          display: flex;
          align-items: center;
          margin-right: 70px;

          .searchTitle {
            margin-right: 5px;
          }

          .card {
            width: 150px;

            .input {
              color: red;
            }
          }
        }
      }
    }

    .elRowDown{

      .elColDown{
        :deep(.table){
          width: 100%;
          height: 100%;
        }
      }
    }
  }
}
</style>
