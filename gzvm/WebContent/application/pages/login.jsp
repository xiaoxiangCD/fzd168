<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">
<title>登录</title>
<link rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link rel="stylesheet" href="/gzvm/css/common.css">
<link rel="stylesheet" href="/gzvm/application/css/login.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
<script type="text/javascript" src="/gzvm/js/common.js"></script>
<script type="text/javascript" src="/gzvm/application/js/login.js"></script>
</head>

<body onkeydown="keyLogin();">
	<div>
		<div class="flex">
			<div class="flex_item" style="padding: 5em 0;">
				<img src="/gzvm/application/images/gb_logo.png"
					style="width: 17.5em; height: 15em;">
			</div>
		</div>
		<div>

			<div class="flex">
				<div class="flex_item">
					<input id="name" type="text" name="userName" placeholder="请输入用户名"
						class="user_name form-control">
				</div>
			</div>

			<div class="flex">
				<div class="flex_item">
					<input id="psw" type="password" name="userPwd" placeholder="请输入密码"
						class="user_pwd form-control">
				</div>
			</div>

			<!-- <div class="flex"
				style="margin: .7em auto; padding: 0; border: 1px solid #ccc; border-radius: 5px; max-width: 73%;background:#FFFFFF;">
				<div class="train_item flex_item">
					<select class="text" id="selectRole">
						<option value="" style="color: #999;">请选择登录角色</option>
						<option value="10">系统管理员</option>
					</select>
				</div>
			</div> -->

			<div class="flex" style="margin-top: 25px;">
				<div class="flex_item">
					<input id="submit" type="button" value="登录"
						class="btn btn-info btn-block submit bgAll" onclick="login();">
				</div>
			</div>
		</div>

		<div class="flex">
			<div class="flex_item"></div>
		</div>
	</div>
</body>
</html>