/**
 * 
 */
$(function(){

	var  listUrl = '/blockchainDemo/am/showaircraftinfo';

	var addAmUrl = '/blockchainDemo/am/oneaddam';
	getAircraftInfo();

	function getAircraftInfo(){
		$.getJSON(listUrl,function (data){
			if(data.success){
					var tempHtml = '';
					data.aircraftList.map(function (item,index){
						tempHtml += '<option data-id="' + item.acId
						+ '">' +item.acName + '</option>';
					});
					$('#aircraftList').html(tempHtml);
			}
		});
	}


	$('#submit').click(function(){
		var am={};

		am.amName = $('#amName').val();
		am.amDesc =$('#amDesc').val();
		am.amExpireTime =$('#amExpireTime').val();
		//获取选择的机型
		am.aircraft={
			acId:$('#aircraftList').find('option').not(function(){
				return !this.selected;
			}).data('id')
		};
		alert("am.amName"+am.amName);
		alert("am.amDesc"+am.amDesc);
		alert("am.amExpireTime"+am.amExpireTime);
		var formData = new FormData();
		formData.append('amStr',JSON.stringify(am));

		$.ajax({
			url : addAmUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					alert("添加成功!");
				} else {
					alert('提交失败！');
				}
			}
		});
	});
});