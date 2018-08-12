<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际垂直马拉松</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/common.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/pay.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
</head>
<body>
<div class="bg">
	<div id="header">
		<div class="header_panel" >
			<div class="header_item">
				<div class="row">
					<div class="col-md-6 logo_panel">
						<img id="logoImg" src="/gzvm/client/images/chuima.png" class="img-responsive logo_img">
					</div>
					<div class="col-md-6 logo_panel">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="nav_panel">
		<ul class="nav h">
			<li class="h">
				<a href="#">
					<span >首页</span>
				</a>  
			</li>
			<li class="h">
				<a href="#">
					<span class="current">赛事资讯</span>
				</a>  
			</li>
			<li class="h">
				<a href="#">
					<span>关于我们</span>
				</a>  
			</li>
		</ul>
	</div>
	<div class="container content ">
		<div class="detail_title align_l w space_bottom">
			<p class="detail_name">中签缴费</p>
			<div class="state_search">
			</div>
		</div>	
		<div class="pay_content">
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
							<!-- <div class="competition_type">
								<p>个人赛</p>
								<p>系列赛</p>
							</div> -->
							<div class="competiton_date">
								<p>时间：</p>
								<p id="date">2017-04-13</p>
							</div>
							<div class="competiton_adress">
								<p>地点：</p>
								<p id="adress">成都国际金融中心</p>
							</div>
							<div class="competiton_sign">
								<p>报名时间：</p>
								<p id="sign_time">2017-04-23 至 2017-05-12</p>
							</div>
							<div class="competiton_high">
								<p>垂直高度：</p>
								<p id="high">236米</p>
							</div>
							<div class="competiton_floor">
								<p>楼层数：</p>
								<p id="floor">49F</p>
							</div>
							<div class="competiton_package">
								<p>已选参赛包：</p>
								<p id="package">
									<span>标准参赛包</span>
									<span id="price">￥189</span>
									
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="privilege space_top space_bottom">
				<div class="row space_bottom">
					<div class="col-md-1"></div>
					<div class="col-md-2 align_l">
						<lable>
							<input class="rule_select" type="checkbox" value="">
							<p class=" align_l privilege_dsc">使用口令减免</p>
						</lable>
					</div>
					<div class="col-md-5 n_padding">
						<input class="item verify_text" type="text"/>
						<input class="item verify_btn bg_color" type="submit" value="口令验证" placeholder="输入您的减免口令"/>
					</div>
					<div class="col-md-3"></div>
				</div>
			</div>
			
			<div class="pay_type space_top">
				<div class="pay row space_top">
					<div class="col-md-1"></div>
					<div class="col-md-1 pay_title">支付方式：</div>
					<div class="col-md-2 pay">
						<lable>
							<input class="pay_select" type="radio" value="1" name="payType">
							<div class="pay_image">
								<img  src="/gzvm/client/images/default.png">
							</div>
						</lable>
					</div>
					<div class="col-md-2 pay">
						<lable>
							<input class="pay_select" type="radio" value="2"  name="payType">
							<div class="pay_image">
								<img  src="/gzvm/client/images/default.png">
							</div>
						</lable>
					</div>
					<div class="col-md-2 pay">
						<lable>
							<input class="pay_select" type="radio" value="3"  name="payType">
							<div class="pay_image">
								<img  src="/gzvm/client/images/default.png">
							</div>
						</lable>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
			
			<div class="row space_top ">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input class="item w bg_color btn space_top pay_btn" type="submit" value="立即支付" id="sure"/>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		
	</div>
	<div id="footer">
		<div class="footer_panel" >
			<p class="footer_item">广州垂马体育发展有限公司</p>
		</div>
	</div>
</div>
<script>
$('.carousel').carousel({
	  interval: 2000
	}) 


</script>
</body>
</html>