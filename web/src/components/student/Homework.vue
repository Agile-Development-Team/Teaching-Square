<template>
<!-- 作业列表 -->
  <div v-if="this.$store.state.showOneHomework==='1'">
    <el-row class="subTitle">
      <el-col :span=12 >作业标题</el-col>
      <el-col :span=4>提交截止时间</el-col>
      <el-col :span=4>分数</el-col>
      <el-col :span=4>详情</el-col>
    </el-row>
    <el-row
      v-for="index in this.$store.state.selectHomeworks"
      :key="index['homeworkId']"
    >
      <el-col :span=12>{{index['homeworkName']}}</el-col>
      <el-col :span=4>{{index['deadline']}}</el-col>
      <el-col :span=4>{{index['grade']}}</el-col>
      <el-col :span=4>
        <el-button @click="handleHomework(index['homeworkId'],index['homeworkName'],index['deadline'],index['grade'])">点击查看</el-button>
      </el-col>
    </el-row>
  </div>
<!-- 详细作业界面 -->
  <div v-else-if="this.$store.state.showOneHomework==='2'">
    <el-page-header @back="goBack" content="详情页面">
    </el-page-header>
    <div class="subTitle">{{this.$store.state.selectedHomework['homeworkName']}}</div>
    <div>{{this.$store.state.selectedHomework['description']}}</div>

    <el-descriptions 
      class="margin-top" 
      title="作业完成情况" 
      :column="1" 
      border
      :labelStyle="{'width': '15%'}"
    >
      <el-descriptions-item label="截止日期">
        {{this.$store.state.selectedHomework['deadline']}}
      </el-descriptions-item>
      <el-descriptions-item label="提交状态">
        已提交
      </el-descriptions-item>
      <el-descriptions-item label="提交内容">
        {{this.$store.state.selectedHomework['content']}}
      </el-descriptions-item>
      <el-descriptions-item label="作业评分">
        {{this.$store.state.selectedHomework['grade']}}
      </el-descriptions-item>
    </el-descriptions>

    <!-- <el-button class="submit-btn" @click="submitHomework">提交作业</el-button> -->
    <el-upload
      class="submit-btn"
      action=""
      align="left"
      :before-upload="beforeUpload"
      style="float: left;"
    >
      <el-button size="small" type="primary">提交作业</el-button>
      <div slot="tip" class="el-upload__tip">只能上传文本类型文件</div>
    </el-upload>
  </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  data(){
    return {
    }
  },
  
  methods: {
      handleHomework(homeworkId,homeworkName,deadline,grade){
        if(this.$store.state.isUp==false){
          alert("尚未登录")
          this.$router.replace('/login')
        }else{
          console.log(homeworkId)
          this.$axios.get('/api/homeworkDetail',{params:
            {courseId: this.$store.state.selectCourse['courseId'],
              homeworkId:homeworkId,
              number: this.$store.state.number}}
          ).then(res=>{
            var detail={}
            detail['homeworkId']=homeworkId
            detail['homeworkName']=homeworkName
            detail['deadline']=deadline
            detail['grade']=grade
            detail['description']=res.data['description']
            detail['content']=res.data['link']
            if(detail['content']==''){
              detail['status']='0'
            }else{
              detail['status']='1'
            }
            detail['percentage']='未定义'
            console.log(detail)
            this.$store.commit("CHANGE_SELECTEDHOMEWORK", detail);
            
          });

          this.$store.commit("CHANGE_SHOWONEHOMEWORK", '2');
          }
          
      },
      goBack(){
        this.$store.commit("CHANGE_SHOWONEHOMEWORK", '1');
        var detail={}
        this.$store.commit("CHANGE_SELECTEDHOMEWORK", detail);
      },
      // submitHomework(){
      //   if(this.$store.state.selectedHomework['status']==='1'){
      //     alert("作业不可提交")
      //   }else{
      //     console.log("提交作业")
      //   }
      // },

      beforeUpload(file){
        // if(this.$store.state.selectedHomework['status']==='1'){
        //   alert("作业已提交")
        // }else{
        //   console.log("提交作业")
        // }
        let url='/api/file/uploadHomework'
        let form = new FormData();
        form.append('file', file);
        form.append("courseId", this.$store.state.selectCourse['courseId']);
        form.append("homeworkId", this.$store.state.selectedHomework['homeworkId']);
        form.append("number", this.$store.state.number);
        // var params = new URLSearchParams();
        // params.append("courseId", this.$store.state.selectCourse['courseId']);
        // params.append("homeworkId", this.$store.state.selectedHomework['homeworkId']);
        // params.append("number", this.$store.state.number);
        // params.append("file", file);
        
        this.$axios({
          method: "post",
          url: url,
          data: form
        }).then(res => {
          alert("作业已提交")

          console.log(res.data)

          this.$axios.get('/api/homeworkDetail',{params:
            {courseId: this.$store.state.selectCourse['courseId'],
              homeworkId:this.$store.state.selectedHomework['homeworkId'],
              number: this.$store.state.number}}
          ).then(res=>{
            var detail={}
            detail['homeworkId']=this.$store.state.selectedHomework['homeworkId']
            detail['homeworkName']=this.$store.state.selectedHomework['homeworkName']
            detail['deadline']=this.$store.state.selectedHomework['deadline']
            detail['grade']=this.$store.state.selectedHomework['grade']
            detail['description']=res.data['description']
            detail['content']=res.data['link']
            if(detail['content']==''){
              detail['status']='0'
            }else{
              detail['status']='1'
            }
            detail['percentage']='未定义'
            console.log(detail)
            this.$store.commit("CHANGE_SELECTEDHOMEWORK", detail);
            
          });
        });
      }
  },
  setup() {
    
  },
})
</script>

<style scoped>
.subTitle{
  font-size: 20px;
  margin-top: 10px;
  margin-bottom: 10px;
  font-weight: bold;
  color: #47505a;
}
.submit-btn{
  margin-top: 10px;
  margin-left: 10px;
}
</style>