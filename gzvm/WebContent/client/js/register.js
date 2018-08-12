/**
 * 
 */
var nickname;
var password;
var newPassWord;
var idType;
var idCard;
var userName;
var sex;
var profession;
var addr;
var mobile;
var varCode;
var authCode;
var year;
var age;
var maiBox;
var a = 0;
var b = 0;
var c = 0;
var d = 0;

function checkIdCard(txt) {
	//	var reg =isIDCard1= /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
	if (CheckUtils.checkCard(txt) == false) {
		swal({
			title : "错误!",
			text : "身份证号码不符合规范!",
			type : "error",
			confirmButtonText : "重新填写"
		});
		a = 0;
	}
	a = 1;
	var year = txt.substring(6, 10);
	$('#SYear').val(year);
	$('#SYear').change();
	var month = txt.substring(10, 12);
	$('#SMonth').val(month);
	$('#SMonth').change();
	var day = txt.substring(12, 14);
	$('#SDay').val(day);
}

function checkNickName(txt) {
	if (txt.length == 0 || txt == null) {
		swal({
			title : "错误!",
			text : "用户名不能为空!",
			type : "error",
			confirmButtonText : "重新填写"
		});
		b = 0;
	}
	b = 1;
}

function checkNewPassWord(txt) {
	password = document.getElementById("tvPassWord").value
	if (txt.length == 0 || txt == null || txt != password) {
		swal({
			title : "错误!",
			text : "两次输入密码不相同!",
			type : "error",
			confirmButtonText : "重新填写"
		});
		c = 0;
	}
	c = 1;
}

function checkUserName(txt) {
	if (txt.length == 0 || txt == null) {
		swal({
			title : "错误!",
			text : "真实姓名不能为空!",
			type : "error",
			confirmButtonText : "重新填写"
		});
		d = 0;
	}
	d = 1;
}

$(".infor").eq(1).hide();
$(".infor").eq(2).hide();
$("#basicSure").click(
		function() {
			if ((a + b + c + d) != 4) {
				swal({
					title : "错误!",
					text : "有数据不符合要求!",
					type : "error",
					confirmButtonText : "重新填写"
				});
			} else {
				nickname = document.getElementById("tvNickName").value
				password = document.getElementById("tvPassWord").value
				newPassWord = document.getElementById("tvNewPassWord").value
				var obj = $('#SYear option:selected').val()
				var myDate = new Date();
				age = myDate.getFullYear() - obj;
				maiBox = document.getElementById("tvMaiBox").value + 1;
				//1是身份证,2是护照，3是港澳通
				idType = document.getElementById("selIdType").selectedIndex;
				idCard = document.getElementById("tvId").value;
				userName = document.getElementById("tvMyName").value;
				//1是男生,2是女生
				sex = document.getElementById("selSex").selectedIndex + 1;
				profession = document.getElementById("tvPro").value;
				addr = document.getElementById("tvareAddr").value;
				$("#basic").hide();
				$("#phone").show();
				$("#stepTwo").removeClass("step_2").addClass("step_2_current")
						.addClass("step_current")
				$("#stepTwo span").removeClass("type_color")
			}
		})
$("#phoneSure").click(
		function() {
			mobile = document.getElementById("tvMobile").value;
			authCode = document.getElementById("tvVarCode").value;
			var url = '/gzvm/user!loginSms.action';
			var data = {
				mobile : mobile,
				authCode : authCode
			};
			$.ajax({
				url : url,
				data : data,
				dataType : 'json',
				type : 'post',
				success : function(result) {
					
					/*alert("MobileNumber:" + mobile + "  ;AuthCode: " + authCode + "  ;ResultMessage:" + result.resultMsg + "  ;ResultCode:" + result.resultCode );*/
					
					if (result.resultCode != 0) {
						swal("验证码验证成功!", result.resultMsg);
						var url = '/gzvm/user!saveUser.action';
						var data = {
							mobile : mobile,
							nickname : nickname,
							userName : userName,
							password : password,
							idType : idType,
							idCard : idCard,
							sex : sex,
							profession : profession,
							addr : addr,
							mobile : mobile,
							age : age,
							maiBox : maiBox
						};
						$.ajax({
							url : url,
							data : data,
							dataType : 'json',
							type : 'post',
							success : function(result) {
								if (result.resultCode != 0) {
									swal("注册成功!", result.resultMsg);
									$("#phone").hide();
									$("#success").show();
									$("#stepThree").removeClass("step_3")
											.addClass("step_3_current")
											.addClass("step_current")
									$("#stepThree span").removeClass(
											"type_color")
								}
							},
							failure : function(result) {
								swal("请求失败!", result.resultMsg);
							}
						});
					}
				},
				failure : function(result) {
					swal("请求失败!", result.resultMsg);
				}
			});
		})
$("#successSure").click(function() {
	window.location.href = "/gzvm/client/pages/client_login.jsp"
})
$("#subVarCode").click(function() {
	mobile = document.getElementById("tvMobile").value;
	if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(mobile))) {
		swal({
			title : "错误!",
			text : "不是完整的手机号!",
			type : "error",
			confirmButtonText : "重新填写"
		});
	} else {
		var url = '/gzvm/user!getSmsCode.action';
		var data = {
			mobile : mobile,
		};
		$.ajax({
			url : url,
			data : data,
			dataType : 'json',
			type : 'post',
			success : function(result) {
				if(result.resultCode == 1){
					swal("验证码发送成功!");	
				}
			},
			failure : function(result) {
				swal("请求失败!", result.resultMsg);
			}
		});
	}
})

$(function() {
	var yearid = $('#SYear') //年所在的控件
	var monthid = $('#SMonth') //月所在的控件
	var dayid = $('#SDay') //天所在的控件
	var myDate = new Date();
	var year = myDate.getFullYear();

	for (var i = (year - 70); i <= (year); i++) {
		yearid.append('<option value="' + i + '">' + i + '</option>')
	}

	yearid.change(function() {
		monthid.html('')
		for (var i = 1; i <= 12; i++) {
			var a = i < 10 ? '0' : '';
			monthid.append('<option value="' + a + i + '">' + i + '</option>')
		}

		monthid.change()
	})

	monthid.change(function() {
		var yearValue = yearid.val()
		var monthValue = parseInt(monthid.val())
		var dayvalue;
		dayid.html('')

		if (monthValue == 1 || monthValue == 3 || monthValue == 5
				|| monthValue == 7 || monthValue == 8 || monthValue == 10
				|| monthValue == 12) {
			dayvalue = 31
		} else if (monthValue == 4 || monthValue == 6 || monthValue == 11
				|| monthValue == 9) {
			dayvalue = 30
		} else if (monthValue == 2) {

			if (yearValue % 4 == 0
					&& (yearValue % 4 != 0 || yearValue % 400 == 0)) { //闰年
				dayvalue = 29
			} else {
				dayvalue = 28
			}

		}

		for (var i = 1; i <= dayvalue; i++) {
			var a = i < 10 ? '0' : '';
			dayid.append('<option value="' + a + i + '">' + i + '</option>')
		}

	})
})