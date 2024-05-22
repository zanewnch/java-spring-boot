<script lang="ts" setup>
import { ref } from 'vue'

// todo: 可以用navigation 來寫右上角的選單

const activeIndex = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

/*
  el-menu:
  :default-active="activeIndex"：这个属性用于设置默认选中的菜单项。您需要将一个在菜单项中定义的 name 属性的值赋给 activeIndex，以确保页面加载时显示特定的菜单项为选中状态。

  class="el-menu-demo"：这是为 el-menu 组件添加的自定义 CSS 类，它可以用来对菜单进行样式定制。在您的 CSS 文件中，您可以使用 .el-menu-demo 类选择器来定义特定的样式规则。

  mode="horizontal"：mode 属性用于设置菜单的显示模式。在这里，它被设置为 "horizontal"，表示菜单将以水平方式显示，通常用于顶部导航栏。

  :ellipsis="false"：这个属性用于控制菜单项文本是否截断显示。如果设置为 false，则文本不会截断，而是显示完整的文本。如果设置为 true，则文本可能会被截断以适应菜单项的宽度。

  @select="handleSelect"：这是一个事件监听器，用于捕获菜单项被选中的事件。当用户选择菜单项时，会触发 select 事件，然后调用 handleSelect 方法来处理所选的菜单项。
  */
</script>

<template>
  <div class="container">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      :ellipsis="false"
      @select="handleSelect"
    >
      <el-menu-item index="0">
        <img src="../../../public/crisis-management.png" alt="Management logo" class="logo" />
      </el-menu-item>

      <el-menu-item index="1">
        <router-link to="/" class="routerLink"> Management System </router-link>
      </el-menu-item>

      <div class="flex-grow" />

      <el-menu-item index="1" style="margin-right: 10px">
        <router-link to="/login" class="routerLink"> Sign in</router-link>
      </el-menu-item>

      <el-sub-menu index="2">
        <template #title>Setting</template>

        <el-menu-item index="2-1">item one</el-menu-item>

        <el-menu-item index="2-2">item two</el-menu-item>

        <el-menu-item index="2-3">item three</el-menu-item>

        <el-sub-menu index="2-4">
          <template #title>item four</template>
          <el-menu-item index="2-4-1">item one</el-menu-item>
          <el-menu-item index="2-4-2">item two</el-menu-item>
          <el-menu-item index="2-4-3">item three</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
    </el-menu>
  </div>
</template>

<style scoped lang="scss">
.container {
  height: 100px;
  width: 100%;

  .logo {
    width: 40px;
    height: 40px;

    margin-left: 30px;
  }

  .flex-grow {
    flex-grow: 1;
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
