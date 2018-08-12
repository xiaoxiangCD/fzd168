<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际垂直马拉松</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/common.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/sweepPay.css">
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
			<div class="order_detail">
				<a href="#">订单详情</a>
			</div>
		</div>	
		<div class="pay_content">
			<div class="price_panel">
				<div class="pay_icon float_l">
					<img src="/gzvm/client/images/weixin.jpg">
				</div>
				<div class="pay_price float_l">
					<p>
						<span class="price">189</span>元
					</p>
				</div>
				<div class="clear"></div>
			</div>
			<div class="qrcode_panel">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-3">
						<div class="qrcode">
							<img src="/gzvm/client/images/qrcode.jpg">
						</div>
						<p class="qrcode_dsc">打开微信扫一扫</p>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-4">
						<img src="/gzvm/client/images/sweep_step.png">
					</div>
					<div class="col-md-2"></div>
				</div>
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