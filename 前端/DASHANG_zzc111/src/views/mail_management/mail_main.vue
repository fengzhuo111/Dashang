<template>
    <div class="mailHome">
    <el-container>
      <el-header class="mailHeader">
          <!-- Header content -->
          <Header></Header>

        </el-header>

        <el-main class="mailMain">
<!--            <div class="mailMainA">-->
<!--          &lt;!&ndash; Main content &ndash;&gt;-->
<!--&lt;!&ndash;          <hr style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="100%" color=#87CEFA SIZE=3>&ndash;&gt;-->
<!--                <div class="mailMainB">-->
                    <left></left>
<!--                </div>-->
<!--            </div>-->
        </el-main>

        <el-footer class="mailFooter">
          <!-- Footer content -->
<!--          <hr style="FILTER: alpha(opacity=100,finishopacity=0,style=1)" width="100%" color=#87CEFA SIZE=3>-->
          <Footer></Footer>
        </el-footer>

      </el-container>
    </div>
</template>

<script>
import left from './Left';
import Header from "../../components/Header";
import Footer from "../../components/Footer";

export default {
  name: 'mail',
  components:{
      Footer,
      Header,
      left,
  },
  data(){
    return{
      
    }
  }
}


</script>

<style scoped>

  .mailHome{
      height: 100%;
      width: 100%;
      position: fixed;
  }
    .mailHeader{
        height: 100%;
        background-color: #373f41;
        display: flex;
        align-items: center;
    }
    .mailMain{
        height: 100%;
        /*height:fit-content;*/
        padding: 0;
        margin: 0;
        /*position: relative;*/
        /*background-image: url("../../assets/images/background/loginbackground.jpg") ;*/
        /*background-size: 100% 100%;*/
    }
   
    .mailFooter{
        height: 100%;
        width: 100%;
        background-color: #373f41;
        position:absolute;
        bottom:0%;
        display: flex;
        align-items: center;
    }


</style>
