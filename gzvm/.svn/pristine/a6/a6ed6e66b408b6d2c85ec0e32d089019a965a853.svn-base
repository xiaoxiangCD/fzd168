package cn.com.voge.gzvm.action;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import cn.com.voge.base.action.BaseAction;
import cn.com.voge.gzvm.CommonUtil;
import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.service.WXService;

import com.opensymphony.xwork2.Preparable;


@SuppressWarnings({ "rawtypes", "unchecked" })
public class WXPayAction extends BaseAction implements Preparable  {

	private static final long serialVersionUID = 7192665683402077826L;
	
	private String spbill_create_ip;  // ip地址
	private String body;  // 商品简介
	private String orderName;  // 商品名称
	private Integer total_fee;//订单金额
	private String notify_url;
	private WXService wxService;
	private String openid;
	
	
	@Override
	public void prepare() throws Exception {
		
	}
	
	public void apiPay(){
		unifiedOrderPay(createPayInfo("JSAPI"));
	}
	
	public void qrCodePay(){
		unifiedOrderPay(createPayInfo("NATIVE"));
	}
	
	public void unifiedOrderPay(Map payMap){
//		HttpServletRequest request = getRequest();
		if (payMap == null) {
			writeJson(getResponse(), getReturnMap("调起支付失败", 0));
			return;
		}
		String payInfo = CommonUtil.getXmlWithMap(payMap);
		Map result = wxService.unifiedOrderPay(payInfo);
		System.out.println(result);
		if(result!=null){
			// 得到请求消息的数据输入流
			if(result.get("return_code").equals(Constant.WX_SUCCESS_CODE)){
				if(result.get("result_code").equals(Constant.WX_SUCCESS_CODE)){
//					String codeUrl = (String) result.get("code_url");
					writeJson(getResponse(),result);
				}else{
					/*
					*名称	描述	原因	解决方案
					*NOAUTH	商户无此接口权限	商户未开通此接口权限	请商户前往申请此接口权限
					*NOTENOUGH	余额不足	用户帐号余额不足	用户帐号余额不足，请用户充值或更换支付卡后再支付
					*ORDERPAID	商户订单已支付	商户订单已支付，无需重复操作	商户订单已支付，无需更多操作
					*ORDERCLOSED	订单已关闭	当前订单已关闭，无法支付	当前订单已关闭，请重新下单
					*SYSTEMERROR	系统错误	系统超时	系统异常，请用相同参数重新调用
					*APPID_NOT_EXIST	APPID不存在	参数中缺少APPID	请检查APPID是否正确
					*MCHID_NOT_EXIST	MCHID不存在	参数中缺少MCHID	请检查MCHID是否正确
					*APPID_MCHID_NOT_MATCH	appid和mch_id不匹配	appid和mch_id不匹配	请确认appid和mch_id是否匹配
					*LACK_PARAMS	缺少参数	缺少必要的请求参数	请检查参数是否齐全
					*OUT_TRADE_NO_USED	商户订单号重复	同一笔交易不能多次提交	请核实商户订单号是否重复提交
					*SIGNERROR	签名错误	参数签名结果不正确	请检查签名参数和方法是否都符合签名算法要求
					*XML_FORMAT_ERROR	XML格式错误	XML格式错误	请检查XML参数格式是否正确
					*REQUIRE_POST_METHOD	请使用post方法	未使用post传递参数 	请检查请求参数是否通过post方法提交
					*POST_DATA_EMPTY	post数据为空	post数据不能为空	请检查post数据是否为空
					*NOT_UTF8	编码格式错误	未使用指定编码格式	请使用NOT_UTF8编码格式
					*/
					System.out.println("----微信下单回调err_code="+result.get("err_code")+"err_code_des="+result.get("err_code_des"));
				}
			}else{
				System.out.println("----微信下单回调失败原因："+ result.get("return_msg"));
			}
		}else{
			writeJson(getResponse(), getReturnMap("获取失败", 0));
		}
	}
	
	/**
	 * 创建统一下单的xml的java对象
	 * @param bizOrder  系统中的业务单号
	 * @param ip  用户的ip地址
	 * @param openId 用户的openId
	 * @return
	 * @throws Exception 
	 */
	public Map createPayInfo(String type){
		SortedMap map = new TreeMap();
		map.put("trade_type", type);//支付方式 JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付  
		if (type.equals("JSAPI") && openid != null) {
			map.put("openid", openid);
		}else if (type.equals("JSAPI")){
			System.err.println("createPayInfo() errorMsg: openid不能为空");
			return null;
		}
		map.put("appid", Constant.WX_APP_ID);//appid
		map.put("device_info", "WEB");//选填 设备号
		map.put("mch_id", Constant.WX_MCH_ID);//商户号
		map.put("nonce_str", CommonUtil.create_nonce_str(32));//随机字符串
		map.put("body", "voge产品-产品1");//产品简介  线上电商，商家名称必须为实际销售商品的商家   格式为： 商家名称-销售商品类目
		map.put("out_trade_no", orderName+Math.round(System.currentTimeMillis()/1000) + CommonUtil.create_nonce_str(8));//商户订单号
		map.put("total_fee", total_fee);//总金额
		map.put("spbill_create_ip", spbill_create_ip);//ip地址
		map.put("notify_url", "http://www.voge.com.cn"+request.getContextPath()+notify_url);//回调URL
		map.put("sign", CommonUtil.createSign("UTF-8",map,Constant.WX_APP_KEY));//签名
		System.err.println("PayInfo == "+map);
		return map;
	}
	
	public void payCallBack(){
		HttpServletRequest request = getRequest();
		try {
			String xmlStr = CommonUtil.parseInputStream(request.getInputStream());
			Map result = CommonUtil.parseXML(xmlStr);
			// 得到请求消息的数据输入流
			if(result.get("return_code").equals(Constant.WX_SUCCESS_CODE)){
				if(result.get("result_code").equals(Constant.WX_SUCCESS_CODE)){
					System.out.println("----openid为"+result.get("openid")+"的用户扫码支付成功。"
							+"\n金额为："+result.get("total_fee")+"分");
				}else{
					System.out.println("----扫码支付回调err_code="+result.get("err_code")+"err_code_des="+result.get("err_code_des"));
				}
			}else{
				System.out.println("----扫码支付回调失败原因："+ result.get("return_msg"));
			}
		} catch (KeyManagementException | NoSuchAlgorithmException
				| NoSuchProviderException | IOException e) {
			System.out.println(e.getMessage());
		}
		
		Map map = new HashMap();
		map.put("return_code", "SUCCESS");
		writeJson(getResponse(), CommonUtil.getXmlWithMap(map));
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public WXService getWxService() {
		return wxService;
	}

	public void setWxService(WXService wxService) {
		this.wxService = wxService;
	}
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}


}
