var WH = $(window).height();
var moduleId = '';

$().ready(function(){
	var HH = $("#header").height();
	var IH = WH - HH ;
	console.log(WH+','+ HH +','+IH);
	$('#rightPanel').css('min-height',IH-350);
	if($.query.keys && $.query.keys.moduleId){
		moduleId = $.query.keys.moduleId;
	}
	setFooter();
});


function getModule(option){
	$.ajax({
		url : '/gzvm/admin!getModule.action',
		dataType : 'json',
		type : 'post',
		success : function(result) {
			if(result.resultCode == 1){
				var current = '';
				var crt = '';
				if(moduleId == ''){
					current = ' active';
					crt = ' class="selected"';
				}
				var url = '<li class="h'+current+'"><a href="/gzvm/index.jsp">首页 </a></li>';
				var urlB = '<li><a href="/gzvm/index.jsp"'+crt+'>- 首页 </a></li>';
				if(result.results && result.results.length > 0){
					for(var i in result.results){
						var obj = result.results[i];
						current = '';
						crt = '';
						if(moduleId != '' && moduleId==obj.moduleId){
							current = ' active';
							crt = ' class="selected"';
						}
						url += '<li class="h'+current+'"><a href="'+obj.moduleUrl+'?moduleId='+obj.moduleId+'">'+obj.moduleName+'</a></li>';
						urlB += '<li><a href="'+obj.moduleUrl+'?moduleId='+obj.moduleId+'"'+crt+'>- '+obj.moduleName+' </a></li>';
					}
					getModuleItems(option);
				}
				$('#nav').html(url);
				$('#sNav').html(urlB);
			}else{
				swal( result.resultMsg);
			}
		},
		failure : function(result) {
			swal("请求失败!", result.resultMsg);
		}
	});	
}

function getModuleItems(option){
	if(moduleId != ''){
		$.ajax({
			url : '/gzvm/admin!getModuleItem.action',
			data : { moduleId : moduleId},
			dataType : 'json',
			type : 'post',
			success : function(result) {
				if(result.resultCode==0){
					swal( result.resultMsg);
				} else {
					var url = '';
					if(result.results && result.results.length>0){
						for(var i in result.results){
							var obj = result.results[i];
							url += '<li id="'+obj.itemId+'" class="mg_list_item'+ (i == 0 ? ' mg_active">' : '">')
								+ obj.itemName+'</li>';
						}
						getItemContents(result.results[0].itemId,option);
						$('#itemName').html(result.results[0].itemName);
					}
					$('#items').html(url);
					
					if(url!=''){
						$('.mg_list_item').each(function (i){
							$(this).click(function (){
								var obj = result.results[i];
								var clickHtml = obj.itemName;
								getItemContents(obj.itemId,option,clickHtml);
							});
						});
					}
				}
			},
			failure : function(result) {
				swal("请求失败!", result.resultMsg);
			}
		});
	}
}

function getItemContents(itemId,option,titleName){
	$('.mg_list_item').removeClass("mg_active");
	$('#'+itemId).addClass('mg_active');
	$('#itemName').html(titleName);
	$.ajax({
		url : '/gzvm/admin!getItemContents.action',
		data : {
			itemId : itemId,
			state : 2
		},
		dataType : 'json',
		type : 'post',
		success : function(result) {
			if(result.resultCode==0){
				swal( result.resultMsg);
			}else{
				option && option(result);
			}
		},
		failure : function(result) {
			swal("请求失败!", result.resultMsg);
		}
	});
	
	
}

function logout(){
	window.location.href = '/gzvm/admin!logout.action';
}




/*setInterval(ping, 150000);
function ping() {
	$.ajax({
		url : '/gzvm/admin!ping.action',
		dataType : 'json',
		type : 'post',
		success : function(result) {
			if (result.resultCode == 0) {
				parent.logout();
			}
		}
	});
}
*/
function openItemPage(contentId){
	window.location.href = '/gzvm/fzd/pages/health_item.jsp?contentId='+contentId+'&moduleId='+moduleId;
	
}

function setFooter(){
	var htmlStr = '<div class="row footer_show_panel"><div class="col-md-4 footer_show" ><p class="footer_item">'
		+'关于锋之道：<br>    ”锋之道健康养生“是广州锋之道实业有限公司旗下的养生品牌，它以公司及所属科研团队多年研究成果为依托，'
		+'以”传播健康，弘扬中医文化为己任，是将中国五千年中医养生文化与现代科技完美结合的成果，是针对调节人体稳定平衡而精心研制的系列健康养生产品，'
		+'以专业的制造工艺、卓越的产品质量、显著的产品功效从根本上弥补了肌体的先天不足。</p></div>'
		+'<div class="col-md-4 footer_tran" ><p class="">产品展示</p><p class="">案例展示</p><p class="">古方养生</p><p class="">商城</p></div>'
		+'<div class="col-md-4 footer_cont" ><p class="">联系电话</p><p class="cont_item">臧生：139 2643 2931</p>'
		+'<p class="cont_item">高生：185 2009 3344</p><p class="">地址</p><p class="cont_item">广州市荔湾区鹤洞路342号悦锋商务大厦6楼</p></div></div>'
		+'<div class="footer_panel"><div class="footer_item"><p>2014 广州锋之道实业有限公司 版权所有      粤ICP备20141113号</p></div></div>';
	$('#footer').html(htmlStr);
	
}





