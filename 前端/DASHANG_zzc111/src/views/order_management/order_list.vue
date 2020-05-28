<template>
    <div id='order_list' width='80%'>
    <!--头部 -->
        <div class="header">
        欢迎查看商品列表
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
        <el-table-column prop="order_number" label="订单编号" width="180" v-on:click="counter+=1"></el-table-column>
        <el-table-column prop="order_date" label="下单日期" width="180"></el-table-column>
        <el-table-column prop="deadline" label="到期日期" width="180"></el-table-column>
        <el-table-column prop="username" label="下单客户" width="180"></el-table-column>
        </el-table>



    </div>
</template>

<script>
export default {
    data() {
        return {
          table_order: [{
            deadline: '2016-05-02',
            order_number: '00001',
            username: '王小虎',
            order_date: '2016-05-02'
          }, 
          {
            deadline: '2016-05-02',
            order_number: '00001',
            username: '王小虎',
            order_date: '2016-05-02'
          },
          {
            deadline: '2016-05-02',
            order_number: '00001',
            username: '王小虎',
            order_date: '2016-05-02'
          },
          {
            deadline: '2016-05-02',
            order_number: '00001',
            username: '王小虎',
            order_date: '2016-05-02'
          },
          {
            deadline: '2016-05-02',
            order_number: '00001',
            username: '王小虎',
            order_date: '2016-05-02'
          },
          {
            deadline: '2016-05-02',
            order_number: '00001',
            username: '王小虎',
            order_date: '2016-05-02'
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
   
  .order_list {
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