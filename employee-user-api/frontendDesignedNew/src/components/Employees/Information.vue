<script setup lang="ts">
import {useEmployeeStore} from "@/stores/EmployeeStore";
import {OfficeBuilding} from "@element-plus/icons-vue";

const employeeStore = useEmployeeStore();
</script>

<template>
  <div class="content">
    <el-row class="contentRow">
      <el-col :span="24" class="contentCol">
        <el-descriptions
            class="margin-top"
            title="Employee information"
            :column="3"
            :size="'large'"
            border
        >
          <template #extra>
            <el-button type="info" plain>Edit</el-button>
          </template>

          <el-descriptions-item>

            <template #label>
              <div class="cell-item">
                <el-icon :style="iconStyle">
                  <user/>
                </el-icon>
                Id:
              </div>
            </template>

            {{employeeStore.requestData?.[0].id}}
          </el-descriptions-item>

          <el-descriptions-item>
            <template #label>
              <div class="cell-item">
                <el-icon :style="iconStyle">
                  <iphone/>
                </el-icon>
                Name:
              </div>
            </template>
            {{employeeStore.requestData?.[0].name}}
          </el-descriptions-item>

          <el-descriptions-item>
            <template #label>
              <div class="cell-item">
                <el-icon :style="iconStyle">
                  <location/>
                </el-icon>
                Number:
              </div>
            </template>
            {{employeeStore.requestData?.[0].number}}
          </el-descriptions-item>

          <el-descriptions-item>
            <template #label>
              <div class="cell-item">
                <el-icon :style="iconStyle">
                  <tickets/>
                </el-icon>
                Age:
              </div>
            </template>
            {{employeeStore.requestData?.[0].age}}
          </el-descriptions-item>

          <el-descriptions-item>
            <template #label>
              <div class="cell-item">
                <el-icon :style="iconStyle">
                  <office-building/>
                </el-icon>
                Gender:
              </div>
            </template>
            {{employeeStore.requestData?.[0].gender}}
          </el-descriptions-item>

          <el-descriptions-item>
            <template #label>
              <div class="cell-item">
                <el-icon :style="iconStyle">
                  <office-building/>
                </el-icon>
                Create time:
              </div>
            </template>
            {{employeeStore.requestData?.[0].createTime}}

          </el-descriptions-item>

          <el-descriptions-item>
            <template #label>
              <div class="cell-item">
                <el-icon :style="iconStyle">
                  <office-building/>
                </el-icon>
                Update time:
              </div>
            </template>
            {{employeeStore.requestData?.[0].updateTime}}
          </el-descriptions-item>

        </el-descriptions>

      </el-col>
    </el-row>
  </div>

</template>

<style scoped lang="scss">

</style>