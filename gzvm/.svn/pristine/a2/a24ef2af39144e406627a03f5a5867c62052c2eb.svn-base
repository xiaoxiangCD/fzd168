
var anliStr = '<div class="row ctrl_panel"><div class="col-md-6  col-sm-12 col-xs-12"><div class="col-md-6 ctrl_item"><a id="anliPanelName">'
var weiStr = '</a></div></div></div><div class="row anli_panel"><div class="col-md-4 col-sm-6 col-xs-12 anli_mobile_list"><div class="anli_product_panel"><a class="anli_product_name"><img src="/gzvm/fzd/images/01.png" class="anli_product_img"></a><a class="anli_product_item">产后着凉受风引起的腰部酸痛，敷三次泥膜明显好转，坚持使用近一个月症状完全消失。</a></div></div><div class="col-md-4 col-sm-6 col-xs-12 anli_mobile_list"><div class="anli_product_panel"><a class="anli_product_name"><img src="/gzvm/fzd/images/02.png" class="anli_product_img"></a><a class="anli_product_item">长期伏案工作，低头使用手机导致颈椎劳损，涂抹一次感觉疼痛明显减轻。</a></div></div><div class="col-md-4 col-sm-6 col-xs-12 anli_mobile_list"><div class="anli_product_panel"><a class="anli_product_name"><img src="/gzvm/fzd/images/03.png" class="anli_product_img"></a><a class="anli_product_item">长期坐在办公室，经常开车，缺发运动，引起腰肌劳损，使用痛可贴，一贴明显好转。</a></div></div><div class="col-md-4 col-sm-6 col-xs-12 anli_mobile_list"><div class="anli_product_panel"><a class="anli_product_name"><img src="/gzvm/fzd/images/04.png" class="anli_product_img"></a><a class="anli_product_item">山区长期劳作引起的风湿性关节炎，坚持使用泥膜15次，完全恢复正常。</a></div></div><div class="col-md-4 col-sm-6 col-xs-12 anli_mobile_list"><div class="anli_product_panel"><a class="anli_product_name"><img src="/gzvm/fzd/images/05.png" class="anli_product_img"></a><a class="anli_product_item">女性经期紊乱，宫寒，敷用泥膜一次好转。</a></div></div><div class="col-md-4 col-sm-6 col-xs-12 anli_mobile_list"><div class="anli_product_panel"><a class="anli_product_name"><img src="/gzvm/fzd/images/06.png" class="anli_product_img"></a><a class="anli_product_item">夏天吹空调导致的体内湿寒过重，人体疲惫没精神，使用泥膜一次祛湿明显，精神倍增。</a></div></div></div>';

jQuery(document).ready(function($){
	getModule(function (result){
		console.log(result);
		var htmlStr = '';
		for(var i in result.results){
			var obj = result.results[i];
			var path = '';
			if(obj.photoId && obj.photo != ''){
				path = result.picUrl + obj.photoId;
			}else{
				path='/gzvm/project/images/default.png';
			}
			htmlStr += '<div class="col-md-4 col-sm-6 col-xs-12 anli_mobile_list" onclick="openItemPage('+obj.contentId+')"><div class="anli_product_panel">'
				+'<a class="anli_product_name"><img src="'+path+'" class="anli_product_img"></a>'
				+'<a class="anli_product_item">'+obj.contentTitle+'</a></div></div>'
		}
		$('#contents').html(htmlStr);
		
	});
	/*$('#gukeCase').show();
	$('#gukeCase').siblings().hide();
	$('#gukeCase').html(anliStr+'骨科类案例'+weiStr);
	$('.mg_list_item').click(function(){
		var showId = $(this).attr("id");
		console.log(showId);
		$(this).addClass("mg_active");
		$(this).siblings().removeClass("mg_active");
		var titleStr = '';
		var panelId = '';
		if(showId == 'L1'){
			titleStr = '骨科类案例';
			panelId = 'gukeCase';
		}else if(showId == 'L2'){
			titleStr = '经络类案例';
			panelId = 'jingluoCase';
		}else if(showId == 'L3'){
			titleStr = '脏腑类案例';
			panelId = 'zangfuCase';
		}else if(showId == 'L4'){
			titleStr = '女性类案例';
			panelId = 'nvxingCase';
		}else if(showId == 'L5'){
			titleStr = '扶元类案例';
			panelId = 'fuyuanCase';
		}else if(showId == 'L6'){
			titleStr = '痛可贴类案例';
			panelId = 'tongketieCase';
		}
		$('#'+panelId).show();
		$('#'+panelId).siblings().hide();
		$('#'+panelId).html(anliStr+titleStr+weiStr);
	})*/
});