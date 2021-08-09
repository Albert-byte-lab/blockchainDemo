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
                    <table class="table table-bordered">
                    <tbody>
                    <tr>
                        <td class="col-sm-2">零部件名称:</td>
                        <td ><input type="text"  id = "amName" name="amName"  class="form-control" value=""></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>简介:</td>
                        <td><input type="text" id = "amDesc" name = "amDesc" class="form-control" ></td>
                        <td></td>
                    </tr>
                     <tr>
                        <td>零部件所属类别</td>
                        <td>
                            <input type="text" id = "amCategory" name = "amCategory" class="form-control" >
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>零部件使用年限</td>
                        <td>
                            <input type="number" id="amExpireTime" name = "amExpireTime" class="form-control"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>零部件质量合格证编号:</td>
                        <td>
                            <input type="text" id = "amQualifiedNum" name = "amQualifiedNum" class="form-control" >
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>零部件产品序列号:</td>
                        <td>
                            <input type="text" id = "amSerialNum" name = "amSerialNum" class="form-control" >
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>零部件已使用次数:</td>
                        <td>
                            <input type="number" id="amUsedTime" name="amUsedTime" class="form-control"/>
                        </td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>RFID epc值:</td>
                        <td>
                            <input type="text" id="epc" name="epc" class="form-control"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>RFID tid值:</td>
                        <td>
                            <input type="text" id="tid" name="tid" class="form-control"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button id ="submit"  class="btn btn-info" > 提交</button>
                        </td>
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
</body>
</html>