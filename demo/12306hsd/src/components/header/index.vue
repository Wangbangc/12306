<template>
  <div class="b">
    <el-header class="a">
      <el-row class="nav-row">
        <el-col :span="14">
          <div class="logo">
            <img src="../../assets/logo.png" class="logo1" alt="Logo">
          </div>

        </el-col>
        <el-col class="about-col" :span="10" >
          <el-row class="left">
            <el-col :span="6"><el-button
                key="plain"
                type=""
                link
                @click="TicketSearch"
            ><li>首页</li></el-button>
            </el-col>
            <el-col :span="6"><el-link href="https://github.com/Wangbangc/12306hsd" target="_blank"><li>github地址</li></el-link>
            </el-col>
            <el-col :span="6"> <el-button
                type=""
                link
                @click="Team"

            ><li>团队信息</li></el-button>
            </el-col>
            <el-col :span="6"> <div class="about-content">
            </div>
              </el-col>
          </el-row>
        </el-col>
      </el-row>
    </el-header>
  </div>
</template>
<script>
export default {
  data(){
    return{

    }
  },
  methods:{
    TicketSearch(){
      this.$router.push('/ticketSearch')
    },
    Team(){
      this.$router.push('/team')
    }
  }
}
</script>
<style>
.about-content{
  margin-left: 60px;
  width: 40px;
  height: 40px;
  background-color: #327fd2;
  border-radius: 25%;
}
.left{
  margin-top: 15px;
  display: flex;
  text-decoration: none;
  list-style: none;

}
.logo1{
  margin-top: 10px;
  height: 40px;
  cursor: pointer;
}
.logo {
  display: flex;
  flex: 1;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: nowrap;
  color: rgba(255, 255, 255, 0.8);
}
li {
  margin-top: 8px;
  width: 100px;
  font-size: 18px;
  padding: 0 30px;
color: #ffffff;
}
.about-col{
  display: flex;
  text-decoration: none;
  list-style: none;
  margin: 0;
}
.b{

}
.a{
  width:100%;
  background-color: rgba(10, 10, 10, 0.89);
}
el-row{
  background-color: #0a0a0a;


  padding: 0;
  border: none;


}
el-col {
  padding: 0;
  border: none;
}


</style>