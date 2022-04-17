<template>
<header class="header">
  <div class="top">
    <div class="loginList">
      <p>欢迎使用Teaching Square</p>
      <!-- 没有用户名：未登录 -->
      <p v-if="!number">
        <span>请</span>
        <!-- 声明式导航：router-link务必要有to属性 -->
        <router-link to="/login">登录</router-link>
        <router-link class="register" to="/register">注册</router-link>
      </p>
      <!-- 登录了 -->
      <p v-else>
        <a>{{number}}</a>
        <a class="register" @click="logout">退出登录</a>
      </p>
    </div>
    <div class="pageList">
      <router-link to="/" exact-active-class="eac">主页</router-link> 
      <!-- <router-link to="/login">登录</router-link> 
      <router-link to="/register">注册</router-link>  -->
      <router-link to="/student" exact-active-class="eac">学生</router-link> 
      <router-link to="/teacher" exact-active-class="eac">教师</router-link> 
      <router-link to="/studentcourse" exact-active-class="eac">课程</router-link>
    </div>

  </div>
</header>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  data () {
    return {
    }
  },
  computed:{
    //用户信息
    number(){
      return this.$store.state.number;
    }
  },
  // watch:{
  //   number: function(){
  //     console.log('用户登录状态变更！')
  //   }
  // },
  methods: {
    async logout(){
      //退出登录: 清除项目当中用户相关的数据
        try {
          //如果退出成功
          await this.$store.commit('CLEAR');
          //回到首页
          this.$router.replace('/')
        } catch (error) {
          console.log('Error!')
        }
    }
  }
})
</script>

<style scoped lang="less">
.header {
  box-shadow: 0px 5px 10px #cccc;
  & > .top {
    background-color: #e8f2fc;
    height:60px;
    line-height: 30px;
    .loginList {
      float: left;

      p {
        float: left;
        margin-left: 10px;
        margin-right: 10px;

        .register {
          border-left: 1px solid #b3aeae;
          padding: 0 5px;
          margin-left: 5px;
        }
      }
    }
    .pageList {
      float: right;
      margin-top: 15px;
      a {
        padding: 0 10px;
        & + a {
          border-left: 1px solid #b3aeae;
        }
      }
    }
    
  }
  .eac{
    color: rgb(8, 1, 20);
    font-size: 22px;
  }
}
</style>
