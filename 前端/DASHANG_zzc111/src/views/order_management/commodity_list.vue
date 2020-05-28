<template>
<div id='commodity_list'>
<!--头部 -->
<!--    <div style="text-align: center;font-size: 20px">-->
<!--      欢迎查看商品列表-->
<!--    </div>-->
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
    <div class="container">

       <el-table :data="table_order" style="width: 80%" align="center" >
        <el-table-column prop="commodity_picture" label="商品图片" width="180"></el-table-column>
         <el-table-column prop="commodity_name" label="商品名称" width="180"></el-table-column>
        <el-table-column prop="commodity_brand" label="品牌" width="180"></el-table-column>
        <el-table-column prop="commodity_price" label="价格" width="180"></el-table-column>

        </el-table>
        <el-pagination layout="prev, pager, next" :total="50" align="center"></el-pagination>


    </div>
  </div>
</template>

<script>
export default {
    data() {
        return {
          table_order: [{
            commodity_picture: '一张图片',
            commodity_name: '99999',
            commodity_price: '三星s10',
            commodity_brand: '三星'
          },
          {
            commodity_picture: '一张图片',
            commodity_name: '99999',
            commodity_price: '三星s10',
            commodity_brand: '三星'
          },
          {
            commodity_picture: '一张图片',
            commodity_name: '99999',
            commodity_price: '三星s10',
            commodity_brand: '三星'
          },
          {
            commodity_picture: '一张图片',
            commodity_name: '99999',
            commodity_price: '三星s10',
            commodity_brand: '三星'
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

  .commodity_list {
    font-family: Arial;
    padding: 10px;
    background: #f1f1f1;
  }

  /* 头部标题 */
  /*.header {*/
  /*  padding: 30px;*/
  /*  text-align: center;*/
  /*  background: white;*/
  /*}*/

  .header h1 {
    font-size: 50px;
  }

  /* 导航条 */
  .topnav {
    overflow: hidden;
    background-color: #333;
  }

  /* 导航条链接 */
  .topnav a {
    float: left;
    display: block;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }

  /* 链接颜色修改 */
  .topnav a:hover {
    background-color: #ddd;
    color: black;
  }

  /* 搜索条*/
  .search {
    padding: 30px;
    float: right;
  }

  /* 创建两列 */
  /* Left column */
  .container {
    overflow: hidden;
    width: 80%;
  }

  /* 右侧栏 */
  .rightcolumn {
    float: left;
    width: 25%;
    background-color: #f1f1f1;
    padding-left: 20px;
  }

  /* 图像部分 */
  .fakeimg {
    background-color: #aaa;
    width: 100%;
    padding: 20px;
  }

  /* 文章卡片效果 */
  .card {
    background-color: white;
    padding: 20px;
    margin-top: 20px;
  }

  /* 列后面清除浮动 */
  .row:after {
    content: "";
    display: table;
    clear: both;
  }

  /* 底部 */
  .footer {
    padding: 20px;
    text-align: center;
    background: #ddd;
    margin-top: 20px;
  }



/*分页*/
ul.pagination {
    display: inline-block;
    padding: 0;
    margin: 0;
}

ul.pagination li {display: inline;}

ul.pagination li a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
}
ul.pagination li a.active {
  background-color: #4CAF50;
  color: white;
}

ul.pagination li a:hover:not(.active) {background-color: #ddd;}


  /* 响应式布局 - 屏幕尺寸小于 800px 时，两列布局改为上下布局 */
  @media screen and (max-width: 800px) {
    .leftcolumn, .rightcolumn {
      width: 100%;
      padding: 0;
    }
  }

  /* 响应式布局 -屏幕尺寸小于 400px 时，导航等布局改为上下布局 */
  @media screen and (max-width: 400px) {
    .topnav a {
      float: none;
      width: 100%;
    }
  }





</style>
