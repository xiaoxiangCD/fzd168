
$().ready(function(){
	var Sh = window.screen.availHeight;
	$('#selectRoles').css('bottom',-Sh);
	if(window.localStorage){
		console.log("浏览器支持localStorage");
	}else{
		console.log("浏览器暂不支持localStorage");
	}
	var loUser = localStorage.getItem("user") || "";
	var loPass = localStorage.getItem("pass") || "";
	$("#name").val(loUser);
	$("#psw").val(loPass);
})

function keyLogin(){
 if (event.keyCode==13)  //回车键的键值为13
   document.getElementById("submit").click(); //调用登录按钮的登录事件
}


