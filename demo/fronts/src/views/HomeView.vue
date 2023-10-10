<script setup lang="ts">
import AdminHeader from '@/components/Layout/AdminHeader.vue'
import AdminMenu from '@/components/Layout/AdminMenu.vue';
</script>

<template>
    <div id="home">
    <el-container>
      <el-header>
        <AdminHeader></AdminHeader>
      </el-header>
      <el-container>
        <el-affix>
          <el-aside width="200px">
            <AdminMenu></AdminMenu>
          </el-aside>
        </el-affix>
        <el-main>
          <RouterView></RouterView>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<style>
#home{
  min-height: 100vh;
}
.el-header{
  background: #2b2c44;
  padding: 0;
}
.el-aside{
  background: #2b2c44;
  min-height: calc(100vh - 60px);
}
</style>
