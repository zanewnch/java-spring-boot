<script setup lang="ts">

</script>

<template>
  <div class="tip">
    <div class="department">
      <div class="header">
        <div class="left">
          <img src="../../public/hotel-bell.ico" alt="The image of department">
          <span>Department</span>
        </div>
        <div class="right">
          <span>All</span>
          <el-icon>
            <ArrowRightBold/>
          </el-icon>

        </div>
      </div>

      <div class="content">
        <ul>
          <li>神經內科</li>
          <li>消化內科</li>
          <li>內科</li>
          <li>神經內科</li>
          <li>婦科內科</li>
          <li>產科內科</li>
          <li>兒科</li>
          <li>神經內科</li>
        </ul>
      </div>

    </div>
    <div class="notification">
      <div class="header">
        <div class="left">
          <img src="../../public/hotel-bell.ico" alt="The image of department">
          <span>Notification</span>
        </div>
        <div class="right">
          <span>All</span>
          <el-icon>
            <ArrowRightBold/>
          </el-icon>
        </div>
      </div>

      <div class="content">
        <ul>
          <li>延長北京大學國際醫院放假通知</li>
          <li>中國醫藥大學東方醫院部分科室一枕門診時間表更動</li>
          <li>榮總醫院掛號系統更新通知</li>
        </ul>
      </div>

    </div>

    <div class="notification">
      <div class="header">
        <div class="left">
          <img src="../../public/hotel-bell.ico" alt="The image of department">
          <span>Notification Schedule</span>
        </div>
        <div class="right">
          <span>All</span>
          <el-icon>
            <ArrowRightBold/>
          </el-icon>
        </div>
      </div>

      <div class="content">
        <ul>
          <li>早上時段門診時間變動</li>
          <li>假日門診時間變動</li>
          <li>國定假日門診時間變動</li>
        </ul>
      </div>

    </div>
  </div>
</template>

<style scoped>
.tip {
  color: #7f7f7f;

  .department {
    .header {
      display: flex;
      justify-content: space-between;

      .left {
        display: flex;

        span {
          margin-left: 5px;
        }
      }

    }
    .content {
     ul{
       display: flex;
       flex-wrap: wrap;
       justify-content: space-between;
       li{
         width:40%;
         margin-top: 2px;
       }
     }
    }
  }
  .notification{
    margin-top: 20px;
    .header{
      display: flex;
      justify-content: space-between;
      .left{
        display: flex;
      }
      .content{
        ul{
          li{
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            margin-top: 20px;
          }
        }
      }
    }
  }
}
</style>