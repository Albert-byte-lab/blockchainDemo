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
    <link href="../resources/Public/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
    	folder instead of downloading all of them to reduce the load. -->
    <link href="../resources/Public/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="../resources/Public/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
    <!-- jQuery 2.1.4 -->
    <script src="../resources/Public/plugins/jQuery/jquery-3.2.1.min.js"></script>
	<script src="../resources/Public/js/global.js"></script>
    <script src="../resources/Public/js/myFormValidate.js"></script>
    <script src="../resources/Public/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../resources/Public/js/layer/layer-min.js"></script><!-- 弹窗js 参考文档 http://layer.layui.com/-->
    <script src="../resources/Public/js/myAjax.js"></script>
      <script src="../resources/Public/js/echart/echarts.js"></script>
      <script src="../resources/Public/js/echart/china.js"></script>
      <script src="../resources/Public/js/echart/echarts.js.map"></script>
      <script src="../resources/Public/js/echart/macarons.js"></script>
      <script src="../resources/Public/js/echart/bmap.js"></script>
      <script src="../resources/Public/js/echart/dataTool.js"></script>
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
  <meta name="__hash__" content="6f2f83477e27fc132fe9427e851ef6a0_f98429bc72657fc38860af448bf30e91" /></head>
  <body style="background-color:#ecf0f5;">
 

<div class="wrapper">
     <div class="breadcrumbs" id="breadcrumbs">
	<ol class="breadcrumb">
	<li><a href="javascript:void();"><i class="fa fa-home"></i>&nbsp;&nbsp;后台首页</a></li>
	        
	        <li><a href="javascript:void();">飞行零部件全生命周期管理系统</a></li>
	        <li><a href="javascript:void();"></a></li>          
	</ol>
</div>

     <section class="content">
		<div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="info-box">
                <%--<span class="info-box-icon bg-aqua"><i class="fa fa-bell"></i></span>--%>
                  <img src="../resources/Public/img/ARJ21.png" style="height: 90px;width: 90px;float: left">
                <div class="info-box-content">
                  <span class="info-box-text">总零部件数</span>
                  <span class="info-box-number">139</span>
                </div>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="info-box">
                <%--<span class="info-box-icon bg-green"><i class="fa fa-flag-o"></i></span>--%>
                    <img src="../resources/Public/img/C919.png" style="height: 90px;width: 90px;float: left">
                <div class="info-box-content">
                  <span class="info-box-text">总零部件数</span>
                  <span class="info-box-number">105</span>
                </div>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="info-box">
                <%--<span class="info-box-icon bg-yellow"><i class="fa fa-files-o"></i></span>--%>
                    <img src="../resources/Public/img/CR929.png" style="height: 90px;width: 90px;float: left">
                <div class="info-box-content">
                  <span class="info-box-text">总零部件数</span>
                  <span class="info-box-number">149</span>
                </div>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="info-box">
                  <span class="info-box-icon bg-aqua"><i class="fa fa-bell"></i></span>
                <div class="info-box-content">
                  <span class="info-box-text">其他</span>
                  <span class="info-box-number">2568</span>
                </div>
              </div>
            </div>
         </div>
		
		<%--<div class="row">
			<div class="col-md-12">
		      <div class="box box-info">
		        <div class="box-header">
		          <h3 class="box-title">今日统计</h3>
		        </div>
		        <div class="box-body">
	         		<div class="row">
			  			<div class="col-sm-3 col-xs-6">
			  				新增零部件：12			  			</div>
			  				<div class="col-sm-3 col-xs-6">
			  				今日访问数：205			  			</div>
			  				<div class="col-sm-3 col-xs-6">
			  				即将过期零部件：5			  			</div>
			  				<div class="col-sm-3 col-xs-6">
			  				待查看反馈：6			  			</div>
		  			</div>
		        </div>
		      </div>
		    </div>
		</div>
          <div class="row">
          	     <div class="col-md-12">
			       	 <div class="box  box-primary">
                        <div class="box-body">
                            <div class="info-box">                 
                            	<table class="table table-bordered">
                                <tbody>
                                <tr>
                                    <td>服务器操作系统：</td>
                                    <td>Linux</td>
                                    <td>服务器域名/IP：</td>
                                    <td>demo2.ego.cn [ 183.158.35.60 ]</td> 
                                    <td>服务器环境：</td> 
                                    <td>Apache/2.4.12 (Unix) OpenSSL/1.0.1m /5.6.8 mod_perl/2.0.8-dev Perl/v5.16.3</td>       
                                </tr> 
                                <tr>
                                    <td> 版本：</td>
                                    <td>5.6.8</td>
                                    <td>Mysql 版本：</td>
                                    <td>5.6.24</td> 
                                    <td>GD 版本</td> 
                                    <td>bundled (2.1.0 compatible)</td>  
                                </tr>   
                                <tr>
                                    <td>文件上传限制：</td>
                                    <td>128M</td>
                                    <td>最大占用内存：</td>
                                    <td>512M</td> 
                                    <td>最大执行时间：</td> 
                                    <td>30s</td>  
                                </tr>  
                                <tr>
                                    <td>安全模式：</td>
                                    <td>NO</td>
                                    <td>Zlib支持：</td>
                                    <td>YES</td> 
                                    <td>Curl支持：</td> 
                                    <td>YES</td>  
                                </tr>  
                            	</table>				
                            </div>
                        </div>
                    </div>
			    </div>
          </div>--%>



     </section>
 </div>
 </body>
 </html>