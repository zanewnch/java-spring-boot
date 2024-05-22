<!--suppress ALL -->
<script lang="ts" setup>
import {onMounted, ref} from 'vue'
import {Search} from '@element-plus/icons-vue'
import {useSuperMarketSaleStore} from "@/stores/SupermarketSaleStore";

// todo: get寫完，剩下其他三個功能 還有UI interface調整

const superMarketSaleStore = useSuperMarketSaleStore();

onMounted(() => {
  superMarketSaleStore.pageNum = 1;
  superMarketSaleStore.pageSize = 10;
  superMarketSaleStore.get();
});


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
                  v-model="superMarketSaleStore.branchInput"
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
                  v-model="superMarketSaleStore.cityInput"
                  class="input"
                  :prefix-icon="Search"
                  size="large"
                  clearable
              />
            </el-card>
          </div>
          <div class="column">
            <span class="searchTitle">Customer Type</span>
            <el-select v-model="superMarketSaleStore.customerTypeInput" class="m-2" placeholder="Select" size="large">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
              />
            </el-select>
          </div>

          <div class="column">

            <el-button
                type="info"
                text
                bg
                @click="superMarketSaleStore.read()"
            >search</el-button
            >
          </div>


        </el-col>

      </el-row>

      <el-row class="elRowDown">
        <el-col :span="24" class="elColDown">

          <el-table
              :data="superMarketSaleStore.requestData?.data.mapperReturnValue"
              style="width: 100%"
              height="500"
              class="table"
          >
            <el-table-column fixed
                             prop="id" label="id" width="180"/>

            <el-table-column fixed
                             prop="branch" label="branch" width="180"/>

            <el-table-column fixed
                             prop="customerType" label="customerType" width="180"/>
            <el-table-column fixed
                             prop="gender" label="gender" width="180"/>
            <el-table-column fixed
                             prop="productLine" label="productLine" width="180"/>

            <el-table-column fixed
                             prop="unitPrice" label="unitPrice" width="180"/>


            <el-table-column fixed
                             prop="quantity" label="quantity" width="180"/>

            <el-table-column fixed
                             prop="tax5Percent" label="tax5Percent" width="180"/>

            <el-table-column fixed
                             prop="total" label="total" width="180"/>

            <el-table-column fixed
                             prop="date" label="date" width="180"/>

            <el-table-column fixed
                             prop="time" label="time" width="180"/>

            <el-table-column fixed
                             prop="payment" label="payment" width="180"/>

            <el-table-column fixed
                             prop="cogs" label="cogs" width="180"/>

            <el-table-column fixed
                             prop="grossMarginPercentage" label="grossMarginPercentage" width="180"/>

            <el-table-column fixed
                             prop="grossIncome" label="grossIncome" width="180"/>

            <el-table-column fixed
                             prop="rating" label="rating" width="180"/>

          </el-table>

        </el-col>

        <el-col :span="24">


          <el-pagination
              v-model:current-page="superMarketSaleStore.pageNum"
              v-model:page-size="superMarketSaleStore.pageSize"
              :page-sizes="[5, 20, 30, 40]"
              :small="false"
              :disabled="false"
              :background="true"
              layout="total, sizes, prev, pager, next, -> , jumper"
              :total="superMarketSaleStore.requestData?.data.totalDataAmounts"
              @current-change="superMarketSaleStore.get()" @size-change="superMarketSaleStore.get()"

          />

        </el-col>

      </el-row>
    </div>
  </div>

  <div class="test">
    <button @click="superMarketSaleStore.create()">create test</button>
  </div>
</template>

<style scoped lang="scss">
.container {
  display: flex;
  justify-content: center;
  align-items: center;

  width: 100%;
  height: 100vh;


  .content {
    width: 95%;
    height: 90%;


    .elRowUp {
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

    .elRowDown {

      padding-top: 60px;

      .elColDown {
        :deep(.table) {
          width: 100%;
          height: 100%;
        }
      }
    }
  }
}
</style>
