<!DOCTYPE html>
<html lang="zh">
<head>
    <title>Hello Spring Security</title>
    <meta charset="utf-8" />
    <script src="/echarts.min.js"></script>
</head>
<body>
<div>
    <#list datas as data >
        ${data}
    </#list>
</div>
    <div id="main" style="width: 100%;height:400px;"></div>
    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('main'));

        var option = {
            xAxis: {
                type: 'category',
                data: []
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [],
                type: 'line',
                smooth: true
            }]
        };
        var count = 1;
        <#list datas as data >
            option.xAxis.data.push('' + count++);
            option.series[0].data.push(${data});
        </#list>

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>