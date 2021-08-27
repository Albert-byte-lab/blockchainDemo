/**
 * 
 */
$(function(){

	var  modifyUrl = '/blockchainDemo/am/modifyamtwo';



	$('#submit').click(function(){
		var am={};
		var rfid={};
		am.amId=$('#amId').val();
		am.amSerialNum=$('#amSerialNum').val();
		am.amExpireTime=$('#amExpireTime').val();

		var formData = new FormData();
		formData.append('amStr',JSON.stringify(am));
		$.ajax({
			url : modifyUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					alert("更新成功!");
					//重新获取数据库的值进行刷新。
					window.location.href = "/blockchainDemo/am/threeshowam";
				} else {
					alert('提交失败！');
				}
			}
		});
	});
});