<template>
  <div id="detail">
    <buttongroup></buttongroup>
    <div class="information">
      <div class="information_left">
        <img src="../mail_assets/01.gif" style="width: 100px; height: 100px" />
        <!-- @/assets/01.gif -->
      </div>

      <div class="information_right">
        <div>商品名称：{{message}}</div>
        <div>品牌：{{message}}</div>
        <div>编号：{{message}}</div>
      </div>
    </div>
    <div class="t_form">
      <el-form ref="form" label-width="100px" size="mini">
        <el-form-item label="商品描述：">
          <el-input id="simpleinput" v-model="detaildescribe"></el-input>
        </el-form-item>
        <el-form-item label="生产厂商：">
          <el-select v-model="firmvalue" placeholder="请选择厂商">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品状态：">
          <el-select v-model="statevalue" placeholder="请选择状态">
            <el-option
              v-for="item in states"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="定价：">
          <el-input-number v-model="price" :precision="2" :step="0.1" :max="10000"></el-input-number>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import buttongroup from '../mail_com/buttongroup'
export default {
  name: "detial",
  components:{
      buttongroup
  },
  data() {
    return {
      message: "信息",
       options: [{
          value: '选项1',
          label: '厂商一'
        }, {
          value: '选项2',
          label: '厂商二'
        }, {
          value: '选项3',
          label: '厂商三'
        }, {
          value: '选项4',
          label: '厂商四'
        }, {
          value: '选项5',
          label: '厂商五'
        }],
        firmvalue: '',
        states: [{
          value: '选项1',
          label: '下架'
        }, {
          value: '选项2',
          label: '上架'
        }],
        statevalue:'',
        price:'9999.99',
        detaildescribe:''

    };
  },
  created(){
      this.firmvalue = this.options[0].value
      this.statevalue = this.states[0].value
  }
};
</script>

<style scoped>
.el-input__inner{
    padding-left: 20px;
    padding-right: 20px;
}
#simpleinput {
  width: 200px;
}
.information_right,
.information_left {
  display: inline-block;
  margin: 10px;
  line-height: 30px;
}
.el-tabs__content,
#pane-1,
#detail {
  height: 100%;
}
</style>