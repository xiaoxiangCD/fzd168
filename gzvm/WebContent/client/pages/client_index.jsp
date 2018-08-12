<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际垂直马拉松赛事</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/common.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/client_index.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
</head>
<body>
<div class="bg">
	<div id="header">
		<div class="header_panel" >
			<div class="header_item">
				<div class="row">
					<div class="col-md-2 logo_panel">
						<img id="logoImg" src="/gzvm/client/images/logo.png" class="img-responsive logo_img">
					</div>
					<div class="col-md-3 logo_panel">
						<img  src="/gzvm/client/images/avalogo.png" class="img-responsive avalogo_img">
						<img  src="/gzvm/client/images/tvalogo.png" class="img-responsive avalogo_img">
					</div>
					<div class="col-md-3 logo_panel">
						<p class="login_text"><a href="/gzvm/client/pages/client_login.jsp">登录</a> | <a href="/gzvm/client/pages/register.jsp">注册</a></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="nav_panel">
		<ul class="nav h" id="nav">
			<li class="h current">
				<a href="#">
					<span class="index_icon_current" id="index"></span>
					<span class="nav_name nav_name_current" id="index_name">首页</span>
					<div class="clear"></div>
				</a>  
			</li>
			<li class="h">
				<a href="#">
					<span class="competition_icon" id="competition"></span>
					<span class="nav_name" id="competition_name">赛事资讯</span>
					<div class="clear"></div>
				</a>  
			</li>
			<li class="h">
				<a href="#">
					<span class="about_icon" id="about"></span>
					<span class="nav_name" id="about_name">关于我们</span>
					<div class="clear"></div>
				</a>  
			</li>
		</ul>
	</div>
	<div class="container content ">
		<div class="banner">
			<div id="myCarousel" class="carousel slide">
			  <ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active">
			    	
			    </li>
			    <li data-target="#myCarousel" data-slide-to="1">
			    	
			    </li>
			    <li data-target="#myCarousel" data-slide-to="2">
			    	
			    </li>
			    <li data-target="#myCarousel" data-slide-to="3">
			    	
			    </li>
			    <li data-target="#myCarousel" data-slide-to="4">
			    	
			    </li>
			  </ol>
			  <!-- Carousel items -->
			  <div class="carousel-inner">
			    <div class="active item">
			    	<img src="/gzvm/client/images/banner.png" id="banner01">
			    </div>
			    <div class="item">
			    	<img src="/gzvm/client/images/banner.png" id="banner02">
			    </div>
			    <div class="item">
			    	<img src="/gzvm/client/images/banner.png" id="banner03">
			    </div>
			    <div class="item">
			    	<img src="/gzvm/client/images/banner.png" id="banner04">
			    </div>
			    <div class="item">
			    	<img src="/gzvm/client/images/banner.png" id="banner05">
			    </div>
			  </div>
			  <!-- Carousel nav -->
			  <a class="carousel-control left" href="#myCarousel" data-slide="prev">
			  	<span class="prev_img">
			  		<img src="/gzvm/client/images/prev.png">
			  	</span>
			  </a>
			  <a class="carousel-control right" href="#myCarousel" data-slide="next">
			  	<span class="next_img">
			  		<img src="/gzvm/client/images/next.png">
			  	</span>
			  </a>
			</div>
			<!-- <div class="search_panel">
				<div class="">
					<div class="search_row">
						<div class="search_text align_r"> 城 市</div>
						<select class="form-control search_input " type="text" name="" >
							<option>广州</option>
							<option>成都</option>
							<option>上海</option>
							<option>深圳</option>
						</select>
					</div>
					<div class="search_row">
						<div class="search_text align_r"> 日 期</div>
						<select class="form-control search_input" type="text" name="" >
							<option>广州</option>
							<option>成都</option>
							<option>上海</option>
							<option>深圳</option>
						</select>
						<input class="form-control search_input " type="month">
					</div>
					<div class="search_row">
						<div class="search_text align_r"> 赛事级别</div>
						<select class="form-control search_input " type="text" name="" >
							<option>系列赛</option>
							<option>公开赛</option>
							<option>挑战赛</option>
							<option>精英赛</option>
							<option>大满贯</option>
						</select>
					</div>
					<div class="search_row">
						<div class="search_text align_r"> 赛事组别</div>
						<select class="form-control search_input " type="text" name="" >
							<option>个人赛</option>
							<option>团体赛</option>
						</select>
					</div>
					<div class="search_row">
						<div class="search_text align_r"></div>
						<input class="form-control search_input  w bg_color btn search_sub" type="submit" value="确认提交"/>
					</div>
				</div>
			</div> -->
		</div>
		<div class="competition_panel">
			<div class="title space_top">
				<div class="title_icon">
					<img src="/gzvm/client/images/competition_list.png">
				</div>
				<h2 class="title_cn">热门赛事</h2>
				<h2 class="title_en">HOT</h2>
				<p class="more">
					<a href="#" >更多赛事 ></a>
				</p>
				<div class="clear"></div>
			</div>
			<div class="competition">
				<div class="row">
					<div class="col-md-5">
						<div class="comptition_img">
							<img src="/gzvm/client/images/com_photo.png">
						</div>
					</div>
					<div class="col-md-7">
						<div class="comptition_text">
							<div class="competition_title">成都国际金融中心（成都IFS）</div>
							<div class="competition_type">
								<p class="type_panel">
									<span>
										<img src="/gzvm/client/images/type_ico.png">
									</span>
									<span>个人赛</span>
								</p>
								<p class="type_panel">
									<span>
										<img src="/gzvm/client/images/type_ico.png">
									</span>
									<span>系列赛</span>
								</p>
							</div>
							<div class="competition_date">
								<p>时间：</p>
								<p id="date">2017-04-13</p>
							</div>
							<div class="competition_adress">
								<p>地点：</p>
								<p id="adress">成都国际金融中心</p>
							</div>
							<div class="competition_dsc">
								<p>
									本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中超100个为首驻成都的品牌。届时来自国内外的“梯客”…
								</p>
							</div>
							<div class="detail">
								<a href="#">更多详情 ></a>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="competition">
				<div class="row">
					<div class="col-md-5">
						<div class="comptition_img">
							<img src="/gzvm/client/images/default.png">
						</div>
					</div>
					<div class="col-md-7">
						<div class="comptition_text">
							<div class="competition_title">成都国际金融中心（成都IFS）</div>
							<div class="competition_type">
								<p>个人赛</p>
								<p>系列赛</p>
							</div>
							<div class="competition_date">
								<p>时间：</p>
								<p id="date">2017-04-13</p>
							</div>
							<div class="competition_adress">
								<p>地点：</p>
								<p id="adress">成都国际金融中心</p>
							</div>
							<div class="competition_dsc">
								<p>
									本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中超100个为首驻成都的品牌。届时来自国内外的“梯客”…
								</p>
							</div>
							<div class="detail">
								<a href="#">更多详情 ></a>
							</div>
						</div>
					</div>
				</div>
				
			</div>
			<div class="competition">
				<div class="row">
					<div class="col-md-5">
						<div class="comptition_img">
							<img src="/gzvm/client/images/default.png">
						</div>
					</div>
					<div class="col-md-7">
						<div class="comptition_text">
							<div class="competition_title">成都国际金融中心（成都IFS）</div>
							<div class="competition_type">
								<p>个人赛</p>
								<p>系列赛</p>
							</div>
							<div class="competition_date">
								<p>时间：</p>
								<p id="date">2017-04-13</p>
							</div>
							<div class="competition_adress">
								<p>地点：</p>
								<p id="adress">成都国际金融中心</p>
							</div>
							<div class="competition_dsc">
								<p>
									本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中超100个为首驻成都的品牌。届时来自国内外的“梯客”…
								</p>
							</div>
							<div class="detail">
								<a href="#">更多详情 ></a>
							</div>
						</div>
					</div>
				</div>
				
			</div>
			<div class="competition">
				<div class="row">
					<div class="col-md-5">
						<div class="comptition_img">
							<img src="/gzvm/client/images/default.png">
						</div>
					</div>
					<div class="col-md-7">
						<div class="comptition_text">
							<div class="competition_title">成都国际金融中心（成都IFS）</div>
							<div class="competition_type">
								<p>个人赛</p>
								<p>系列赛</p>
							</div>
							<div class="competition_date">
								<p>时间：</p>
								<p id="date">2017-04-13</p>
							</div>
							<div class="competition_adress">
								<p>地点：</p>
								<p id="adress">成都国际金融中心</p>
							</div>
							<div class="competition_dsc">
								<p>
									本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中超100个为首驻成都的品牌。届时来自国内外的“梯客”…
								</p>
							</div>
							<div class="detail">
								<a href="#">更多详情 ></a>
							</div>
						</div>
					</div>
				</div>
				
			</div>
			<div class="competition">
				<div class="row">
					<div class="col-md-5">
						<div class="comptition_img">
							<img src="/gzvm/client/images/default.png">
						</div>
					</div>
					<div class="col-md-7">
						<div class="comptition_text">
							<div class="competition_title">成都国际金融中心（成都IFS）</div>
							<div class="competition_type">
								<p>个人赛</p>
								<p>系列赛</p>
							</div>
							<div class="competition_date">
								<p>时间：</p>
								<p id="date">2017-04-13</p>
							</div>
							<div class="competition_adress">
								<p>地点：</p>
								<p id="adress">成都国际金融中心</p>
							</div>
							<div class="competition_dsc">
								<p>
									本次比赛场地设于成都市中心的地标性建筑之一——成都国际金融中心（成都IFS），购物中心主楼双塔高达248米，共52个楼层，购物中心主楼双塔高达248米，共52个楼层，拥有近300家商铺，其中超100个为首驻成都的品牌。届时来自国内外的“梯客”其中超100个为首驻成都的品牌。届时来自国内外的“梯客”…
								</p>
							</div>
							<div class="detail">
								<a href="#">更多详情 ></a>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		
		</div>
	</div>
	<div id="footer">
		<div class="footer_panel" >
			<div class="footer_item">
				<p class="footer_org">主办单位：</p>
				<p class="footer_text"> 成都全搜索新闻网</p>
			</div>
			<div class="footer_item">
				<p class="footer_org">协办单位：</p>
				<p class="footer_text"> 成都国际金融中心（成都IFS）</p>
			</div>
			<div class="footer_item">
				<p class="footer_org">赛事版权单位：</p>
				<p class="footer_text"> 世界高塔竞速协会、亚太地区垂直马拉松协会</p>
			</div>
			<div class="footer_item">
				<p class="footer_org">运营推广单位：</p>
				<p class="footer_text"> 广州垂马体育发展有限公司</p>
			</div>
		</div>
	</div>
</div>
<script>
$('.carousel').carousel({
	  interval: 2000
	}) 
 $("#nav li").click(function(){
	$(this).siblings().removeClass("current");
	$(this).addClass("current");
	
})
$("#nav li").eq(0).click(function(){
	$("#competition").removeClass("competition_icon_current").addClass("competition_icon");
	$("#about").removeClass("about_icon_current").addClass("about_icon");
	$("#index").removeClass("index_icon").addClass("index_icon_current");
	$("#competition_name,#about_name").removeClass("nav_name_current");
	$("#index_name").addClass("nav_name_current");
})
$("#nav li").eq(1).click(function(){
	$("#index").removeClass("index_icon_current").addClass("index_icon");
	$("#about").removeClass("about_icon_current").addClass("about_icon");
	$("#competition").removeClass("competition_icon").addClass("competition_icon_current");
	$("#index_name,#about_name").removeClass("nav_name_current");
	$("#competition_name").addClass("nav_name_current");
})
$("#nav li").eq(2).click(function(){
	$("#index").removeClass("index_icon_current").addClass("index_icon");
	$("#competition").removeClass("competition_icon_current").addClass("competition_icon");
	$("#about").removeClass("about_icon").addClass("about_icon_current");
	$("#index_name,#competition_name").removeClass("nav_name_current");
	$("#about_name").addClass("nav_name_current");
})
</script>
</body>
</html>