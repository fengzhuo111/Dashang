<template>
  <el-button-group>
    <el-button type="primary" icon="el-icon-goods">去采购</el-button>
    <el-button type="primary" icon="el-icon-sold-out">下架</el-button>
    <el-button type="primary" icon="el-icon-sell">上架</el-button>
    <el-button type="primary" icon="el-icon-delete">删除</el-button>
   
  </el-button-group>
</template>
<script>
export default {
    name: 'buttongroup'
}
</script>
<style scoped>
/* .el-button-group{
    margin: 20px;
} */
.el-button{
    margin: 10px;
}
</style>