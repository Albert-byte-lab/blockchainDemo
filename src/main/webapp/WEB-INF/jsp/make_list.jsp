<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yoga</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap 3.3.4 -->
<link href="../resources/Public/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- FontAwesome 4.3.0 -->
<link href="../resources/Public/bootstrap/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons 2.0.0 --
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
<link href="../resources/Public/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
    	folder instead of downloading all of them to reduce the load. -->
<link href="../resources/Public/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />
<!-- iCheck -->
<link href="../resources/Public/plugins/iCheck/flat/blue.css" rel="stylesheet"
	type="text/css" />
<link href="../resources/Public/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
<!-- jQuery 2.1.4 -->
<script src="../resources/Public/plugins/jQuery/jquery-3.2.1.min.js"></script>
<script src="../resources/Public/js/global.js"></script>
<script src="../resources/Public/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../resources/Public/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="../resources/Public/js/myFormValidate.js"></script>
<script src="../resources/Public/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="../resources/Public/js/layer/layer-min.js"></script>
<!-- 弹窗js 参考文档 http://layer.layui.com/-->
<script src="../resources/Public/js/myAjax.js"></script>
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
<meta name="__hash__"
	content="8013c0469ba19ddbcae1bba39ea16d4c_2c3b9985cd50ac41e16f763df2fd1628" />
</head>
<body style="background-color: #ecf0f5;">


	<div class="wrapper">
		<div class="breadcrumbs" id="breadcrumbs">
			<ol class="breadcrumb">
				<li><a href="javascript:void();"><i class="fa fa-home"></i>&nbsp;&nbsp;飞行零部件全生命周期管理系统</a></li>

				<li><a href="javascript:void();">信息管理</a></li>
				<li><a href="javascript:void();">信息展示</a></li>
			</ol>
		</div>

		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="fa fa-list"></i> 会馆列表
						</h3>
					</div>
					<div class="panel-body">
						<div class="navbar navbar-default">
							<form action="" id="search-form2" class="navbar-form form-inline"
								method="post" onsubmit="return false">
								<div class="form-group">
									<a href="/blockchainDemo/am/make"
										class = "btn btn-primary pull-left">Refresh</a>
								</div>

							</form>
						</div>
						<div id="ajax_return">
							<form method="post" enctype="multipart/form-data" target="_blank"
								id="form-order">
								<div class="table-responsive">
									<table class="table table-bordered table-hover" id="table_list">
										<thead>
											<tr>
												<td class="text-right"><a
													href="javascript:sort('user_id');">ID</a></td>
												<td class="text-left"><a
													href="javascript:sort('username');">零部件名称</a></td>
												<td class="text-left"><a
													href="javascript:sort('level');">简介</a></td>
												<td class="text-left"><a
														href="javascript:sort('level');">所属类别</a></td>
												<td class="text-left"><a
														href="javascript:sort('level');">零部件使用年限</a></td>
												<td class="text-left"><a
														href="javascript:sort('level');">质量合格证编号</a></td>
												<td class="text-left"><a
														href="javascript:sort('level');">产品序列号</a></td>
												<td class="text-left"><a
														href="javascript:sort('level');">已使用次数</a></td>

											</tr>
										</thead>
										<tbody class ="user-list">
										  <c:forEach items="${make_list}" var="u">
											<tr>
												<td class="text-right">${u.amId}</td>
												<td class="text-left">${u.amName}</td>
												<td class="text-left">${u.amDesc}</td>
												<td class="text-left">${u.amCategory}</td>
												<td class="text-left">${u.amExpireTime}</td>
												<td class="text-left">${u.amQualifiedNum}</td>
												<td class="text-left">${u.amSerialNum}</td>
												<td class="text-left">${u.amUsedTime}</td>
												<td class="text-right"><a
														href="/blockchainDemo/history/showhistorybyamid?amId=${u.amId}"
														data-toggle="tooltip" title="" class="btn btn-info"
														data-original-title=""><i>Track</i></a>
												</td>
												<td class="text-right"><a
														href="/blockchainDemo/history/showcharts?amId=${u.amId}"
														data-toggle="tooltip" title="" class="btn btn-info"
														data-original-title=""><i>报表</i></a>
												</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
								<input name="__hash__"
									value="36c9fbc400a35c45c99a82bec874df93_1c272a2501b90c41a8de3ff7cad1569a"
									type="hidden">
							</form>
<script>
    $(".pagination  a").click(function(){
        var page = $(this).data('p');
        ajax_get_table('search-form2',page);
    });
</script>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<script>
    $(document).ready(function(){
        ajax_get_table('search-form2',1);

    });

    // ajax 抓取页面
    function ajax_get_table(tab,page){
        cur_page = page; //当前页面 保存为全局变量
            $.ajax({
                type : "POST",
                url:"../resources/afterend/Public"+"/index/Admin/user/ajaxindex/p/"+page,//+tab,
                data : $('#'+tab).serialize(),// 你的formid
                success: function(data){
                    $("#ajax_return").html('');
                    $("#ajax_return").append(data);
                }
            });
    }
	//分页
	$('#table_list').dataTable({
	//lengthMenu: [5, 10, 20, 30],//这里也可以设置分页，但是不能设置具体内容，只能是一维或二维数组的方式，所以推荐下面language里面的写法。
	paging: true,//分页
	ordering: false,//是否启用排序
	searching: true,//搜索
	language: {
		lengthMenu: '<select class="form-control input-xsmall">' + '<option value="1">1</option>' + '<option value="3">3</option>' + '<option value="5">5</option>' + '<option value="10">10</option>' + '</select>条记录',//左上角的分页大小显示。
		search: '<span class="label label-success">搜索：</span>',//右上角的搜索文本，可以写html标签

		paginate: {//分页的样式内容。
			previous: "上一页",
			next: "下一页",
			first: "第一页",
			last: "最后"
		},

		zeroRecords: "没有内容",//table tbody内容为空时，tbody的内容。
		//下面三者构成了总体的左下角的内容。
		info: "总共_PAGES_ 页，显示第_START_ 到第 _END_ ，筛选之后得到 _TOTAL_ 条，初始_MAX_ 条 ",//左下角的信息显示，大写的词为关键字。
		infoEmpty: "0条记录",//筛选为空时左下角的显示。
		infoFiltered: ""//筛选之后的左下角筛选提示，
	},
	paging: true,
	pagingType: "full_numbers",//分页样式的类型
	});
    // 点击排序
    function sort(field)
    {
        $("input[name='order_by']").val(field);
        var v = $("input[name='sort']").val() == 'desc' ? 'asc' : 'desc';
        $("input[name='sort']").val(v);
        ajax_get_table('search-form2',cur_page);
    }

    //发送站内信
    function send_message(id)
    {
        var obj = $("input[name*='selected']");
        var url = "用户列表-发送站内信.html";
        if(obj.is(":checked")){
            var check_val = [];
            for(var k in obj){
                if(obj[k].checked)
                    check_val.push(obj[k].value);
            }
            url += "?user_id_array="+check_val;
        }
        layer.open({
            type: 2,
            title: '站内信',
            shadeClose: true,
            shade: 0.8,
            area: ['580px', '480px'],
            content: url
        });
    }

    //发送邮件
    function send_mail(id)
    {
        var obj = $("input[name*='selected']");
        var url = "用户列表-发送邮箱.html";
        if(obj.is(":checked")){
            var check_val = [];
            for(var k in obj){
                if(obj[k].checked)
                    check_val.push(obj[k].value);
            }
            url += "?user_id_array="+check_val;
            layer.open({
                type: 2,
                title: '发送邮箱',
                shadeClose: true,
                shade: 0.8,
                area: ['580px', '480px'],
                content: url
            });
        }else{
            layer.msg('请选择会员');
        }

    }

    /**
     * 回调函数
     */
    function call_back(v) {
        layer.closeAll();
        if (v == 1) {
            layer.msg('发送成功');
        } else {
            layer.msg('发送失败');
        }
    }
</script>
</body>
</html>