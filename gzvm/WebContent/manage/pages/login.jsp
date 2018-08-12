<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="/gzvm/css/bootstrap.css">
<link rel="stylesheet" href="/gzvm/css/common.css">
<link rel="stylesheet" href="/gzvm/manage/css/login.css">
<script type="text/javascript" src="/gzvm/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="/gzvm/js/bootstrap.js"></script>
<script type="text/javascript" src="/gzvm/js/common.js"></script>
<script type="text/javascript" src="/gzvm/manage/js/login.js"></script>
</head>
<script type="text/javascript">
var errMsg =  "<%=request.getAttribute("errMsg")%>";
function init(){
	if((errMsg!=null)&&(errMsg!="null")){
		/* document.getElementById("pwd").value="";
		document.getElementById("pwd").focus(); */
		showErrText(errMsg);
	}	
}
</script>
<body onload="init()">
	<div id="header">
		<div class="header_panel" >
			<div class="header_item">
				<div class="row">
					<div class="col-md-6 logo_panel">
						<img id="logoImg" src="/gzvm/fzd/images/fzd.png" class="img-responsive logo_img">
						<p class="header_fonts">| 欢迎登录</p>
					</div>
					<div class="col-md-6 logo_panel">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container" id="container">
		<div class="row login_panel">
			<div class="col-md-6"></div>
			<div class="col-md-6 edit_panel">
				<div class="login_space">
					<form action="<%=request.getContextPath()%>/admin!login.action" name="loginForm" id="loginForm" method="post"
						onSubmit="javascript:return login();">
						<div class="login_row">
							<p style="font-size:20px;">管理员登录</p>
							<span id="errStr" style="color: red; margin-top: 5px;display: block;"></span>
						</div>
						<div class="login_row">
							<input class="form-control mg_input_text" type="text" value="${adminCode}" name="adminCode" id="adminCode" placeholder="管理员账号/手机号"
							onKeyDown="javascript:if (event.keyCode==13||event.keyCode==9) document.forms.loginForm.password.focus();"/>
						</div>
						<div class="login_row">
							<input class="form-control mg_input_text"  type="password" value="${password}" name="password" id="password" placeholder="密码"
							onKeyDown="javascript:if (event.keyCode==13) return login();">
						</div>
					</form>
					<div class="login_row">
						<input class="btn btn-block btn-warning mg_btn" value="登录" type="button" onclick="login();"/>
					</div>
				</div>	
			</div>
		</div>
	</div>
	<div id="footer">
		
	</div>
</body>
</html>