<template>
    <div>
        <div id="lineChart" style="width: 1600px;height: calc(100vh - 160px);"></div>
    </div>
</template>

<script>
    import echarts from 'echarts';

    export default {
        name: "venderCharts",
        mounted() {
            // var myChart = echarts.init(document.getElementById('main'));
            var lineChart = echarts.init(document.getElementById('lineChart'));
            // var option1 = {
            //     title: {
            //         text: '季度畅销商品'
            //     },
            //     tooltip: {},
            //     legend: {
            //         data:['销量']
            //     },
            //     xAxis: {
            //         data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子","衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            //     },
            //     yAxis: {},
            //     series: [{
            //         name: '销量',
            //         type: 'bar',
            //         data: [5, 20, 36, 10, 10, 20,54,12,89,56,44,77]
            //     }]
            // };
            var option2 = {
                legend: {},
                tooltip: {
                    trigger: 'axis',
                    showContent: false
                },
                dataset: {
                    source: [
                        ['product', '2012', '2013', '2014', '2015', '2016', '2017'],
                        ['手机', 41.1, 30.4, 65.1, 53.3, 83.8, 98.7],
                        ['冰箱', 86.5, 92.1, 85.7, 83.1, 73.4, 55.1],
                        ['彩电', 24.1, 67.2, 79.5, 86.4, 65.2, 82.5],
                        ['洗衣机', 55.2, 67.1, 69.2, 72.4, 53.9, 39.1],
                        ['电风扇', 29.1, 38.2, 80.5, 50.4, 12.2, 32.5],
                    ]
                },
                xAxis: {type: 'category'},
                yAxis: {gridIndex: 0},
                grid: {top: '55%'},
                series: [
                    {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                    {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                    {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                    {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                    {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                    {
                        type: 'pie',
                        id: 'pie',
                        radius: '30%',
                        center: ['50%', '25%'],
                        label: {
                            formatter: '{b}: {@2012} ({d}%)'
                        },
                        encode: {
                            itemName: 'product',
                            value: '2012',
                            tooltip: '2012'
                        }
                    }
                ]
            };
            // myChart.setOption(option1);
            lineChart.setOption(option2);
        }
    }
</script>

<style scoped>

</style>
