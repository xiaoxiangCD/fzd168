


jQuery(document).ready(function($){
	getModule(function (result){
		console.log(result);
		var htmlStr = '';
		for(var i in result.results){
			var arr = result.results[i]
			var path = '';
			if(arr.photoId && arr.photo != ''){
				path = result.picUrl + arr.photoId;
			}else{
				path='/gzvm/project/images/default.png';
			}

			htmlStr += '<div class="col-md-6 col-sm-6 col-xs-12 anli_mobile_list" onclick="openItemPage('+arr.contentId+')"><div class="anli_product_panel">'
					+'<a class="anli_product_name"><img src="'+path+'" class="anli_product_img"></a>'
					+'<a class="anli_product_item">'+arr.contentTitle+'</a></div></div>';	
		}
		$('#contents').html(htmlStr);
		
		
	});
});