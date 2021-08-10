<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>飞行零部件全生命周期管理系统</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- Bootstrap 3.3.4 -->
	<link href="../resources/Public/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<!-- Theme style -->
	<link href="../resources/Public/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
	<!-- iCheck -->
	<link href="../resources/Public/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />
	<style>#imgVerify{width: 120px;margin: 0 auto; text-align: center;display: block;}	</style>
	<script>
		function detectBrowser()
		{
			var browser = navigator.appName
			if(navigator.userAgent.indexOf("MSIE")>0){
				var b_version = navigator.appVersion
				var version = b_version.split(";");
				var trim_Version = version[1].replace(/[ ]/g,"");
				if ((browser=="Netscape"||browser=="Microsoft Internet Explorer"))
				{
					if(trim_Version == 'MSIE8.0' || trim_Version == 'MSIE7.0' || trim_Version == 'MSIE6.0'){
						alert('请使用IE9.0版本以上进行访问');
						return;
					}
				}
			}
		}
		detectBrowser();
	</script>
	<meta name="__hash__" content="35a35d71936253d091570f5dcdf3efda_36195b7c33bcc5ab73f67451e5438f65" /></head>
<body class="login-page">
<div class="login-box">
	<div class="login-logo">
		<a href="#"><b>天链</b></a>
	</div>
	<div class="login-box-body">
		<p class="login-box-msg"><b>飞行零部件全生命周期管理系统</b></p>
		<div class="form-group has-feedback">
			<select id="usertype" class="form-control">
				<option data-id="1" data-name="飞机制造商工程部门">飞机制造商工程部门</option>
				<option data-id="2" data-name="零部件供应商">零部件供应商</option>
				<option data-id="3" data-name="飞机制造商总装配厂">飞机制造商总装配厂</option>
				<option data-id="4" data-name="航司">航司</option>
				<option data-id="5" data-name="飞机修理厂">飞机修理厂</option>
			</select>
		</div>
		<div class="form-group has-feedback">
			<input type="text" name="username" id="username" class="form-control" placeholder="账号" />
			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
			<input type="password" name="password" class="form-control" id="password" placeholder="密码" />
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-primary btn-block btn-flat" id="submit" >立即登录</button>
		</div>
	</div>

</div><!-- /.login-box -->
<!-- jQuery 2.1.4 -->
<script src="../resources/Public/plugins/jQuery/jquery-3.2.1.min.js" type="text/javascript"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="../resources/Public/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!-- iCheck -->
<script src="../resources/Public/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
<script src="../resources/Public/js/layer/layer.js"></script><!-- 弹窗js 参考文档 http://layer.layui.com/-->
<script src="../resources/login.js" type="text/javascript"></script>
</body>
</html>