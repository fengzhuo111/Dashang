<template>
    <div id='purchase_task_list' width='80%'>
    <!--头部 -->
        <div class="header">
        欢迎查看采购任务列表
        </div>
        <!-- 导航栏 -->
        <div class="topnav">
        
        </div>
      <div class='container' direction='vertical' width='80%'>
    
        <div class="search">
        <div >
          <el-select v-model="value" placeholder="全部订单">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
        </div>
        
        <!--页面主体 -->
      <div  style="width: 80%" align="center">
          <el-table :data="table_order"  >
          <el-table-column prop="task_number" label="采购任务号" width="180"></el-table-column>
          <el-table-column prop="commodity_name" label="商品名称" width="180" v-on:click="counter+=1"></el-table-column>
          <el-table-column prop="commodity_number" label="商品数量" width="180"></el-table-column>
          <el-table-column prop="purchase_price" label="报价" width="180"></el-table-column>
          <el-table-column prop="vendor" label="厂商" width="180"></el-table-column>
          <el-table-column prop="purchase_date" label="采购日期" width="180"></el-table-column>
          </el-table>
      </div>
      </div>


    </div>
</template>

<script>
export default {
    data() {
        return {
          table_order: [{
            purchase_date: '2016-05-02',
            task_number: '00001',
            vendor: '苹果商贸有限公司',
            purchase_price:'50,000',
            commodity_number:'200',
            commodity_name:'苹果mp3'

          },{
            purchase_date: '2016-05-02',
            task_number: '00001',
            vendor: '苹果商贸有限公司',
            purchase_price:'50,000',
            commodity_number:'200',
            commodity_name:'苹果mp3'

          },{
            purchase_date: '2016-05-02',
            task_number: '00001',
            vendor: '苹果商贸有限公司',
            purchase_price:'50,000',
            commodity_number:'200',
            commodity_name:'苹果mp3'

          }, ],
        options: [{
          value: '选项1',
          label: '未完成'
        }, {
          value: '选项2',
          label: '已完成'
        }, {
          value: '选项3',
          label: '全部'
        },]
        }
      }
}
</script>


<style scoped>

* {
    box-sizing: border-box; 
  }
   
  .purchase_task_list {
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