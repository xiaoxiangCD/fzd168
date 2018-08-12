<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>详情</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/fzd/css/common.css">
<link type="text/css" rel="stylesheet"
	href="/gzvm/fzd/css/health_item.css">
<link rel="stylesheet" href="/gzvm/fzd/css/style.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/jquery.params.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
<script src="/gzvm/fzd/js/common.js"></script>
<script type="text/javascript">
getModule();
</script>

</head>
<body>
	<div id="header">
		<div class="header_panel">
			<div class="header_item">
				<div class="row">
					<div class="col-md-2 col-sm-2 col-xs-4 logo_panel">
						<img id="logoImg" src="/gzvm/fzd/images/fzd.png"
							class="img-responsive logo_img">
					</div>
					<div class="col-md-7 col-sm-10 hidden-xs nav_panel">
						<ul class="nav h" id="nav">
							<li class="h "><a href="/gzvm/fzd/pages/fzd_index.jsp">
									首页 </a></li>
						</ul>
					</div>
					<!-- <div class="col-md-3 logo_panel">
						<p class="login_text"><a href="/gzvm/client/pages/client_login.jsp">用户登录</a> | <a href="/gzvm/client/pages/register.jsp">用户注册</a>| <a href="/gzvm/manage/pages/login.jsp">管理员登录</a></p>
					</div> -->
					<div class="col-md-3 hidden-sm hidden-xs phone_panel">
						<!-- <p>
							订购热线：<span>400-888-8888</span>
						</p> -->
					</div>
					<div
						class="col-md-3 col-xs-3 hidden-sm hidden-md hidden-lg logo_panel">
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
	<main>
	
	<div class="container">
		<div class="row mg_choice_panel">
			<div class="col-md-12" id="rightPanel">
				<div class="col-md-12" id="healthTalk">
					<div class="row ctrl_panel">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="col-md-9 ctrl_item">
								<p id="contentTitle"></p>
							</div>
							<div class="col-md-3 item_go_back">
								<a onclick="window.history.go(-1);">返回上一级</a>
							</div>
						</div>
					</div>
					<div class="row health_panel" id="contents">
						
					</div>
				</div>
				
			</div>
		</div>
	</div>

	<!-- <div style="height: 5em;"></div> -->
	<div id="footer">
	</div>
	</main>
	<div id="cd-nav" class="cd-nav">
		<div class="cd-navigation-wrapper">
			<div class="cd-half-block">
				<nav>
				<ul class="cd-primary-nav" id="sNav">
					<li><a href="/gzvm/fzd/pages/fzd_index.jsp" class="selected">-
							首页 </a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
	<script src="/gzvm/js/main.js"></script>
	<script src="/gzvm/fzd/js/health_item.js"></script>
</body>
</html>