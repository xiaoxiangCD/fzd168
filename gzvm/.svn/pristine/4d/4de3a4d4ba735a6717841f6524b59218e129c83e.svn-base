package cn.com.voge.gzvm.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;
import com.voyageci.tools.utils.GeneralUtils;
import com.voyageci.tools.utils.NumberUtils;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.UserToken;
import cn.com.voge.gzvm.security.AdminSession;
import cn.com.voge.gzvm.security.UserSession;
import cn.com.voge.gzvm.beans.Sms;
import cn.com.voge.gzvm.beans.User;
import cn.com.voge.gzvm.beans.UserPhoto;
import cn.com.voge.gzvm.service.GzvmService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserAction extends GebileAction  {

	private String code;
	private String password; 
	private Integer userId; 
	private Integer start;
	private Integer pageSize;
	private Integer userType;
	private String nickname;
	private String openid;
	private String userName;
	private String idCard;
	private Integer idType;
	private String mobile;
	private Integer age;
	private Integer sex;
	private Float stature;
	private Float weight;
	private String size;
	private String profession;
	private String city;
	private String addr;
	private String contactName;
	private String contactNumber;
	private Integer content;
	private Date sendTime;
	private Integer authCode;
	private Integer photoId;
	private String pics;
	private String type;
	private String searchLike;
	private Integer pic;
	private String maiBox;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4693996600450220654L;

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/** 登录验证接口
	 * @author xzq
	 */
	public void login(){	
		Map result = userService.authenticate(code, password);
		if (result.containsKey("userId")) {
			userId = (Integer) result.get("userId");
			try {
				UserSession token = createUserSession(userId, request);
				result.put("token", token.getToken());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		}
		writeJson(response, result);
	}
	
	/** 发送短信验证码
	 * @author xzq
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * @throws ProtocolException 
	 * @throws MalformedURLException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public void getSmsCode() {
		Map result = null;
		try {
			Integer authCode=(int)((Math.random()*9+1)*100000);
			String url="https://inolink.com/ws/BatchSend2.aspx?CorpID=TCLK04618&Pwd=@wuhuan&Mobile="+mobile+"&Content="+authCode;
			String open=GzvmService.httpsRequest(url, "GET", null);
			if(NumberUtils.toIntValue(open)>0){
				userService.saveSms(authCode,mobile,sendTime);
				result = getReturnMap("获取成功", Constant.RESULT_CODE_SUCCESS);
			}else{
				result = getReturnMap("获取失败", Constant.RESULT_CODE_ERROR);
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		writeJson(response, result);
	}
	
	
	
	/** 验证短信验证码
	 * @author xzq
	 */
	public void loginSms(){
		Sms sms = null;
		Map result = null;
		try {
			sms = userService.getSms(authCode, mobile,sendTime);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (sms == null) {
			result = getReturnMap("获取失败", Constant.RESULT_CODE_ERROR);
		}else{
			result=getReturnMap("获取成功!", Constant.RESULT_CODE_SUCCESS);
		}
		writeJson(response, result);
	}
	
	
	/** 获取用户列表
	 * @author xzq
	 */
	public void getUsers(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		Map param = Maps.newHashMap();
		if (searchLike != null) {
			param.put("searchLike", searchLike);
		}
		try {
			result = userService.getUsers(param, start, pageSize);
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
	
	/** 注册用户
	 * @author xzq
	 */
	public void saveUser(){
//		AdminSession token = getAdminSession(true);
//		if (token == null) {
//			return;
//		}
		Map values = Maps.newHashMap();
		if (userId != null) {
			values.put("userId", userId);
		}
		if(userType == null){
			userType=1;
//			userType = Constant.ADMIN_TYPE_COMMON;
		}
		if (openid != null) {
			values.put("openid", openid);
		}
		values.put("userType", userType);
		values.put("userName", userName);
		values.put("idCard", idCard);
		values.put("idType", idType);
		values.put("mobile", mobile);
		values.put("password",GeneralUtils.MD5(password));
		values.put("age",age);
		values.put("maiBox",maiBox);
		values.put("sex",sex);
		values.put("weight",weight);
		values.put("size",size);
		values.put("profession",profession);
		values.put("city",city);
		values.put("addr",addr);
		values.put("contactName",contactName);
		values.put("contactNumber",contactNumber);
		values.put("nickname",nickname);
		values.put("stature",stature);
		
		Map result = null;
		try {
			result = userService.saveUser(values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("保存失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("保存成功!", Constant.RESULT_CODE_SUCCESS));
		}
		writeJson(response, result);
	}
	
	/** 修改用户密码
	 * @author xzq
	 */
	public void changePassWord(){
		Map result = null;
		User user = null;
		try {
			 user = userService.changePassWord(mobile,GeneralUtils.MD5(password));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (user == null) {
			result = getReturnMap("更改失败", Constant.RESULT_CODE_ERROR);
		}else{
			result = getReturnMap("更改成功", Constant.RESULT_CODE_SUCCESS);
		}
		writeJson(response, result);
	}
	
	/** 删除用户
	 * @author xzq
	 */
	public void delUser(){
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		Map result = null;
		try {
			result = userService.deleteUser(userId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (result == null) {
			result = getReturnMap("删除失败", Constant.RESULT_CODE_ERROR);
		}else{
			result.putAll(getReturnMap("删除成功!", Constant.RESULT_CODE_SUCCESS));
		}
		writeJson(response, result);
	}
	
	/** 获取用户头像
	 * @author xzq
	 */
	@SuppressWarnings("null")
	public void getUserPhoto(){
		UserToken token = getWebUserToken(true);
		if (token == null) {
			return;
		}
		UserPhoto userPhoto=null;
		Map result = null;
		try {
		    userPhoto = userService.getUserPhoto(userId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (userPhoto == null) {
			result = getReturnMap("获取失败", Constant.RESULT_CODE_ERROR);
		}else{
			String url = getRequest().getContextPath() + "!showPic.action?pic=";
			result.put("url", url);
			result.put("获取成功!",  Constant.RESULT_CODE_SUCCESS);
			result.put("result",userPhoto);
		}
		writeJson(response, result);
	}
	
	
	/** 保存用户头像
	 * @author xzq
	 */
	@SuppressWarnings("null")
	public void saveUserPhoto(){
		String url=null;
		Map result = null;
		AdminSession token = getAdminSession(true);
		if (token == null) {
			return;
		}
		String[] strPics = null;
		if(pics != null){
			int length = pics.length();
			pics = pics.substring(1, length-1);
			strPics = pics.split(",");
		}
		try {
		 url = userService.saveUserPic(strPics,userId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (url==null) {
			result = getReturnMap("保存失败", Constant.RESULT_CODE_ERROR);
		}else{
//			result.put(getReturnMap("保存成功!", Constant.RESULT_CODE_SUCCESS));
			url = getRequest().getContextPath() + "!showPic.action?pic=";
			result.put("保存成功", Constant.RESULT_CODE_SUCCESS);
			result.put("url",url);
		}
		writeJson(response, result);
	}
	
	public void showPic(){
		response.setContentType("image/jpg");
		String stype = type;
		if(stype == null){
			stype = "s";
		}
		if((pic == null)&&(pic<1)){
			return ;
		}
		userService.showPic(pic, stype, response,request);
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}


	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Float getStature() {
		return stature;
	}

	public void setStature(Float stature) {
		this.stature = stature;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getContent() {
		return content;
	}

	public void setContent(Integer content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getAuthCode() {
		return authCode;
	}

	public void setAuthCode(Integer authCode) {
		this.authCode = authCode;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPic() {
		return pic;
	}

	public void setPic(Integer pic) {
		this.pic = pic;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSearchLike() {
		return searchLike;
	}

	public void setSearchLike(String searchLike) {
		this.searchLike = searchLike;
	}

	public String getMaiBox() {
		return maiBox;
	}

	public void setMaiBox(String maiBox) {
		this.maiBox = maiBox;
	}

}
