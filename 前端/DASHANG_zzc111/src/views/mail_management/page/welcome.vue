<template>
  <div id="welcome">
    <input type="button" id="login" value="登录" @click.stop="maillogin">
    <h3 class="txttitle">欢迎您，{{this.$store.state.username}}</h3>
    <div id="mail_num">
      <span>       
            我的邮箱：   
      </span>
      <span>
      {{unReadNum}} 
      <a href="" value="未读邮件" @click.prevent="toDraft"> 封未读邮件</a>
      </span>
     
    </div>
  </div>
</template>
<script>
export default {
  name: "welcome",
  data() {
    return {
      username: "用户",
      unReadNum: '0'
    };
  },
  methods:{
    maillogin:function(){
      var _this = this
      _this.username = 'fengzhuo'
      this.$http.get('http://localhost:8088/login?userName=fengzhuo')
      .then(function(response){
        console.log(response)
      }).catch(function(e){
        console.log(e)
      })
      this.$store.dispatch('commitUserName','fengzhuo')
      // 登录后自动加载全部信息
      
      
    },
    toDraft:function(){
      
    }
  }
};
</script>
<style scoped>
  #welcome{
    padding: 10px;
    margin-top: 10px;
  }
  #mail_num{
    margin-top: 10px;
  }
  .txttitle{
    color: #1B1B1B;
  }
   a:link{
    color: rgb(43, 1, 43);
    text-decoration-line: none;
  }
  a:hover{
    color: rgba(156, 9, 9, 0.6);
    
  }
</style>