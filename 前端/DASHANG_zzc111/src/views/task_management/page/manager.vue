<template>
    <div class="managerMain">
        <el-tabs type="border-card" :tab-position="tabPosition" style="height: 100%;">
            <el-tab-pane><span slot="label"><i class="el-icon-s-data"></i> <span
                    style="font-size: 14px;">季度报表</span></span>
                <manager-charts></manager-charts>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-shop"></i> <span
                    style="font-size: 14px;">采购管理</span></span>
                <manager-purchase></manager-purchase>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-claim"></i> <span
                    style="font-size: 14px;">任务管理</span></span>
                <manager-task></manager-task>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-order"></i> <span
                    style="font-size: 14px;">订单管理</span></span>
                <manager-order></manager-order>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-goods"></i> <span
                    style="font-size: 14px;">商品管理</span></span>
                <manager-goods></manager-goods>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-home"></i> <span
                    style="font-size: 14px;">厂商管理</span></span>
                <manager-vendor></manager-vendor>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    import managerOrder from "./manager/managerOrder";
    import managerTask from "./manager/managerTask";
    import managerPurchase from "./manager/managerPurchase";
    import managerGoods from "./manager/managerGoods";
    import managerVendor from "./manager/managerVendor";
    import managerCharts from "./manager/managerCharts";

    export default {
        name: "Manager",
        components: {
            managerOrder,
            managerTask,
            managerPurchase,
            managerGoods,
            managerVendor,
            managerCharts
        },
        data() {
            return {
                tabPosition: 'left'
            };
        },
    }
</script>

<style scoped>
    .managerMain {
        height: 100%;
        width: 100%;
        padding: 0;
        position: fixed;
    }

    .el-tab-pane {
        font-size: 60px;
    }
</style>
