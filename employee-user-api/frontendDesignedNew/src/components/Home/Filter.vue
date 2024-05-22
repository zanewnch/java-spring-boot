<script setup lang="ts">
import {useEmployeeStore} from "@/stores/EmployeeStore";
const employeeStore = useEmployeeStore();
</script>

<template>
  <el-row :justify="'start'" :align="'middle'" class="filter">

    <el-col :span="3" class="title">
      <p>Department:</p>
    </el-col>

    <!--        設計邏輯是這樣：先設計一個activeDepartment variable, and which initial value is ''(empty string);-->
    <!--    {active:employeeStore.activeDepartment== ''}   這個{}代表是一個expression, className:condition,  if condition equal to true, then the element's className would be assigned,用這種方式來control條件css    -->
    <!--        最一開始是all,所以all need to highlight, and the other element should be inactive, so the other element use text:employeeStore.activeDepartment=='' -->
    <el-col :span="4"
            :class="{active:employeeStore.activeDepartment== '', text:employeeStore.activeDepartment!=''}"
            @click="employeeStore.setDepartmentInactive()">
      <p>All</p>
    </el-col>

    <el-col :span="4"
            v-for="department in employeeStore.employeeStatic.department" :key="department"
            @click="employeeStore.setDepartment(department)"
            :class="{text:employeeStore.activeDepartment=='' || employeeStore.activeDepartment!=department,active:employeeStore.activeDepartment==department}">

      <p>{{ department }}</p>

    </el-col>

  </el-row>

  <el-row :justify="'start'" :align="'middle'">

    <el-col :span="3" class="title">

      <p>Age:</p>

    </el-col>

    <el-col :span="4"
            @click="employeeStore.setAgeInactive()"
            :class="{active:employeeStore.activeAge=='',text:employeeStore.activeAge!=''}"
    >
      <p>All</p>
    </el-col>

    <el-col :span="4"
            v-for="age in employeeStore.employeeStatic.age" :key="age"
            @click="employeeStore.setAge(age)"
            :class="{active:employeeStore.activeAge==age,text:employeeStore.activeAge!=age || employeeStore.activeAge==''}"
    >
      <p>{{ age }}</p>
    </el-col>


  </el-row>

  <el-row :justify="'start'" :align="'middle'">
    <el-col :span="3" class="title">

      <p>Gender:</p>

    </el-col>

    <el-col :span="4"
            @click="employeeStore.setGenderInactive()"
            :class="{active:employeeStore.activeGender == '',text:employeeStore.activeGender!=''}">
      <p>All</p>
    </el-col>

    <el-col :span="4"
            v-for="gender in employeeStore.employeeStatic.gender" :key="gender"
            @click="employeeStore.setGender(gender)"
            :class="{active:employeeStore.activeGender==gender, text:employeeStore.activeGender!=gender || employeeStore.activeGender==''}"
    >
      <p>{{ gender }}</p>
    </el-col>

  </el-row>
</template>

<style scoped lang="scss">

.title {
  display: flex;
  justify-content: start;
  align-items: center;

}


.text {
  display: flex;
  justify-content: center;
  align-items: center;

  flex-wrap: wrap;
}

.text:hover {
  color: #0c69c6;
  cursor: pointer;
}

.active {
  display: flex;
  justify-content: center;
  align-items: center;

  color: #0c69c6;
}

</style>