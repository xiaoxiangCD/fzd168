function login(){
	var canLogin = doLogin();
	if (canLogin) {
		document.getElementById("loginForm").submit();
	}
}

function doLogin(){
	var user= document.getElementById("adminCode").value;
	if(!user || user.length==0){
		showErrText('请输入登录手机号！');
		document.getElementById("adminCode").focus();
		return false;
	}
	var pwd=document.getElementById("password").value;
	if(!pwd || (pwd.length==0 )){
		showErrText('请输入密码！');
		document.getElementById("password").focus();
		return false;
	}
	return true;
}

function showErrText(errMsg){
	$('#errStr').html(errMsg);
	$('#errStr').show();
}