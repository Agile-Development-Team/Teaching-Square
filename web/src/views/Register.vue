<template>
  <el-form
    ref="registerForm"
    label-width="100px"
    class="registerForm sign-up-form"
    :model="registerForm"
    :rules="registerRules"
  >
    <el-form-item label="账号" prop="number">
      <el-input
        v-model="registerForm.number"
        placeholder="Enter UserName..."
      ></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input
        type="password"
        v-model="registerForm.password"
        placeholder="Enter Password..."
      ></el-input>
    </el-form-item>
    <el-form-item label="确认密码" prop="password2">
      <el-input
        type="password"
        v-model="registerForm.password2"
        placeholder="Enter Password..."
      ></el-input>
    </el-form-item>
    <el-form-item label="选择身份" prop="identity">
      <el-select v-model="registerForm.identity" placeholder="请选择身份">
        <el-option label="管理员" value="admin"></el-option>
        <el-option label="教师" value="teacher"></el-option>
        <el-option label="学生" value="student"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button
        @click="handleRegister('registerForm')"
        type="primary"
        class="submit-btn"
        >注册</el-button
      >
    </el-form-item>
  </el-form>
</template>

<script>
// import axios from 'axios' // 仅限在当前组件使用
export default {
  data(){
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码以确认'));
      } else if (value !== this.registerForm.password) {
        callback(new Error('两次输入密码不一致'));
      } else {
        callback();
      }
    };
    return {
      registerForm: {
        number: '',
        password: '',
        password2: '',
        identity: ''
      },
      registerRules: {
        number: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 6 到 15 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ],
        password2: [
          { validator: validatePass2,  trigger: 'blur' }
        ],
        identity: [
          { required: true, message: '请确认身份', trigger: 'blur' }
        ]
      }
    }
  },
  methods:{
    handleRegister(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
  },
}
</script>
<style scoped>
</style>
