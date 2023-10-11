<template>
  <el-container>
    <el-main>
      <el-card class="box-card">
      <el-form   label-width="60px">
        <el-row>
          <el-col :span="4"><el-form-item label="出发地">
            <el-input  placeholder="北京" />
          </el-form-item></el-col>
          <el-col :span="2"></el-col>
          <el-col :span="4"><el-form-item label="目的地">
            <el-input placeholder="哈尔滨"  />
          </el-form-item></el-col>
          <el-col :span="4"><el-form-item label="日期">
            <el-date-picker
                v-model="value1"
                type="date"
                placeholder="Pick a day"
                :size="size"
            />
          </el-form-item></el-col>
          <el-col :span="3"><el-button class="search" @click="loginone" type="primary" >查询</el-button></el-col>
          <el-col :span="4"> <el-form-item>

          </el-form-item></el-col>
        </el-row>
      </el-form>
    </el-card>
      <div></div>
      <div class="display">
        <el-card class="box-card1">
          <el-table class="table" :data="tableData" stripe style="width: 100%">
            <el-table-column prop="date" label="车次" width="180" />
            <el-table-column prop="name" label="出发站到达站" width="180" />
            <el-table-column prop="name" label="出发时间达到时间" width="180" />
            <el-table-column prop="name" label="历时" width="180" />
            <el-table-column prop="name" label="坐席" width="180" />
            <el-table-column prop="name" label="其他" width="180" />

            <el-table-column prop="address" label="备注" />
          </el-table>
        </el-card>
      </div>
    </el-main>
  </el-container>
</template>

<script>
export default {
  data(){
    return{
      tableData : [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  }
}
</script>
<style>
.search{width: 50%;}
.box-card{
  margin-top: 25px;
 width: 100% !important;
  height: 75px;
  border:1px solid #1890ff !important;
  background: #ffffff;
  padding: 0;
  border-radius: 4px;
}
.box-card1{
  margin-top: 25px;
}
</style>