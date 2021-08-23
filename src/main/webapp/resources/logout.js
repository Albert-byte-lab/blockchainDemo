/**
 * 
 */
$(function(){

	$('#log-out').click(function (){
		//清除session
		$.ajax({
			url:"/blockchainDemo/localauth/tocancel",
			type : "post",
			async : false,
			cache : false,
			dataType : 'json',
			success : function(data) {
				if (data.success) {
					// 清除成功后退出到登录界面
					window.location.href = "/blockchainDemo/admin/login";
					return false;
				}
			},
			error : function(data, error) {
				alert(error);
			}
		});
	});

});