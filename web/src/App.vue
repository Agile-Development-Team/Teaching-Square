<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">主页</router-link> |
      <router-link to="/login">登录</router-link> |
      <router-link to="/register">注册</router-link> |
      <router-link to="/student">学生</router-link> |
      <router-link to="/studentcourse">课程</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
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
