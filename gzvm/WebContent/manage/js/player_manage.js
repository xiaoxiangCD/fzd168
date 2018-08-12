var Theight = '';
$().ready(function() { 
	getUsers();
	$('#searchBtn').click(function(){
		refreshList();
	});
})

function refreshList(){
	var param = {};
	if ($('#searchLike').val() != '') {
		param.searchLike = $('#searchLike').val();
	}
	$("#table").bootstrapTable('refresh', {url : '/gzvm/user!getUsers.action',query : param});
}
function getUsers(){
	initTable({
		tableId :"table",
		url : '/gzvm/user!getUsers.action',
		columns: [
	        {field:"userid",title:"",type:"hidden",checkbox:"true"},
            {field:"userName",title:"姓名",align:"center",valign:"middle",sortable:"true"},
			{field:"sex",title:"性别",align:"center",valign:"middle",sortable:"true",formatter:function(value,row,index){
				if(value == 2){
					return "女";
				}else{
					return "男";
				}
			}},
			{field:"idCard",title:"证件号码",align:"center",valign:"middle",sortable:"true"},
			{field:"age",title:"年龄",align:"center",valign:"middle",sortable:"true"},
			{field:"mobile",title:"电话",align:"center",valign:"middle",sortable:"true"},
			{field:"addr",title:"地址",align:"center",valign:"middle",sortable:"true"},
			{field:"profession",title:"职业",align:"center",valign:"middle",sortable:"true"},
		],
	})
}

var userId = '';
function getParam(){
	var param = {};
	if($("#userName").val() != ""){
		param.userName =$("#userName").val();
	}else{
		alert("请输入姓名");
		return null;
	}
	if($("#sex").val() != ""){
		param.sex =$("#sex").val();
	}else{
		alert("请选择性别");
		return null;
	}
	if($("#idType").val() != ""){
		param.idType =$("#idType").val();
	}else{
		alert("请选择证件类型");
		return null;
	}
	if($("#idCard").val() != ""){
		param.idCard =$("#idCard").val();
	}else{
		alert("请输入证件号");
		return null;
	}
	if($("#mobile").val() != ""){
		param.mobile =$("#mobile").val();
	}else{
		alert("请输入手机号");
		return null;
	}
	if($("#email").val() != ""){
		param.email =$("#email").val();
	}
	if($("#profession").val() != ""){
		param.profession =$("#profession").val();
	}
	if($("#addr").val() != ""){
		param.addr =$("#addr").val();
	}
	if (userId != '') {
		param.userId = userId;
	}else{
		param.password = param.mobile;
	}
	/*param.state =$("#calssifyState").combobox('getValue');
	param.description =$("#description").val();*/
	return param;
}

function save(){
	/*$('.btn-pubing').attr("disabled",true);*/
	var param = getParam();
	console.log();
	if(param){
		$.ajax({
	    	url : '/gzvm/user!saveUser.action',
	    	data: param,
	    	dataType : 'json',
	    	type : 'post',
	    	success : function(result) {
	    		if(result.resultCode==1){
	    			hideAddView();
	    			refreshList();
	    		}else{
	    			alert(result.resultMsg);
	    		}
	    	}
	    });
	}
}

function hideAddView(){
	$("#addWindow").hide();
	$("#userName").val('');
	$("#sex").val('');
	$("#idType").val('');
	$("#idCard").val('');
	$("#mobile").val('');
	$("#email").val('');
	$("#profession").val('');
	$("#addr").val('');
}

function showAdd(){
	$('#addWindow').show();
}

function showEdit(){
	var datas = $("#table").bootstrapTable('getSelections');
	if (datas.length > 0) {
		var data = datas[0];
		userId = data.userId;
		//TODO 把data里的值放到对应的内容里，显示编辑弹框
		
		$('#addWindow').show();
	}else{
		 swal("请选择需要编辑的管理员!");
	}
}

function closeAdd(){
	$('#addWindow').hide();
	//TODO　把弹框的内容全部置空或默认值
	userId = '';
//	$('#addForm').reset();
}

function showDel(){
	var datas = $("#table").bootstrapTable('getSelections');
	if (datas.length > 0) {
		var data = datas[0];
		swal({
			title : "确定删除该选手?",
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
				url : "/gzvm/user!delUser.action",
				data : {userId : data.userId},
				dataType : 'json',
				type : 'post',
				success : function(result) {
					if (result.resultCode == 1) {
						$("#table").bootstrapTable('remove',{field: 'userId', values: [data.userId]});
						swal("删除成功!", "该选手已删除", "success");
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

function closeDel(){
	$('#alertWindow').hide();
}





