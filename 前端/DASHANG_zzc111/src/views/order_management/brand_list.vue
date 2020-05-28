<template>
    <div id='brand_list' width='80%'>
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
            <button v-on:click="counter+=1">搜索品牌</button>
        </div>
        </div>
        
        <!--页面主体 -->

        <el-table :data="table_order" style="width: 80%" align="center" >
        <el-table-column prop="brand_name" label="品牌名称" width="180" v-on:click="counter+=1"></el-table-column>
        <el-table-column prop="brand_introduction" label="品牌介绍" width="500"></el-table-column>
        </el-table>



    </div>
</template>

<script>
export default {
    data() {
        return {
          table_order: [{
            brand_name: '三星',
            brand_introduction:'三星是全球领先的手机公司，具有最先进的工艺，值得拥有。'
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
   
  .brand_list {
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