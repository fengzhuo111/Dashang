<template>  
    <div>
      <table class="open">
        <tbody>
          <tr>
            <th><span>收件人：</span></th>
            <td>
              <el-input v-model="inputTo" placeholder="请输入内容"></el-input>
            </td>
          </tr>
          <tr>
            <th><span>主题：</span></th>
            <td>
              <el-input v-model="inputTitle" placeholder="请输入内容"></el-input>
            </td>
          </tr>
          <tr>
            <th rowspan="30" style="display: flex; justify-content: flex-end;"><span>正文：</span></th>
            <td>
              <textarea v-model="inputText" class="" rows="30" cols="70"></textarea>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
 
</template>

<script>
export default {
  name: "write",
  data() {
    return {
      from:'',
      inputTo: '',
      inputTitle: '',
      time:'',
      inputText:''
    };
  }
};
</script>
<style scoped>

table.open tr{
  height: 50px;
  padding: 5px;
}
table.open th{
  width: 80px;
  text-align: right;
}

</style>

