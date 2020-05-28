<template>
    <div class="mail_detial">
        <div class="detial_top">
            <h2 style="padding:0px 10px;">邮件主题</h2>
            <p>发件人：<span>用户 (fengzhuo123@mail.dlut.edu.cn)</span></p>
            <p>时  间：<span>2019年08月30日 11:06:22 (星期五)</span></p>
            <p>收件人：<span>atlantis@dlut.edu.cn</span></p>
        </div>
        <div class="detial_buttom">
            富文本
        </div>
    </div>
</template>
<script>
export default {
    name: 'maildetial',
}
</script>
<style scoped>
.detial_top{
    border: 3px solid lightgray;
    background: #e8e8e8;
    height: 200px;
}
.detial_buttom{
    
    height: 50%;
}
.mail_detial{
    height: 100%;
}
.detial_top p{
    padding: 5px 10px;
    color: rgba(0, 0, 0, 0.65);
    font-size: 14px;
}
p span{
    font-size: 14px;
}

</style>