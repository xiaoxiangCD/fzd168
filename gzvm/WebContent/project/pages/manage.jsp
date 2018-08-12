<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广州锋之道实业有限公司</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/css/pagination.css">
<link type="text/css" rel="stylesheet"
	href="/gzvm/project/css/common.css">
<link type="text/css" rel="stylesheet"
	href="/gzvm/project/css/manage.css">
<link type="text/css" rel="stylesheet" href="/gzvm/css/sweetalert.css">
<!-- <link rel="stylesheet" href="../css/diyUpload.css">
<link rel="stylesheet" href="../css/webuploader.css">
<script src="../js/diyUpload.js"></script> -->
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/jquery.form.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
<script type="text/javascript" src="/gzvm/js/jquery.pagination.js"></script>
<script type="text/javascript" src="/gzvm/js/common.js"></script>
</head>
<body>
	<div id="header">
		<div class="header_panel">
			<div class="header_item">
				<div class="row">
					<div class="col-md-6 col-xs-6 logo_panel">
						<img id="logoImg" src="/gzvm/fzd/images/fzd.png"
							class="img-responsive logo_img">
					</div>
					<div class="col-md-6 col-xs-6 hidden-xs logo_panel">
						<p class="login_text">
							<a id="adminName">${user.adminName}</a> | <a onclick="logout();" style="cursor:pointer;">注销</a>
						</p>
					</div>
					<div
						class="col-md-6 col-xs-6 hidden-sm hidden-md hidden-lg logo_panel">
						<a href="#cd-nav" class="cd-nav-trigger">Menu <span
							class="cd-nav-icon"></span> <svg x="0px" y="0px" width="40px"
								height="40px" viewBox="0 0 40 40"> <circle
								fill="transparent" stroke="#656e79" stroke-width="1" cx="20"
								cy="20" r="20" stroke-dasharray="157 157"
								stroke-dashoffset="157"></circle> </svg>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<main> <nav class="hidden-xs navbar nav_panel">
	<div class="container-fluid" style="padding-left: 60px;">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="glyphicon glyphicon-align-justify"
					style="font-size: 22px;"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1" style="background: #ffd819">
			<ul class="nav navbar-nav h" id="titleModule">
				<!-- <li class="h current"><a href=""><span
						class="nav_name nav_name_current" id="index_name">首页</span> </a></li>
				<li class="h"><a href=""><span class="nav_name"
						id="competition_name">赛事资讯</span> </a></li>
				<li class="h"><a href=""><span class="nav_name"
						id="about_name">关于我们</span> </a></li> -->
			</ul>
		</div>
	</div>
	</nav>

	<div class="bg">
		<div class="container content space_top">
			<!-- <div class="Type align_l w space_bottom row" >

			</div> -->
			<div class="sub_nav float_l" id="moduleItem">
				<!-- <div class="basics">
				<div class="user_img">
					<img src="/gzvm/project/images/default.png">
				</div>
				<div class="user_infor">
					<p class="user_name">用户昵称</p>
					<p class="user_detail">
						<span class="user_sex">女</span>
						<span class="user_age">25</span>
					</p>
				</div>
			</div> -->
				<!-- <div class="sub_nav_type">
				<p>分类</p>
			</div>
			<div class="sub_type personal " id="moduleIzzz">
				<p class="name_panel">个人资料</p>
				<p class="tool_panel s">
					<img alt="" src="/gzvm/manage/images/edit.png">
					<img alt="" src="/gzvm/manage/images/del.png">
				</p>
			</div>
			<div class="sub_type grade ctrl_item">
				<p class="name_panel" id="newType">
					<img alt="" src="/gzvm/project/images/new.png"> <a>新增分类</a>
				</p>
			</div> -->
			</div>

			<div class="detail_panel float-l">
				<div class="list">
					<div class="detail_title align_l w space_bottom row">
						<p class="detail_name col-md-6" id="itemName">内容</p>
						<!-- <div class="state_search">
						<lable>
							<select class="form-control search_input " type="text" name="" >
								<option>赛时状态</option>
								<option>预报名</option>
								<option>抽签中</option>
								<option>开赛</option>
								<option>已结束</option>
							</select>
							<input class="form-control btn bg_color state_btn" type="submit"  value="赛事筛选"/>
							<div class="clear"></div>
						</lable>
					</div> -->
						<div class="col-md-6">
							<div class="col-md-3 "></div>
							<div class="col-md-3 "></div>
							<div class="col-md-3 "></div>
							<div class="col-md-3 ctrl_item" onclick="addContent();">
								<img alt="" src="/gzvm/manage/images/add.png"> <a>新增</a>
							</div>
						</div>
					</div>
					<div id="contents">
						<!-- <div class="competition">
							<div class="row">
								<div class="col-md-4">
									<div class="competition_list_panel">
										<div class="comptition_text">
											<div class="competition_date">
												<p>更新时间：</p>
												<p id="date">2017-04-13</p>
											</div>
										</div>
										<div>
											<div class="competition_title">成都国际金融中心</div>
										</div>
										<div class="comptition_img">
											<div class="sendImgPanel" style="">
												<p style="">更换封面</p>
											</div>
											<img src="/gzvm/project/images/default.png">
										</div>
										<div class="comptition_text">
											<div class="competition_title_item">成都国际金融中心成都国际金融中心成都国际金融中心成都国际金融中心</div>
										</div>
										<div>
											<div class="competition_edit">
												<a title="编辑" class="competition_icons"></a>
											</div>
											<div class="competition_del">
												<a title="删除" class="competition_icons"></a>
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-md-4">
									<div class="competition_list_panel">
										<div class="comptition_text">
											<div class="competition_date">
												<p>更新时间：</p>
												<p id="date">2017-04-13</p>
											</div>
										</div>
										<div>
											<div class="competition_title">成都国际金融中心</div>
										</div>
										<div class="comptition_img">
											<div class="sendImgPanel" style="">
												<p style="">更换封面</p>
											</div>
											<img src="/gzvm/project/images/default.png">
										</div>
										<div class="comptition_text">
											<div class="competition_title_item">成都国际金融中心成都国际金融中心成都国际金融中心成都国际金融中心</div>
										</div>
										<div>
											<div class="competition_edit">
												<a title="编辑" class="competition_icons"></a>
											</div>
											<div class="competition_del">
												<a title="删除" class="competition_icons"></a>
											</div>
										</div>
									</div>
								</div>
								
							</div>
						</div> -->
					</div>
					<!-- <div class="page space_top space_bottom ">
						<div class="M-box3"></div>
						<div class="clear"></div>
					</div> -->
				</div>

			</div>

			<div class="clear"></div>
		</div>
		<div id="footer">
			<div class="footer_panel">
				<p class="footer_item">广州锋之道实业有限公司/p>
			</div>
		</div>
		<div class="pop_panel" id="new">
			<div class="pop_top w">
				<p id="saveModuleType">新增分类</p>
				<span class="pop_exit" id="exit"> <img
					src="/gzvm/client/images/exit.png">
				</span>
			</div>
			<div class="pop_content">
				<div class=" w space_top space_bottom">
					<div class="row space_bottom hint_panel align_c">
						<div class="row space_bottom">
							<div class="col-md-2 align_r" id="saveModuleName">分类名字</div>
							<div class="col-md-9">
								<input class="item w" type="text" id="tvMobile" />
							</div>
						</div>
					</div>
					<div class="row space_top align_c" id="moduleType">
						<div class="col-md-2"></div>
						<div class="align_c col-md-6">
							<input class="item  bg_color btn  pop_btn" type="submit"
								value="保存" id="login" /> <input
								class="item  bg_color btn  pop_btn "
								style="background-color: #f00; margin-top: 15px;" type="submit"
								value="删除" id="del" onclick="del();" />
						</div>
						<div class="col-md-4"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="pop_panel" id="selImg">
			<div class="pop_top w">
				<p id="saveModuleType">上传封面图</p>
				<span class="pop_exit" onclick="closeSelImg();"> 
					<img src="/gzvm/client/images/exit.png">
				</span>
			</div>
			<iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"></iframe>
			<form id="imgForm" enctype="multipart/form-data" method="post" >
				<input  type="hidden" id="contentId" name="contentId"/>
				<input  type="hidden" id="photoId" name="photoId"/>
				<div class="pop_content">
					<div class=" w space_top space_bottom">
						<div class="row space_bottom hint_panel align_c">
							<div class="row space_bottom">
								<div class="col-md-2 align_r" id="saveModuleName">选择图片</div>
								<div class="col-md-9">
									<input class="item w" type="file" name="file" accept="image/*"/>
								</div>
							</div>
						</div>
						<div class="row space_top align_c" id="moduleType">
							<div class="col-md-2"></div>
							<div class="align_c col-md-6">
								<input class="item  bg_color btn  pop_btn" type="button" onclick="submitForm();" 
									value="保存" /> 
							</div>
							<div class="col-md-4"></div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	</main>

</body>
<script src="/gzvm/js/sweetalert.min.js"></script>
<script type="text/javascript" src="/gzvm/project/js/manage.js"></script>
</html>