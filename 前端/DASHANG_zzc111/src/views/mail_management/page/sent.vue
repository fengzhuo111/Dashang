<template>
<div>
  <el-card>
<div class="mail_msg"><strong><span>已发送</span></strong><span style="color:rgba(0,0,0,0.7); font-size:14px; margin-left:10px;">   (共 {{sentnum}} 封)</span></div>
  <el-table
    :data="sentList"
    style="width: 100%"
    height="450">
     <el-table-column
      type="selection"
      width="55">
      <!-- @selection-change="handleSelectionChange"> -->
    </el-table-column>
    <el-table-column
      prop="sentSender"
      label="收件人"
      width="120">
    </el-table-column>
    <el-table-column
      prop="sentTheme"
      label="主题"
      width="200">
    </el-table-column>
     <el-table-column
      prop="sentDetial"
      label="正文"
      width="600">
    </el-table-column>
    <el-table-column
      
      prop="sentDate"
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
      :total="totalSent">
    </el-pagination>
  </el-card>
  
</div>

</template>

<script>
  export default {
    name: 'sent',

    data() {
      return {
        multipleSelection: [],
        sentnum:0,
        sentList:[],
        totalSent: 0,
        queryInfo:{
          query:'',
          pagenum: 1,
          pagesize: 2
        },
      
        // methods:{   
        //     handleSelectionChange(val) {
        //         this.multipleSelection = val;
        //     }
        // }
      }
    },
    created(){
      this.init()
      this.initSentNum()
    },
    mounted(){
      this.init()
      this.initSentNum()
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
          init(){
            var _this = this
             // 草稿箱初始化
              this.$http.get('http://localhost:8088/message/sents',{
                params:{
                  userName:'fengzhuo',
                  page: _this.queryInfo.pagenum,
                  pageSize: _this.queryInfo.pagesize
                  }})
              .then(function(response){
                  console.log(response.data)
                  _this.sentList = response.data.items
                  _this.totalSent = response.data.total   
               }).catch(function(e){
                    console.log(e)
              })


          },
          initSentNum(){
            var _this = this
              this.$http.get('http://localhost:8088/message/sentNum',{params:{userName:'fengzhuo'}})
            .then(function(response){
              console.log(response)
              _this.sentnum = response.data
            }).catch(function(e){
              console.log(e)
            })
          }
          
    },
  }
</script>

<style>

</style>