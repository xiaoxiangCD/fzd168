<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link rel="stylesheet" href="/gzvm/css/common.css">
<link rel="stylesheet" href="/gzvm/css/bootstrap-table.css">
<link rel="stylesheet" href="/gzvm/manage/css/index.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>

</head>
<body>
	<div id="header">
		<div class="header_panel" >
			<div class="header_item">
				<div class="row">
					<div class="col-md-6 logo_panel">
						<img id="logoImg" src="" class="img-responsive logo_img">
						<p class="header_fonts">| 欢迎你</p>
					</div>
					<div class="col-md-6 user_panel">
						<div class="user_panel">
							<img id="headImg" src="/gzvm/manage/images/imgNull.png" class="img-circle head_img">
							<p class="user_name">管理员1</p>
						</div>
						<p class="login_out">| <a style="color:#FFF;"> 【退出】</a></p>
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
						<li class="mg_list_item" onclick="openLottery();">中签管理</li>
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
			
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-4">
						<div class="data_panel" style="background:#FF9933;">
							<p class="data_item">
								<img src="/gzvm/manage/images/imgNull.png" class="data_item_img">10
							</p>
							<p class="data_title">
								进行中的赛事
							</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="data_panel" style="background:#00CC99;">
							<p class="data_item">
								<img src="/gzvm/manage/images/imgNull.png" class="data_item_img">10
							</p>
							<p class="data_title">
								进行中的赛事
							</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="data_panel" style="background:#0086DF;">
							<p class="data_item">
								<img src="/gzvm/manage/images/imgNull.png" class="data_item_img">10
							</p>
							<p class="data_title">
								进行中的赛事
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="footer"></div>
	
	<script type="text/javascript" src="/gzvm/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="/gzvm/js/common.js"></script>
	<script type="text/javascript" src="/gzvm/manage/js/index.js"></script>
</body>
</html>