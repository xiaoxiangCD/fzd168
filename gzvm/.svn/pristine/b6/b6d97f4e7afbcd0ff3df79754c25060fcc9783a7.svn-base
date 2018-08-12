package cn.com.voge.gzvm.action;

import java.util.Map;

import cn.com.voge.base.action.BaseAction;
import cn.com.voge.gzvm.service.WXService;

import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("rawtypes")
public class WXAction extends BaseAction implements Preparable  {

	private static final long serialVersionUID = -6797571666021264495L;
	private WXService wxService;
	
	public void getAccessToken(){
		Map map = wxService.getAccessToken();
		writeJson(getResponse(), map);
	}
	
	public void getJsapiTicket(){
		Map map = wxService.getJsapiTicket();
		writeJson(getResponse(), map);
	}

	@Override
	public void prepare() throws Exception {
		
	}
	
	public WXService getWxService() {
		return wxService;
	}

	public void setWxService(WXService wxService) {
		this.wxService = wxService;
	}
	
}
