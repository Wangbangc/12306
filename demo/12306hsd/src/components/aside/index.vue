<template>
  <div class="asi" :style="{
      position: 'relative',
      minWidth: isCollapse ? '240px' : '240px',
      height: 'calc(100vh )',
    }" >
    <el-row class="bom">
      <el-col :span="12"> <div>
        <el-button class="logout" @click="Coll"  :icon="View" circle />
      </div></el-col>
      <el-col :span="12">  <div>
        <el-button class="logout" @click="logout" :icon="SwitchButton" circle />
      </div></el-col>
    </el-row>
        <el-aside width="240px" class="aside">

          <el-menu
              background-color="#e6e9ee"
              default-active="2"
              class="el-menu-vertical-demo"
              :collapse="isCollapse"
              @open="handleOpen"
              @close="handleClose"
          >
            <el-sub-menu index="1">
              <template #title>

                <span> <el-icon><TakeawayBox /></el-icon>车票管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-1"><el-button
                    key="plain"
                    type=""
                    link
                  @click="ticketSearch"
                >车票查询</el-button></el-menu-item>

              </el-menu-item-group>
            </el-sub-menu>
            <el-sub-menu index="2">
              <template #title>

                <span>  <el-icon><UserFilled /></el-icon>信息管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1"><el-button
                    key="plain"
                    type=""
                    link
                    @click="userInfo"
                >用户信息管理</el-button></el-menu-item>
              </el-menu-item-group>
            
            </el-sub-menu>
            <el-sub-menu index="3">
              <template #title>

                <span><el-icon><Document /></el-icon>订单管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="3-1"><el-button
                    key="plain"
                    type=""
                    link
                    @click="Orderlist"
                >车票订单</el-button></el-menu-item>
              </el-menu-item-group>
            </el-sub-menu>
         </el-menu>
        </el-aside>

  </div>
</template>
<script  setup>
import {
  View,
 SwitchButton,
  Document,
  TakeawayBox,
  UserFilled
} from '@element-plus/icons-vue'
</script>
<script>
export default {
  data(){
    return{
      label:false,
      isCollapse:true,
    }
  },
  methods:{
    Coll(){if ( this.isCollapse){
      this.isCollapse=false;
    }else {
      this.isCollapse=true;
    }

    },
    logout(){
      this.$router.push('/login')
    },
ticketSearch(){
  this.$router.push('/ticketSearch')
},
    userInfo(){
      this.$router.push('/userinfo')
    },
    Passenger(){
      this.$router.push('/passenger')
    },
    Orderlist(){
      this.$router.push('/orderList')
    }
  }
}
</script>

<style>
.asi{
  background-color: #e6e9ee;
}
.bom{

  justify-content: flex-end !important;
  padding: 10px!important;
}
.logout{
  background: transparent !important;
  border: none !important;
}
.aside{
  height: calc(100vh - 64px);
  background-color: #e6e9ee;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 240px;
  min-height: 400px;
  border-right: none;

}
.radio{
  background-color: #e6e9ee;
}
.radiobutton{

  background-color:  rgba(0, 0, 0, 0) ;/* 非选中时的背景色 */
  border: 1px solid  rgba(0, 0, 0, 0); /* 非选中时的边框样式 */
  cursor: pointer;
}
.radiobutton:active{
  background-color: rgba(0, 0, 0, 0); /* 非选中时的背景色 */
  border: 1px solid  rgba(0, 0, 0, 0); /* 非选中时的边框样式 */
}
</style>