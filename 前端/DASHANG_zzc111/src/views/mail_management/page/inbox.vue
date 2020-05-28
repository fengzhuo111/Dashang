<template>
<div>
  <el-card>
    <div class="mail_msg"><strong><span>收件箱</span></strong><span style="color:rgba(0,0,0,0.7); font-size:14px; margin-left:10px;">   (共 {{mailnum}} 封，其中 未读邮件 {{unReadNum}} 封)</span></div>
<el-table
    :data="mailList"
    style="width: 100%"
    height="450"
    @selection-change="handleSelectionChange">
     <el-table-column
      type="selection"
      width="55"
      >
      <!-- @selection-change="handleSelectionChange"> -->
    </el-table-column>
    <el-table-column
      prop="mailType"
      label="邮件类型"
      width="100">
    </el-table-column>
    <el-table-column
      prop="mailSender"
      label="发件人"
      width="120">
    </el-table-column>
    <el-table-column
      prop="mailTheme"
      label="主题"
      width="700">
    </el-table-column>
    <el-table-column
      
      prop="mailDate"
      label="日期"
      width="150">
    </el-table-column>
  </el-table>
  <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="queryInfo.pagenum"
      :page-sizes="[1, 2, 5, 10]"
      :page-size="queryInfo.pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="totalMails">
    </el-pagination>
  </el-card>
 
  
</div>
 
</template>

<script>
  export default {
    name: 'inbox',  
    data() {
      return {
        mailnum: 0,
        unReadNum:0,
        queryInfo:{
          query:'',
          pagenum: 1,
          pagesize: 5
        },
        multipleSelection: [],
        mailList:[],
        totalMails: 0,     
      }
    },
    created(){
      this.init()
    },
    methods:{   
          handleSelectionChange(val) {
              this.multipleSelection = val;
          },
          // 监听pagesize改变事件
          handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
             this.queryInfo.pagesize = val
             this.init()
          },
          handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.queryInfo.pagenum = val
            this.init()
          },
          // 监听多选
           handleSelectionChange(val) {
                this.multipleSelection = val;
            },
          init(){
            var _this = this
             // 收件箱初始化
              this.$http.get('http://localhost:8088/message/inboxs',{
                params:{
                  userName:'fengzhuo',
                  page: _this.queryInfo.pagenum,
                  pageSize: _this.queryInfo.pagesize
                  }})
              .then(function(response){
                  console.log(response.data)
                  _this.mailList = response.data.items
                  _this.totalMails = response.data.total   
               }).catch(function(e){
                    console.log(e)
              })
          }
          
    },
   
  }
</script>

<style>

</style>