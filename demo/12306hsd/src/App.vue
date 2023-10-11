<script setup>
import { useRoute } from 'vue-router'
import Header from './components/header/index.vue'
import { ref, watch, onMounted, reactive } from 'vue'
import Aside from './components/aside/index'

const isLogin = ref(false)
const route = useRoute()
watch(
    () => route.path,
    (newRoute) => {
      if (newRoute === '/login') {
        isLogin.value = false
      } else {
        isLogin.value = true
      }
    }
)

</script>
<template>
  <div class="common-layout">
    <Layout    v-if="isLogin" >
      <Header class="full-width-header" >
      </Header>
      <Layout class="page-wrapper" v-if="isLogin">
<Aside>
</Aside>
        <router-view/>
      </Layout>
    </Layout>
    <Layout v-if="!isLogin">
      <router-view/>
    </Layout>
  </div>

</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.page-wrapper {
  display: flex;
  height: 100vh;
}
.wh{

}

.full-width-header {
  flex: 1; /* Take up remaining space */
}
</style>
