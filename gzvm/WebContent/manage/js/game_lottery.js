var Theight = '';
$().ready(function() { 
	Theight = $('#container').height() - ($('.ctrl_panel').height() + 40);
	$(".table_panel").height(Theight+'px');
	//$("#table").height(Theight+'px');
	$('#table').bootstrapTable({
		height: Theight,
		striped: true,
		pagination: true,
		pageSize: 20,
		pageNumber:1,
		pageList: [10, 20, 50, 100],
		//search: true,
		//showRefresh: true,
		clickToSelect: true,
		columns: [
			{field:"user_email",title:"邮箱",align:"center",valign:"middle",sortable:"true"},
			{field:"user_company",title:"公司",align:"center",valign:"middle",sortable:"true"},
			{field:"user_dates",title:"开始时间",align:"center",valign:"middle",sortable:"true"},
			{field:"user_lastlogintime",title:"最后登录时间",align:"center",valign:"middle",sortable:"true"},
			{field:"user_version",title:"记录",align:"center",valign:"middle",sortable:"true"},
			{field:"userstatus_package_id",title:"role_id",align:"center",valign:"middle",sortable:"true"},
			{field:"userstatus_end_time",title:"结束时间",align:"center",valign:"middle",sortable:"true"}
				],
			
		data : [
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
			{"user_email":"51684684@qq.com","user_company":"广州沃捷","user_dates":"2014-10-13 13:35:51","user_lastlogintime":"2014-10-13 13:35:51","user_version":"0","userstatus_package_id":"100014","userstatus_end_time":"2014-10-13 13:35:51"},
				],
		formatNoMatches: function(){
	            	return '无符合条件的记录';
	            }
		});
})

function openSignItem(){
	window.location.href = '/gzvm/manage/pages/game/game_lottery_item.jsp';
}

function showDel(){
	$('#alertWindow').show();
}

function closeDel(){
	$('#alertWindow').hide();
}







