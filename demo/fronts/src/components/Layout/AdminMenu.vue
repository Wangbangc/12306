<template>
  <div id="menu">
    <el-menu active-text-color="#fff" background-color="#2b2c44" class="el-menu-vertical-demo"
      :default-active="defaultActive" text-color="#c1c1c1" router>
      <component :is="item.children?ElSubMenu:ElMenuItem" v-for="item in menulist" :key="item.id" :index="item.index">
        <template v-if="item.children" #title>
          <item.icon v-if="item.icon" class="icon">
            <component :is="item.icon"></component>
          </item.icon>
          <span>{{ item.name }}</span>
        </template>
        <span v-if="!item.children" class="item-content">
          <item.icon v-if="item.icon">
            <component :is="item.icon" class="icon"></component>
          </item.icon>
          <span class="text">{{ item.name }}</span>
        </span>
        <el-menu-item v-for="subItem in item.children" :key="subItem.id"  :index="subItem.index">
          {{ subItem.name }}
        </el-menu-item>
      </component>
    </el-menu>
  </div>
</template>
<script setup lang="ts">
import { ref, type Component } from 'vue';
import { House, User, Goods } from '@element-plus/icons-vue'
import { ElSubMenu, ElMenuItem } from 'element-plus';
import router from '@/router';
// const defaultActive=ref<string>(router.currentRoute.value.path)
const defaultActive = ref<string>(router.currentRoute.value.path)
interface MenuItem {
  id: number;
  name: string;
  index: string;
  icon?: Component;
  children?: MenuItem[];
}
const menulist: MenuItem[] = [
  {
    id: 1,
    name: "首页",
    index: "/home/admin-home",
    icon: House,
  },
  {
    id: 2,
    name: "用户管理",
    index: "/home/user",
    icon: User,
  },
  {
    id: 101,
    name: "车票系统",
    index: defaultActive.value,
    icon: Goods,
    children: [
      {
        id: 4,
        name: "车站管理",
        index: "/home/station",
      },
      {
        id: 5,
        name: "车次管理",
        index: "/home/brand",
      },
      {
        id: 6,
        name: "车票管理",
        index: "/home/type",
      },
    ],
  },
];
</script>
<style>
.item-content {
  display: flex;
  align-items: center;
}

.icon {
  width: 20px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.text {
  margin-left: 5px;
}
</style>