/**
 * 
 */

$().ready(function(){
	
	
})

var moduleId='';
var itemId='';

var selModuleId = '';
var selItemId = '';
 /*$('.M-box3').pagination({
	        pageCount:50,
	        jump:true,
	        coping:true,
	        homePage:'首页',
	        endPage:'末页',
	        prevContent:'上页',
	        nextContent:'下页'
	    });*/
	    $("#newType").click(function(){
	    	$("#new").show();
	    })
	    $("#exit").click(function(){
	    	$("#new").hide();
	    	$("body").css('overflow','auto');
	    })
	    
getModule();
function getModule(){
	    	var url = '/gzvm/admin!getModule.action';
	    	var data = {
	    	};
	    	$.ajax({
				url : url,
				data : data,
				dataType : 'json',
				type : 'post',
				success : function(result) {
					var url='';
					for(var i in result.results){
						var obj = result.results[i];
						 /*url=url+'<p class="Type_new" > <a onclick="getModultItem('+obj.moduleId+') ">'
						 +obj.moduleName+'</a><img alt="" src="/gzvm/manage/images/edit.png" onclick="showDelModule('+obj.moduleId+');" >  </p>';*/
						url += '<li class="h"><a onclick="getModultItem('+obj.moduleId+',this)"><span class="nav_name nav_name_current">'+obj.moduleName+'</span></a></li>';
					}
					/*$("#titleModule").html('<p class="Type_name"><a href="">首页</a></p> '
		                    + url
							+ '<p class="Type_new" onclick="showModule('+""+')"> <a>新增模块</a> <img alt="" src="/gzvm/project/images/new.png" >  </p>');*/
					
					$("#titleModule").html(url);
					$("#titleModule>li").eq(0).addClass('current');
					
					if(result.results[0].moduleId>0){
						getModultItem(result.results[0].moduleId);	
					}
				},
				failure : function(result) {
					swal("请求失败!", result.resultMsg);
				}
			});	
	    }

 function getModultItem(mid,obj){
	 if(mid){
		 selModuleId = mid;
	 }
	 console.log(obj);
	 $(obj).parent().addClass('current');
	 $(obj).parent().siblings().removeClass('current');
	 var url = '/gzvm/admin!getModuleItem.action';
	var data = {
			moduleId : selModuleId,
	};
	$.ajax({
		url : url,
		data : data,
		dataType : 'json',
		type : 'post',
		success : function(result) {
			if(result.resultCode==0){
				swal( result.resultMsg);
			}
			else{
				var url='';
				if(result.results && result.results.length>0){
					for(var i in result.results){
						var obj = result.results[i];
						url=url+'<div class="sub_type personal " ><p class="name_panel" onclick="getItemContent('+obj.itemId+',\''+obj.itemName+'\')">'+obj.itemName+'</p>'+'<p class="tool_panel s">'+'<img alt="" src="/gzvm/manage/images/edit.png" onclick="showItem('+selModuleId+','+obj.itemId+')">'+'<img alt="" src="/gzvm/manage/images/del.png" onclick="delItem('+obj.itemId+','+selModuleId+')"> </p></div>';
					}
					$("#moduleItem").html('<div class="sub_nav_type"> <p>分类</p> </div>'+url+'<div class="sub_type grade ctrl_item">'+'<p class="name_panel" id="newType"> <img alt="" src="/gzvm/project/images/new.png"> <a onclick="showItem()">新增分类</a> </p> </div>');
					getItemContent(result.results[0].itemId,result.results[0].itemName);
				}else{
					$('#itemName').html('内容');
					$("#moduleItem").html('<div class="sub_nav_type"> <p>分类</p> </div>'+url+'<div class="sub_type grade ctrl_item">'+'<p class="name_panel" id="newType"> <img alt="" src="/gzvm/project/images/new.png"> <a onclick="showItem()">新增分类</a> </p> </div>');
					$('#contents').html('<div class="row"><div class="col-md-12" style="text-align:center;padding-top: 20px;">暂无内容</div></div>');
				}
			}
		},
		failure : function(result) {
			swal("请求失败!", result.resultMsg);
		}
	});
 }	

function getItemContent(itemId,itemName){
	if(itemName){
		$('#itemName').html(itemName);
	}
	if(itemId){
		selItemId = itemId;
	}
	var url = '/gzvm/admin!getItemContents.action';
	var data = {
		itemId : selItemId,
		state : 3
	};
	$.ajax({
		url : url,
		data : data,
		dataType : 'json',
		type : 'post',
		success : function(result) {
			if(result.resultCode==0){
				swal( result.resultMsg);
			}else{
				console.log(result);
				var htmlStr='';
				if(result.results.length>0){
					for ( var i in result.results) {
						var data = result.results[i];
						/*htmlStr += '<div class="competition" id="'+data.contentId+'div"><div class="row"><div class="col-md-5"><div class="comptition_img">'
							+ '<img src="/gzvm/client/images/default.png" onclick="selImage('+data.contentId+');"></div></div><div class="col-md-7"><div class="comptition_text">'
							+ '<div class="competition_title">'+data.contentTitle+'</div>';
						htmlStr+= '<div class="competition_date"><p>发布时间：</p>'
							+ '<p class="date">'+data.pubTime+'</p></div><div class="competition_dsc">'		
							+ '<p >'+'neiron '+'</p></div><div class="detail">'
							+ (data.state == 1? '草稿':'已发布') +'</div>'
							+ '<div><input type="button" value="编辑" onclick="editContent('+data.contentId+');"/>'
							+ '<input type="button" value="删除" onclick="delContent('+data.contentId+');"/></div>'
							+ '<div class="clear"></div></div></div></div></div>'	
							*/
						var path = '';
						if(data.photoId && data.photo != ''){
							path = result.picUrl + data.photoId;
						}else{
							data.photoId=0;
							path='/gzvm/project/images/default.png';
						}
						htmlStr	+='<div class="col-md-4" id="'+data.contentId+'div"><div class="competition_list_panel"><div class="comptition_text"><div class="competition_date">'
							+'<p>更新时间：</p><p id="date">'+data.pubTime+'</p></div></div>'
							+'<div><div class="competition_title">'+data.contentTitle+'</div></div>'
							+'<div class="comptition_img"><div class="sendImgPanel" onclick="selImage('+data.contentId+','+data.photoId+');" style="cursor:pointer;">'
							+'<p style="">更换封面</p></div><img src="'+path+'"></div>'
							+'<div class="comptition_text"><div class="competition_title_item">状态：'+(data.state == 1?'草稿': '已发布')+'</div></div>'
							+'<div><div class="competition_edit">'
							+'<a title="编辑" class="competition_icons"onclick="editContent('+data.contentId+');"></a></div>'
							+'<div class="competition_del">'
							+'<a title="删除" class="competition_icons"onclick="delContent('+data.contentId+');"></a></div></div></div></div>'
					}
				}
				if(htmlStr == ''){
					htmlStr = '<div class="row"><div class="col-md-12" style="text-align:center;padding-top: 20px;">暂无内容</div></div>'
				}
				$('#contents').html(htmlStr);
				$(".comptition_img").mouseover(function(){
					var children = $(this).children();
					$(children[0]).css("display","block");
				});
				$(".comptition_img").mouseout(function(){
					var children = $(this).children();
					$(children[0]).css("display","none");
				});
			}
		},
		failure : function(result) {
			swal("请求失败!", result.resultMsg);
		}
	});
}
 
 function showModule(){
	 $("#moduleType").html('<div class="col-md-2"></div> <div class="align_c col-md-6"> <input class="item  bg_color btn  pop_btn" type="submit" value="保存" onclick="saveModule()" /> <input class="item  bg_color btn  pop_btn " style="background-color:#f00; margin-top:15px;	"type="submit" value="删除" id="del" onclick="del();" /> </div>  <div class="col-md-4"></div>')
	 $("#saveModuleType").html("新增模块");
		$("#saveModuleName").html("模块名字");
		$("#new").show();
		$("#del").hide();
 }
 
 function showDelModule(moduleId){
	 $("#moduleType").html('<div class="col-md-2"></div> <div class="align_c col-md-6"> <input class="item  bg_color btn  pop_btn" type="submit" value="保存" onclick="saveModule('+moduleId+')" /> <input class="item  bg_color btn  pop_btn " style="background-color:#f00; margin-top:15px;	"type="submit" value="删除" id="del" onclick="delModule('+moduleId+');" /> </div>  <div class="col-md-4"></div>')
	 $("#del").show();
	 $("#saveModuleType").html("编辑模块");
	 $("#saveModuleName").html("模块名字");
	 $("#new").show();
 }
 
 
 function showItem(moduleId,itemId){
	 $("#moduleType").html('<div class="col-md-2"></div> <div class="align_c col-md-6"> <input class="item  bg_color btn  pop_btn" type="submit" value="保存" onclick="saveItem('+moduleId+','+itemId+')" />  </div>  ')
	 $("#saveModuleType").html("编辑分类");
	 $("#saveModuleName").html("分类名称");
	 $("#new").show();
	 $("body").css('overflow','hidden');
 }

 function saveModule(moduleId){
		$("#new").hide();
		$("body").css('overflow','auto');
		var moduleName=	$("#tvMobile").val();
		var url = '/gzvm/admin!saveModule.action';
		var data = {
				moduleName : moduleName,
		};
		if(moduleId!=''){
			data.moduleId = selModuleId;
		}
		
		$.ajax({
					url : url,
					data : data,
					dataType : 'json',
					type : 'post',
					success : function(result) {
						getModule();
						swal( result.resultMsg);
					},
					failure : function(result) {
						swal("请求失败!", result.resultMsg);
					}
				});
	}	 
 
 
 function saveItem(moduleId,itemId){
	 var itemName=	$("#tvMobile").val();
	 var url = '/gzvm/admin!saveModuleItem.action';
	 var data = {
			 moduleId : selModuleId,
			 itemName:itemName,
	 }; 
	 if(itemId!=''){
		 data.itemId = itemId;
	 }
		
	 $.ajax({
			url : url,
			data : data,
			dataType : 'json',
			type : 'post',
			success : function(result) {
				swal( result.resultMsg);
				getModultItem(moduleId);
				$("#new").hide();
				$("body").css('overflow','auto');
			},
			failure : function(result) {
				swal("请求失败!", result.resultMsg);
			}
		});
 }
 
 function delModule(moduleId){
	 var url = '/gzvm/admin!delModule.action';
		var data = {
				moduleId : moduleId,
		};
		$.ajax({
		url : url,
		data : data,
		dataType : 'json',
		type : 'post',
		success : function(result) {
			swal( result.resultMsg);
			getModule();
			$("#new").hide();
			$("body").css('overflow','auto');
		},
		failure : function(result) {
			swal("请求失败!", result.resultMsg);
		}
	});
 }
 
 function delItem(itemId,moduleId){
	 var url = '/gzvm/admin!delModuleItem.action';
		var data = {
				itemId : itemId,
		};
		$.ajax({
		url : url,
		data : data,
		dataType : 'json',
		type : 'post',
		success : function(result) {
			swal( result.resultMsg);
			getModultItem(moduleId);
		},
		failure : function(result) {
			swal("请求失败!", result.resultMsg);
		}
	});
 }
 
 // 新增内容
 function addContent(){
	 window.location.href = '/gzvm/project/pages/item_content_add.html?itemId='+selItemId;
	 
 }
 
 // 编辑内容
 function editContent(contentId){
	 window.location.href = '/gzvm/project/pages/item_content_add.html?itemId='+selItemId+'&contentId='+contentId;
	 
 }
 // 删除内容
 function delContent(contentId){
	 swal({
			title : "删除后无法恢复，确认要删除该条内容吗?",
			// text: "You will not be able to recover this imaginary file!",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "是",
			cancelButtonText : "否",
			showLoaderOnConfirm : true,
			closeOnConfirm : false
		}, function() {
			$.ajax({
				url : "/gzvm/admin!delItemContent.action",
				data : {contentId : contentId},
				dataType : 'json',
				type : 'post',
				success : function(result) {
					if (result.resultCode == 1) {
						$('#'+contentId+'div').remove();
						swal("删除成功!", "该管理员已删除", "success");
					}
				},
				failure : function(result) {
					swal("请求失败!", result.resultMsg);
				}
			});
			
		});
 }
 
 function closeSelImg(){
	 $('#photoId').val('');
	 $('#contentId').val('');
	 $('#selImg').css('display','none');
 }
 
 // 显示上传封面图
 function selImage(contentId,photoId){
	 if(photoId!=0){
		 $('#photoId').val(photoId);
	 }
	
	$('#contentId').val(contentId);
	$('#selImg').css('display','block');
 }
 
 function submitForm(){	
	 var form = $("#imgForm"); //其中的form1是我form的名称  
     var options  = {  
         url:'/gzvm/admin!saveItemPhoto.action',  
         type:'post',  
         success:function(data)  
         {  
        	 closeSelImg(); 
    		 swal("上传成功!");
    		 getItemContent();
         }  
     };  
     form.ajaxSubmit(options);
}
