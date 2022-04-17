<template>
  <div>
      <div class="teacher-header">
        <el-button style="float:right" @click="visible=true">添加作业</el-button>
      </div>
      <el-table :data="homework">
        <el-table-column type="expand">
          <template slot-scope="scope">
            <el-table :data="homeworkDetail[scope.row.homeworkId]">
              <el-table-column prop="studentName" label="学生姓名"></el-table-column>
              <el-table-column label="下载链接">
                <template slot-scope="scope">
                  <el-link @click="download(scope.row.link)">下载</el-link>
                </template>
              </el-table-column>
            </el-table>
          </template>
        </el-table-column>
        <el-table-column prop="title" label="标题"></el-table-column>
        <el-table-column prop="ddl" label="截止日期"></el-table-column>
      </el-table>
       <el-dialog :visible.sync="visible">
          <el-form :rules="rules" :model="homeworkForm">
              <el-form-item label="作业标题" prop="title">
                <el-input v-model="homeworkForm.title"></el-input>
              </el-form-item>
              <el-form-item label="作业描述" prop="description">
                <el-input v-model="homeworkForm.description"></el-input>
              </el-form-item>
              <el-form-item label="截止时间" prop="deadline">
                <el-date-picker
                  v-model="homeworkForm.deadline"
                  type="datetime"
                  placeholder="选择截止时间">
                </el-date-picker>
              </el-form-item>
              <el-form-item label="作业占比(百分比)" prop="percentage">
                <el-input v-model="homeworkForm.percentage"></el-input>
              </el-form-item>
              <el-form-item>
                  <el-button @click="addHomework">提交</el-button>
                  <el-button @click="visible=false">取消</el-button>
              </el-form-item>
          </el-form>
        </el-dialog>
  </div>
</template>

<script>
export default {
    name:'Homework',
    data(){
      return {
        homework:[
          {
            homeworkId:1, 
            title:"完成八大排序算法",
            ddl:"2021.12.30", 
          },
          {
            homeworkId:2, 
            title:"完成九大排序算法",
            ddl:"2021.12.30", 
          },
      ],
        homeworkDetail:{
          2:[
            {studentName:'wyj',link:'http:////////'}
          ]
            
          
        },
        visible:false,
        rules:{
          description:[
            {required:true,message:'请输入描述',trigger:'blur'}
          ],
          title:[
            {required:true,message:'请输入标题',trigger:'blur'}
          ],
          deadline:[
            {required:true,message:'请填写截止时间',trigger:'blur'}
          ],
          percentage:[
            {required:true,message:'请设置作业占比',trigger:'blur'}
          ],
        },
        homeworkForm:{
          description:undefined,
          title:undefined,
          deadline:undefined,
          percentage:undefined
        }
      }
    },
    mounted(){
      //获取课程作业列表
      this.$axios.get('/api/teacherCourseHomeworks',{
        params:{
          courseId:this.$store.state.selectCourseId
        }
      }).then(res=>{
        console.log(res)
        this.homework = res
        for(let i of res){
          //获取作业下的学生作业列表
          this.$axios.post('/api/searchHomeworkStudents',{
            courseId:this.$store.state.selectCourseId,
            homeworkId:i.homeworkId
          }).then(res=>{
            console.log(res)
            this.homeworkDetail[res[0].homeworkId] = res
          })
        }
      })
    },
    methods:{
      getHomeworkDetail(homeworkId){
        let res = this.homeworkDetail.filter(x=>x[0].homeworkId==homeworkId)
        if(res)
          return res[0]
        this.$axios.get('/api/searchHomeworkStudents',{
          params:{
            courseId:this.$store.state.selectCourseId,
            homeworkId
          }
        }).then(res=>{
          console.log(res)
          return res
        })
      },
      download(link){
        console.log(link)
        this.$axios.get('/api/download',{
          params:{
            link
          },
          responseType:'blob'
        }).then(res=>{
          let blob = new Blob([res.data],{type:"pdf"})
          const reader = new FileReader();
          reader.readAsDataURL(blob);
          reader.onload = e => {
            const a = document.createElement('a');
            a.href = e.target.result;
            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
          }
        })
    },
    addHomework(){
      this.$axios.post('/api/addHomework',{
        courseId:this.$store.selectCourseId,
        description:this.homeworkForm.description,
        title:this.homeworkForm.title,
        deadline:this.homeworkForm.deadline,
        percentage:this.homeworkForm.percentage,
      }).then(res=>{
        console.log(res)
        this.homework.push({
          title:this.homeworkForm.title,
          ddl:this.homeworkForm.deadline
        })
        this.visible = false
      })
    }
  },
  watch:{
    visible:function(){
      if(this.visible==false){
        this.homeworkForm.description = undefined
        this.homeworkForm.title = undefined
        this.homeworkForm.percentage = undefined
        this.homeworkForm.deadline = undefined
      }
    }
  }
}
</script>

<style>

</style>