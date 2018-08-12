
jQuery(document).ready(function($){
	getModule();
	$('#companyShow').show();
	$('#companyShow').siblings().hide();
	$('.mg_list_item').click(function(){
		var showId = $(this).attr("id");
		console.log(showId);
		$(this).addClass("mg_active");
		$(this).siblings().removeClass("mg_active");
		var titleStr = '';
		var panelId = '';
		if(showId == 'L1'){
			panelId = 'companyShow';
		}else if(showId == 'L2'){
			panelId = 'companyCulture';
		}else if(showId == 'L3'){
			panelId = 'companyPurpose';
		}else if(showId == 'L4'){
			panelId = 'companyContact';
		}
		$('#'+panelId).show();
		$('#'+panelId).siblings().hide();
	})
});