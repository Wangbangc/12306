<template>
  <div id="header">
    <div class="logo-box">
      12306
    </div>
    <div class="right-box">
      <div class="title">后台管理系统</div>
      <div class="avater-box">
        <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" />
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
</script>
<style>
#header {
  background-color: #2b2c44;
  color: #fff;
  display: flex;
  justify-content: space-between;
}

.logo-box {
  background-color: #2b2c44;
  color: #fff;
  display: flex;
  justify-content: space-between;
  width: 200px;
  text-align: center;
  line-height: 60px;
  font-size: 22px;
  font-weight: bold;
  color: #e73267;
}

.right-box {
  background-color: #2b2c44;
  color: #fff;
  display: flex;
  justify-content: space-between;
  flex: 1;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 18px;

  
}
.el-avatar {
    background-color: #2b2c44;
    color: #fff;
    display: flex;
    justify-content: space-between;
    margin-right: 10px;
  }
</style>