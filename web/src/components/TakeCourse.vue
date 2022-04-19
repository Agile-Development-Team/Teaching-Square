<template>
  <div>
    <el-form
      ref="joinForm"
      :inline="true" 
      class="demo-form-inline"
      :model="joinForm" 
      :rules="joinRules" 
    >
      <el-form-item label="选课" prop="code">
        <el-input 
          v-model="joinForm.code" 
          placeholder="请输入选课密码" 
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="joinCourse('joinForm')">加入</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
    data(){
    // var validateCode = (rule, value, callback) => {
    //   if (value === '') {
    //     callback(new Error('请输入选课码'));
    //   } else {
    //     callback();
    //   }
    // };
    return{
      joinForm: {
        code: ''
      },
      joinRules: {
        code: [
          { required: true, trigger: 'change' }
        ]
      }
    }
  },
  methods: {
    handleCourse(courseId, courseName, number){
      var course = {
        courseId: courseId,
        courseName: courseName,
        number: number
      }
      this.$store.commit("CHANGE_SELECTCOURSE", course);
      this.$router.replace('/studentcourse')
    },
    joinCourse(formName){
      if (this.$store.state.isUp==false){
        alert('请先登录!');
        this.$router.replace('/login')
      }else{
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // var params = new URLSearchParams();
            // params.append("courseId", this.$store.state.chooseCourseId);
            // params.append("number", this.$store.state.number);
            // params.append("courseCode", this.joinForm.code);
            var jsons={  
              courseId:this.$store.state.chooseCourseId,
              number:this.$store.state.number,
              courseCode:this.joinForm.code
            }
            this.$axios({
              method: "post",
              url: '/api/chooseCourse',
              data: jsons,
              header:{
                'Content-Type':'application/json'  //如果写成contentType会报错
              }

            }).then(res => {
              alert(res.data['msg'])
              this.$axios.get('/api/studentCourses',{params:
                {number: this.$store.state.number}}
              ).then(res=>{
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
            });
            
            // this.$router.replace('/student')
          } else {
            console.log('选课码为空!');
            return false;
          }
        });
      }
      
    },

  },
})
</script>

<style scoped>

</style>
