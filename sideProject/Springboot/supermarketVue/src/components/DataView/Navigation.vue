<script lang="ts" setup>
import { Document, Menu as IconMenu, Location, Setting } from '@element-plus/icons-vue'

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

/*
el-menu:
open	展开指定的 sub-menu	index: 需要打开的 sub-menu 的 index
close	收起指定的 sub-menu	index: 需要收起的 sub-menu 的 index
 */
</script>

<template>
  <el-row class="elRow">
    <el-col :span="24" class="elCol">
      <el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
        class="el-menu-vertical-demo"
        default-active="2"
        text-color="#fff"
        @open="handleOpen"
        @close="handleClose"
      >
        <el-sub-menu index="1">
          <template #title>
            <el-icon>
              <location />
            </el-icon>
            <span>Navigator One</span>
          </template>
          <el-menu-item-group title="Group One">
            <el-menu-item index="1-1">item one</el-menu-item>
            <el-menu-item index="1-2">item two</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="Group Two">
            <el-menu-item index="1-3">item three</el-menu-item>
          </el-menu-item-group>
          <el-sub-menu index="1-4">
            <template #title>item four</template>
            <el-menu-item index="1-4-1">item one</el-menu-item>
          </el-sub-menu>
        </el-sub-menu>

        <el-menu-item index="2">
          <el-icon>
            <icon-menu />
          </el-icon>
          <span>Navigator Two</span>
        </el-menu-item>

        <el-menu-item index="3" disabled>
          <el-icon>
            <document />
          </el-icon>
          <span>Navigator Three</span>
        </el-menu-item>

        <el-menu-item index="4">
          <el-icon>
            <setting />
          </el-icon>
          <span>Navigator Four</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
</template>

<style scoped lang="scss">
.elRow{
  height:100%;
}
</style>
