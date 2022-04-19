<template>
   <el-container style="width:100%">
     <el-header></el-header>
     <el-container>
       <el-aside style="width:150px">
         <el-menu @select="handleSelect"
                  default-active="Total">
           <el-menu-item index="Total">
             <template slot="title">总览</template>
           </el-menu-item>
           <el-menu-item index="Call"> 
             <template slot="title">点名</template>
           </el-menu-item>
           <el-menu-item index="Homework">
             <template slot="title">作业</template>
           </el-menu-item>
           <el-menu-item index="Resource">
             <template slot="title">资源</template>
           </el-menu-item>
           <el-menu-item index="Test">
             <template slot="title">课堂小测</template>
           </el-menu-item>
         </el-menu>
       </el-aside>
       <el-main>
         <keep-alive>
          <div :is="currentComponent"></div>
         </keep-alive>
       </el-main>
     </el-container>
    
   </el-container>
</template>

<script>

export default {
  name:'Teacher',
  data(){
   return {
     currentComponent:()=>import('./Total.vue'),
   }
  },
  mounted(){
    
  },
  methods:{
    handleSelect(key){
      this.currentComponent = ()=>import(`./${key}`)
    }
  }
}
</script>

<style scoped>

</style>
