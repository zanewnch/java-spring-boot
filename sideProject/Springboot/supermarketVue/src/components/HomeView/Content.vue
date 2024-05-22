<!--suppress ALL -->
<script lang="ts" setup></script>

<template>
  <div class="container">
    <el-row>
      <el-col :span="24" class="elCol">
        <el-card class="box-card">
          <template #header>
            <div class="card-header">
              <span>Function</span>
            </div>
          </template>
          <div class="text item">
            <router-link to="/data" class="routerLink">Data
            </router-link>
          </div>
          <div class="text item">function 1</div>
          <div class="text item">function 1</div>
          <div class="text item">function 1</div>
        </el-card>

        <el-card class="box-card">
          <template #header>
            <div class="card-header">
              <span>Report</span>
            </div>
          </template>
          <div v-for="reportNumber in 4" :key="reportNumber" class="item text">
            Report {{ reportNumber }}
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped lang="scss">
.container {
  height: 700px;
  width: 100%;

  .elCol {
    display: flex;
    justify-content: space-around;
    align-items: center;

    :deep(.box-card) {
      height: 300px;
      width: 200px;
      margin-top: 50px;

      .card-header {
        display: flex;
        justify-content: center;
        align-items: center;
      }

      // class="text item"
      // 代表這些元素可以有text and item 兩個className
      .item {
        margin-top: 18px;
        text-align: center;
      }
    }
  }

  .routerLink {
    color: black;
    text-decoration: none;
  }

  .routerLink:hover {
    color: #55a6fe;
    cursor: pointer;
  }
}
</style>
