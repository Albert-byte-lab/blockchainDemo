/**
 * 
 */
$(function(){
	
	var loginUrl = '/blockchainDemo/localauth/tologin';
	
	$('#submit').click(function(){

			var localAuth = {};
			localAuth.username = $('#username').val();
			localAuth.password = $('#password').val();
			var userId = $('#usertype').find('option').not(function() {
							return !this.selected;
							}).data('id');
			alert(userId);

			var name = $('#usertype').find('option').not(function() {
				return !this.selected;
			}).data('name');

			alert(name);

			var formData = new FormData();
			
			formData.append('localAuthStr',JSON.stringify(localAuth));
			
			formData.append('userId',userId);
			
			$.ajax({
				url:loginUrl,
				type : 'POST',
				data : formData,
				contentType : false,
				processData : false,
				cache : false,
				success:function(data){
					if(data.success){
						alert("登录成功！欢迎您:"+ name);
						//登录成功后，跳转到index页面;
						if(userId == 2){
							window.location.href = "/blockchainDemo/admin/index";
						}else if(userId == 1){

						}

					}else{
						alert("   登录失败!  " + "   用户名或密码不正确!");
					}	
					// //无论是否成功都换一下验证码!
					// $('#realNum').click();
				}
			})
			
			

	})
	
	
	// function checkModel(){
	// 	var username = $('input[name="username"]').val();
	// 	var password = $('input[name="password"]').val();
	// 	var checkNum = $('#checkNum').val();
	// 	var reg = new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
	// 	if(username == ''){
	// 		alert('用户名不可为空!');
	// 		return false;
	// 	}
	// 	if(!reg.test(username)){
	// 		alert('用户名必须为数字和字母组成且长度不少于8!');
	// 		return false;
	// 	}
	//
	// 	if(password == ''){
	// 		alert('密码不可为空!');
	// 		return false;
	// 	}
	// 	if(!reg.test(password)){
	// 		alert('密码必须为数字和字母组成且长度不少于8!');
	// 		return false;
	// 	}
	// 	if(checkNum == ''){
	// 		alert('验证码不能为空!');
	// 		return false;
	// 	}
	// 	return true;
	// }

})