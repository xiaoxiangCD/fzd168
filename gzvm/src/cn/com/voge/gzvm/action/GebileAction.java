package cn.com.voge.gzvm.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.codehaus.plexus.util.StringUtils;

import com.google.gxp.com.google.common.collect.Maps;
import com.opensymphony.xwork2.Preparable;
import com.voyageci.tools.utils.NumberUtils;
import com.voyageci.tools.utils.ServletUtils;
import com.voyageci.tools.utils.WebUtils;

import ChartDirector.BaseChart;
import ChartDirector.Chart;
import cn.com.voge.base.action.MobileBaseAction;
import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.AdminToken;
import cn.com.voge.gzvm.beans.Attachment;
import cn.com.voge.gzvm.beans.User;
import cn.com.voge.gzvm.beans.UserToken;
import cn.com.voge.gzvm.beans.VMAdmin;
import cn.com.voge.gzvm.chart.GebileChart;
import cn.com.voge.gzvm.security.AdminSession;
import cn.com.voge.gzvm.security.UserSession;
import cn.com.voge.gzvm.service.AdminService;
import cn.com.voge.gzvm.service.AttachmentService;
import cn.com.voge.gzvm.service.UserService;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class GebileAction extends MobileBaseAction implements Preparable {

	private static final long serialVersionUID = -7451554701857640901L;
	protected AttachmentService attachmentService;
	protected AdminService adminService;
	protected UserService userService;
	protected Integer attachId;
	protected Integer adminId;
	protected String adminCode;
	protected String password;
	protected String token;
	protected Integer userId;
	protected Integer state;
	protected Integer start;
	protected Integer pageSize;
	protected String searchLike;
	
	@Override
	public void prepare() throws Exception {

	}
	
	/** 获取手机token
	 * @author lianzw
	 * @param isJson
	 * @return
	 */
	public AdminToken getTokens(){
		AdminToken adminToken = adminService.getAdminToken(adminId, adminCode, token);
		if (adminToken == null) {
			Map result = getReturnMap("还没登录，请登录后使用！", 0);
			result.put("hasLogined", 0);
			writeJson(getResponse(), result);
		}
		return adminToken;
	}
	
	/** 获取手机Usertoken
	 * @author xzq
	 * @param isJson
	 * @return
	 */
	public UserToken getUserTokens(){
		UserToken userToken = userService.getUserToken(userId, adminCode, token);
		if (userToken == null) {
			Map result = getReturnMap("还没登录，请登录后使用！", 0);
			result.put("hasLogined", 0);
			writeJson(getResponse(), result);
		}
		return userToken;
	}
	
	/** 保存token
	 * @author lianzw
	 * @param adminId
	 * @param request
	 * @return
	 */
	public AdminToken saveToken(Integer adminId,HttpServletRequest request){
		HttpSession session = request.getSession();
		VMAdmin admin = adminService.getAdmin(adminId);
		AdminToken token = adminService.saveAdminToken(admin, request);
		session.setAttribute("adminToken", token);
		return token;
	}
	
	/** 保存session
	 * @author lianzw
	 * @param adminId
	 * @param request
	 * @return
	 */
	public AdminSession createAdminSession(Integer adminId,HttpServletRequest request){
		request.getSession();
		VMAdmin admin = adminService.getAdmin(adminId);
		AdminSession session = new AdminSession();
		String token = WebUtils.getSessionId(request);
		session.setSessionId(token);
		session.setToken(token);
		session.setAdminId(admin.getAdminId());
		session.setAdminName(admin.getAdminName());
		session.setAdminCode(admin.getAdminCode());
		session.setLoginTime(new Date());
		session.setInstanceId(0);
		securityHandler.setUserData(request, session);
		return session;
	}
	
	/** 保存用户session
	 * @author xzq
	 * @param userId
	 * @param request
	 * @return
	 */
	public UserSession createUserSession(Integer userId,HttpServletRequest request){
		request.getSession();
		Map criteria = Maps.newHashMap();
		criteria.put("userId", userId);
		User user = userService.getUser(criteria);
		UserSession userSession = new UserSession();
		String token = WebUtils.getSessionId(request);
		userSession.setSessionId(token);
		userSession.setToken(token);
		userSession.setUserId(user.getUserId());
		userSession.setUserName(user.getUserName());
		userSession.setIdCard(user.getIdCard());
		userSession.setIdType(user.getIdType());
		userSession.setMobile(user.getMobile());
		userSession.setAge(user.getAge());
		userSession.setSex(user.getSex());
		userSession.setStature(user.getStature());
		userSession.setWeight(user.getWeight());
		securityHandler.setUserData(request, userSession);
		return userSession;
	}
	
	/** 获取session
	 * @author lianzw
	 * @param request
	 * @return
	 */
	public AdminSession getAdminSession(boolean isJson){
		AdminSession tokens = (AdminSession) securityHandler.getUserData(request);
		if (tokens == null && isJson) {
			Map result = getReturnMap("还没登录，请登录后使用！", 0);
			result.put("hasLogined", 0);
			writeJson(getResponse(), result);
		}
		return tokens;
	}	
	
	/** 获取用户session
	 * @author xzq
	 * @param request
	 * @return
	 */
	public UserSession getUserSession(boolean isJson){
		UserSession tokens = (UserSession) securityHandler.getUserData(request);
		if (tokens == null && isJson) {
			Map result = getReturnMap("还没登录，请登录后使用！", 0);
			result.put("hasLogined", 0);
			writeJson(getResponse(), result);
		}
		return tokens;
	}
	
	/** 保存Usertoken
	 * @author lianzw
	 * @param adminId
	 * @param request
	 * @return
	 */
	public UserToken saveUserToken(Integer userId,HttpServletRequest request){
		HttpSession session = request.getSession();
		UserToken token = userService.saveUserToken(userId, request);
		session.setAttribute("userToken", token);
		return token;
	}
	
	/**
	 * 获取web登录信息
	 * @author lianzw
	 * @return
	 */
	public AdminToken getWebToken(boolean isJson) {
		HttpSession tokens = getRequest().getSession(false);
		if (tokens == null && isJson) {
			Map result = getReturnMap("还没登录，请登录后使用！", 0);
			result.put("hasLogined", 0);
			writeJson(getResponse(), result);
			return null;
		}else if (tokens == null){
			return null;
		}
		return (AdminToken) tokens.getAttribute("adminToken");
	}
	
	/**
	 * 获取webUser登录信息
	 * @author xzq
	 * @return
	 */
	public UserToken getWebUserToken(boolean isJson) {
		HttpSession tokens = getRequest().getSession(false);
		if (tokens == null && isJson) {
			Map result = getReturnMap("还没登录，请登录后使用！", 0);
			result.put("hasLogined", 0);
			writeJson(getResponse(), result);
			return null;
		}else if (tokens == null){
			return null;
		}
		return (UserToken) tokens.getAttribute("userToken");
	}
	
	public void writeImage(BaseChart chart) throws IOException{
		OutputStream out =response.getOutputStream();
		try {
			response.setContentType("image/png");
			GebileChart.writeChart(out, chart, Chart.PNG);

			response.setStatus(HttpServletResponse.SC_OK);
			response.flushBuffer();
		} catch (Exception ex) {
			//log.info("chart generator error.", ex);
		} finally {
			IOUtils.closeQuietly(out);
		}
	}

	public void download(){
		Attachment attach = attachmentService.getAttachmentDao().get(attachId);
		String fileName = attach.getAttachName();
		String mimeType = WebUtils.getContentTypeByFile(fileName);
		String path = attachmentService.getSavePath(attach);
		if(path == null){
			path = attach.getAttachPath();
		}
		fileName =(path+"/"+fileName);
		
		ServletUtils.sendFile(getRequest(), getResponse(), false,fileName,attach.getAttachName(),mimeType);
		//SessionData sessionData = getSessionData();
		//log.info("用户ID为："+sessionData.getUserCode() +"用户名称为："+sessionData.getUserName()+DateUtils.datetimeToStr(new Date())+" 下载了附件：" + attach.getAttachName());
		
	}
	
	public void showAttachPic(String fileName){
		attachmentService.showPic(fileName, getResponse(), getRequest());
	}
	
	public void showAttachPic(Integer attachId){
		Attachment attach = attachmentService.getAttachmentDao().get(attachId);
		String fileName = attach.getAttachName();
		String path = attachmentService.getSavePath(attach);
		fileName =(path+"/"+fileName);
		boolean hasPic = attachmentService.showPic(fileName, getResponse(), getRequest());
		if(!hasPic){
			/*int intOwnerType = attach.getOwnerType().intValue();
			if(intOwnerType == Constant.TYPE_CHANNEL){
				hasPic = attachmentService.showPic(attachmentService.getAttachDir()+"/gebile/channel/channel.png", response,request);
			}else if(intOwnerType == Constant.TYPE_STAFF){
				hasPic = attachmentService.showPic(attachmentService.getAttachDir()+"/gebile/staff/user.png", response,request);
			}else if(intOwnerType == Constant.TYPE_COURSE){
				hasPic = attachmentService.showPic(attachmentService.getAttachDir()+"/gebile/course/course.png", response,request);
			}else if(intOwnerType == Constant.TYPE_SCHEME){
				hasPic = attachmentService.showPic(attachmentService.getAttachDir()+"/gebile/scheme/scheme.png", response,request);
			}*/
		}
	}
	
	public void showPic(Integer attachId,String type){
		Attachment attach = attachmentService.getAttachmentDao().get(attachId);
		if(attach == null){
			return ;
		}
		String fileName = attach.getAttachName();
		//String mimeType = WebUtils.getContentTypeByFile(fileName);
		//response.setHeader("Content-Type", mimeType);
		response.setContentType("image/jpg");
		String path = attachmentService.getSavePath(attach);
		if(type!=null) {
			type = type.toLowerCase();
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			if(type.equals("s")){
				fileName +="s."+attach.getAttachExt();
			}else if(type.equals("l")){
				fileName +=(type +"."+attach.getAttachExt());
			}else{
				fileName = attach.getAttachName();
			}
		}
		fileName =(path+"/"+fileName);
		attachmentService.showPic(fileName, getResponse(), getRequest());
	}
	
	public boolean showPic(Integer ownerType,Integer ownerId,String type,HttpServletResponse response,HttpServletRequest request){
		//先判断ownerId是否为空或0
		boolean  hasPic = true;
		if((ownerId == null)|| (ownerId <1)){
			hasPic = false;
		}else{
			String path = attachmentService.getSavePath(ownerType, ownerId);
			hasPic = attachmentService.showPic((path+"/"+ownerId+type+"."+Constant.IMAGE_EXT_JPG), response,request);
		}
		
		if(!hasPic){
			/*int intOwnerType = ownerType.intValue();
			if(intOwnerType == Constant.TYPE_CHANNEL){
				hasPic = attachmentService.showPic(attachmentService.getAttachDir()+"/gebile/channel/channel.png", response,request);
			}else if(intOwnerType == Constant.TYPE_STAFF){
				hasPic = attachmentService.showPic(attachmentService.getAttachDir()+"/gebile/staff/user.png", response,request);
			}else if(intOwnerType == Constant.TYPE_COURSE){
				hasPic = attachmentService.showPic(attachmentService.getAttachDir()+"/gebile/course/course.png", response,request);
			}else if(intOwnerType == Constant.TYPE_SCHEME){
				hasPic = attachmentService.showPic(attachmentService.getAttachDir()+"/gebile/scheme/scheme.png", response,request);
			}*/
		}
		
		return hasPic;
	} 
	
	/**保存管理员日志
	 * @author lianzw
	 * @param module 调用类
	 * @param method 调用方法
	 * @param describe 说明
	 * @return
	 */
	public Map saveAdminLog(AdminToken token,String module, String method, String describe,Map result){
		return adminService.saveAdminLog(token.getAdminId(), module, method, "编码为"+token.getAdminCode()+"的管理员，调用了"+describe,result);
	}
	
	/** 接口统一回调
	 * @author lianzw
	 * @param session
	 * @param result
	 * @param message
	 */
	public void callback(AdminSession session, Map result,String module,String method, String message){
		if (result == null) {
			result = getReturnMap(message+"失败", Constant.RESULT_CODE_ERROR);
		}else if (!result.containsKey("resultMsg")) {
			result.putAll(getReturnMap(message+"成功", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(session, module, method, message, result);
		writeJson(response, result);
	}
	
	public void callback( Map result, String message){
		if (result == null) {
			result = getReturnMap(message+"失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap(message+"成功", Constant.RESULT_CODE_SUCCESS));
		}
		writeJson(response, result);
	}
	
	public Map saveAdminLog(AdminSession session,String module, String method, String describe,Map result){
		return adminService.saveAdminLog(session.getAdminId(), module, method, "编码为"+session.getAdminCode()+"的管理员，调用了"+describe+"接口。",result);
	}
	
	public String getSavePath(Integer instanceId,Integer ownerType,Integer ownerId,String extFolder){
		return attachmentService.getSavePath(instanceId,ownerType, ownerId, extFolder);
	}
	
	public static String getIp2(HttpServletRequest request) {
		System.out.println(request.getHeader("X-Real-IP"));
		System.out.println(request.getHeader("X-Forwarded-For"));
		String ip = request.getHeader("X-Forwarded-For");
		if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
			//多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
		    if(index != -1){
		        return ip.substring(0,index);
		    }else{
		          return ip;
		    }
	  }
	  ip = request.getHeader("X-Real-IP");
	  if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
	      return ip;
	  }
	  return request.getRemoteAddr();
	}
	
	public List stringToArr(String strArr,String regex,boolean isId){
		List arr = new ArrayList<>();
		if (strArr != null) {
			int length = strArr.length();
			if (strArr.substring(0, 1).equals("[")) {
				strArr = strArr.substring(1, length - 1);
			}
			String[] strs = strArr.split(regex == null ? "," : regex);
			for (int i = 0; i < strs.length; i++) {
				if (isId) {
					Integer id = NumberUtils.toInt(strs[i]);
					arr.add(id);
				}else{
					arr.add(strs[i]);
				}
			}
		}
		return arr;
	}
	
	public AttachmentService getAttachmentService() {
		return attachmentService;
	}

	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Integer getAttachId() {
		return attachId;
	}

	public void setAttachId(Integer attachId) {
		this.attachId = attachId;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchLike() {
		return searchLike;
	}

	public void setSearchLike(String searchLike) {
		this.searchLike = searchLike;
	}
	
}
