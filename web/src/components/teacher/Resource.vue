<template>
    <div>
      <div class="teacher-header">
        <el-button style="float:right" @click="visible=true">上传课件</el-button>
      </div>
      <div>
        <el-table :data="$store.state.selectCoursewares">
          <el-table-column prop="title" label="课件标题"></el-table-column>
          <el-table-column prop="publishedTime" label="发布时间"></el-table-column>
          <el-table-column label="链接">
            <template slot-scope="scope">
              <el-link @click="download(scope.row.link)">下载</el-link>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-dialog :visible.sync="visible">
            <el-form :rules="rules" :model="resourceForm">
                <el-form-item label="课件标题" prop="title">
                    <el-input v-model="resourceForm.title"></el-input>
                </el-form-item>
                <el-form-item label="文件" prop="file">
                    <el-upload ref="upload" 
                               action="#"
                               :auto-upload="false"
                               :limit="1"
                               :file-list="fileList"
                               :on-change="upload">
                      <el-button>点击上传</el-button>
                    </el-upload>
                </el-form-item>
                <el-form-item>
                    <el-button @click="addResource">提交</el-button>
                    <el-button @click="visible=false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
export default {
  name:'Resource',
  data(){
   return {
     visible:false,
     resourceForm:{
       courseId:undefined,
       title:undefined,
       file:null,
     },
     fileList:[],
     rules:{
       title:[
         {required:true,message:'请输入课件标题',trigger:'blur'}
       ],
       file:[
         {required:true,message:'请选择文件',trigger:'blur'}
       ]
     },
    
   }  
  },
  mounted(){
    this.getResources()
    this.resourceForm.courseId = this.$store.state.chooseCourseId
  },
  methods:{
    addResource(){
      let params = new FormData()
      params.append('courseId',this.resourceForm.courseId)
      params.append('title',this.resourceForm.title)
      params.append('file',this.resourceForm.file.raw)

      this.$axios.post('/api/file/addResource',params).then(res=>{
        console.log(res)
        this.getResources()
        this.visible = false
      })
    },
    upload(file,fileList){
      console.log(file,fileList)
      this.resourceForm.file = file
    },
    getResources(){
      this.$axios.get('/api/courseResources',{
        params:{
          courseId:this.$store.state.chooseCourseId
        }
      }).then(res=>{
        console.log(res)
        this.$store.commit('CHANGE_SELLECTCOURSEWARES',res.data)

      })
    },
    download(link){
      console.log(link)
        this.$axios.get('/api/file/download',{
          params:{
            link
          },
          responseType:'blob'
        }).then((res)=>{
          let blob = new Blob([res.data],{type:'application/pdf;charset=UTF-8'})
          const reader = new FileReader();
          reader.readAsDataURL(blob);
          reader.onload = e => {
            const a = document.createElement('a');
            a.href = e.target.result;
            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
          }
          // var iframe = "<iframe width='100%' height='100%' src='http://172.19.241.104:8888/file/download?link=" + link + "'></iframe>"
          // var x = window.open()
          // x.document.open()
          // x.document.write(iframe)
          // x.document.close()
        })
    },
    watch:{
      visible:function(){
        if(this.visible==false){
          this.resourceForm.title = undefined
          this.resourceForm.file = null
        }
      }
    }
  }
}
</script>

<style scoped>

</style>
