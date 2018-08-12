var h = $(window).height() - 100;
	$("#body").css('height', h + 'px');
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');
	var contentId;
	var itemId = '';
	function getParams(pubType){
		var params={itemId:itemId};
		if(pubType){
			params.state=pubType;
		}
		if($('#titleText').val()!=''){
			params.contentTitle=$('#titleText').val();
		}else{
			alert('请输入标题！');
			return null;
		}
		if(ue.getContent()!=''){
			params.content=ue.getContent();
		}else{
			alert('请输入内容！');
			return null;
		}
		if(contentId){
			params.contentId=contentId;
		}
		return params;
	}
	
	function saveNotice(pubType){
		var param = getParams(pubType);
		if(param){
			$.ajax({
				url : '/gzvm/admin!saveItemContent.action',
				data : param,
				type : 'post',
				dataType : 'json',
				success : function(result) {
					if(result.resultCode == 1){
						back();
					}else{
						alert(result.resultMsg);
					}
				}
			});
		}
		
	}
	
	function back(){
		window.location.href='/gzvm/project/pages/manage.jsp';
	}
	
	if ($.query && $.query.keys) {
		if ($.query.keys.contentId){
			contentId = $.query.keys.contentId;
			
			$.ajax({
				url : '/gzvm/admin!getItemContent.action',
				data:{contentId : contentId},
				dataType : 'json',
				type : 'post',
				success : function(data) {
					if(data.resultCode==1){
						ue.ready(function() {
							$('#titleText').val(data.contentTitle);
							ue.setContent(data.content);
						});
					}
				}
			});	
		}
		if($.query.keys.itemId){
			itemId = $.query.keys.itemId;
		}
	}