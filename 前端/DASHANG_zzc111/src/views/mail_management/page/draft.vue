<template>
<div>
  <el-card>
  <div class="mail_msg"><strong><span>草稿箱</span></strong><span style="color:rgba(0,0,0,0.7); font-size:14px; margin-left:10px;">   (共 {{draftnum}} 封)</span></div>
 <el-table
    :data="draftList"
    style="width: 100%"
    height="450"
     @selection-change="handleSelectionChange">
     <el-table-column
      type="selection"
      width="55">
      <!-- @selection-change="handleSelectionChange"> -->
    </el-table-column>
   
    <el-table-column
      prop="draftSender"
      label="收件人"
      width="120">
    </el-table-column>
    <el-table-column
      prop="draftTheme"
      label="主题"
      width="200">
    </el-table-column>
     <el-table-column
      prop="draftDetial"
      label="正文"
      width="600">
    </el-table-column>
    <el-table-column
      
      prop="draftDate"
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
      :total="totalDraft">
    </el-pagination>
    </el-card>
</div>

 
</template>

<script>
  export default {
    name: 'draft',

    data() {
      return {
        draftnum:0,
        draftList:[],
        totalDraft: 0,
        queryInfo:{
          query:'',
          pagenum: 2,
          pagesize: 2
        },
        multipleSelection: [],
        // methods:{   
        //     handleSelectionChange(val) {
        //         this.multipleSelection = val;
        //     }
        // }
      }
    },
    created(){
      this.init()
      this.initDraftNum()
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
             // 草稿箱初始化
              this.$http.get('http://localhost:8088/message/drafts',{
                params:{
                  userName:'fengzhuo',
                  page: _this.queryInfo.pagenum,
                  pageSize: _this.queryInfo.pagesize
                  }})
              .then(function(response){
                  console.log(response.data)
                  _this.draftList = response.data.items
                  _this.totalDraft = response.data.total   
               }).catch(function(e){
                    console.log(e)
              })


          },
          initDraftNum(){
            var _this = this
              this.$http.get('http://localhost:8088/message/draftNum',{params:{userName:'fengzhuo'}})
            .then(function(response){
              console.log(response)
              _this.draftnum = response.data
            }).catch(function(e){
              console.log(e)
            })
          }
          
    },
}
</script>

<style>

</style>