<template>
  <el-card class="team">
  <template  #header>

    <el-row>
      <el-col :span="16"><span class="title1">第九组</span></el-col>
      <el-col :span="8"><a>team</a></el-col>
    </el-row>
  </template>
    <div class="nr">
      <el-row>
        <el-col :span="12">姜塬滨</el-col>
        <el-col :span="12">田嘉怡</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">张梓褀</el-col>
        <el-col :span="12">王邦城</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">郑鑫</el-col>
        <el-col :span="12">衣红竹</el-col>
      </el-row>
    </div>
  </el-card>
</template>

<style>

.title1{
  color: #000000;
  margin-left: -100px;
}
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;

}


.nr{

background-color: #ffffff;
  width: 100%;
  height: 100%;
}
.team {
  margin-left: 20px;
  width: 300px;
  height: 160px !important;
  border:1px solid #1890ff !important;
  background: #ffffff !important;
  margin-top: 25px;

}

</style>
