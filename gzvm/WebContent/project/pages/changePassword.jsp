<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际垂直马拉松</title>
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/common.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/changePassword.css">
<link type="text/css" rel="stylesheet" href="/gzvm/css/sweetalert.css">
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
						<p class="header_fonts">| 修改密码</p>
					</div>
					<div class="col-md-6 logo_panel">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container content space_top ">
		<div class="infor w space_top space_bottom context_panel">
<!-- 			<p class="hint align_c w space_top">为了保证您能正常参赛，请保证您所有填写信息正确无误！</p> -->			
			<div class="row space_bottom">
				<div class="col-md-2"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 手机号码</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvMobile"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-3 align_l ps">PS:填写常用手机号码</div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-2"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 验证码</div>
				<div class="col-md-4">
					<input class="item verify_text" type="text" id="code"/>
					<input class="item verify_btn bg_color" type="submit" value="获取验证码" id="verCode"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-3 align_l ps">PS:填写您收到的验证码</div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-2"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 密码</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvPassWrod"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-3 align_l ps">PS:建议使用字母和数字，区分大小写</div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-2"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 确认 密码</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvNewPassWrod"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-3 align_l ps">请重新输入密码</div>
			</div>
			
			<div class="row space_top ">
				<div class="col-md-3"></div>
				<div class="col-md-4">
					<input class="item w bg_color btn" type="submit" value="确认提交" id="sure"/>
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
	<div class="pop_panel" id="new">
		<div class="pop_top w">
			<p>温馨提示</p>
			<span class="pop_exit" id="exit">
				<img src="/gzvm/client/images/exit.png">
			</span>
		</div>
		<div class="pop_content">
			<div class=" w space_top space_bottom">
				<div class="row space_bottom hint_panel align_c">
					<div class="pop_hint pop_hint_l">
						<span class="hint_img">
							<img src="/gzvm/client/images/hint_img.png">
						</span>
					</div>
					<div class="pop_hint pop_hint_r">
						<p class="success_hint align_l w ">您的登录密码重置成功，请妥善保管！</p>
					</div>
				</div>
				<div class="row space_top align_c">
					<div class="align_c">
						<input class="item  bg_color btn  pop_btn" type="submit" value="立即登录" id="login"/>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
<script src="/gzvm/js/sweetalert.min.js"></script>
<script type="text/javascript" src="/gzvm/client/js/changePassword.js"></script>
</html>