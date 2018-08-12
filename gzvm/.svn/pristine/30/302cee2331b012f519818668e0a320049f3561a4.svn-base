var Pheight = '';
var competiId="";
var init=0;
$().ready(function() { 
	console.log($('#container').height());
	console.log($('.ctrl_panel').height());
	Pheight = $('#container').height() - ($('.ctrl_panel').height() + 40);
	$(".add_panel").height(Pheight+'px');
})

function initList(){
	if(competiId==""){
		swal("请先定义赛事基本信息!");
	}else{
		var url = '/gzvm/competi!getDiscoun.action';
		var data = {
				competiId : competiId,
		};
		//初始化口令表格	
		initTable({
			tableId :"orderTable",
			url : url,
			queryParams : data,
			height:250,
			striped: true,
			pagination: true,
			pageSize: 10,
			pageNumber:1,
			clickToSelect: true,
			singleSelect : true,
			columns: [
			    {field:"",title:"",align:"center",valign:"middle",checkbox:"true"},
	            {field:"password",title:"口令编码",align:"center",valign:"middle"},
				{field:"discount",title:"减免费用",align:"center",valign:"middle"},
				{field:"discountNum",title:"使用次数",align:"center",valign:"middle"},
				{field:"count",title:"操作",align:"center",valign:"middle",formatter:function(value,data,index){
						return '<button class="btn mg_btn search_btn" style="padding: 1px 21px;" onclick="delDis('+data.ruleId+')">删除</button>';
				}},
			],
		});
	}
}

function delDis(ruleId){
	var url = '/gzvm/competi!delDis.action';
	var data = {
			ruleId : ruleId,
	};
	$.ajax({
				url : url,
				data : data,
				dataType : 'json',
				type : 'post',
				success : function(result) {
					swal( result.resultMsg);
					refreshList();
				},
				failure : function(result) {
					swal("请求失败!", result.resultMsg);
				}
			});
}


function saveCompet(){
		var competiName= $("#competiName").val();
		var level=$("#level").val();
		var groupType=$("#groupType").val();
		var peopleNum=$("#peopleNum").val();
		var city=$("#city").val();
		var startTime=$("#startTime").val();
		var joinStartTime=$("#joinStartTime").val();
		var joinEndTime=$("#joinEndTime").val();
		var joinType=$("#joinType").val();
		var chargeType=$("#chargeType").val();
		var addr=$("#addr").val();
		var endTime=$("#endTime").val();
		
		var url = '/gzvm/competi!saveCompeti.action';
		var data = {
				competiName : competiName,
				level : level,
				groupType : groupType,
				peopleNum : peopleNum,
				city : city,
				startTime : startTime,
				joinStartTime : joinStartTime,
				joinEndTime : joinEndTime,
				joinType : joinType,
				chargeType : chargeType,
				addr:addr,
				endTime:endTime,
		};
		$.ajax({
					url : url,
					data : data,
					dataType : 'json',
					type : 'post',
					success : function(result) {
						competiId=result.competiId;
						
						swal( result.resultMsg);
					},
					failure : function(result) {
						swal("请求失败!", result.resultMsg);
					}
				});
}

function saveDiscount(){
	if(competiId==""){
		swal("请先定义赛事基本信息!");
	}else{
		var password=$("#password").val();
		var discount=$("#discount").val();
		var discountNum=$("#discountNum").val();
		var url = '/gzvm/competi!saveDiscount.action';
		var data = {
				competiId : competiId,
				password : password,
				discount : discount,
				discountNum : discountNum,
		};
		$.ajax({
					url : url,
					data : data,
					dataType : 'json',
					type : 'post',
					success : function(result) {
						swal( result.resultMsg);
						$("#password").val('');
						$("#discount").val('');
						$("#discountNum").val('');
						if(init==0){
							initList();
							init=1;
						}else{
							refreshList();
						}
					},
					failure : function(result) {
						swal("请求失败!", result.resultMsg);
					}
				});
	}
}

function refreshList(){
	$("#orderTable").bootstrapTable('refresh', {url : '/gzvm/competi!getDiscoun.action',query : {competiId : competiId}});
}


function changeJoinType(){
	var joinType=$("#joinType").val();
	if(joinType==1){
//		预报名
		$("#chargeType").html('<option value="" >--请选择--</option> <option value="1" >预报名收费</option> <option value="2" >中签收费</option> <option value="3" >中签不收费</option>');
	}else{
//		直接报名
		$("#chargeType").html('<option value="" >--请选择--</option> <option value="1" >报名收费</option> <option value="2" >报名不收费</option>');
	}
}
