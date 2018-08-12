package cn.com.voge.gzvm.action;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.security.AdminSession;

import com.google.common.collect.Maps;
import com.voyageci.core.security.SessionData;
import com.voyageci.tools.utils.GeneralUtils;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月4日 下午3:29:22 
 * 类说明 
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class AdminAction extends GebileAction{

	private static final long serialVersionUID = 6031581639462035004L;
	private String adminName;
	private String adminType;
	private String mobile;
	private String qq;
	private Integer start;
	private Integer pageSize;
	private String roleName;
	private String roleDescribe;
	private Integer roleId;
	private Integer relaId;
	private String moduleName;
	private String moduleCode;
	private String description;
	private Integer dispIndex;
	private Integer moduleId;
	private Integer operId;
	private String roleCode;
	private String oldPassword;
	private Integer itemId;
	private Integer parentId;
	private String itemName;
	private Integer itemType;
	private String itemCode;
	private Integer contentId;
	private String contentTitle;
	private Integer contentType;
	private String content;
	private Date pubTime;
	private Integer photoId;
	private Integer photoType;
	private String fileName;
	private String remark;
	private String type;
	private File file;

	/** 登录接口
	 * @author lianzw
	 */
	public String login(){
		try {
			Map result = adminService.authenticate(adminCode, password);
			if (result.containsKey("adminId")) {
				adminId = (Integer) result.get("adminId");
				AdminSession token = createAdminSession(adminId, request);
				result.put("token", token.getToken());
//				result.put("tokenId", token.getAdminSessionId());
				saveAdminLog(token,"AdminAction", "login", "登录接口。",result);
				request.setAttribute("user", result);
				return "index";
			}
			request.setAttribute("errMsg", result.get("resultMsg"));
			request.setAttribute("adminCode", adminCode);
			request.setAttribute("password", password);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return "login";
//		writeJson(response, result);
	}
	
	/** 管理员登出
	 * @author lianzw
	 * @return
	 */
	public String logout(){
		SessionData sessionData = securityHandler.getUserData(request);
		if (sessionData != null) {
			//userService.logout(sessionData, "用户主动退出");
			securityHandler.logout(request, response);
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "login";
	}
	
	/** 获取管理员
	 * @author lianzw
	 */
	public void getAdmins(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map param = null;
		if (searchLike != null) {
			param = Maps.newHashMap();
			param.put("searchLike", searchLike);
		}
		Map result = null;
		try {
			result = adminService.getAdmins(param, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("获取失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("获取成功!", Constant.RESULT_CODE_SUCCESS));
		}
		writeJson(response, result);
		
	}
	
	/** 保存管理员
	 * @author lianzw
	 */
	public void saveAdmin(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map values = Maps.newHashMap();
		if (adminId != null) {
			values.put("adminId", adminId);
		}
		if(adminType == null){
			adminType = Constant.ADMIN_TYPE_COMMON;
		}
		values.put("adminType", adminType);
		values.put("adminCode", adminCode);
		values.put("adminName", adminName);
		values.put("mobile", mobile);
		values.put("qq", qq);
		values.put("roleId", roleId);
		if (password != null) {
			values.put("password",GeneralUtils.MD5(password));
		}
		Map result = null;
		try {
			result = adminService.saveAdmin(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token, result, "AdminAction", "saveAdmin", "新增/编辑管理员");
	}
	
	/** 修改密码
	 * @author lianzw
	 */
	public void resetPassword(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		if (adminId == null) {
			adminId = token.getAdminId();
		}
		Map result = null;
		try {
			result = adminService.savePassword(adminId, oldPassword, password);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token, result, "AdminAction", "delAdmin", "修改id为"+adminId+"管理员密码");
	}
	
	/** 删除管理员
	 * @author lianzw
	 */
	public void delAdmin(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.deleteAdmin(adminId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token, result, "AdminAction", "delAdmin", "删除管理员");
	}
	
	
	/** 获取角色
	 * @author xzq
	 */
	public void getAdminRoles(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.getAdminRoles(null, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result, "获取角色");
		
	}
	
	/** 增加编辑角色
	 * @author xzq
	 */
	public void saveAdminRole(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map values = Maps.newHashMap();
		if (roleId != null) {
			values.put("roleId", roleId);
		}
		values.put("roleName", roleName);
		values.put("roleCode", roleCode);
		values.put("roleDescribe", roleDescribe);
		Map result = null;
		try {
			result = adminService.saveAdminRole(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token, result,"AdminAction", "saveAdminRole", "新增/编辑角色");
	}
	
	/** 删除角色
	 * @author xzq
	 */
	public void delAdminRole(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.delAdminRole(roleId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token,result,"AdminAction", "delAdminRole", "删除角色");
	}
	
	
	/** 获取管理员角色
	 * @author xzq
	 */
	public void getAdminRelaRoles(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.getAdminRelaRoles(adminId, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result,"获取管理员角色");
		
	}
	
	/** 保存管理员角色
	 * @author xzq
	 */
	public void saveAdminRelaRole(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map values = Maps.newHashMap();
		if(relaId!=null){
			values.put("relaId", relaId);
		}
		values.put("adminId", adminId);
		values.put("roleId", roleId);
		Map result = null;
		try {
			result = adminService.saveAdminRelaRole(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token,result,"AdminAction", "saveAdminRelaRole", "新增保存管理员角色");
	}
	
	/** 删除管理员角色
	 * @author xzq
	 */
	public void delAdminRelaRole(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.delAdminRelaRole(relaId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(token,result,"AdminAction", "delAdminRole", "删除角色");
	}
	
	
	/** 获取系统模块
	 * @author xzq
	 */
	public void getModule(){
		Map result = null;
		try {
			result = adminService.getModule(null, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		callback(result,"获取系统模块");
		
	}
	
	/**保存或者修改系统模块
	 * @author xzq
	 */
	public void saveModule(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map values = Maps.newHashMap();
		if(moduleId!=null){
			values.put("moduleId", moduleId);
		}
//		if(moduleName!=null){
			values.put("moduleName", moduleName);
//		}
//		if(moduleCode!=null){
//			values.put("moduleCode", moduleCode);
//		}
//		if(description!=null){
//			values.put("description", description);
//		}
//		if(dispIndex!=null){
//			values.put("dispIndex", dispIndex);
//		}
		Map result = null;
		try {
			result = adminService.saveModule(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("保存失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("保存成功!", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(token,"AdminAction", "saveModule", "保存系统模块",result);
		writeJson(response, result);
	}
	
	/** 删除系统模块
	 * @author xzq
	 */
	public void delModule(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.delModule(moduleId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("删除失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("删除成功!", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(token,"AdminAction", "delModule", "删除系统模块",result);
		writeJson(response, result);
	}
	
	/** 获取管理员系统模块
	 * @author xzq
	 */
	public void getOperModule(){
		Map result = null;
		try {
			result = adminService.getOperModule(operId, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("获取失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("获取成功!", Constant.RESULT_CODE_SUCCESS));
		}
		writeJson(response, result);
	}
	
	/** 获取系统栏目
	 * @author xzq
	 */
	public void getModuleItem(){
		Map result = null;
		try {
			result = adminService.getModuleItem(moduleId, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("获取失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("获取成功!", Constant.RESULT_CODE_SUCCESS));
		}
		writeJson(response, result);
	}
	
	/** 获取内容详情
	 * @author lianzw
	 */
	public void getItemContent(){
		Map result = null;
		try {
			result = adminService.getItemContent(contentId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("获取失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("获取成功!", Constant.RESULT_CODE_SUCCESS));
		}
		writeJson(response, result);
		
	}
	/** 获取内容列表
	 * @author lianzw
	 */
	public void getItemContents(){
		Map result = null;
		try {
			result = adminService.getItemContents(itemId, state, start, pageSize);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("获取失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("获取成功!", Constant.RESULT_CODE_SUCCESS));
		}
		result.put("picUrl",request.getContextPath()+"/admin!showPic.action?photoId=");
		writeJson(response, result);
	}
	
	/** 保存或者修改管理员系统模块
	 * @author xzq
	 */
	public void saveOperModule(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map values = Maps.newHashMap();
		if(operId!=null){
			values.put("operId", operId);
		}
		values.put("moduleId", moduleId);
		values.put("roleId", roleId);
		Map result = null;
		try {
			result = adminService.saveOperModule(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("保存失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("保存成功!", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(token,"AdminAction", "saveOperModule", "保存管理员系统模块",result);
		writeJson(response, result);
	}
	
	/** 保存或者修改栏目
	 * @author xzq
	 */
	public void saveModuleItem(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map values = Maps.newHashMap();
		if(itemId!=null){
			values.put("itemId", itemId);
		}
		values.put("moduleId", moduleId);
		values.put("parentId", parentId);
		values.put("itemName", itemName);
		values.put("itemType", itemType);
		values.put("itemCode", itemCode);
		values.put("description", description);
		
		Map result = null;
		try {
			result = adminService.saveModuleItem(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("保存失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("保存成功!", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(token,"AdminAction", "saveModuleItem", "保存修改栏目",result);
		writeJson(response, result);
	}
	
	/** 保存或者修改栏目内容
	 * @author xzq
	 */
	public void saveItemContent(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map values = Maps.newHashMap();
		if(contentId!=null){
			values.put("contentId", contentId); 
		}
		values.put("itemId", itemId);
		values.put("contentTitle", contentTitle);
		values.put("contentType", contentType);
		values.put("content", content.replace("&nbsp;"," "));
		values.put("adminId", token.getAdminId());
		values.put("description", description);
		if(state != null){
			values.put("state", state);
			if(state == Constant.BASE_STATE_PUBLISH){
				values.put("pubTime", new Date());
			}
		}
		Map result = null;
		try {
			result = adminService.saveItemContent(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("保存失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("保存成功!", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(token,"AdminAction", "saveItemContent", "保存修改栏目内容",result);
		writeJson(response, result);
	}
	
	/** 删除管理员系统模块
	 * @author xzq
	 */
	public void delOperModule(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.delOperModule(operId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("删除失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("删除成功!", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(token,"AdminAction", "delOperModule", "删除管理员系统模块",result);
		writeJson(response, result);
	}
	
	/** 删除栏目内容
	 * @author xzq
	 */
	public void delItemContent(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.delItemContent(contentId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("删除失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("删除成功!", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(token,"AdminAction", "delItemContent", "删除栏目内容",result);
		writeJson(response, result);
	}
	
	/** 删除栏目
	 * @author xzq
	 */
	public void delModuleItem(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = adminService.delModuleItem(itemId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("删除失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("删除成功!", Constant.RESULT_CODE_SUCCESS));
		}
		saveAdminLog(token,"AdminAction", "delModuleItem", "删除栏目",result);
		writeJson(response, result);
	}
	
	/** 是否登录
	 * @author lianzw
	 */
	public void ping(){
		HttpServletRequest request = getRequest();
		if (!getSecurityHandler().isLogined(request)) {
			writeJson(getResponse(),getReturnMap("没有登录",0));
			return;
		}
		writeJson(getResponse(), getReturnMap("已登录",1));
	}
	
	/** 保存封面图
	 * @author lianzw
	 */
	public void saveItemPhoto(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return ;
		}
		if (photoType == null) {
			photoType = Constant.PHOTO_TYPE_COVER;
		}
		boolean result = adminService.saveItemContentPhoto(photoId, contentId, photoType, fileName, remark, file);
		Map map =null;
		if(result){
			map = getReturnMap("成功", 1);
		}else{
			map = getReturnMap("失败", 0);
		}
		writeJson(response, map);
	}
	
	public void showPic(){
		response.setContentType("image/jpg");
		String stype = type;
		if(stype == null){
			stype = "l";
		}
		
		String fileName = photoId + stype+"."+Constant.IMAGE_EXT_JPG;
		String path = adminService.getItemPhotoPath(photoId);
		if(path != null){
			this.showAttachPic(path+"/"+fileName);
		}
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescribe() {
		return roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRelaId() {
		return relaId;
	}

	public void setRelaId(Integer relaId) {
		this.relaId = relaId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getOperId() {
		return operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getPhotoType() {
		return photoType;
	}

	public void setPhotoType(Integer photoType) {
		this.photoType = photoType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
