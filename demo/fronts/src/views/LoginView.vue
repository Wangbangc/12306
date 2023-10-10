<template>
  <div id="login">
    <div class="login-box">
      <div class="logo">
        <el-image src="public\favicon.ico" fit="fill" :lazy="true"></el-image>
      </div>
      <el-main>
        <el-form :model="form" label-width="120px" ref="formRef" :rules="rules">
          <el-form-item label="username" prop="username">
            <el-input v-model="form.username" placeholder="username" :prefix-icon="User" />
          </el-form-item>
          <el-form-item label="Password" prop="password">
            <el-input v-model="form.password" type="password" autocomplete="off" placeholder="password"
              :prefix-icon="Lock" />
          </el-form-item>
          <div class="btns">
            <el-button @click="reset" class="btn reset">重置</el-button>
            <el-button @click="login" type="primary" class="btn">登录</el-button>
          </div>
        </el-form>
      </el-main>
    </div>


  </div>
</template>
<script setup lang="ts">
import { User, Lock } from '@element-plus/icons-vue'
import { rules } from '@/rules/userinfo'
import { ElMessage, type FormInstance } from 'element-plus'
import { ref } from 'vue'
import { loginApi } from '@/apis/login'
import { useInfoStore } from '@/stores/userinfo.store'
import { useRouter } from 'vue-router'
const router = useRouter()
const userInfoStore = useInfoStore();
interface Form {
  username: string
  password: string
}
const form = ref<Form>({
  username: '',
  password: ''
})
const formRef = ref<FormInstance>()
const reset = () => {
  formRef.value?.resetFields()
}
const login = async () => {
  const res = await loginApi(form.value)
  userInfoStore.setAuth(res.data.data)
  ElMessage.success('登录成功')
  router.push('/home/admin-home')
}
</script>
<style>
#login,
.logo {
  height: 100vh;
  margin: auto, 0;
  background: linear-gradient(to right, #2b2c43, #1e3158);
  display: flex;
  align-items: center;
  justify-content: center;
}

.login-box,
.logo.btn.btns {
  align-items: center;
  display: flex;
  width: 360px;
  height: 450px;
  background-color: aliceblue;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
}

.logo {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  box-shadow: 0 0 4px 2px #fff;
  margin-bottom: 30px;
  overflow: hidden;
}

.el-form {
  width: 90%;
  margin-top: 30px;

}
.btns{
  display: flex;
  justify-content: center;
  align-items: center;

}

.btn {
  border-radius: 20px;
  margin-bottom: 20px;
}

.reset {
  text-align: center;

}
</style>
