/**
 * 
 */
$(function(){
	
	// var courseId = getQueryString('courseId');
	//
	// var isEdit = courseId ? true : false;
	//
	// //根据Id获取数据的URL
	// var courseUrl = '/yogaShare/course/getcourseinfobyid?courseId='+courseId;
	//
	// var modifyCourseUrl = '/yogaShare/course/modifycourse';
	
	var addAmUrl = '/blockchainDemo/am/addam';
	
	// var initUrl = '/yogaShare/course/getinitinfo';
	
	// function getQueryString(name) {
	// 	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	// 	var r = window.location.search.substr(1).match(reg);
	// 	if (r != null) {
	// 		return decodeURIComponent(r[2]);
	// 	}
	// 	return '';
	// }
	
	// if(isEdit){
	// 	getInfoById(courseId);
	// }else{
	// 	getInitInfo();
	// }
	
	// function getInfoById(courseId){
	// 	$.getJSON(courseUrl,function(data){
	// 		if(data.success){
	// 			var course = data.course;
	// 			$('#courseName').val(course.courseName);
	// 			$('#courseInstruction').val(course.courseInstruction);
	// 			$('#priority').val(course.priority);
	//
	// 			//可以修改课程所属种类，但是不可修改上传者
	// 			var uploader = '<option data-id="'+course.user.userId+'"selected>'
	// 							+course.user.name+'</option>';
	//
	// 			var ccHtml = '';
	// 			data.ccList.map(function(item,index){
	// 				ccHtml += '<option data-id="'+item.courseCategoryId+'">'
	// 				+item.courseCategoryName+'</option>'
	// 			});
	// 			//不可修改上传者
	// 			$('#myUploader').html(uploader);
	// 			$('#myUploader').attr('disabled', 'disabled');
	//
	//
	// 			$('#belongCC').html(ccHtml);
	// 			$("#belongCC option[data-id='" + course.courseCategory.courseCategoryId + "']").attr(
	// 					"selected", "selected");
	//
	//
	// 			$('#priority').attr('disabled', 'disabled');
	// 		}
	// 	})
	// }
	//
	// function getInitInfo(){
	// 	$.getJSON(initUrl,function(data){
	// 		if(data.success){
	// 			var uploadHtml = '';
	// 			var ccHtml = '';
	// 			data.userList.map(function(item,index){
	// 				uploadHtml += '<option data-id = "' + item.userId +'">'
	// 				+item.name+'</option>'
	// 			});
	//
	// 			data.ccList.map(function(item,index){
	// 				ccHtml += '<option data-id="'+item.courseCategoryId+'">'
	// 				+item.courseCategoryName+'</option>'
	// 			});
	// 			$('#myUploader').html(uploadHtml);
	// 			$('#belongCC').html(ccHtml);
	// 		}
	// 	})
	// }
	//
	
	$('#submit').click(function(){
		var am = {};
		// if(isEdit){
		// 	course.courseId = courseId;
		// }
			am.amName = $('#amName').val();
			am.amDesc =$('#amDesc').val();
			am.amCategory =$('#amCategory').val();
			am.amExpireTime =$('#amExpireTime').val();
			am.amQualifiedNum =$('#amQualifiedNum').val();
			am.amSerialNum =$('#amSerialNum').val();
			am.amUsedTime =$('#amUsedTime').val();
			alert(am.amName)
			// 生成表单对象，用于接收参数并传递给后台
			var formData = new FormData();
			
			formData.append('amStr',JSON.stringify(am));
			
			$.ajax({
				url: addAmUrl,
				type : 'POST',
				data : formData,
				contentType : false,
				processData : false,
				cache : false,
				success:function(data){
					if(data.success){
						alert("操作成功!");
					}else{
						alert("操作失败!");
					}
				}
			});

	});
	
	 // function checkUserUpdate(){
	 //        var courseName = $('input[name="courseName"]').val();
	 //        var courseInstruction = $('input[name="courseInstruction"]').val();
	 //        var error ='';
	 //        if(courseName == ''){
	 //            error += "课程名称不能为空哦！\t";
	 //        }
	 //        if(courseInstruction == ''){
	 //        	error += "注明简介会更好!\t";
	 //        }
	 //        if(error){
	 //            layer.alert(error, {icon: 2});  //alert(error);
	 //            return false;
	 //        }
	 //        return true;
	 //    }
	
})