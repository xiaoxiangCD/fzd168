package cn.com.voge.gzvm.service;

import java.util.Date;
import java.util.Map;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.WXApiToken;
import cn.com.voge.gzvm.manager.OrderManager;
import cn.com.voge.gzvm.manager.WXApiManager;

import com.voyageci.tools.utils.DateUtils;

@SuppressWarnings({"rawtypes"})
public class WXService  extends HttpService {

	private String wxAppId = "wxe1f1a5472102dd15";
	private String wxAppSecret = "770d06efba3a2e1c863abd0764dd82d0";
	
	private WXApiManager wxApiManager;
	private OrderManager orderManager;
	
	public Map updateAccessToken(){
		String url = Constant.WX_ACCESS_TOKEN_URL + "appid="+wxAppId+"&secret="+wxAppSecret;
		Map value = HttpService.httpsRequestToJSON(url, "GET", null);
		String token = getStringValue(value, "access_token");
		Integer exires = getIntValue(value, "expires_in");
		Map result = wxApiManager.updateToken(token, Constant.WX_TOKEN_TYPE_API_TOKEN,exires);
		if(result == null){
			return value;
		}
		return result;
	}
	
	public Map updateJsapiTicket(){
		Map token = getAccessToken();
		String url = Constant.WX_JSAPI_TICKET_URL + getStringValue(token, "token");
		Map value = HttpService.httpsRequestToJSON(url, "GET", null);
		if(value.containsKey("errcode")){
			token = updateAccessToken();
			url = Constant.WX_JSAPI_TICKET_URL + getStringValue(token, "token");
			value = HttpService.httpsRequestToJSON(url, "GET", null);
		}
		String ticket = getStringValue(value, "ticket");
		Integer exires = getIntValue(value, "expires_in");
		Map result = wxApiManager.updateToken(ticket, Constant.WX_TOKEN_TYPE_JSAPI_TICKET,exires);
		if(result == null){
			return value;
		}
		return result;
	}

	public Map getAccessToken(){
		Map token = getToken(Constant.WX_TOKEN_TYPE_API_TOKEN);
		if(token== null){
			token =	updateAccessToken();
		}
		return token;
	}
	
	public Map getJsapiTicket(){
		Map token = getToken(Constant.WX_TOKEN_TYPE_JSAPI_TICKET);
		if(token== null){
			token =	updateJsapiTicket();
		}
		return token;
	}
	
	public Map getToken(String tokenType){
		WXApiToken token = wxApiManager.getToken(tokenType);
		if(token == null || DateUtils.after(token.getExpiresTime(), new Date())){
			return null;
		}
		return wxApiManager.getRecordDetail(token);
	}
	
	public Map getProducts(int instanceId, Map param,Integer start, Integer pageSize){
		return orderManager.getProducts(instanceId, param, start, pageSize);
	}
	
	public Map getOrders(int instanceId, Map param,Integer start, Integer pageSize){
		return orderManager.getOrders(instanceId, param, start, pageSize);
	}
	
	public Map getOrder(int instanceId, Integer orderId,Map criteria){
		return orderManager.getOrder(instanceId, orderId, criteria);
	}
	
	public Map saveOrder(int intanceId,Map values) {
		return orderManager.saveOrder(intanceId, values);
	}
	
	public Map unifiedOrderPay(String payInfo){
		return httpsRequestToXML(Constant.WX_UNIFIED_ORDER_URL, "POST",payInfo);
	}
	
	public String getWxAppId() {
		return wxAppId;
	}
	public void setWxAppId(String wxAppId) {
		this.wxAppId = wxAppId;
	}
	public String getWxAppSecret() {
		return wxAppSecret;
	}
	public void setWxAppSecret(String wxAppSecret) {
		this.wxAppSecret = wxAppSecret;
	}
	public WXApiManager getWxApiManager() {
		return wxApiManager;
	}
	public void setWxApiManager(WXApiManager wxApiManager) {
		this.wxApiManager = wxApiManager;
	}
	
}
