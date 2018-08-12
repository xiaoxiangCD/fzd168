<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广州锋之道实业有限公司</title>

<link type="text/css" rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/common.css">
<link type="text/css" rel="stylesheet" href="/gzvm/client/css/register.css">
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
						<img id="logoImg" src="/gzvm/client/images/logo.png" class="img-responsive logo_img">
					</div>
					<div class="col-md-3 logo_panel">
					</div>
					<div class="col-md-3 logo_panel">
						<p class="login_text"><a href="/gzvm/client/pages/client_login.jsp">登录</a> | <a href="/gzvm/client/pages/register.jsp">注册</a></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container content space_top">
		<div class="row step_panel">
			<div class="col-md-4 ">
				<p class="step align_c w step_1 step_current"><span >①</span> 填写用户信息</p>
			</div> 
			<div class="col-md-4 ">
				<p class="step align_c w step_2" id="stepTwo"><span class="type_color">②</span> 手机验证</p>
			</div>
			<div class="col-md-4 ">
				<p class="step align_c w step_3" id="stepThree"><span class="type_color">③</span> 注册成功</p>
			</div>
		</div>
		<div class="infor w space_top space_bottom" id="basic">
			<p class="hint align_c w space_top">为了保证您能正常参赛，请保证您所有填写信息正确无误！</p>
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 用户名</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvNickName" onblur="checkNickName(this.value)"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-4 align_l ps">PS:建议使用字母和数字</div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 密码</div>
				<div class="col-md-4">
					<input class="item w" type="password" id="tvPassWord"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-4 align_l ps">PS:建议使用字母和数字，区分大小写</div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 确认 密码</div>
				<div class="col-md-4">
					<input class="item w" type="password" id="tvNewPassWord" onblur="checkNewPassWord(this.value)"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-4 align_l ps">请重新输入密码</div>
			</div>
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 证件类型</div>
				<div class="col-md-4">
					<select class="item w" id="selIdType">
						<option>身份证</option>
						<option>护照</option>
						<option>港澳通行证</option>
					</select>
				</div>
				<div class="col-md-1 align_l"><span class="required">*</span> 证件号码</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvId" onblur="checkIdCard(this.value)"/>
				</div>
				<div class="col-md-1"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 真实姓名</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvMyName"  onblur="checkUserName(this.value)" />
				</div>
				<div class="col-md-1 align_l"><span class="required">*</span> 性别</div>
				<div class="col-md-4">
					<select class="item w" id="selSex">
						<option>男</option>
						<option>女</option>
					</select>
				</div>
				<div class="col-md-1"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 出生日期</div>
				<div class="col-md-4">
					<select name="SYear" id="SYear" class="date date_left">
					　　 <option value="">年</option>
					</select>
					<select name="SMonth" id="SMonth" class="date">
					　　 <option value="">月</option>
					</select>
					<select name="SDay" id="SDay" class="date date_right">
					　　 <option value="">日</option>
					</select>
				</div>
				
				<div class="col-md-6"></div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l">职业</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvPro"/>
				</div>
				<div class="col-md-1 align_l">邮箱</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvMaiBox"/>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row space_bottom">
				<div class="col-md-1"></div>
				<div class="col-md-1 align_l">地址</div>
				<div class="col-md-7">
					<textarea class="area w" id="tvareAddr"></textarea>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="coi-md-11">
					<p><span class="required">*</span>为必填项</p>
				</div>
			</div>
			
			<div class="row space_top ">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input class="item w bg_color btn" type="submit" value="确认提交" id="basicSure"/>
				</div>
				<div class="col-md-4"></div>
			</div>
			
		</div>
		<div class="infor w space_top space_bottom" id="phone">
			<p class="hint align_c w space_top phone_hint">手机号用于以后登录，建议使用常用手机号码！</p>
			
			<div class="row space_bottom space_top ">
				<div class="col-md-3"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 手机号码</div>
				<div class="col-md-4">
					<input class="item w" type="text" id="tvMobile"/>
				</div>
				<div class="col-md-1"></div>
				<div class="clo-md-3 align_l ps">PS:填写常用手机号码</div>
			</div>
			
			<div class="row space_bottom">
				<div class="col-md-3"></div>
				<div class="col-md-1 align_l"><span class="required">*</span> 验证码</div>
				<div class="col-md-4">
					<input class="item verify_text" type="text" id="tvVarCode"/>
					<input class="item verify_btn bg_color" type="submit" value="获取验证码" id="subVarCode"/>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row space_top ">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input class="item w bg_color btn sub_btn" type="submit" value="确认提交"  id="phoneSure"/>
				</div>
				<div class="col-md-4"></div>
			</div>
			
		</div>
		<div class="infor w space_top space_bottom" id="success">
			<div class="row space_bottom hint_panel">
				<div class="col-md-3"></div>
				<div class="col-md-2 align_c">
					<span class="hint_img">
						<img src="/gzvm/client/images/hint_img.png">
					</span>
				</div>
				<div class="col-md-5">
					<p class="success_hint align_l w space_top">恭喜您注册成功，开启精彩垂马生涯！</p>
				</div>
				<div class="col-md-2"></div>
			</div>
			<div class="row space_top ">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<input class="item w bg_color btn sub_btn" type="submit" value="立即登录"  id="successSure"/>
				</div>
				<div class="col-md-4"></div>
			</div>
			
		</div>
	</div>
	<!-- <div id="footer">
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
	</div> -->
</div>

</body>
<script src="/gzvm/js/checkUtils.js"></script>
<script src="/gzvm/js/sweetalert.min.js"></script>
<script src="/gzvm/client/js/register.js"></script>
</html>