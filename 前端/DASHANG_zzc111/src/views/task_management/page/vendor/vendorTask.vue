<template>
    <div style="width: 100%;height: calc(100vh - 160px);">
        <div style="width: 100%;margin-bottom: -50px;text-align:center">
            <span style="font-weight: bold;font-size: 40px;margin: 10px auto">任务管理</span>
        </div>
        <div style="float: right;width: 500px;margin: 20px">
            <el-input
                    placeholder="请输入内容"
                    prefix-icon="el-icon-search"
                    v-model="input"
                    style="margin: 5px;width: 100%">
            </el-input>
        </div>

        <el-table
                :data="tableData"
                style="width: 100%;height: 400px"
                max-height="400px">
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="商品图片" style="display: block">
                            <img :src="props.row.goodsImageUrl" style="height: 100px;width: 100px"/>
                        </el-form-item>
                        <el-form-item label="商品名称：">
                            <span>{{ props.row.taskName }}</span>
                        </el-form-item>
                        <el-form-item label="商品报价：">
                            <span>{{ props.row.taskOffer }}</span>
                        </el-form-item>
                        <el-form-item label="任务 ID：">
                            <span>{{ props.row.taskId }}</span>
                        </el-form-item>
                        <el-form-item label="采购数量：">
                            <span>{{ props.row.taskAmount }}</span>
                        </el-form-item>
                        <el-form-item label="任务状态：">
                            <span>{{ props.row.taskState }}</span>
                        </el-form-item>
                        <el-form-item label="总价：">
                            <span>{{ props.row.taskAmountOffer }}</span>
                        </el-form-item>
                        <el-form-item label="物业地址：">
                            <span>{{ props.row.managerAddress }}</span>
                        </el-form-item>
                        <el-form-item label="物业联系方式：">
                            <span>{{ props.row.telephoneManager }}</span>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" style="margin-top: 20px">接单</el-button>
                            <el-button type="primary" style="margin-top: 20px;margin-left: 25px">到货</el-button>
                        </el-form-item>
                        <el-form-item label="采购数量：" style="margin-top: 20px">
                            <el-input-number v-model="props.row.taskAmount" controls-position="right"
                                             @change="handleChange" :min="0" :max="100000"></el-input-number>
                            <el-button type="primary" style="margin-left: 20px">确定</el-button>
                        </el-form-item>

                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="任务 ID"
                    width="180px"
                    prop="taskId">
            </el-table-column>
            <el-table-column
                    label="任务状态"
                    width="180px"
                    prop="taskState"
                    :filters="[{ text: '待下单', value: '待下单' },
                    { text: '待收货', value: '待收货' },
                    { text: '已完成', value: '已完成' }]"
                    :filter-method="filterTag"
                    filter-placement="bottom-end">
            </el-table-column>
            <el-table-column
                    label="任务商品"
                    width="240px"
                    prop="taskName">
            </el-table-column>
            <el-table-column
                    label="采购数量"
                    width="180px"
                    sortable
                    prop="taskAmount">
            </el-table-column>
            <el-table-column
                    label="报价"
                    width="180px"
                    sortable
                    prop="taskOffer">
            </el-table-column>
            <el-table-column
                    label="总价"
                    width="180px"
                    sortable
                    prop="taskAmountOffer">
            </el-table-column>
            <el-table-column
                    label="任务日期"
                    prop="taskDate"
                    sortable
                    width="180"
                    column-key="taskDate"
                    :filters="[{text: '2019-05-01', value: '2019-05-01'},
                    {text: '2019-05-02', value: '2019-05-02'},
                    {text: '2019-05-03', value: '2019-05-03'},
                    {text: '2019-05-04', value: '2019-05-04'}]"
                    :filter-method="filterHandler">
            </el-table-column>
            <el-table-column
                    label="操作"
                    fixed="right"
                    align="center"
                    width="100px">
                <template slot-scope="scope">
                    <el-button type="primary" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div class="block">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page.sync="currentPage3"
                    :page-size="100"
                    layout="prev, pager, next, jumper"
                    :total="1000"
                    style="margin-top: 10px;text-align: center">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "venderTask",
        data() {
            return {
                input: '',
                tableData: [{
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                }, {
                    taskName: '三星智能手机S10旗舰版全网通',
                    taskId: '12987122',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    taskPrice: '3130',
                    taskOffer: '2130',
                    taskState: '待收货',
                    taskAmount: '1233',
                    taskDate: '2019-5-1',
                    managerAddress: '上海市浦东区青桥镇顺安街215号',
                    telephoneManager: '13838384438',
                    taskAmountOffer: '2130*1233',
                },]
            }
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            filterTag(value, row) {
                return row.tag === value;
            },
            filterHandler(value, row, column) {
                const property = column['property'];
                return row[property] === value;
            },
            handleChange(value) {
                console.log(value);
            },
        }
    }
</script>

<style scoped>
    .demo-table-expand {
        font-size: 0;
    }

    .demo-table-expand label {
        width: 90px;
        color: #99a9bf;
    }

    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }
</style>
