<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选手管理</title>
<link rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link rel="stylesheet" href="/gzvm/css/common.css">
<link rel="stylesheet" href="/gzvm/css/bootstrap-table.css">
<link rel="stylesheet" href="/gzvm/manage/css/game_lottery_item.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>

</head>
<body>
	<div id="header">
		<div class="header_panel">
			<div class="header_item">
				<div class="row">
					<div class="col-md-6 logo_panel">
						<img id="logoImg" src="" class="img-responsive logo_img">
						<!-- <p class="header_fonts">| 欢迎你</p> -->
					</div>
					<div class="col-md-6 user_panel">
						<div class="user_panel">
							<img id="headImg" src="/gzvm/manage/images/imgNull.png"
								class="img-circle head_img">
							<p class="user_name">管理员1</p>
						</div>
						<p class="login_out">
							| <a style="color: #FFF;"> 【退出】</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container" id="container">
		<div class="row mg_choice_panel">
			<div class="col-md-2 mg_left_panel">
				<div class="mg_choice_item">
					<div class="mg_choice_name">管理</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openAdministrate();">管理员管理</li>
						<li class="mg_list_item" onclick="openRole();">角色管理</li>
					</ul>
				</div>
				<div class="mg_choice_item">
					<div class="mg_choice_name">赛事</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openGame();">赛事管理</li>
						<li class="mg_list_item" onclick="openGamePackage();">参赛包管理</li>
						<li class="mg_list_item" onclick="openSignUp();">报名管理</li>
						<li class="mg_list_item mg_active">中签管理</li>
					</ul>
				</div>
				<div class="mg_choice_item">
					<div class="mg_choice_name">用户</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openPlayer();">选手管理</li>
						<!-- <li class="mg_list_item">角色管理</li>
						<li class="mg_list_item">消息管理</li> -->
					</ul>
				</div>
				<div class="mg_choice_item">
					<div class="mg_choice_name">显示</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openBanner();">banner管理</li>
					</ul>
				</div>
				<div class="mg_choice_item">
					<div class="mg_choice_name">联系我们</div>
					<ul class="mg_choice_list">
						<li class="mg_list_item" onclick="openProblem();">常见问题</li>
						<li class="mg_list_item" onclick="openContact();">联系方式</li>
					</ul>
				</div>
			</div>

			<div class="col-md-10 mg_right_panel">
				<div class="row ctrl_panel">
					<div class="col-md-7" style="padding-left:0;">
						<div class="col-md-2 ctrl_item ctrl_item_add" onclick="window.location.href='/gzvm/manage/pages/game/game_lottery.jsp';">
							<img alt="" src="/gzvm/manage/images/back.png"><a style="font-size:15px;height:40px;">返回</a>
						</div>
						<!-- <div class="col-md-2 ctrl_item ctrl_item_add"  onclick="showAdd();">
							<img alt="" src="/gzvm/manage/images/add.png"> <a>新增</a>
						</div>
						<div class="col-md-2 ctrl_item ctrl_item_add">
							<img alt="" src="/gzvm/manage/images/edit.png"> <a>编辑</a>
						</div>
						<div class="col-md-2 ctrl_item ctrl_item_add"  onclick="showDel();">
							<img alt="" src="/gzvm/manage/images/del.png"> <a>删除</a>
						</div> -->
						<div class="col-md-2 ctrl_item ctrl_item_add">
							<img alt="" src="/gzvm/manage/images/import.png"> <a>导入</a>
						</div>
						<div class="col-md-2 ctrl_item ctrl_item_add">
							<img alt="" src="/gzvm/manage/images/export.png"> <a>导出</a>
						</div>
					</div>
					<div class="col-md-5">
						<div class="col-md-9 search_panel" style="text-align:right;">
							<input type="text" class="search">
						</div>
						<div class="col-md-3 search_panel" style="text-align:left;">
							<input type="button" class="btn mg_btn search_btn" value="搜索">
						</div>
						
					</div>
				</div>
				<div class="row table_panel">
					<table id="table" data-undefined-text="暂无数据" data-search-tex="搜索"></table>
				</div>
			</div>
		</div>
	</div>

	<div id="footer"></div>
	<div id="alertWindow" class="mg_alert_window">
		<div class="mg_window_top">
			<p class="mg_title_font">删除</p>
			<p class="mg_title_icon"><img alt="" src="/gzvm/manage/images/close.png" class="mg_icon_img" onclick="closeDel();"></p>
		</div>
		<div class="mg_window_middle">
			<p class="mg_alert_item">删除后将无法回复，是否确定删除？</p>
		</div>
		<div class="mg_window_bottom">
			<div class="mg_btn_panel"><button class="btn mg_sure_btn mg_btn">确定</button></div>
			<div class="mg_btn_panel"><button class="btn mg_cancel_btn" onclick="closeDel();">取消</button></div>
		</div>
	</div>
	<div id="addWindow" class="mg_add_window" style="width:700px;height:400px;margin-top:-200px;margin-left:-350px;">
	  <form action="" id="addForm">
		<div class="mg_add_top">
			<p class="mg_addtitle_font">新增</p>
			<p class="mg_addtitle_icon"><img alt="" src="/gzvm/manage/images/close.png" class="mg_addicon_img" onclick="closeAdd();"></p>
		</div>
		<div class="mg_add_middle" style="height:310px;">
			<div class="row form-group mg_add_item" style="margin-left:0;padding:0;">
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label"><label>姓名:</label></div>
					<div class="col-md-9"><input type="text" class="form-control" placeholder="请输入姓名"></div>
				</div>
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label"><label>性别:</label></div>
					<div class="col-md-9">
						<select class="form-control">
							<option>--请选择--</option>
							<option>男</option>
							<option>女</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row form-group mg_add_item" style="margin-left:0;padding:0;">
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label"><label>证件类型:</label></div>
					<div class="col-md-9">
						<select class="form-control">
							<option>--请选择--</option>
							<option>身份证</option>
							<option>护照</option>
							<option>港澳通行证</option>
						</select>
					</div>
				</div>
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label"><label>证件号:</label></div>
					<div class="col-md-9"><input type="text" class="form-control" placeholder="请输入证件号"></div>
				</div>
			</div>
			<div class="row form-group mg_add_item" style="margin-left:0;padding:0;">
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label"><label>手机:</label></div>
					<div class="col-md-9"><input type="text" class="form-control" placeholder="请输入手机"></div>
				</div>
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label"><label>邮箱:</label></div>
					<div class="col-md-9"><input type="text" class="form-control" placeholder="请输入邮箱"></div>
				</div>
			</div>
			<div class="row form-group mg_add_item" style="margin-left:0;padding:0;">
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label" style="padding-left:0;"><label>紧急联系人:</label></div>
					<div class="col-md-9"><input type="text" class="form-control" placeholder="请输入联系人姓名"></div>
				</div>
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label"><label>紧急电话:</label></div>
					<div class="col-md-9"><input type="text" class="form-control" placeholder="请输入紧急联系电话"></div>
				</div>
			</div>
			<div class="row form-group mg_add_item" style="margin-left:0;padding:0;">
				<div class="col-md-6" style="padding:0;">
					<div class="col-md-3 mg_add_item_label" style="padding-left:0;"><label>职业:</label></div>
					<div class="col-md-9"><input type="text" class="form-control" placeholder="请输入职业"></div>
				</div>
			</div>
			<div class="row form-group mg_add_item" style="margin-left:0;padding:0;">
				<div class="col-md-12" style="padding:0;padding-left: 32px;">
					<div class="col-md-1 mg_add_item_label" style=""><label>地址:</label></div>
					<div class="col-md-11"><input type="text" class="form-control" placeholder="请输入居住地址"></div>
				</div>
			</div>
		</div>
		<div class="mg_add_bottom">
			<div class="mg_addbtn_panel"><button class="btn mg_addsure_btn mg_btn">确定</button></div>
			<div class="mg_addbtn_panel"><button class="btn mg_addcancel_btn" onclick="closeAdd();">取消</button></div>
		</div>
	  </form>
	</div>
	
	<script type="text/javascript" src="/gzvm/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="/gzvm/js/common.js"></script>
	<script type="text/javascript" src="/gzvm/manage/js/game_lottery_item.js"></script>
	<script type="text/javascript" src="/gzvm/js/bootstrap-table-zh-CN.js"></script>
</body>
</html>