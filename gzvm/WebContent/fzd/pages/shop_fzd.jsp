<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>商城</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/fzd/css/common.css">
<link type="text/css" rel="stylesheet"
	href="/gzvm/fzd/css/shop_fzd.css">
<link rel="stylesheet" href="/gzvm/fzd/css/style.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/jquery.params.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
<script src="/gzvm/fzd/js/common.js"></script>

</head>
<body>
<!-- <div id="header">
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
					<div class="col-md-3 logo_panel">
						<p class="login_text"><a href="/gzvm/client/pages/client_login.jsp">用户登录</a> | <a href="/gzvm/client/pages/register.jsp">用户注册</a>| <a href="/gzvm/manage/pages/login.jsp">管理员登录</a></p>
					</div>
					<div class="col-md-3 hidden-sm hidden-xs phone_panel">
						<p>
							订购热线：<span>400-888-8888</span>
						</p>
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
	<div class="banner">
		<div class="bs-example" data-example-id="carousel-with-captions">
			<div id="carousel-example-captions" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-captions" data-slide-to="0"
						class=""></li>
					<li data-target="#carousel-example-captions" data-slide-to="1"
						class=""></li>
					<li data-target="#carousel-example-captions" data-slide-to="2"
						class="active"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="item">
						<img data-src="holder.js/900x500/auto/#777:#777" alt="900x500"
							src="/gzvm/fzd/images/carousel01.jpg" data-holder-rendered="true" class="carousel_img">
					</div>
					<div class="item">
						<img data-src="holder.js/900x500/auto/#666:#666" alt="900x500"
							src="/gzvm/fzd/images/carousel02.jpg" data-holder-rendered="true" class="carousel_img">
					</div>
					<div class="item active">
						<img data-src="holder.js/900x500/auto/#555:#555" alt="900x500"
							src="/gzvm/fzd/images/carousel03.jpg" data-holder-rendered="true" class="carousel_img">
					</div>
				</div>
				<a class="left carousel-control" href="#carousel-example-captions"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-captions"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<div class="container">
			<div class="row mg_choice_panel">
				<div class="col-md-2 mg_left_panel">
					<div class="mg_choice_item">
						<ul class="mg_choice_list" id="items">
						</ul>
					</div>
				</div>
				
				<div class="col-md-10" id="rightPanel">
					<div class="row ctrl_panel">
						<div class="col-md-6 col-sm-12 col-xs-12">
							<div class="col-md-3 ctrl_item">
								<p id="itemName"></p>
							</div>
						</div>
					</div>
				<div class="row anli_panel" id="contents">
					<div class="col-md-4 col-sm-6 col-xs-12 anli_mobile_list">
						<div class="anli_product_panel">
							<a class="anli_product_name"><img src="/gzvm/fzd/images/01.png" class="anli_product_img"></a>
							<a class="anli_product_item">产后着凉受风引起的腰部酸痛，敷三次泥膜明显好转，坚持使用近一个月症状完全消失。</a>
						</div>
					</div>
				</div>
			</div>
				
			</div>
		</div>

	<div style="height: 5em;"></div>
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
	<script src="/gzvm/fzd/js/product_show.js"></script>
</body>
</html>
</body>
</html> -->