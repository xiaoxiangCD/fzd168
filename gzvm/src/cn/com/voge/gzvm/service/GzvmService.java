package cn.com.voge.gzvm.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import cn.com.voge.gzvm.dao.AttachmentDao;
import cn.com.voge.gzvm.service.AttachmentService;
import cn.com.voge.gzvm.template.manager.ModuleManager;
import cn.com.voge.gzvm.CommonUtil;
import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.manager.AdminManager;
import cn.com.voge.gzvm.manager.UserManager;

import com.google.gxp.com.google.common.collect.Maps;
import com.voyageci.core.service.BaseService;
import com.voyageci.tools.json.JSON;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月4日 上午11:23:29 
 * 类说明 预留的公共类，写公用方法
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class GzvmService  extends BaseService{
	
	protected AdminManager adminManager;
	protected ModuleManager moduleManager;
	protected UserManager userManager;
	protected AttachmentDao attachmentDao;
	protected AttachmentService attachmentService;
	
	/** 初始化查询参数
	 * @author lianzw
	 * @param criteria
	 */
	public Map initCriteria(Map criteria){
		if (criteria == null) {
			criteria = Maps.newHashMap();
			criteria.put("state", Constant.BASE_STATE);
		}else{
			if (!criteria.containsKey("state")) { 
				criteria.put("state", Constant.BASE_STATE);
			}
		}
		return criteria;
	}
	
	/**
	 * @author lianzw
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 */
	public static Map httpsRequestToXML(String requestUrl, String requestMethod, String outputStr) {
		Map result = null;
		try {
			String str = httpsRequest(requestUrl, requestMethod, outputStr);
			result = CommonUtil.parseXML(str);
		} catch (ConnectException ce) {
			System.out.println("连接超时：" + ce.getMessage());
		} catch (Exception e) {
			System.out.println("https请求异常：" + e.getMessage());
		}
		return result;
	}

	public static Map httpsRequestToJSON(String requestUrl, String requestMethod, String outputStr) {
		Map result = null;
		try {
			String str = httpsRequest(requestUrl, requestMethod, outputStr);
			result = JSON.parseToMap(str);
		} catch (ConnectException ce) {
			System.out.println("连接超时：" + ce.getMessage());
		} catch (Exception e) {
			System.out.println("https请求异常：" + e.getMessage());
		}
		return result;
	}

	public static String httpsRequest(String requestUrl, String requestMethod, String output)
			throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, MalformedURLException,
			IOException, ProtocolException, UnsupportedEncodingException {
		URL url = new URL(requestUrl);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
//		connection.setRequestProperty(key, value);
		connection.setRequestMethod(requestMethod);
		if (null != output) {
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(output.getBytes("UTF-8"));
			outputStream.close();
		}
		// 从输入流读取返回内容
		InputStream inputStream = connection.getInputStream();
		String map = CommonUtil.parseInputStream(inputStream);
		connection.disconnect();
		return map;
	}
	
	public Map initCriteria(){
		Map criteria = Maps.newHashMap();
		return initCriteria(criteria);
	}
	
	public AdminManager getAdminManager() {
		return adminManager;
	}

	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public ModuleManager getModuleManager() {
		return moduleManager;
	}

	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}

	public AttachmentDao getAttachmentDao() {
		return attachmentDao;
	}

	public void setAttachmentDao(AttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}

	public AttachmentService getAttachmentService() {
		return attachmentService;
	}

	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	
}
