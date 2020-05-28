<template>

<div class="mailLeftMain">
  <el-tabs id="mailTab" :tab-position="tabPosition" style="height: 100%; ">
    <el-tab-pane label="欢迎页">
      <welcome ref="mailWelcome"></welcome>
    </el-tab-pane>
    <!-- <el-tab-pane label="详情页">
      <detial></detial>
    </el-tab-pane> -->
    <!-- <el-tab-pane label="邮件详情页">
      <el-row class="top_function"> 
        <div class="btn-container">
        <el-button type="primary" size="medium">回复</el-button>
        <el-button type="primary" size="medium">转发</el-button>
        <el-button type="primary" size="medium">删除</el-button>
        <eloption></eloption>
        </div>  
      </el-row>
      <maildetial></maildetial>
    </el-tab-pane> -->
    <el-tab-pane label="写信" >
      <el-row class="top_function">
      <div class="btn-container">
        <el-button type="primary" size="medium" @click="sendMail">发送</el-button>
        <el-button type="primary" size="medium" @click="saveDraft">存草稿</el-button>
        <el-button type="primary" size="medium">取消</el-button>
      </div>
    </el-row>
      <write ref="mailWrite"></write>
    </el-tab-pane>

    <el-tab-pane label="收信">
      
      <el-row class="top_function"> 
        <div class="btn-container">
        <el-button type="primary" size="medium" @click="deleteInbox(select)">删除</el-button>
        <el-button type="primary" size="medium">转发</el-button>
        <eloption></eloption>
        </div>
      </el-row>
      
      
      <inbox ref="mailInbox"></inbox>
    </el-tab-pane>

    <el-tab-pane label="草稿箱">
       <el-row class="top_function"> 
        <div class="btn-container">
        <el-button type="primary" size="medium" @click="deleteDraft(select)">删除</el-button>
        <el-button type="primary" size="medium">发送</el-button>
        </div>
      </el-row>
  
      <draft ref="mailDraft"></draft>    
    </el-tab-pane>
    <el-tab-pane label="已发送">
      <el-row class="top_function"> 
        <div class="btn-container">
        <el-button type="primary" size="medium" @click="deleteSent(select)">删除</el-button>
        <el-button type="primary" size="medium">再次发送</el-button>
        <eloption></eloption>
        </div>
      </el-row>
      
      <sent></sent>
    </el-tab-pane>
  </el-tabs>
</div>


</template>

<script>
import inbox from './page/inbox'
import welcome from './page/welcome'
import detial from './page/detail'
import write from './page/write'
import eloption from './mail_com/eloption'
import draft from './page/draft'
import sent from './page/sent'
import maildetial from './page/mail_detial'
export default {
  name: 'left',
  components:{
   inbox,
    welcome,
    detial,
    write,
    eloption,
    draft,
    sent,
    maildetial
  },
  data() {

      return {
        select: [],
        tabPosition: 'left',
        mailnum: 0,
        unReadNum: 0,
        
        
      };
  },
  mounted(){
    this.init()
  },
  methods:{
    init(){
      var _this = this
    

      // 欢迎页-初始化
      this.$http.get('http://localhost:8088/message/unReadNum?userName=fengzhuo')
      .then(function(response){
        console.log(response)
        _this.$refs.mailWelcome.unReadNum = response.data
        _this.$refs.mailInbox.unReadNum = response.data
      }).catch(function(e){
        console.log(e)
      })

      // 邮件数目初始化
      this.$http.get('http://localhost:8088/message/mailNum',{params:{userName:'fengzhuo'}})
       .then(function(response){
        console.log(response)
        _this.$refs.mailInbox.mailnum = response.data
      }).catch(function(e){
        console.log(e)
      })

      
      
    },
    sendMail(){
      var _this = this
      var nowtime = this.getDate()
      if((this.$refs.mailWrite.inputTitle == '') || (this.$refs.mailWrite.inputTo == '') || (this.$refs.mailWrite.inputText == '')){
        this.$toast({text:'邮件信息不完整，无法发送', duration: 3000})
        retrun;
      }

      // 保存邮件
      this.$http.post('http://localhost:8088/save/mail',{
          userName: _this.$store.state.username,
          mailTheme: _this.$refs.mailWrite.inputTitle,
          mailSender: _this.$store.state.email,
          mailDate: nowtime,
          mailType: 1,
          mailRecipient: _this.$refs.mailWrite.inputTo,
          mailDetial: _this.$refs.mailWrite.inputText
      }).then(function(response){
        console.log(response)
        if(response.data == 1){
          _this.$toast({text:'邮件发送成功', duration: 3000})
        }else{
          _this.$toast({text:'邮件发送失败', duration: 3000})
        }
      }).catch(function(e){
        console.log(e)
      })


    },
    saveDraft(){
      var _this = this
      var nowtime = this.getDate()
      // 保存草稿
      this.$http.post('http://localhost:8088/save/draft',{
          userName: _this.$store.state.username,
          mailTheme: _this.$refs.mailWrite.inputTitle,
          mailSender: _this.$store.state.email,
          mailDate: nowtime,
          mailRecipient: _this.$refs.mailWrite.inputTo,
          mailDetial: _this.$refs.mailWrite.inputText
      }).then(function(response){
        console.log(response)
        if(response.data == 1){
          _this.$toast({text:'草稿保存成功', duration: 3000})
        }else{
          _this.$toast({text:'草稿保存失败', duration: 3000})
        }
      }).catch(function(e){
        console.log(e)
      })
    },
    //  deleteDraft(multipleSelection){
    //   var _this = this
    //    // select值绑定
    //   this.select = this.$refs.mailDraft.multipleSelection
    //   console.log(this.select)
    //   // 删除提示
    //   this.showNotice()
    //     // 删除
    //   this.$http.post('http://localhost:8088/delete/drafts',{
    //     items: multipleSelection
    //   }).then(function(response){
    //     console.log(response)
    //   }).catch(function(e){
    //     console.log(e)
    //   })

    // },
    deleteInbox(multipleSelection){
      var _this = this
       // select值绑定
      this.select = this.$refs.mailInbox.multipleSelection
      console.log(this.select)
      // 删除提示
      this.showNotice()

        // 删除
      this.$http.post('http://localhost:8088/delete/mails',{
        items: multipleSelection
      }).then(function(response){
        console.log(response)
      }).catch(function(e){
        console.log(e)
      })

    },
    async showNotice(){
      // 弹出提示框
      const result = await this.$confirm('此操作将永久删除所选, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch(err => err)

        if(result !== 'confirm'){
          return this.$message.info('');
        }
        console.log('确认了删除')       
    },
    getDate(){
      var now = new Date();
      var year = now.getFullYear(); //得到年份
      var month = now.getMonth();//得到月份
      var date = now.getDate();//得到日期
      
      var hour = now.getHours();//得到小时
      var minu = now.getMinutes();//得到分钟
      var sec = now.getSeconds();//得到秒

      month = month + 1;
      if (month < 10) month = "0" + month;
      if (date < 10) date = "0" + date;
      if (hour < 10) hour = "0" + hour;
      if (minu < 10) minu = "0" + minu;
      if (sec < 10) sec = "0" + sec;

      var time = ''
      time = year+'-'+month+'-'+date+' '+hour+':'+minu+':'+sec;
      return time;  
    }
  }
}



</script>
<style>
  .mailLeftMain{
    height: 100%;
    width: 100%;
    padding:0;
    background: transparent;
    /*display: flex;*/
    position: absolute;
    /*align-content: center;*/
  }

#mailTab .el-tabs__header{
    margin: 0px !important;
    width: 200px;
    background: #282b33;
    
  }
 
#mailTab  .el-tabs__item{
    padding: 5px 20px !important;
    height: 45px !important;
    color: #fff !important;
    text-align: left !important;
  }
  
#mailTab  .el-tabs__item.is-active {
    background-color: #009688;
}
 
.mailLeftMain  .el-button--primary {
    color: #FFF !important;
    background-color: #009688 !important;
    border-color: #02756a !important;
    transition: background-color 0.5s, color 0.5s;
}
.mailLeftMain .el-button--primary:hover{
  color: #FFF !important;
  background-color: #30a89d !important;
}
.mailLeftMain .btn-container{
  margin-left: 80px ;
  padding: 5px;
}
.mailLeftMain .top_function{
  border: 1px solid lightgray;
  height: 50px;
  margin: 0;
  background-color: #FFF;
}

.mailLeftMain .el-tab-pane{
  height: 100%;
}
.mailLeftMain .el-tabs__content{
  height: 100%;
  /* background-color: rgb(238, 222, 222);
    opacity: 0.85; */
}

</style>
