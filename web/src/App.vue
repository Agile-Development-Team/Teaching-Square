<template>
  <div id="app">
    <Header />
    <!-- 路由组件出口的地方 -->
    <router-view/>
    
    <!-- <div id="nav">
      <router-link to="/">主页</router-link> |
      <router-link to="/login">登录</router-link> |
      <router-link to="/register">注册</router-link> |
      <router-link to="/student">学生</router-link> |
      <router-link to="/teacher">教师</router-link> |
      <router-link to="/studentcourse">课程</router-link>
    </div> -->

  </div>
</template>

<script>
import Header from "./components/Header";

export default {
  name: 'App',
  components: {
    Header,
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

/* // #nav {
//   padding: 30px;

//   a {
//     font-weight: bold;
//     color: #2c3e50;

//     &.router-link-exact-active {
//       color: #42b983;
//     }
//   }
// } */
</style>
