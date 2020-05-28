<template>
  <div class="footer">
    <p>{{company}}</p>
    <p>{{message}}</p>
  </div>
</template>

<script>
export default {
  name: "Footer",
  data() {
    return {
      company: '大商电器代理服务平台',
      message: '大商集团版权所有 copyright@2003-2020 辽ICP备12138号 ICP证:辽B-2-4-20200319'
    };
  }
};
</script>

<style scoped>
/*.footer{*/
/*  height: 100%;*/
/*  width: 100%;*/
/*  background-color: #373f41;*/
/*  color: #fff;*/
/*  font-size: 14px;*/
/*  display: flex;*/
/*  flex-direction:column;*/
/*  justify-content: center;*/
/*  align-items: center;*/
/*}*/
/*.footer p{*/
/*  display: flex;*/
/*  justify-content: center;*/
/*  align-items: center;*/
/*  margin: 0;*/
/*}*/

.footer {
  position: absolute;
  z-index: 9999;
  bottom: 0;
  left: 0;
  height: 80px;
  width: 100%;
  color: #ecf0f1;
  background-color: #3d4450;
}

.footer p {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
