<template>
  <div id="users" style="margin-bottom: 20px; overflow: auto">
    <el-breadcrumb :separator-icon="ArrowRight">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <div class="header">
        <div class="mt-4">
          <el-input v-model="keyword" placeholder="请输入" class="input-with-select" style="margin-right: 10px">
            <template #append>
              <el-button :icon="Search" @click="handerSearch"/>
            </template>
          </el-input>
          <el-button type="danger" size="default" @click="disableUsers">批量改变</el-button>
        </div>
      </div>
      <el-table :data="tableData" style="width: 100%" @selection-change="handleChange">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="id" label="id" width="90"></el-table-column>
        <el-table-column prop="username" label="username" width="150"></el-table-column>
        <el-table-column prop="password" label="password" width="150"></el-table-column>
        <el-table-column prop="phone" label="phone" width="150"></el-table-column>
        <el-table-column prop="city" label="city" width="150"></el-table-column>
        <el-table-column label="status" width="80">
          <template #default="scope">
            <div style="display: flex; align-items: center;justify-content: center">
              <el-switch v-model="scope.row.status" @change="userStatus([scope.row.id])"/>
            </div>
          </template>
        </el-table-column>
        <el-table-column prop="minister" label="minister" width="80"></el-table-column>
        <el-table-column label="Operations">
          <template #default="scope">
            <el-button size="small" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination class="mt"
          v-model:current-page="query.page"
          v-model:page-size="query.pageSize"
          :page-sizes="[5, 10, 15]"
          layout="sizes, prev, pager, next"
          :total="total"
          @size-change="getUserList"
          @current-change="getUserList"
      />
    </el-card>
  </div>
</template>
<script setup lang="ts">
import {ArrowRight, Search} from '@element-plus/icons-vue'
import {Timer} from '@element-plus/icons-vue'
import {ref} from "vue";
import {getUserListApi, modifyStatus} from "@/apis/users";
import {ElMessage} from "element-plus";
const selectedUsers=ref<User[]>([])
const total = ref<number>(0)
const query = ref({
  page: 1,
  pageSize: 5,
  name: ''
})
const keyword = ref<string>()

interface User {
  id: number;
  username: string;
  password: string;
  phone: string;
  city: string;
  status: boolean;
  minister: string;
}
const userStatus= async (id:number)=>{
  const res=await modifyStatus(id)
  ElMessage.success(res.data.data)
  getUserList()
}
const handleChange=(val:User[])=>{
  selectedUsers.value=val;
}
const disableUsers=async ()=>{
  const ids=selectedUsers.value.map((user)=>user.id)
  const res=await modifyStatus(ids)
  ElMessage.success(res.data.data)
  getUserList()
}
const handerSearch = () => {
  typeof keyword.value === "string" ? query.value.name = keyword.value : query.value.name = '';
  getUserList()
}
const handleEdit = (index: number, row: User) => {
  console.log(index, row)
}
const handleDelete = (index: number, row: User) => {
  console.log(index, row)
}

const tableData = ref<User[]>([]);
const getUserList = async () => {
  const res = await getUserListApi(query.value);
  res.data.data.records.map((item: any) => {
    item.status = item.status == 1;
  })
  console.log(res.data.data.records)
  tableData.value = res.data.data.records;
  total.value = res.data.data.total;
}
getUserList()
</script>
<style>
#users .el-breadcrumb {
  margin-bottom: 20px;
}

.header {

}

.el-input {
  width: 300px;
}
.mt{
  margin-top: 30px;
}
</style>