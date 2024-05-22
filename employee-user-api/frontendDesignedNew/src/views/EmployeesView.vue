<script setup lang="ts">

import {User} from "@element-plus/icons-vue";
import {useRoute} from "vue-router";
import {onMounted} from "vue";
import {useEmployeeStore} from "@/stores/EmployeeStore";

// get current route data
const route = useRoute();

const employeeStore = useEmployeeStore();

onMounted(() => {
  // assign current page query string to employeeStore.employeeNumber
  employeeStore.employeeNumber = route.query.employeeNumber;

  // send request
  employeeStore.selectEmployeeByNumber(employeeStore.employeeNumber);
})


// 直接在view 這邊request data with onMounted, 然後request 完的data 會儲存在pinia store, sub-route 在直接invoke fetch data
// 為何要在此request 而不是在子路由request? 因為有三個子路由 不可能連接到一個子路由就request一次 所以統一先在parent-route request data

</script>

<template>
  <div class="common-layout">
    <el-container>

      <el-aside width="200px" class="aside">

        <!--  original el-menu structure chart

        element level:
        el-scrollbar ->
        el-menu ->
        el-sub-menu(foldable) ->
        el-menu-item-group(only for group name) ->
        el-menu-item(end node with exact page route)

        如果需要折疊，就用el-sub-menu
        不用折疊，就直接是el-menu-item

        但這邊有一個bug 就是el-sub-menu, el-menu-item-group
        都一定要用template #title才可以使用文字，而這個template #title 目前還找不到方法設定css

        el-scrollbar
        |
        |-- el-menu
           |
           |-- el-sub-menu (Navigator One)
           |   |
           |   |-- el-menu-item-group (Group 1)
           |   |   |
           |   |   |-- el-menu-item (Option 1)
           |   |   |-- el-menu-item (Option 2)
           |   |
           |   |-- el-menu-item-group (Group 2)
           |   |   |
           |   |   |-- el-menu-item (Option 3)
           |   |
           |   |-- el-sub-menu (Option 4)
           |       |
           |       |-- el-menu-item (Option 4-1)
           |
           |-- el-sub-menu (Navigator Two)
           |   |
           |   |-- el-menu-item-group (Group 1)
           |   |   |
           |   |   |-- el-menu-item (Option 1)
           |   |   |-- el-menu-item (Option 2)
           |   |
           |   |-- el-menu-item-group (Group 2)
           |   |   |
           |   |   |-- el-menu-item (Option 3)
           |   |
           |   |-- el-sub-menu (Option 4)
           |       |
           |       |-- el-menu-item (Option 4-1)
           |
           |-- el-sub-menu (Navigator Three)
               |
               |-- el-menu-item-group (Group 1)
               |   |
               |   |-- el-menu-item (Option 1)
               |   |-- el-menu-item (Option 2)
               |
               |-- el-menu-item-group (Group 2)
               |   |
               |   |-- el-menu-item (Option 3)
               |
               |-- el-sub-menu (Option 4)
                   |
                   |-- el-menu-item (Option 4-1)
        -->


        <el-scrollbar>

          <!--          set el-menu :router="true", el-menu-item 就會根據which index value('/employees/information') 進行路由跳轉-->
          <!--          :default-active: 就是預設是哪一個el-menu-item 會是highlight, 要根據當前路由去做選擇,然後 route.path 就會是 /employees/information 根據路由去做變化-->
          <el-menu
              :default-openeds="['1', '3']"
              :router="true"
              :default-active="route.path"
              active-text-color="#f6f53c"
              background-color="#0c69c6"
              text-color="#fff"
          >

            <el-sub-menu index="1">


              <!--                Vue的插槽 (slots) 允許您定義一個組件模板中的“佔位符”，然後在使用該組件的地方插入特定的內容。具名插槽允許您定義多個插槽，每個插槽都有一個名稱。-->
              <!--                <template #title> 和 <template v-slot:title> 在功能上是相同的。-->
              <!--                summary: 在別的地方customize vue slot, and uses template #slot name to import the slot-->
              <template #title>

                <div class="text">
                  <el-icon>
                    <User/>
                  </el-icon>
                  Employee navigator
                </div>

              </template>


              <el-menu-item-group title="Employee">


                <el-menu-item index="/employees/information">
                  Information
                </el-menu-item>

                <el-menu-item index="/employees/notification">
                  Notification
                </el-menu-item>

                <el-menu-item index="/employees/reservation">
                  Reservation
                </el-menu-item>

              </el-menu-item-group>

            </el-sub-menu>

          </el-menu>

        </el-scrollbar>

      </el-aside>

      <el-main class="main">
        <router-view/>
      </el-main>

    </el-container>
  </div>
</template>

<style scoped lang="scss">
.aside {
  position: fixed;
  z-index: 999;

  width: 300px;
  height: 100%;
  background-color: #0c69c6;

  .text {
    display: flex;
    justify-content: center;
    align-items: center;
  }
}

.main {
  margin-left: 300px;

}

</style>