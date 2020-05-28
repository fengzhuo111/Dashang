<template>
  <div id="reg">
    <div id="regbox">  <!--注册信息盒子-->
        <el-form  label-width="110px" id="r_form">
            <el-form-item label="填写商品名称">  <!--一个输入框-->
                <el-input placeholder="商品名称"></el-input>
            </el-form-item>
            <el-form-item label="填写商品品牌">
                <el-input placeholder="商品品牌"></el-input>
            </el-form-item>
            <el-form-item label="填写商品报价">
                <el-input placeholder="商品报价"></el-input>
            </el-form-item>
            <el-form-item label="填写备注信息">   <!--多行输入框-->
                <el-input type="textarea" placeholder="备注信息"></el-input>
            </el-form-item>
            <el-form-item label="">
                <el-checkbox label="本人已阅读并同意服务条跨" name="type"></el-checkbox>
            </el-form-item>
            <el-form-item id="buttons">     <!--按钮部分-->
                <el-button type="primary">确认注册</el-button>
                <el-button type="info">重置数据</el-button>
            </el-form-item>
        </el-form>
    </div>
  </div>
</template>

<script>

</script>

<style scoped>
    #reg{
        height:100%;
        margin: 0;
        padding: 0;
    }
    #regbox{
        width: 660px;
        height: 450px;
        background-color:snow;
        border-radius: 6px;
        position: absolute;
        left:50%;
        top:50%;
        transform: translate(-50%,-50%);
    }
    #r_form{
        padding: 10px 0 4px 10px;
        width: 93%;
        position: absolute;
        bottom: 0;
    }
    #buttons{
        padding:0 20px 0 0;
        display:flex;
        justify-content: flex-end;
    }
</style>
