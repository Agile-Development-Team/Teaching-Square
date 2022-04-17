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
      console.log('111')
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log('222')
          // alert('submit!');
          var params = new URLSearchParams();
          params.append("number", this.loginForm.number);
          params.append("password", this.loginForm.password);
          this.$axios({
            method: "post",
            url: '/api/login',
            data: params
          }).then(res => {
            console.log('333')
            if(res.data['success']==true){
              this.$store.commit("CHANGE_ISUP", true);
              this.$store.commit("CHANGE_IDENTITY", res.data['identity']);
              console.log('444')
              console.log(res.data)
              if(res.data['identity']==1){
                console.log('555')
                this.$axios.get('/api/studentCourses',{params:
                  {number: this.loginForm.number}}
                ).then(res=>{
                  console.log('666')
                  this.$router.replace('/student')
                  var courses=[]
                  for(var course in res.data){
                    console.log(res.data[course]['courseId'])
                    courses.push({
                      courseId: res.data[course]['courseId'],
                      courseName: res.data[course]['courseName'],
                      teacherName: res.data[course]['teacherName']
                    })
                  }
                  this.$store.commit("CHANGE_COURSES", courses);
                });
              }else if(res.data['identity']==2){
                this.$axios.get('/api/teacherCourses',{
                  params:{
                    number:this.loginForm.number
                  }
                }).then(res=>{
                  this.$router.replace('/teacher')
                  let courses = []
                  for(let course in res.data){
                    courses.push({
                      courseId: res.data[course]['courseId'],
                      courseName: res.data[course]['courseName'],
                      teacherName: res.data[course]['teacherName']
                    })
                  }
                  this.$store.commit("CHANGE_COURSES", courses);
                })
              }
            }else{
              console.log('000')
              alert(res.data['msg']);
            }
          });
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
