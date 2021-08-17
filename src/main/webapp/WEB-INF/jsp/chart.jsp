<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>飞行零部件全生命周期管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap 3.3.4 -->
    <link href="../resources/Public/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- FontAwesome 4.3.0 -->
 	<link href="../resources/Public/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons 2.0.0 --
    <link href="../resources/Public/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="../resources/Public/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
    <!-- jQuery 2.1.4 -->
    <script src="../resources/Public/plugins/jQuery/jquery-3.2.1.min.js"></script>
    <script src="../resources/common.js" type="text/javascript"></script>
	<script src="../resources/Public/js/global.js"></script>
    <script src="../resources/Public/js/myFormValidate.js"></script>
    <script src="../resources/Public/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../resources/Public/js/layer/layer-min.js"></script><!-- 弹窗js 参考文档 http://layer.layui.com/-->
    <script src="../resources/Public/js/myAjax.js"></script>
    <script src="../resources/amAdd.js"></script>
      <script src="../resources/Public/js/echart/echarts.js"></script>
      <script src="../resources/Public/js/echart/china.js"></script>
      <script src="../resources/Public/js/echart/echarts.js.map"></script>
      <script src="../resources/Public/js/echart/macarons.js"></script>
      <script src="../resources/Public/js/echart/bmap.js"></script>
      <script src="../resources/Public/js/echart/dataTool.js"></script>
  <meta name="__hash__" content="af098848e23b6e770b5a0fa581e8f81a_e923060bad73d6e054e32d7d8661c548" /></head>
  <body style="background-color:#ecf0f5;">
 

<div class="wrapper">
    <!-- Content Header (Page header) -->
   <div class="breadcrumbs" id="breadcrumbs">
	<ol class="breadcrumb">
	<li><a href="javascript:void();"><i class="fa fa-home"></i>&nbsp;&nbsp;飞行零部件全生命周期管理系统</a></li>
	        
	        <li><a href="javascript:void();">新增零部件</a></li>
	        <li><a href="javascript:void();"></a></li>          
	</ol>
</div>

    <section class="content">
    <!-- Main content -->
    <!--<div class="container-fluid">-->
    <div class="row">
      <div class="col-sm-12">
        <div class="panel panel-default">
            <div class="pull-right">
                <a href="javascript:history.go(-1)" data-toggle="tooltip" title="" class="btn btn-default" data-original-title="返回"><i class="fa fa-reply"></i></a>
            </div>
            <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-list"></i>新增零部件</h3>
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-hover" id="table_list">
                    <thead>
                        <tr>
                            <td class="text-right"><div id="main1" style="width: 500px;height:300px;"></div></td>
                            <td class="text-left"><div id="main2" style="width: 500px;height:300px;"></div></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right"><div id="main3" style="width: 500px;height:300px;"></div></td>
                            <td class="text-left"><div id="main4" style="width: 500px;height:300px;"></div></td>
                        </tr>
                    </tbody>
                </table>

                <input type="hidden" name="__hash__" value="af098848e23b6e770b5a0fa581e8f81a_e923060bad73d6e054e32d7d8661c548" />
            </div>
        </div>
 	  </div> 
    </div>    <!-- /.content -->
   </section>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart01 = echarts.init(document.getElementById('main1'));
    var myChart02 = echarts.init(document.getElementById('main2'));
    var myChart03 = echarts.init(document.getElementById('main3'));
    var myChart04 = echarts.init(document.getElementById('main4'));
    // 指定图表的配置项和数据
    var option1 = {
        title: {
            text: '库存报表'
        },
        tooltip: {},
        legend: {
            data:['存量']
        },

        xAxis: {
            data: ["发生器","救生衣","传感器","飞机导线","电插头","转化器"]
        },
        yAxis: {},
        series: [{
            name: '存量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };
    myChart01.setOption(option1);

var option2;
    option2 = {
        title:{
            text:'零部件更换比例',
        },
        legend: {
            top: 'bottom'
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        series: [
            {
                name: '面积模式',

                type: 'pie',
                radius: [0, 120],  /*调整整个画面的大小*/
                center: ['50%', '50%'],
                roseType: 'area',
                itemStyle: {
                    borderRadius: 8
                },
                data: [
                    {value: 40, name: '铆钉'},
                    {value: 38, name: '飞机导线'},
                    {value: 32, name: '救生衣'},
                    {value: 30, name: '电插头'},
                    {value: 28, name: '化学氧发生器'},
                    {value: 26, name: 'TA102转化器'},
                    {value: 22, name: '支柱充气工具'},
                    {value: 18, name: '数显压力表'}
                ]
            }
        ]
    };

    if (option2 && typeof option2 === 'object') {
        myChart02.setOption(option2);
    }


    var option3;

   option3 = {
       title: {
           text: ''
       },
       tooltip: {
           trigger: 'axis'
       },
       legend: {
           data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎']
       },
       grid: {
           left: '3%',
           right: '4%',
           bottom: '3%',
           containLabel: true
       },
       toolbox: {
           feature: {
               saveAsImage: {}
           }
       },
       xAxis: {
           type: 'category',
           boundaryGap: false,
           data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
       },
       yAxis: {
           type: 'value'
       },
       series: [
           {
               name: '邮件营销',
               type: 'line',
               stack: '总量',
               data: [120, 132, 101, 134, 90, 230, 210]
           },
           {
               name: '联盟广告',
               type: 'line',
               stack: '总量',
               data: [220, 182, 191, 234, 290, 330, 310]
           },
           {
               name: '视频广告',
               type: 'line',
               stack: '总量',
               data: [150, 232, 201, 154, 190, 330, 410]
           },
           {
               name: '直接访问',
               type: 'line',
               stack: '总量',
               data: [320, 332, 301, 334, 390, 330, 320]
           },
           {
               name: '搜索引擎',
               type: 'line',
               stack: '总量',
               data: [820, 932, 901, 934, 1290, 1330, 1320]
           }
       ]
   };

    myChart03.setOption(option3);


    var option4;



    // Schema:
    // date,AQIindex,PM2.5,PM10,CO,NO2,SO2
    var dataBJ = [
        [55,9,56,0.46,18,6,1],
        [25,11,21,0.65,34,9,2],
        [56,7,63,0.3,14,5,3],
        [33,7,29,0.33,16,6,4],
        [42,24,44,0.76,40,16,5],
        [82,58,90,1.77,68,33,6],
        [74,49,77,1.46,48,27,7],
        [78,55,80,1.29,59,29,8],
        [267,216,280,4.8,108,64,9],
        [185,127,216,2.52,61,27,10],
        [39,19,38,0.57,31,15,11],
        [41,11,40,0.43,21,7,12],
        [64,38,74,1.04,46,22,13],
        [108,79,120,1.7,75,41,14],
        [108,63,116,1.48,44,26,15],
        [33,6,29,0.34,13,5,16],
        [94,66,110,1.54,62,31,17],
        [186,142,192,3.88,93,79,18],
        [57,31,54,0.96,32,14,19],
        [22,8,17,0.48,23,10,20],
        [39,15,36,0.61,29,13,21],
        [94,69,114,2.08,73,39,22],
        [99,73,110,2.43,76,48,23],
        [31,12,30,0.5,32,16,24],
        [42,27,43,1,53,22,25],
        [154,117,157,3.05,92,58,26],
        [234,185,230,4.09,123,69,27],
        [160,120,186,2.77,91,50,28],
        [134,96,165,2.76,83,41,29],
        [52,24,60,1.03,50,21,30],
        [46,5,49,0.28,10,6,31]
    ];

    var dataGZ = [
        [26,37,27,1.163,27,13,1],
        [85,62,71,1.195,60,8,2],
        [78,38,74,1.363,37,7,3],
        [21,21,36,0.634,40,9,4],
        [41,42,46,0.915,81,13,5],
        [56,52,69,1.067,92,16,6],
        [64,30,28,0.924,51,2,7],
        [55,48,74,1.236,75,26,8],
        [76,85,113,1.237,114,27,9],
        [91,81,104,1.041,56,40,10],
        [84,39,60,0.964,25,11,11],
        [64,51,101,0.862,58,23,12],
        [70,69,120,1.198,65,36,13],
        [77,105,178,2.549,64,16,14],
        [109,68,87,0.996,74,29,15],
        [73,68,97,0.905,51,34,16],
        [54,27,47,0.592,53,12,17],
        [51,61,97,0.811,65,19,18],
        [91,71,121,1.374,43,18,19],
        [73,102,182,2.787,44,19,20],
        [73,50,76,0.717,31,20,21],
        [84,94,140,2.238,68,18,22],
        [93,77,104,1.165,53,7,23],
        [99,130,227,3.97,55,15,24],
        [146,84,139,1.094,40,17,25],
        [113,108,137,1.481,48,15,26],
        [81,48,62,1.619,26,3,27],
        [56,48,68,1.336,37,9,28],
        [82,92,174,3.29,0,13,29],
        [106,116,188,3.628,101,16,30],
        [118,50,0,1.383,76,11,31]
    ];

    var dataSH = [
        [91,45,125,0.82,34,23,1],
        [65,27,78,0.86,45,29,2],
        [83,60,84,1.09,73,27,3],
        [109,81,121,1.28,68,51,4],
        [106,77,114,1.07,55,51,5],
        [109,81,121,1.28,68,51,6],
        [106,77,114,1.07,55,51,7],
        [89,65,78,0.86,51,26,8],
        [53,33,47,0.64,50,17,9],
        [80,55,80,1.01,75,24,10],
        [117,81,124,1.03,45,24,11],
        [99,71,142,1.1,62,42,12],
        [95,69,130,1.28,74,50,13],
        [116,87,131,1.47,84,40,14],
        [108,80,121,1.3,85,37,15],
        [134,83,167,1.16,57,43,16],
        [79,43,107,1.05,59,37,17],
        [71,46,89,0.86,64,25,18],
        [97,71,113,1.17,88,31,19],
        [84,57,91,0.85,55,31,20],
        [87,63,101,0.9,56,41,21],
        [104,77,119,1.09,73,48,22],
        [87,62,100,1,72,28,23],
        [168,128,172,1.49,97,56,24],
        [65,45,51,0.74,39,17,25],
        [39,24,38,0.61,47,17,26],
        [39,24,39,0.59,50,19,27],
        [93,68,96,1.05,79,29,28],
        [188,143,197,1.66,99,51,29],
        [174,131,174,1.55,108,50,30],
        [187,143,201,1.39,89,53,31]
    ];

    var lineStyle = {
        normal: {
            width: 1,
            opacity: 0.5
        }
    };

    option4 = {
        backgroundColor: '#FFFFFF',
        title: {
            text: 'AQI - 雷达图',
            left: 'center',
            textStyle: {
                color: '#0C0B0B'
            }
        },
        legend: {
            bottom: 5,
            data: ['北京', '上海', '广州'],
            itemGap: 20,
            textStyle: {
                color: '#fff',
                fontSize: 14
            },
            selectedMode: 'single'
        },
        // visualMap: {
        //     show: true,
        //     min: 0,
        //     max: 20,
        //     dimension: 6,
        //     inRange: {
        //         colorLightness: [0.5, 0.8]
        //     }
        // },
        radar: {
            indicator: [
                {name: 'AQI', max: 300},
                {name: 'PM2.5', max: 250},
                {name: 'PM10', max: 300},
                {name: 'CO', max: 5},
                {name: 'NO2', max: 200},
                {name: 'SO2', max: 100}
            ],
            shape: 'circle',
            splitNumber: 5,
            name: {
                textStyle: {
                    color: 'rgb(238, 197, 102)'
                }
            },
            splitLine: {
                lineStyle: {
                    color: [
                        'rgba(238, 197, 102, 0.1)', 'rgba(238, 197, 102, 0.2)',
                        'rgba(238, 197, 102, 0.4)', 'rgba(238, 197, 102, 0.6)',
                        'rgba(238, 197, 102, 0.8)', 'rgba(238, 197, 102, 1)'
                    ].reverse()
                }
            },
            splitArea: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: 'rgba(238, 197, 102, 0.5)'
                }
            }
        },
        series: [
            {
                name: '北京',
                type: 'radar',
                lineStyle: lineStyle,
                data: dataBJ,
                symbol: 'none',
                itemStyle: {
                    color: '#F9713C'
                },
                areaStyle: {
                    opacity: 0.1
                }
            },
            {
                name: '上海',
                type: 'radar',
                lineStyle: lineStyle,
                data: dataSH,
                symbol: 'none',
                itemStyle: {
                    color: '#B3E4A1'
                },
                areaStyle: {
                    opacity: 0.05
                }
            },
            {
                name: '广州',
                type: 'radar',
                lineStyle: lineStyle,
                data: dataGZ,
                symbol: 'none',
                itemStyle: {
                    color: 'rgb(238, 197, 102)'
                },
                areaStyle: {
                    opacity: 0.05
                }
            }
        ]
    };

    if (option4 && typeof option4 === 'object') {
        myChart04.setOption(option4);
    }

</script>
</body>
</html>