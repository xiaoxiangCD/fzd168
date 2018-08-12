/**
 * 
 */

$("#searchBtn").click(function(){
	getCompetitions();
})

$("#comCity").change(function(){
	getCompetitions();
})

$("#comLevel").change(function(){
	getCompetitions();
})

$("#comGroup").change(function(){
	getCompetitions();
})

getCompetitions();
function getParams(){
	var param = {};
	if($("#comCity").val()!=''){
		param.city = $("#comCity").val();
	}
	
	if($("#comLevel").val()!=''){
		param.level = $("#comLevel").val();
	}
	
	if($("#comGroup").val()!=''){
		param.groupType = $("#comGroup").val();
	}
	
	if($('#searchText').val()!=''){
		param.searchLike = $("#searchText").val();
	}
	return param;
	
}

function getCompetitions(){
	var param = getParams();
	if(param){
		$.ajax({
			url :'/gzvm/competi!getCompetitions.action', 
			data:param,
			dataType : 'json', 
			type : 'post',
			success : function(result) {
				//
				var htmlStr = '';
				for(var i =0;i< result.results.length;i++){
					var data = result.results[i];
					console.log(data);
					htmlStr+= '<div class="competition"><div class="row"><div class="col-md-5"><div class="comptition_img">'
						+ '<img src="/gzvm/client/images/default.png"></div></div><div class="col-md-7"><div class="comptition_text">'
						+ '<div class="competition_title">'+data.competiName+'</div><div class="competition_type"><p class="type_panel"><span><img src="/gzvm/client/images/type_ico.png"></span>';
					if(data.groupType==1){
						htmlStr+='<span>个人赛</span>';
					}else if(data.groupType==2){
						htmlStr+='<span>团体赛</span>';
					}
					htmlStr+= '</p><p class="type_panel"><span><img src="/gzvm/client/images/type_ico.png"></span><span>'+data.level+'</span></p></div><div class="competition_date"><p>时间：</p>'
						+ '<p id="date">'+data.startTime+'</p></div><div class="competition_adress"><p>地点：</p>'
						+ '<p id="adress">'+data.addr+'</p></div><div class="competition_dsc">'		
						+ '<p >'+data.descr+'</p></div><div class="detail"><a href="#">更多详情 ></a></div><div class="clear"></div></div></div></div></div>'	
				}
				$('#comList').html(htmlStr);
				
			}
		});
	}
	
}