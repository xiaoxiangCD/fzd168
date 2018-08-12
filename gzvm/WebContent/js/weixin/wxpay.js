/**
 * 
 */
function getParam(){
	var param = {
		body : 'voge产品', // 商品描述
		orderName : 'gebile',// 商户订单号前缀
		total_fee : 1,
		spbill_create_ip : returnCitySN["cip"],// 终端ip地址
	};
	param.notify_url = '/pay!payCallBack.action';  //回调地址
//	param.notify_url = 'http://huangh09.xicp.net:35461/gate/pay!payCallBack.action';
	/*
	param.detail = '<![CDATA[' + JSON.stringify({
		goods_detail :[{
			goods_id : 'voge_product_voge',		// String 必填 32 商品的编号
			//wxpay_goods_id : '',				// String 可选 32 微信支付定义的统一商品编号
			goods_name :'捷报',					// String 必填 256 商品名称
			goods_num  : 1,						// Int 必填 商品数量
			price : 1, 							// Int 必填 商品单价，单位为分
			//goods_category : '',				// String 可选 32 商品类目ID
			//body :'' 							// String 可选 1000 商品描述信息
		}]
		 
	}) + ']]>';  // 选填  商品详情
	*/
	// param.attach = '分店'; //选填 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	return param;
}

var payResult = '';
function thePublicPay(){
	var param = getParam();
	if ($.query.keys && $.query.keys.openid) {
		param.openid = $.query.keys.openid
	}else{
		window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2cee035d0fd25149&redirect_uri=http%3a%2f%2fwww.gebile.com%2fecidm%2fpages%2fopenid_back.jsp%3fbackUrl%3dhttp%3a%2f%2fwww.voge.com.cn%2fgate%2fpages%2fpayPage.html&response_type=code&scope=snsapi_base&state=#wechat_redirect';
	}
	if(param){
		$.ajax({
			url :'/gate/pay!apiPay.action', 
			data:param,
			dataType : 'json', 
			type : 'post',
			success : function(result) {
				payResult = result;
				if (typeof WeixinJSBridge == "undefined"){
				   if( document.addEventListener ){
				       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
				   }else if (document.attachEvent){
				       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
				       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
				   }
				}else{
				   onBridgeReady();
				}
			}
		});
	}
}

function qrcodePay(callback) {
	var param = getParam();
	if (param) {
		$.ajax({
			url : '/gzvm/pay!qrCodePay.action',
			data : param,
			dataType : 'json',
			type : 'post',
			success : function(result) {
				console.log(result);
				callback && callback(result);

			}
		});
	}
}

function onBridgeReady() {
	var timeStamp = Date.parse( new Date() ).toString();
	timeStamp = timeStamp.substr(0,10);
	var param = {
		"appId" : payResult.appid, // 公众号名称，由商户传入
		"timeStamp" : timeStamp, // 时间戳，自1970年以来的秒数
		"nonceStr" : randomString(32), // 随机串
		"package" : "prepay_id=" + payResult.prepay_id,
		"signType" : "MD5", // 微信签名方式
	};
	param.paySign = createSign(param);
	WeixinJSBridge.invoke('getBrandWCPayRequest', param, function(res) {
		if (res.err_msg == "get_brand_wcpay_request：ok") {
			alert(true);
		} // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回 ok，但并不保证它绝对可靠。
	});
}
	
function WeiXinPay(callback) {
	var ua = window.navigator.userAgent.toLowerCase();
	//是不是微信浏览器
	if (ua.match(/MicroMessenger/i) == 'micromessenger') {
		thePublicPay();
	} else {
		qrcodePay(callback);
	}
}
