<script setup lang="ts">
// 這裡放的是from element-plus copied, the completed note of original code

import {Message, Setting} from "@element-plus/icons-vue";
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

          <el-menu :default-openeds="['1', '3']">

            <el-sub-menu index="1">


              <template #title>

                <div class="text">
                  <el-icon>
                    <message/>
                  </el-icon>
                  Employee navigator One
                </div>

              </template>


              <el-menu-item-group>

                <!--                Vue的插槽 (slots) 允許您定義一個組件模板中的“佔位符”，然後在使用該組件的地方插入特定的內容。具名插槽允許您定義多個插槽，每個插槽都有一個名稱。-->
                <!--                <template #title> 和 <template v-slot:title> 在功能上是相同的。-->
                <!--                summary: 在別的地方customize vue slot, and uses template #slot name to import the slot-->
                <template #title>Group 1</template>

                <el-menu-item index="1-1" class="text">
                  Option1
                </el-menu-item>
                <el-menu-item index="1-2" class="text">Option 2</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="Group 2">
                <el-menu-item index="1-3" class="text">Option 3</el-menu-item>
              </el-menu-item-group>
              <el-sub-menu index="1-4">
                <template #title>
                  Option 4
                </template>
                <el-menu-item index="1-4-1" class="text">Option 4-1</el-menu-item>
              </el-sub-menu>
            </el-sub-menu>

            <el-sub-menu index="2">
              <template #title>
                <el-icon>
                  <icon-menu/>
                </el-icon>
                Employee navigator Two
              </template>

              <el-menu-item-group>
                <template #title>Group 1</template>

                <el-menu-item index="2-1" class="text">Option 1</el-menu-item>
                <el-menu-item index="2-2" class="text">Option 2</el-menu-item>

              </el-menu-item-group>

              <el-menu-item-group title="Group 2">

                <el-menu-item index="2-3" class="text">Option 3</el-menu-item>

              </el-menu-item-group>

              <el-sub-menu index="2-4">

                <template #title>Option 4</template>
                <el-menu-item index="2-4-1">Option 4-1</el-menu-item>

              </el-sub-menu>
            </el-sub-menu>

            <el-sub-menu index="3">
              <template #title>
                <el-icon>
                  <setting/>
                </el-icon>
                Employee navigator Three
              </template>
              <el-menu-item-group>
                <template #title>Group 1</template>
                <el-menu-item index="3-1" class="text">Option 1</el-menu-item>
                <el-menu-item index="3-2" class="text">Option 2</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="Group 2">
                <el-menu-item index="3-3" class="text">Option 3</el-menu-item>
              </el-menu-item-group>
              <el-sub-menu index="3-4">
                <template #title>Option 4</template>
                <el-menu-item index="3-4-1">Option 4-1</el-menu-item>
              </el-sub-menu>

            </el-sub-menu>

          </el-menu>

        </el-scrollbar>

      </el-aside>

      <el-main>
<!--        The data based on route rendered here-->
<!--        detail reservation notification-->
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

  .text {
    display: flex;
    justify-content: center;
    align-items: center;
  }
}

</style>