package cn.com.voge.gzvm.service;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.queryparser.flexible.core.util.StringUtils;

import com.voyageci.tools.utils.GeneralUtils;

import cn.com.voge.gzvm.Base64Util;
import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.Sms;
import cn.com.voge.gzvm.beans.User;
import cn.com.voge.gzvm.beans.UserPhoto;
import cn.com.voge.gzvm.beans.UserToken;

@SuppressWarnings({"rawtypes","unchecked"})

public class UserService extends GzvmService {
	
	
	/** 用户账号认证
	 * @author lianzw
	 * @param adminCode
	 * @param password
	 * @return
	 */
	public Map authenticate(String Code, String password){
		Map criteria = initCriteria();
		criteria.put("loginCode", Code);// 手机号或者管理员编码
		User user = getUser(criteria);
		if (user == null) {
			return getReturnMap("登录失败，账号不存在。", Constant.RESULT_CODE_ERROR);
		}
		String dbPwd = user.getPassword();
		if (dbPwd.equals(GeneralUtils.MD5(password))){
			return userManager.getRecordDetail(user);
		} 
		return getReturnMap("登录失败，账号或密码错误。", Constant.RESULT_CODE_ERROR);
	}
	
	public User getUser(Map criteria){
		return userManager.getUser(criteria);
	}
	
	
	public Map getUsers(Map criteria,Integer start, Integer pageSize){
		criteria = initCriteria(criteria);
		if((start == null)||(start<0)){
			start = 0;
		}
		if((pageSize == null)||(pageSize<0)){
			pageSize = Constant.ROWS_MAX;
		}
		return userManager.getUsers(criteria, start, pageSize);
	}
	
	public UserPhoto getUserPhoto(Integer userId){
		return userManager.getUserPhoto(userId);
	}
	
	public Map saveUser(Map values){
		return userManager.saveUser(values);
	}
	
	public Map deleteUser(Integer userId){
		return userManager.deleteUser(userId);
	}
	
	public User changePassWord(String mobile, String password){
		return userManager.changePassWord(mobile,password);
	}
	
	public UserToken getUserToken(Integer userId,String userCode,String token){
		Map criteria = initCriteria();
		if (userId != null && userId > 0) {
			criteria.put("userId", userId);
		}else if (userCode!=null && userCode.length() > 0) {
			criteria.put("userCode", userCode);
		}else{
			return null;
		}
		criteria.put("token", token);
		return userManager.getUserToken(criteria);
	}
	
	public UserToken saveUserToken(Integer userId,HttpServletRequest request){
		return userManager.saveUserToken(userId, request);
	}
	
	public Sms saveSms(Integer authCode,String mobile,Date endTime){
		return userManager.saveSms(authCode, mobile,endTime);
	}
	
	public Sms getSms(Integer authCode,String mobile,Date endTime){
		return userManager.getSms(authCode, mobile,endTime);
	}
	
	public String saveUserPic(String[] pics,Integer userId){
		String path = attachmentService.getAttachDir();
		path +=("/"+Constant.USER_PHOTO);
		attachmentService.preparePath(path);
		for(int i=0;i<pics.length;i++){
			String pic = pics[i];
			try{
				byte[] bytes = Base64Util.decode(pic);
				if(bytes.length> 512){
					//先删掉以前的数据和以前的图片
					UserPhoto userPhoto = userManager.getUserPhoto(userId);
					try{
						File file = new File(path+"/"+userPhoto.getPhotoId().toString() + "l."+Constant.IMAGE_EXT_JPG);
						if(file.exists()){
							file.delete();
						}
						File fileS = new File(path+"/"+userPhoto.getPhotoId().toString()  + "s."+Constant.IMAGE_EXT_JPG);
						if(fileS.exists()){
							fileS.delete();
						}
					} catch (Exception e) {
						
					}
					//再插入一条记录
					UserPhoto userPhotoNew = userManager.saveUserPhoto(userId);
					//存储原图
					Integer fileSize = attachmentService.saveFile(bytes, path, StringUtils.toString(userPhotoNew.getPhotoId()), "l", Constant.IMAGE_EXT_JPG);
					//存储压缩图片
					attachmentService.compressImage(bytes, fileSize, path, StringUtils.toString(userPhotoNew.getPhotoId()), "s", Constant.IMAGE_EXT_JPG);
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return path;
	}
	
	/**
	 * 
	 * @param picId
	 * @param type
	 * @return
	 */
	public boolean showPic(int picId,String type,HttpServletResponse response,HttpServletRequest request){
		String path = attachmentService.getAttachDir() + userManager.getPicPath();
		return attachmentService.showPic((path+"/"+picId+type+"."+Constant.IMAGE_EXT_JPG), response,request);
	}
	
}