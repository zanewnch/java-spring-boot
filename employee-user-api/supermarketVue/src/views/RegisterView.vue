<script lang="ts" setup>
// @ts-ignore
import {useRegisterStore} from "@/stores/RegisterStore";
import {onMounted} from "vue";

const registerStore = useRegisterStore();
onMounted(() => {
  registerStore.registrationDate = new Date('2023-01-15T10:30:00');
  registerStore.lastLoginDate = new Date('2023-01-15T10:30:00');
  registerStore.userStatus = "1";

})
</script>

<template>
  <div class="container">
    <div class="content">
      <el-row>
        <el-col>
          <el-input
              v-model="registerStore.username"
              class="input"
              size="large"
              placeholder="Username"
              clearable
          />
          <el-input
              v-model="registerStore.password"
              class="input"
              size="large"
              placeholder="Password"
              clearable
          />
          <button type="submit"
                  @click="registerStore.register(registerStore.username,registerStore.password,registerStore.registrationDate,registerStore.lastLoginDate,registerStore.userStatus)">
            submit
          </button>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<style scoped lang="scss">

</style>