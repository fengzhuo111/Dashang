<template>
    <div class="vendorMain">
        <el-tabs type="border-card" :tab-position="tabPosition" style="height: 100%;">
            <el-tab-pane><span slot="label"><i class="el-icon-s-data"></i> <span
                    style="font-size: 14px;">季度报表</span></span>
                <vendor-charts></vendor-charts>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-order"></i> <span
                    style="font-size: 14px;">生产管理</span></span>
                <vendor-my-goods></vendor-my-goods>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-claim"></i> <span
                    style="font-size: 14px;">任务管理</span></span>
                <vendor-task></vendor-task>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-goods"></i> <span
                    style="font-size: 14px;">查看产品</span></span>
                <vendor-goods></vendor-goods>
            </el-tab-pane>
            <el-tab-pane><span slot="label"><i class="el-icon-s-shop"></i> <span
                    style="font-size: 14px;">注册产品</span></span>
                <vendor-new></vendor-new>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    import vendorCharts from "./vendor/vendorCharts";
    import vendorTask from "./vendor/vendorTask";
    import vendorGoods from "./vendor/vendorGoods";
    import vendorMyGoods from "./vendor/vendorMyGoods";
    import vendorNew from "./vendor/vendorNew";

    export default {
        name: "vendor",
        components: {
            vendorCharts,
            vendorTask,
            vendorGoods,
            vendorMyGoods,
            vendorNew,
        },
        data() {
            return {
                tabPosition: 'left'
            };
        },
    }
</script>

<style scoped>
    .vendorMain {
        height: 100%;
        width: 100%;
        padding: 0;
        position: fixed;
    }

    .el-tab-pane {
        font-size: 60px;
    }
</style>
