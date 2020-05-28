<template>
    <div style="width: 100%; height: calc(100vh - 140px);">
        <div style="width: 100%;margin-bottom: -50px;text-align:center">
            <span style="font-weight: bold;font-size: 40px;margin: 10px auto">订单管理</span>
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
                ref="filterTable"
                :data="tableData"
                style="width: 100%;height: 450px"
                max-height="450px">
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="订单 ID：">
                            <span>{{ props.row.orderId }}</span>
                        </el-form-item>
                        <el-form-item label="订单状态：">
                            <span>{{ props.row.orderState }}</span>
                        </el-form-item>
                        <el-form-item label="收货人姓名：">
                            <span>{{ props.row.userName }}</span>
                            <el-button type="text"><i class="el-icon-edit"></i></el-button>
                        </el-form-item>
                        <el-form-item label="收货人电话：">
                            <span>{{ props.row.userTelephone }}</span>
                            <el-button type="text"><i class="el-icon-edit"></i></el-button>
                        </el-form-item>
                        <el-form-item label="收货人email：">
                            <span>{{ props.row.userEmail }}</span>
                            <el-button type="text"><i class="el-icon-edit"></i></el-button>
                        </el-form-item>
                        <el-form-item label="收货人地址：">
                            <span>{{ props.row.userAddress }}</span>
                            <el-button type="text"><i class="el-icon-edit"></i></el-button>
                        </el-form-item>
                        <el-form-item label="订单内容：" style="display: block">
                            <el-table
                                    :data="goodsTableData"
                                    stripe
                                    style="width: 2400px">
                                <el-table-column
                                        label="序号"
                                        width="50px"
                                        type="index"
                                        align="center"
                                        show-overflow-tooltip>
                                </el-table-column>
                                <el-table-column
                                        prop="goodsId"
                                        label="商品编号"
                                        width="180px">
                                </el-table-column>
                                <el-table-column
                                        prop="goodsName"
                                        label="商品名称"
                                        width="260px">
                                </el-table-column>
                                <el-table-column
                                        prop="goodsPrice"
                                        label="商品售价"
                                        align="center"
                                        width="180px">
                                </el-table-column>
                                <el-table-column
                                        prop="goodsAmount"
                                        label="商品数量"
                                        align="center"
                                        width="180px">
                                </el-table-column>
                                <el-table-column
                                        prop="goodsAmountSP"
                                        label="合计"
                                        align="center"
                                        width="200">
                                </el-table-column>
                                <el-table-column
                                        label="评价"
                                        align="center"
                                        width="400px">
                                    <template slot-scope="scope">
                                        <el-rate
                                                v-model="value"
                                                show-text>
                                        </el-rate>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" style="margin-top: 20px">确认地址</el-button>
                            <el-button type="primary" style="margin-top: 20px">收货</el-button>
                        </el-form-item>
                        <el-form-item label="总价：">
                            <span>{{ props.row.orderAmountPrice }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="序号"
                    width="100px"
                    type="index"
                    align="center"
                    show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                    label="订单 ID"
                    width="120"
                    align="center"
                    prop="orderId">
            </el-table-column>
            <el-table-column
                    label="订单状态"
                    width="180"
                    align="center"
                    prop="orderState"
                    :filters="[{ text: '待接单', value: '待接单' },
                    { text: '待收货', value: '待收货' },
                    { text: '已完成', value: '已完成' }]"
                    :filter-method="filterTag"
                    filter-placement="bottom-end">
            </el-table-column>
            <el-table-column
                    label="订单内容"
                    width="500px"
                    prop="orderName">
            </el-table-column>
            <el-table-column
                    label="下单日期"
                    prop="orderDate"
                    sortable
                    align="center"
                    width="180"
                    column-key="orderDate"
                    :filters="[{text: '2016-05-01', value: '2016-05-01'}, {text: '2016-05-02', value: '2016-05-02'}, {text: '2016-05-03', value: '2016-05-03'}, {text: '2016-05-04', value: '2016-05-04'}]"
                    :filter-method="filterHandler">
            </el-table-column>
            <el-table-column
                    label="操作"
                    align="center"
                    fixed="right"
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
                    style="margin-top: 10px;text-align: center;">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "userOrder",
        data() {
            return {
                value: null,
                input: '',
                goodsTableData: [{
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsAmount: '5',
                    goodsAmountSP: '3130*5'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsAmount: '5',
                    goodsAmountSP: '3130*5'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsAmount: '5',
                    goodsAmountSP: '3130*5'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsAmount: '5',
                    goodsAmountSP: '3130*5'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsAmount: '5',
                    goodsAmountSP: '3130*5'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsAmount: '5',
                    goodsAmountSP: '3130*5'
                },],
                tableData: [{
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                }, {
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                }, {
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                }, {
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                }, {
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                }, {
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                }, {
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                }, {
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                }, {
                    orderId: '12987122',
                    orderState: '待接单',
                    orderName: '三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通,三星智能手机S10旗舰版全网通',
                    userName: 'LV驴',
                    userTelephone: '13838384438',
                    userEmail: '1231231@qq.com',
                    userAddress: '辽宁省朝阳市清水县童家堡平安街14号',
                    orderAmountPrice: '3130*5*6',
                    orderDate: '2019/2/29'
                },]
            }
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            filterHandler(value, row, column) {
                const property = column['property'];
                return row[property] === value;
            },
            filterTag(value, row) {
                return row.tag === value;
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
