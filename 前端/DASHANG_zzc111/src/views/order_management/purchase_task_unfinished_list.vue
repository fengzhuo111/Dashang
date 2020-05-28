<template>
    <div id='purchase_task_unfinished_list' width='80%'>
    <!--头部 -->
        <div class="header">
        欢迎查看未完成采购任务列表
        </div>
        <!-- 导航栏 -->
        <div class="topnav">
        
        </div>

    
        <div class="search">
        <div >
            <input v-model="message" >
            <button v-on:click="counter+=1">搜索商品</button>
        </div>
        </div>
        
        <!--页面主体 -->

        <el-table :data="table_order" style="width: 80%" align="center" >
        <el-table-column prop="commodity_name" label="商品名称" width="180" v-on:click="counter+=1"></el-table-column>
        <el-table-column prop="commodity_number" label="品牌" width="180"></el-table-column>
        <el-table-column prop="commodity_brand" label="厂商" width="180"></el-table-column>
        </el-table>
        <el-pagination layout="prev, pager, next" :total="50" align="center"></el-pagination>


    </div>
</template>

<script>
export default {
    data() {
        return {
          table_order: [{
            commodity_brand:'苹果',
            commodity_number:'200',
            commodity_name:'苹果mp3'

          }, 
          
          ]
        }
      }
}
</script>


<style scoped>

* {
    box-sizing: border-box; 
  }
   
  .purchase_task_unfinished_list {
    font-family: Arial;
    padding: 10px;
    background: #f1f1f1;
  }
   
  /* 头部标题 */
  .header {
    padding: 30px;
    text-align: center;
    background: white;
  }
   
  .header h1 {
    font-size: 50px;
  }
/* 搜索条*/
  .search {
    padding: 30px;
    float: right;
  }
</style>