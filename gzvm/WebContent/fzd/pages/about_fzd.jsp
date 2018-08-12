<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>关于锋之道</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/fzd/css/common.css">
<link type="text/css" rel="stylesheet"
	href="/gzvm/fzd/css/about_fzd.css">
<link rel="stylesheet" href="/gzvm/fzd/css/style.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/jquery.params.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
<script src="/gzvm/fzd/js/common.js"></script>

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
	<div class="banner">
		<div class="bs-example" data-example-id="carousel-with-captions">
			<div id="carousel-example-captions" class="carousel slide"
				data-ride="carousel">
				<!-- <ol class="carousel-indicators">
					<li data-target="#carousel-example-captions" data-slide-to="0"
						class=""></li>
					<li data-target="#carousel-example-captions" data-slide-to="1"
						class=""></li>
					<li data-target="#carousel-example-captions" data-slide-to="2"
						class="active"></li>
				</ol> -->
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
					<ul class="mg_choice_list">
						<li class="mg_list_item mg_active" id="L1">公司简介</li>
						<li class="mg_list_item" id="L2">企业文化</li>
						<li class="mg_list_item" id="L3">服务宗旨</li>
						<li class="mg_list_item" id="L4">联系我们</li>
					</ul>
				</div>
			</div>

			<div class="col-md-10" id="rightPanel">
				<div class="col-md-12" id="companyShow">
					<div class="row ctrl_panel">
						<div class="col-md-6  col-sm-12 col-xs-12">
							<div class="col-md-6 ctrl_item">
								<a id="anliPanelName">公司简介</a>
							</div>
						</div>
					</div>
					<div class="row anli_panel">
						<div class="col-md-12 col-sm-12 col-xs-12 anli_mobile_list">
							<a class="anli_product_item">
								”锋之道健康养生“是广州锋之道实业有限公司旗下的养生品牌，它以公司及所属科研团队多年研究成果为依托，以”传播健康，弘扬中医文化为己任，是将中国五千年中医养生文化与现代科技完美结合的成果，是针对调节人体稳定平衡而精心研制的系列健康养生产品，以专业的制造工艺、卓越的产品质量、显著的产品功效从根本上弥补了肌体的先天不足，调节后天肌能失衡，从而保持肌体各脏腑功能达到最佳的平衡表状态，受到众多中医养生爱好者及创业者的欢迎。公司经历近五年拼搏，规模不断壮大，并于2013年8月搬入位于广州市荔湾区鹤洞路342号的悦锋商务大厦总部。“锋之道”养生馆总部舒适的环境及浓郁的养生氛围，与“锋之道”养生主旨相得益彰，为品牌赢得了众多学员、加盟商及客户的赞赏
							</a>
						</div>
					</div>
				</div>
				
				<div class="col-md-12" id="companyCulture">
					<div class="row ctrl_panel">
						<div class="col-md-6  col-sm-12 col-xs-12">
							<div class="col-md-6 ctrl_item">
								<a id="anliPanelName">企业文化</a>
							</div>
						</div>
					</div>
					<div class="row anli_panel">
						<div class="col-md-12 col-sm-12 col-xs-12 anli_mobile_list">
							<a class="anli_product_item">
								“锋之道健康养生”是集养生、调理、修复和强身健体为主要功能的综合性中医养生机构。充分利用市场资源，建立“锋之道健康养生”在全国范围内的推广体系是市场的要求，也是迅速扩大广州锋之道实业有限公司在行业领域的经营规模和知名度的有效途径。通过有效的推广力度，力求在几年时间内使广州锋之道实业有限公司成为行业市场中知名公司，促使公司品牌“锋之道养生馆”成为业内一支强有力的竞争品牌。
							</a>
						</div>
					</div>
				</div>
				
				<div class="col-md-12" id="companyPurpose">
					<div class="row ctrl_panel">
						<div class="col-md-6  col-sm-12 col-xs-12">
							<div class="col-md-6 ctrl_item">
								<a id="anliPanelName">服务宗旨</a>
							</div>
						</div>
					</div>
					<div class="row anli_panel">
						<div class="col-md-12 col-sm-12 col-xs-12 anli_mobile_list">
							<a class="anli_product_item">
								广州锋之道实业有限公司，秉承以人为本，崇尚创新，力在打造一个和人类共存的知名品牌。公司根据不同的健康问题有针对性的提出相应的解决方案，精心打造和推广人性化、个性化的养生服务，为品牌事业的发展奠定了坚实的基础。<br>
								 广州锋之道实业有限公司遵循“人本，科学，诚实，合作，共赢”，恪守“品质、品味、品格”，不断开拓新市场，推广新服务。“锋之道”旗舰店（广州市荔湾区鹤洞店），作为“锋之道”品牌的全国推广总部，以其独特的优势，完善的服务，严谨的营销策略，规范的市场运作模式，愿与社会各界有识之士精诚合作，构建一个良好和谐的市场体系，共同打造一个可持久发展的人类健康事业！
							</a>
						</div>
					</div>
				</div>
				
				<div class="col-md-12" id="companyContact">
					<div class="row ctrl_panel">
						<div class="col-md-6  col-sm-12 col-xs-12">
							<div class="col-md-6 ctrl_item">
								<a id="anliPanelName">联系我们</a>
							</div>
						</div>
					</div>
					<div class="row anli_panel">
						<div class="col-md-12 col-sm-12 col-xs-12 anli_mobile_list">
							<a class="anli_product_item">
								臧总：139 2643 2931<br>
							        高总：185 2009 3344<br><br>
							       地址：广州市荔湾区鹤洞路342号悦锋商务大厦6楼
							</a>
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
	<script src="/gzvm/fzd/js/about_fzd.js"></script>
</body>
</html>