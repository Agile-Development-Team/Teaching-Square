<template>
    <div>
        <div class="teacher-header">
            <div style="float:right">
                <el-button @click="visible=true">创建课程</el-button>
            </div>
        </div>
        <div class="teacher-course-list">
            <div v-for="course in this.$store.state.courses" :key="course.courseId"  @click="getCourse(course)" class="course">
                 <div style="width:80px">
                    <el-avatar icon="el-icon-user-solid"></el-avatar>
                </div>
                <div style="flex-grow:1">
                    <p><span>课程:</span>{{course.courseName}}</p>
                </div>
                <div style="flex-grow:1">
                    <p><span>任课教师:</span>{{course.teacherName}}</p>
                </div>
            </div>
        </div>
        <el-dialog :visible.sync="visible">
            <el-form :rules="rules" :model="this.courseForm">
                <el-form-item label="课程名" prop="courseName">
                    <el-input v-model="courseForm.courseName"></el-input>
                </el-form-item>
                <el-form-item label="选课码" prop="courseCode">
                    <el-input v-model="courseForm.courseCode"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button @click="addCourse">确认</el-button>
                    <el-button @click="visible=false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
export default {
  name:'TeacherHome',
  data(){
   return {
       courseForm:{
           number:undefined,
           courseCode:undefined,
           courseName:undefined
       },
       rules:{
           courseCode:[
               {required:true,message:'请输入选课码',trigger:'blur'}
           ],
           courseName:[
               {required:true,message:'请输入课程名',trigger:'blur'}
           ]
       },
       visible:false
   }
  },
  mounted(){
      this.courseForm.number = this.$store.state.number
      console.log(this.$store.state)
  },
  methods:{
      getCourse(course){
          console.log(course)
          this.$store.commit('CHANGE_SELECTCOURSE',course)
          this.$store.commit('CHANGE_CHOOSECOURSEID',course.courseId)
          this.$router.push('/teacher')
      },
      addCourse(){
          let tmp = this.courseForm
          console.log(tmp)
          this.$axios.post('/api/addCourse',tmp)
                     .then(res=>{
                         console.log(res)
                         this.visible = false
            })
      }
  },
  watch:{
      visible:function(){
          if(this.visible==false){
              this.courseForm.courseCode = undefined
              this.courseForm.courseName = undefined
          }
      }
  }
}
</script>

<style scoped>
    
</style>
<style src="../../assets/css/teacher.css">

</style>
