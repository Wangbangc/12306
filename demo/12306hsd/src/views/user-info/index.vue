<template>

    <div class="card">
      <h2>基本信息*</h2>
      <el-form  class="form" :model="user"  label-width="70px">
        <el-form-item label="用户名">
          <el-input  v-model="user.username"   placeholder="username" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="user.password" placeholder="userpassword"  />
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="user.realName" placeholder="userpassword"  />
        </el-form-item>
        <el-form-item  label="证件类型">
          <el-select placeholder="中国居民身份证">
            <el-option v-model="user.idType" label="中国居民身份证" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="证件号">
          <el-input v-model="user.idCard" placeholder=""  />
        </el-form-item>
        <el-form-item label="手机号">
          <el-input placeholder="phone" v-model="user.phone"  />
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input placeholder="mail" v-model="user.mail" />
        </el-form-item>
        <el-form-item class="but">
          <el-button @click="updateUser" type="" >修改信息</el-button>
        </el-form-item>
      </el-form>
    </div>

</template>

<script>
import { ElInput, ElSelect, ElOption } from 'element-plus';

export default {
  components: {
    [ElInput.name]: ElInput,
    [ElSelect.name]: ElSelect,
    [ElOption.name]: ElOption
  },
  data() {
    return {
      otherEditType:"view",
      user: {
        username:"admin",
        password:"admin123456",
        region:"中国",
        realName: '李志聪',
        idType: 0,
        idCard: '522121222222222222',
        phone: '111222555444',
        mail: '747880962@qq.com'
      }
    };
  }
};
</script>

<style scoped>
.but{
margin-top: 125px;
}
.card h2 {
  margin-left: 0;
}
/* Add your styles here */
.card {
  margin: auto;
  margin-top: 25px;
  width: 80% !important;
  height: 1000px;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border:1px solid #1890ff !important;
}

.form{
  margin: auto;
  width: 60%;

}
el-form-item{
  margin-top: 80px !important;
}
.el-input input {
  border: none !important;
  border-radius: 0 !important;
}
.form-item label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}
</style>
