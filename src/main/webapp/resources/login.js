/**
 * 
 */
$(function(){

	var  listUrl = '/blockchainDemo/localauth/listuserinfo';
	var loginUrl = '/blockchainDemo/localauth/tologin';
	getUserInfo();

	function getUserInfo(){
		$.getJSON(listUrl,function (data){
			if(data.success){
					var tempHtml = '';
					data.userInfoList.map(function (item,index){
						tempHtml += '<option data-id="' + item.userId
						+ '">' +item.name + '</option>';
					});
					$('#userinfolist').html(tempHtml);
			}
		});
	}


	$('#submit').click(function(){
		var localAuth={};
		var userInfo={};
		//获取输入的账号名
		localAuth.username = $('#username').val();
		//获取输入的密码
		localAuth.password = $('#password').val();
		//获取选择的用户类型
		userInfo={
			userId:$('#userinfolist').find('option').not(function(){
				return !this.selected;
			}).data('id')
		};
		var formData = new FormData();
		formData.append('localAuthStr',JSON.stringify(localAuth));
		formData.append('userInfoStr',JSON.stringify(userInfo));

		$.ajax({
			url : loginUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					alert('提交成功！');
					//登录成功则跳转到主页。
					window.location.href = "/blockchainDemo/admin/index";
					// if (!isEdit) {
					// 	// 若为注册操作，成功后返回店铺列表页
					// 	window.location.href = "/o2o/shopadmin/shoplist";
					// }
				} else {
					alert('提交失败！');
				}
			}
		});
	})
})