var Theight = '';
$().ready(function() { 
	initList();
})

function initList(){	
	initTable({
		tableId :"table",
		url : '/gzvm/competi!getCompetitions.action',
		queryParams : {state : 255},
		columns: [
	        {field:"item",title:"",type:"hidden",checkbox:"true"},
            {field:"competiName",title:"赛事名称",align:"center",valign:"middle",sortable:"true"},
			{field:"level",title:"赛事级别",align:"center",valign:"middle",sortable:"true"},
			{field:"groupType",title:"赛事组别",align:"center",valign:"middle",sortable:"true",formatter:function(value,index,data){
				if(value == 1){
					return '个人赛';
				}else if(value == 2){
					return '团体赛';
				}
			}},
			{field:"joinStartTime",title:"报名时间",align:"center",valign:"middle",sortable:"true",formatter:function(value,data,index){
				return value + ' 至 ' + data.joinEndTime;
			}},
			{field:"startTime",title:"赛事时间",align:"center",valign:"middle",sortable:"true",formatter:function(value,data,index){
				return value + ' 至 ' + data.endTime;
			}},
			{field:"addr",title:"赛事地址",align:"center",valign:"middle",sortable:"true"},
			{field:"state",title:"状态",align:"center",valign:"middle",sortable:"true",formatter:function(value,data,index){
				if (value == 1) {
					return '草稿';
				}else if (value == 2) {
					return '准备中';
				}else if (value == 4) {
					return '报名中';
				}else if (value == 6) {
					return '进行中';
				}else if (value == 8) {
					return '已完赛';
				}
			}},
		],
	});
}

function refshreList(){
	var param = {state : 254};
	if ($('#searchLike').val() != '') {
		param.searchLike = $('#searchLike').val();
	}
	$("#table").bootstrapTable('refresh', {url : '/gzvm/competi!getCompetitions.action',query : param});	
}

function openAdd(){
	window.location.href = '/gzvm/manage/pages/game/game_add.jsp';
}

function showDel(){
	var datas = $("#table").bootstrapTable('getSelections');
	if (datas.length > 0) {
		var data = datas[0];
		if(data.state != 1){
			swal("赛事已经发布，需要删除请联系管理员！");
			return;
		}
		swal({
			title : "确认删除该赛事?",
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
				url : "/gzvm/competi!delCompeti.action",
				data : {competiId : data.competiId},
				dataType : 'json',
				type : 'post',
				success : function(result) {
					if (result.resultCode == 1) {
						$("#table").bootstrapTable('remove',{field: 'competiId', values: [data.competiId]});
						swal("删除成功!", "该赛事已删除", "success");
					}else{
						swal(result.resultMsg);
					}
				},
				failure : function(result) {
					swal("请求失败!", result.resultMsg);
				}
			});
			
		});
	}else{
		 swal("请选择需要删除的管理员!");
	}
}




