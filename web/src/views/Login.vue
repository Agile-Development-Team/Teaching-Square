<template>
<el-form
  ref="loginForm"
  label-width="120px"
  class="loginForm sign-in-form"
>
  <el-form-item label="账号" prop="account">
    <el-input placeholder="Enter account"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="password">
    <el-input placeholder="Enter password" type="password"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button @click="handleLogin()" type="primary" class="submit-btn">登录</el-button>
  </el-form-item>
  <!-- 找回密码 -->
  <div class="tiparea">
    <p>忘记密码？<a>立即找回</a></p>
  </div>
</el-form>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  props: {
    loginUser: {
      type: Object,
      required: true
    },
    loginRules: {
      type: Object,
      required: true
    }
  },
  setup () {
    //
  }
})
</script>

<style scoped>
.loginForm {
  margin-top: 20px;
  background-color: #fff;
  padding: 20px 40px 20px 20px;
  border-radius: 5px;
  box-shadow: 0px 5px 10px #cccc;
}

.submit-btn {
  width: 100%;
}
.tiparea {
  text-align: right;
  font-size: 12px;
  color: #333;
}
.tiparea p a {
  color: #409eff;
}
</style>
