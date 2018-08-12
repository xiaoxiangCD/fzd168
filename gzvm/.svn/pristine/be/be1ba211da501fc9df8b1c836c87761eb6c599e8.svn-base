
$().ready(function() { 
	initList()
})

function initList(){	
	initTable({
		tableId :"table",
		url : '/gzvm/admin!getAdmins.action',
		columns: [
	        {field:"adminid",title:"",type:"hidden",checkbox:"true"},
            {field:"adminName",title:"管理员姓名",align:"center",valign:"middle",sortable:"true"},
			{field:"adminCode",title:"管理员编码",align:"center",valign:"middle",sortable:"true"},
			{field:"mobile",title:"手机号",align:"center",valign:"middle",sortable:"true"},
			{field:"qq",title:"QQ号",align:"center",valign:"middle",sortable:"true"},
		],
	});
}

function refreshList(){
	var param = {};
	if ($('#searchLike').val() != '') {
		param.searchLike = $('#searchLike').val();
	}
	$("#table").bootstrapTable('refresh', {url : '/gzvm/admin!getAdmins.action',query : param});
}

function showAdd(){
	$('#addWindow').show();
	$('#pwDiv').show();
	initRoles();
}

function initRoles(){
	$.ajax({
		url : "/gzvm/admin!getAdminRoles.action",
		dataType : 'json',
		type : 'post',
		success : function(result) {
			if (result.resultCode != 0) {
				// 这里明天整 $.ajax{}
				var htmlStr = '<option value="">请选择权限</option>';
				htmlStr += getSelectOptionStr(result.results,'roleId','roleName');
				$('#roleId').html(htmlStr);
			}
		}
	});
}

var adminId = '';
function showEdit(){
	var datas = $("#table").bootstrapTable('getSelections');
	if (datas.length > 0) {
		initRoles();
		var data = datas[0];
		adminId = data.adminId;
		$('#adminName').val(data.adminName);
		$('#adminCode').val(data.adminCode);
		$('#mobile').val(data.mobile);
		$('#qq').val(data.qq);
		$('#addWindow').show();
		$('#pwDiv').hide();
	}else{
		 swal("请选择需要编辑的管理员!");
	}
}

function save(){
	var param = {};
	param.roleId = $('#roleId').val();
	if (param.roleId == '') {
		swal('请选择管理员角色');
		return;
	}
	param.adminName = $('#adminName').val();
	if (param.adminName == '') {
		swal('请输入管理员姓名');
		return;
	}
	param.adminCode = $('#adminCode').val();
	if (param.adminCode == '') {
		swal('请输入管理员账号');
		return;
	}
	param.mobile = $('#mobile').val();
	if (param.mobile == '') {
		swal('请输入管理员手机号');
		return;
	}
	param.qq = $('#qq').val();
	
	if (adminId != '') {
		param.adminId = adminId;
	}else{
		param.password = $('#password').val();
		if (param.password == '') {
			swal('请输入管理员密码');
			return;
		}
	}
	$.ajax({
		url : "/gzvm/admin!saveAdmin.action",
		data : param,
		dataType : 'json',
		type : 'post',
		success : function(result) {
			if (result.resultCode != 0) {
				// 这里明天整 $.ajax{}
				closeAdd()
			}
			swal(result.resultMsg);
		},
		failure : function(result) {
			swal("请求失败!", result.resultMsg);
		}
	});
	
}

function closeAdd(){
	adminId='';
	$('#addWindow').hide();
	$('#adminName').val('');
	$('#adminCode').val('');
	$('#mobile').val('');
	$('#qq').val('');
}

function showDel(){
	var datas = $("#table").bootstrapTable('getSelections');
	if (datas.length > 0) {
		var data = datas[0];
		swal({
			title : "确认删除该管理员?",
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
				url : "/gzvm/admin!delAdmin.action",
				data : {adminId : data.adminId},
				dataType : 'json',
				type : 'post',
				success : function(result) {
					if (result.resultCode == 1) {
						$("#table").bootstrapTable('remove',{field: 'adminId', values: [data.adminId]});
						swal("删除成功!", "该管理员已删除", "success");
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

