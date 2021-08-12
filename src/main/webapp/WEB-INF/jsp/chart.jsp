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
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <!-- <link href=../resources/afterend/Public/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" /> -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
    	folder instead of downloading all of them to reduce the load. -->
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
    <script type="text/javascript">
    function delfunc(obj){
    	layer.confirm('确认删除？', {
    		  btn: ['确定','取消'] //按钮
    		}, function(){
   				$.ajax({
   					type : 'post',
   					url : $(obj).attr('data-url'),
   					data : {act:'del',del_id:$(obj).attr('data-id')},
   					dataType : 'json',
   					success : function(data){
   						if(data==1){
   							layer.msg('操作成功', {icon: 1});
   							$(obj).parent().parent().remove();
   						}else{
   							layer.msg(data, {icon: 2,time: 2000});
   						}
   						layer.closeAll();
   					}
   				})
    		}, function(index){
    			layer.close(index);
    			return false;// 取消
    		}
    	);
    }
    
    //全选
    function selectAll(name,obj){
    	$('input[name*='+name+']').prop('checked', $(obj).checked);
    }   
    
    function get_help(obj){
        layer.open({
            type: 2,
            title: '帮助手册',
            shadeClose: true,
            shade: 0.3,
            area: ['90%', '90%'],
            content: $(obj).attr('data-url'), 
        });
    }
    
    function delAll(obj,name){
    	var a = [];
    	$('input[name*='+name+']').each(function(i,o){
    		if($(o).is(':checked')){
    			a.push($(o).val());
    		}
    	})
    	if(a.length == 0){
    		layer.alert('请选择删除项', {icon: 2});
    		return;
    	}
    	layer.confirm('确认删除？', {btn: ['确定','取消'] }, function(){
    			$.ajax({
    				type : 'get',
    				url : $(obj).attr('data-url'),
    				data : {act:'del',del_id:a},
    				dataType : 'json',
    				success : function(data){
    					if(data == 1){
    						layer.msg('操作成功', {icon: 1});
    						$('input[name*='+name+']').each(function(i,o){
    							if($(o).is(':checked')){
    								$(o).parent().parent().remove();
    							}
    						})
    					}else{
    						layer.msg(data, {icon: 2,time: 2000});
    					}
    					layer.closeAll();
    				}
    			})
    		}, function(index){
    			layer.close(index);
    			return false;// 取消
    		}
    	);	
    }
    </script>        
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
                            <td class="text-right"><div id="main" style="width: 500px;height:300px;"></div></td>
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

<%--                <div id="main" style="width: 600px;height:400px;"></div>--%>
<%--                <div id="main2" style="width: 600px;height:400px;"></div>--%>
                <input type="hidden" name="__hash__" value="af098848e23b6e770b5a0fa581e8f81a_e923060bad73d6e054e32d7d8661c548" />
            </div>
        </div>
 	  </div> 
    </div>    <!-- /.content -->
   </section>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var myChart02 = echarts.init(document.getElementById('main2'));
    var myChart03 = echarts.init(document.getElementById('main3'));
    var myChart04 = echarts.init(document.getElementById('main4'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '第一个 ECharts 实例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart02.setOption(option);
    myChart03.setOption(option);
    myChart04.setOption(option);
</script>
</body>
</html>