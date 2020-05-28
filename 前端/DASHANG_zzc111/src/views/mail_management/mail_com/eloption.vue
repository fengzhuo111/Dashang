<template id="mailInputSetting">
 
<el-select class="selectSetting" v-model="value" placeholder="标记为" id="mailInput">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
 
  
</template>

<script>
  export default {
      name: 'eloption',
    data() {
      return {
        options: [{
          value: '选项1',
          label: '已读'
        }, {
          value: '选项2',
          label: '未读'
        }, {
          value: '选项3',
          label: '紧急'
        }, {
          value: '选项4',
          label: '普通'
        }, {
          value: '选项5',
          label: '缓慢'
        }],
        value: ''
      }
    }
  }
</script>
<style>
#mailInput {
  width: 100px;
  font-size: 14px;
   background-color: #009688 !important;
   color: #FFF !important;
}
.selectSetting{
  left: 10px;
  width: 90px !important;
}
/* #mailInput .el-input__inner{
    padding-left: 20px;
    padding-right: 20px;
} */

</style>