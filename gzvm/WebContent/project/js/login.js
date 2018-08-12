/**
 * 
 */
var userName;
var passWord;
function login(){
	userName=document.getElementById("userName").value
	passWord=document.getElementById("passWord").value
	var url = '/gzvm/user!login.action';
	var data = {
			code : userName,
			password:passWord
	};
	$.ajax({
				url : url,
				data : data,
				dataType : 'json',
				type : 'post',
				success : function(result) {
					if(result.resultCode==1){
						swal("登录成功!", result.resultMsg,"success");
						window.location.href="/gzvm/client/pages/client_index.jsp"	
					}
					else{
						swal({
		    				   title: "失败!",
		    				   text: "账号不存在或者密码错误!",
		    				   type: "error",
		    				   confirmButtonText: "重新填写"
		    				 }); 
					}
				},
				failure : function(result) {
					swal("登录失败!", result.resultMsg);
				}
			});
}