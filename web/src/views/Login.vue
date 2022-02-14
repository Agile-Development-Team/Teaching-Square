<template>
<el-form
  ref="loginForm"
  label-width="120px"
  class="loginForm sign-in-form"
  :model="loginForm"
  :rules="loginRules"
>
  <el-form-item label="账号" prop="number">
    <el-input 
      placeholder="Enter account" 
      v-model="loginForm.number"
      autocomplete="off"
    >
    </el-input>
  </el-form-item>
  <el-form-item label="密码" prop="password">
    <el-input 
      placeholder="Enter password"
      type="password" 
      v-model="loginForm.password"
    >
    </el-input>
  </el-form-item>
  <el-form-item>
    <el-button @click="handleLogin('loginForm')" type="primary" class="submit-btn">登录</el-button>
  </el-form-item>
  <!-- 找回密码 -->
  <div class="tiparea">
    <p>{{loginForm.number}}</p>
    <p>忘记密码？<a>立即找回</a></p>
  </div>
</el-form>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  data(){
    return {
      loginForm: {
        number: '',
        password: ''
      },
      loginRules: {
        number: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    }
  },
  methods:{
    handleLogin(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // alert('submit!');
          var params = new URLSearchParams();
          params.append("number", this.loginForm.number);
          params.append("password", this.loginForm.password);
          var params2 = new URLSearchParams();
          params2.append("number", this.loginForm.number);
          this.$axios({
            method: "post",
            url: '/api/login',
            data: params
          }).then(res => {
            if(res.data['success']==true){
              if(res.data['data']==1){
                // this.$axios({
                //   method: "post",
                //   url: '/api/studentCourses',
                //   data: params2
                // }).then(res => {
                //   this.$router.replace('/student')
                //   console.log(res.data)
                // });
                this.$router.replace('/student')
              }else if(res.data['data']==2){
                this.$router.replace('/teacher')
              }
            }else{
              alert(res.data['msg']);
            }
          });

          var courses=[];
          courses.push({
            courseId: 1,
            courseName: "course1",
            number: "teacherA"
          })
          courses.push({
            courseId: 2,
            courseName: "course2",
            number: "teacherB"
          })
          this.$store.commit("CHANGE_COURSES", courses);
          console.log(this.$store.state.courses)
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
  },
  // props: {
  //   loginUser: {
  //     type: Object,
  //     required: true
  //   },
  //   loginRules: {
  //     type: Object,
  //     required: true
  //   }
  // },
  // setup () {
  // }
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
