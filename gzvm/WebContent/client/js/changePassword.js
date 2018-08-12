/**
 * 
 */
var mobile;
var password;
var NewpassWord;
var code;

$("#sure").click(function(){
	mobile= document.getElementById("tvMobile").value;
	password= document.getElementById("tvPassWrod").value;
	NewpassWord= document.getElementById("tvNewPassWrod").value;
	code=document.getElementById("code").value;
	if(password==NewpassWord){
		var url = '/gzvm/user!loginSms.action';
		var data = {
			mobile : mobile,
			authCode:code
		};
		$.ajax({
					url : url,
					data : data,
					dataType : 'json',
					type : 'post',
					success : function(result) {
						if(result.resultCode!=0){
							swal("验证码验证成功!", result.resultMsg,"success");
							var url = '/gzvm/user!changePassWord.action';
				    		var data = {
				    			mobile : mobile,
				    			password:password
				    		};
				    		$.ajax({
				    					url : url,
				    					data : data,
				    					dataType : 'json',
				    					type : 'post',
				    					success : function(result) {
				    						if(result.resultCode!=0){
				    							swal("修改密码成功!", result.resultMsg,"success");
				    							$(".pop_panel").show();
				    						}
				    						else{
				    							swal("修改密码失败!", result.resultMsg);
				    						}
				    					},
				    					failure : function(result) {
				    						swal("请求失败!", result.resultMsg);
				    					}
				    				});
						}else{
							swal("验证码验证失败!", result.resultMsg);	
						}
					},
					failure : function(result) {
						swal("请求失败!", result.resultMsg);
					}
				});
		
	}else{
		swal("两次密码不相同!");
	}
	})
	$("#exit").click(function(){
		$(".pop_panel").hide();
	})
	
	$("#login").click(function(){
		window.location.href="/gzvm/client/pages/client_login.jsp"
	})
	
	$("#verCode").click(function(){
		mobile= document.getElementById("tvMobile").value;
		if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(mobile))){
			swal({
				   title: "错误!",
				   text: "不是完整的手机号!",
				   type: "error",
				   confirmButtonText: "重新填写"
				 }); 
		}else{
			var url = '/gzvm/user!getSmsCode.action';
    		var data = {
    			mobile : mobile
    		};
    		$.ajax({
    					url : url,
    					data : data,
    					dataType : 'json',
    					type : 'post',
    					success : function(result) {
    						swal("验证码获取成功!", result.resultMsg,"success");
    					},
    					failure : function(result) {
    						swal("验证码获取失败!", result.resultMsg);
    					}
    				});
			
		}
		
   })
	