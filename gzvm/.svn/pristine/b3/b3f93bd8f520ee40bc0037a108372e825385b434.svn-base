
jQuery(document).ready(function($){
	var contentId = $.query.keys.contentId;
	var moduleId = $.query.keys.moduleId;
	$.ajax({
		url : '/gzvm/admin!getItemContent.action',
		data:{contentId : contentId},
		dataType : 'json',
		type : 'post',
		success : function(data) {
			if(data.resultCode==1){
				console.log(data);
				$('#contentTitle').html(data.contentTitle);
				$('#contents').html(data.content);
			}
		}
	});
	
});