package cn.com.voge.gzvm.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.lucene.queryparser.flexible.core.util.StringUtils;

import com.voyageci.tools.utils.GeneralUtils;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.AdminToken;
import cn.com.voge.gzvm.beans.VMAdmin;
import cn.com.voge.gzvm.template.beans.ItemContentPhoto;

/** 
 * @author lianzw 
 * @version 创建时间：2017年5月4日 上午11:16:52 
 * 类说明 
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class AdminService extends GzvmService{
	
	/** 管理员账号认证
	 * @author lianzw
	 * @param adminCode
	 * @param password
	 * @return
	 */
	public Map authenticate(String adminCode, String password){
		Map criteria = initCriteria();
		criteria.put("loginCode", adminCode);// 手机号或者管理员编码
		VMAdmin admin = getAdmin(criteria);
		if (admin == null) {
			return getReturnMap("登录失败,账号不存在.", Constant.RESULT_CODE_ERROR);
		}
		String dbPwd = admin.getPassword();
		String pw = GeneralUtils.MD5(password);
		if (dbPwd.equals(pw)){
			Map result =  adminManager.getRecordDetail(admin);
			result.remove("password");
			result.putAll(getReturnMap("登录成功", Constant.RESULT_CODE_SUCCESS));
			return result;
		} 
		return getReturnMap("登录失败,账号或密码错误.", Constant.RESULT_CODE_ERROR);
	}
	
	public VMAdmin getAdmin(Integer adminId){
		return adminManager.get(adminId);
	}
	
	public VMAdmin getAdmin(Map criteria){
		return adminManager.getAdmin(criteria);
	}

	public Map getAdmins(Map criteria,Integer start, Integer pageSize){
		criteria = initCriteria(criteria);
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return adminManager.getAdmins(criteria, start, pageSize);
	}
	
	public Map getAdminRoles(Map criteria,Integer start, Integer pageSize){
		criteria = initCriteria(criteria);
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return adminManager.getAdminRoles(criteria, start, pageSize);
	}
	
	public Map getModule(Map criteria,Integer start, Integer pageSize){
		criteria = initCriteria(criteria);
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return moduleManager.getModule(criteria, start, pageSize);
	}
	
	public Map getAdminRelaRoles(Integer adminId,Integer start, Integer pageSize){
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return adminManager.getAdminRelaRoles(adminId, start, pageSize);
	}
	
	public Map getOperModule(Integer operId,Integer start, Integer pageSize){
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return moduleManager.getOperModule(operId, start, pageSize);
	}
	
	public Map getModuleItem(Integer moduleId,Integer start, Integer pageSize){
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return moduleManager.getModuleItem(moduleId, start, pageSize);
	}
	
	public Map getItemContents(Integer itemId,Integer state,Integer start, Integer pageSize){
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return moduleManager.getItemContent(itemId, state, start, pageSize);
	}
	
	public Map saveAdmin(Map values){
		return adminManager.saveAdmin(values);
	}
	
	public Map saveAdminRole(Map values){
		return adminManager.saveAdminRole(values);
	}
	
	public Map saveAdminRelaRole(Map values){
		return adminManager.saveAdminRelaRole(values);
	}
	
	public Map saveModule(Map values){
		return moduleManager.saveModule(values);
	}
	
	public Map saveModuleItem(Map values){
		return moduleManager.saveModuleItem(values);
	}
	
	public Map saveItemContent(Map values){
		return moduleManager.saveItemContent(values);
	}
	
	public Map saveOperModule(Map values){
		return moduleManager.saveOperModule(values);
	}
	
	public Map savePassword(Integer adminId,String oldPassword,String password){
		return adminManager.savePassword(adminId, oldPassword, password);
	}
	
	public Map deleteAdmin(Integer adminId){
		return adminManager.deleteAdmin(adminId);
	}
	
	public Map delAdminRole(Integer roleId){
		return adminManager.delAdminRole(roleId);
	}
	
	public Map delAdminRelaRole(Integer relaId){
		return adminManager.delAdminRelaRole(relaId);
	}
	
	public Map delModule(Integer moduleId){
		return moduleManager.delModule(moduleId);
	}
	
	public Map delOperModule(Integer operId){
		return moduleManager.delOperModule(operId);
	}
	
	public Map delItemContent(Integer contentId){
		Map map = moduleManager.delItemContent(contentId);
		if (map.containsKey("photoIds")) {
			List<Integer> photoIds = (List<Integer>) map.get("photoIds");
			attachmentService.deleteLSImages(Constant.TYPE_MODULE_ITEM_CONTENT, contentId, photoIds,Constant.IMAGE_EXT_JPG);
			map.remove("photoIds");
 		}
		return map;
	}
	
	public Map delModuleItem(Integer itemId){
		return moduleManager.delModuleItem(itemId);
	}
	
	public Map getItemContent(Integer contentId) {
		return moduleManager.getItemContent(contentId);
	}
	
	public boolean saveItemContentPhoto(Integer photoId, Integer contentId, Integer photoType, String fileName, String remark,File file){
		ItemContentPhoto photo = null;
		try {
			photo = moduleManager.saveItemContentPhoto(photoId, contentId, photoType, fileName, remark);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (photo!=null) {
			String savePath = attachmentService.getSavePath(Constant.TYPE_MODULE_ITEM_CONTENT, contentId);
			String savePicName = StringUtils.toString(photo.getPhotoId())+"l."+Constant.IMAGE_EXT_JPG;
			attachmentService.saveFile(file, savePath, savePicName);
			attachmentService.compressImage(file, 0, savePath, StringUtils.toString(photo.getPhotoId()), "s", Constant.IMAGE_EXT_JPG);
			return true;
		}
		return false;
	}
	
	public String getItemPhotoPath(Integer photoId){
		ItemContentPhoto photo = moduleManager.getItemContentPhoto(photoId);
		String path = attachmentService.getSavePath(Constant.TYPE_MODULE_ITEM_CONTENT,photo.getContentId());
		return path;
	}
	
	public Map getAdminLogs(Map criteria,Integer start, Integer pageSize){
		criteria = initCriteria(criteria);
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return adminManager.getAdminLogs(criteria, start, pageSize);
	}
	
	public Map saveAdminLog(Integer adminId, String module, String method, String describe, Map result){
		if (adminId <= 0) {
			return null;
		}
		Integer logState = getIntValue(result, "resultCode");
		String errMsg = getStringValue(result, "resultMsg");
		return adminManager.saveAdminLog(adminId, module, method, describe,logState,errMsg);
	}
	
	
	public AdminToken getAdminToken(Integer adminId,String adminCode,String token){
		Map criteria = initCriteria();
		if (adminId != null && adminId > 0) {
			criteria.put("adminId", adminId);
		}else if (adminCode!=null && adminCode.length() > 0) {
			criteria.put("adminCode", adminCode);
		}else{
			return null;
		}
		criteria.put("token", token);
		return adminManager.getAdminToken(criteria);
	}
	
	
	public AdminToken saveAdminToken(VMAdmin admin,HttpServletRequest request){
		return adminManager.saveAdminToken(admin, request);
	}

//	public static void main(String[] strings) {
//		AdminService as = new AdminService();
//		as.getAdminLogs(null, null, null);
//		
//	}
	
}
