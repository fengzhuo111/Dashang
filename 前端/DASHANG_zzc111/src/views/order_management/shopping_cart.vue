
<template>
    <div id='shopping_cart' width='80%'>
    <!--头部 -->
        <div class="header">
        购物车
        </div>
        <!-- 导航栏 -->
        <div class="topnav">
        
        </div>

    
      
        
        <!--页面主体 -->
        <div class='el-container' direction='vertical'>
            <el-table :data="table_order" style="width: 80%" align="center" > 
                <el-table-column prop="comImage" label="商品图片" align="center" width="150px" padding="0px" :show-overflow-tooltip = "true">
                    <template slot-scope="scope">
                        <img :src="api + scope.row.comImage" alt="" style="width: 36px;height:36px">
                    </template>
                </el-table-column>
                <el-table-column prop="commodity_name" label="商品名称" width="180" v-on:click="counter+=1"></el-table-column>
                <el-table-column prop="commodity_number" label="商品数量" width="100" float="right">
                    <template >
                    <div  class='el-container' direction='horizontal' align='center'>
                        <el-button v-on:click="commodity_number+=1"  type="text" size="small">+</el-button>
                        <el-input v-model="commodity_number" placeholder="1" width='10'></el-input>
                        <el-button v-on:click="commodity_number-=1" type="text" size="small">-</el-button>
                    </div>
                    </template>
                </el-table-column>
                <el-table-column  label="删除商品 " width="120">
                    <template slot-scope="scope">
                        <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">移出购物车</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination layout="prev, pager, next" :total="50" align="center"></el-pagination>
            <el-button >下单</el-button>

        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
          table_order: [{
            ommodity_number: '1',
            commodity_name: '苹果mp3',
            
          }, 
          {
            ommodity_number: '1',
            commodity_name: '苹果mp3',
            
          }, 
          {
            ommodity_number: '1',
            commodity_name: '苹果mp3',
            
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
   
  .shopping_cart {
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












