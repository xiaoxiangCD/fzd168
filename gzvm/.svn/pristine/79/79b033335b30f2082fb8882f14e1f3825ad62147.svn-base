var Theight = '';
var selectItem = [{
					    "value":1,
					    "text":"text1"
					},{
					    "value":2,
					    "text":"text2"
					},{
					    "value":3,
					    "text":"text3",
					},{
					    "value":4,
					    "text":"text4"
					},{
					    "value":5,
					    "text":"text5"
					}];
$().ready(function() {
	$(".easyui-combobox").combobox({editable:false});
	$('#combobox').combobox({
		data : selectItem,
		multiple:true,
		panelHeight:'auto',
	 	editable:false, 
		onChange: function() {
		    var value = $('#combobox').combobox('getValues').join(',');
		    console.log(value);
		}
	});
	$('#combobox').combobox('setValues',[parseInt(selectItem[0].value)]); 
	initTable({
		tableId :"table",
		url : '/gzvm/admin!getAdminRoles.action',
		queryParams : {},
		columns: [
	        {field:"",title:"",align:"center",valign:"middle",checkbox:"true"},
            {field:"roleName",title:"角色名",align:"center",valign:"middle",sortable:"true"},
			{field:"roleCode",title:"角色编码",align:"center",valign:"middle",sortable:"true"},
			{field:"roleDescribe",title:"角色描述",align:"center",valign:"middle",sortable:"true"},
			{field:"",title:"模块定义",align:"center",valign:"middle",formatter:function(value,row,index){
				return '<button class="btn mg_btn search_btn" style="padding: 1px 21px;" onclick="showChoiceWind();">定义</button>';
			}},
		],
	})
})

function showAdd(){
	$('#addWindow').show();
}

function closeAdd(){
	$('#addWindow').hide();
	$('#addForm').reset();
}

function showDel(){
	$('#alertWindow').show();
}

function closeDel(){
	$('#alertWindow').hide();
}

function showChoiceWind(){
	$('#choiceWindow').show();
}

function closeChoice(){
	$('#choiceWindow').hide();
}

function saveModule(){
	var xxxx=$('#module').val()+"";
}

function saveRole(){
	var roleName= document.getElementById("roleName").value;
	var roleCode= document.getElementById("roleCode").value;
	var roleDescribe=document.getElementById("roleDescribe").value;
	var url = '/gzvm/admin!saveAdminRole.action';
	var data = {
			roleName : roleName,
			roleCode : roleCode,
			roleDescribe : roleDescribe 
	};
	$.ajax({
				url : url,
				data : data,
				dataType : 'json',
				type : 'post',
				success : function(result) {
					if(result.resultCode!=0){
						swal("保存成功!", result.resultMsg,"success");	
					}
					else{
						swal("保存失败!");
					}
				},
				failure : function(result) {
					swal("请求失败!");
				}
			});
}






