<template>
  <div class="classInf">
    <!-- <el-form
      ref="joinForm"
      :inline="true" 
      class="demo-form-inline"
      :model="joinForm" 
      :rules="joinRules" 
    >
      <el-form-item label="选课" prop="code">
        <el-input 
          v-model="joinForm.code" 
          placeholder="请输入选课码" 
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="joinCourse('joinForm')">加入</el-button>
      </el-form-item>
    </el-form> -->
    <el-row
      v-for="index in this.$store.state.courses"
      :key="index['courseId']"
    >
      <el-col>
        <el-button 
          @click="handleCourse(index['courseId'],index['courseName'],index['teacherName'])" 
          class="course-btn"
          >{{index['courseId']}} {{index['courseName']}} {{index['teacherName']}}
        </el-button>
      </el-col>
    </el-row>
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
    handleCourse(courseId, courseName, teacherName){
      var course = {
        courseId: courseId,
        courseName: courseName,
        teacherName: teacherName
      }
      this.$store.commit("CHANGE_SELECTCOURSE", course);

      
      this.$axios.get('/api/courseHomeworks',{params:
        {courseId: courseId,
          number: this.$store.state.number}}
      ).then(res=>{
        var homeworks=[]
        for(let i in res.data){
          // console.log(res.data[i]);
          // console.log(res.data[i]['score']);
          homeworks.push({
            homeworkId: res.data[i]['homeworkId'],
            homeworkName: res.data[i]['homeworkTitle'],
            deadline: res.data[i]['deadline'],
            grade: res.data[i]['score']
          })
        }
        console.log(homeworks)
        this.$store.commit("CHANGE_SELECTHOMEWORKS", homeworks);
        this.$router.replace('/studentcourse')
      });

    },

  }
})
</script>

<style scoped>
.classInf{
  margin-top: 50px;

}
</style>
