package cn.com.voge.gzvm.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.BlackList;
import cn.com.voge.gzvm.beans.OldUser;
import cn.com.voge.gzvm.beans.Sms;
import cn.com.voge.gzvm.beans.Team;
import cn.com.voge.gzvm.beans.TeamMember;
import cn.com.voge.gzvm.beans.User;
import cn.com.voge.gzvm.beans.UserCode;
import cn.com.voge.gzvm.beans.UserPhoto;
import cn.com.voge.gzvm.beans.UserToken;
import cn.com.voge.gzvm.dao.BlackListDao;
import cn.com.voge.gzvm.dao.OldUserDao;
import cn.com.voge.gzvm.dao.SmsDao;
import cn.com.voge.gzvm.dao.TeamDao;
import cn.com.voge.gzvm.dao.TeamMemberDao;
import cn.com.voge.gzvm.dao.UserCodeDao;
import cn.com.voge.gzvm.dao.UserDao;
import cn.com.voge.gzvm.dao.UserPhotoDao;
import cn.com.voge.gzvm.dao.UserTokenDao;

import com.google.gxp.com.google.common.collect.Maps;
import com.voyageci.core.manage.AbstractEntityManage;
import com.voyageci.tools.utils.BeanUtils;
import com.voyageci.tools.utils.ListUtils;
import com.voyageci.tools.utils.WebUtils;


@SuppressWarnings({"rawtypes","unchecked"})
public class UserManager extends AbstractEntityManage<User, UserDao> {

	private UserDao userDao;
	private OldUserDao oldUserDao;
	private UserCodeDao userCodeDao;
	private BlackListDao blackListDao;
	private TeamMemberDao teamMemberDao;
	private TeamDao teamDao;
	private UserTokenDao userTokenDao;
	private SmsDao smsDao;
	private UserPhotoDao userPhotoDao;
	@Override
	public Map getRecordDetail(User object) throws DataAccessException {
		Map record = super.getRecordDetail(object);
		if(getUserCode(object.getUserId())!=null){
			String  userCode=getUserCode(object.getUserId());
			record.put("userCode", userCode);
		}
		;
		Integer openOld=getOldUser(object.getUserId());
		Integer openBlack=getBlackList(object.getUserId());
		record.put("openOld", openOld);
		record.put("openBlack", openBlack);
		record.put("resultCode", Constant.RESULT_CODE_SUCCESS);
		return record;
	}
	
	public User getUser(Map criteria) throws DataAccessException{
		User user = firstFindBy(criteria);
		return user;
		
	}
	
	
/** ------ 获取用户   ------ */
	
	/** 获取用户
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public Map getUsers(Map criteria,Integer start, Integer pageSize){
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<User> users = findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(users)) {
			for (User user : users) {
				Map map = getRecordDetail(user);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = users.size();
			}
		}
		result.put("results", users);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 获取用户头像
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public UserPhoto getUserPhoto(Integer userId){
		if(userId==null||userId<0){
			return null;
		}
		UserPhoto userPhoto=userPhotoDao.firstFindBy("userId", userId);
		return userPhoto;
	}
	
	/** 注册或者更新用户
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map saveUser(Map values) throws DataAccessException{
		Integer userId = getIntValue(values, "userId");
		int oper = Constant.OPER_UPDATE;
		User user=null;
		if(userId>0){
			user=get(userId);
		}
		if(user==null){
			oper = Constant.OPER_INSTER;
			user=new User();
			user.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(user, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			insert(user);
		}else{
			update(user);
		}
		Map record = getRecordDetail(user);
		return record;
		
	}
	
	/** 删除用户
	 * @author xzq
	 * @param adminId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteUser(Integer userId) throws DataAccessException{
		User user = get(userId);
		return deleteUser(user);
	}
	
	/** 更改用户密码
	 * @author xzq
	 * @param mobile
	 * @return
	 * @throws DataAccessException
	 */
	public User changePassWord(String mobile,String password) throws DataAccessException{
		Map criteria = Maps.newHashMap();
		criteria.put("state", Constant.BASE_STATE);
		criteria.put("mobile", mobile);
		User user =userDao.firstFindBy(criteria);
		if(user==null){
			return null;
		}
		user.setPassword(password);
		userDao.update(user);
		return user;
		
	}
	
	public Map deleteUser(User user) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (user == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			remove(user);
		}

		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 获取选手编号
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public Map getUserCode(Map criteria, Integer start, Integer pageSize){
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<UserCode> userCodes = userCodeDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(userCodes)) {
			for (UserCode userCode : userCodes) {
				Map map = getRecordMap(userCode, true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = userCodes.size();
			}
		}
		result.put("results", userCodes);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 获取单个用户编码
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public  String  getUserCode(Integer userId){
		UserCode userCode=new UserCode();
		userCode=userCodeDao.get(userId);
		if(userCode==null){
			return null;
		}
		return userCode.getEntryCode();
	}
	
	/** 新增或者修改选手编号
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map setUserCode(Map values) throws DataAccessException{
		Integer codeId = getIntValue(values, "codeId");
		int oper = Constant.OPER_UPDATE;
		UserCode userCode = null;
		if (codeId > 0) {
			userCode = userCodeDao.get(codeId);
		}
		
		if (userCode == null) {
			oper = Constant.OPER_INSTER;
			userCode = new UserCode();
			userCode.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(userCode, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			userCodeDao.insert(userCode);
		}else{
			userCodeDao.update(userCode);
		}
		Map record = getRecordMap(userCode,true);
		return record;
		
	}
	
	/** 珊瑚选手编号
	 * @author xzq
	 * @param adminId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteUserCode(Integer codeId) throws DataAccessException{
		UserCode userCode = userCodeDao.get(codeId);
		return deleteUserCode(userCode);
	}
	
	public Map deleteUserCode(UserCode userCode) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (userCode == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			userCodeDao.remove(userCode);
		}

		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 获取是不是老用户
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public  Integer  getOldUser(Integer userId){
		Integer oper=Constant.RESULT_CODE_SUCCESS;
		OldUser oldUser=new OldUser();
		oldUser=oldUserDao.get(userId);
		if(oldUser==null){
			oper=Constant.RESULT_CODE_ERROR;
		}
		return oper;
	}
	
	/** 获取老用户
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public Map getOldUser(Map criteria, Integer start, Integer pageSize){
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<OldUser> oldUsers = oldUserDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(oldUsers)) {
			for (OldUser oldUser : oldUsers) {
				Map map = getRecordMap(oldUser, true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = oldUsers.size();
			}
		}
		result.put("results", oldUsers);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	
	/** 新增或者修改老用户
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map setOldUser(Map values) throws DataAccessException{
		Integer oldId = getIntValue(values, "oldId");
		int oper = Constant.OPER_UPDATE;
		OldUser oldUser = null;
		if (oldId > 0) {
			oldUser = oldUserDao.get(oldId);
		}
		if (oldUser == null) {
			oper = Constant.OPER_INSTER;
			oldUser = new OldUser();
			oldUser.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(oldUser, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			oldUserDao.insert(oldUser);
		}else{
			oldUserDao.update(oldUser);
		}
		Map record = getRecordMap(oldUser,true);
		return record;
	}
	
	/** 珊瑚老用户 
	 * @author xzq
	 * @param adminId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteOldUser(Integer oldId) throws DataAccessException{
		OldUser oldUser = oldUserDao.get(oldId);
		return deleteOldUser(oldUser);
	}
	
	public Map deleteOldUser(OldUser oldUser) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (oldUser == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			userCodeDao.remove(oldUser);
		}

		Map result = getReturnMap(msg, code);
		return result;
	}
	
	
	/** 获取是不是黑名单
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public  Integer  getBlackList(Integer userId){
		Integer oper=Constant.RESULT_CODE_ERROR;
		BlackList blackList=new BlackList();
		blackList=blackListDao.get(userId);
		if(blackList==null){
			oper=Constant.RESULT_CODE_SUCCESS;
		}
		return oper;
	}
	
	
	/** 获取黑名单用户
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public Map getBlackList(Map criteria, Integer start, Integer pageSize){
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<BlackList> blackLists = blackListDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(blackLists)) {
			for (BlackList balckList : blackLists) {
				Map map = getRecordMap(balckList, true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count =blackLists.size();
			}
		}
		result.put("results", blackLists);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 新增或者修改老用户
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map setBlackList(Map values) throws DataAccessException{
		Integer blackId = getIntValue(values, "blackId");
		int oper = Constant.OPER_UPDATE;
		BlackList blackList = null;
		if (blackId > 0) {
			blackList = blackListDao.get(blackId);
		}
		if (blackList == null) {
			oper = Constant.OPER_INSTER;
			blackList = new BlackList();
			blackList.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(blackList, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			blackListDao.insert(blackList);
		}else{
			blackListDao.update(blackList);
		}
		Map record = getRecordMap(blackList,true);
		return record;
	}
	
	/** 删除黑名单用户
	 * @author xzq
	 * @param adminId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteBlackList(Integer blackId) throws DataAccessException{
		BlackList blackList = blackListDao.get(blackId);
		return deleteBlackList(blackList);
	}
	
	public Map deleteBlackList(BlackList blackList) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (blackList == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			userCodeDao.remove(blackList);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 获取团队成员
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public Map getTeamMember(Map criteria, Integer start, Integer pageSize){
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<TeamMember> teamMembers = teamMemberDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(teamMembers)) {
			for (TeamMember teamMember : teamMembers) {
				Map map = getRecordMap(teamMember, true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count =teamMembers.size();
			}
		}
		result.put("results", teamMembers);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	
	/** 新增或者修改团队成员
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map setTeamMember(Map values) throws DataAccessException{
		Integer menberId = getIntValue(values, "menberId");
		int oper = Constant.OPER_UPDATE;
		TeamMember teamMember = null;
		if (menberId > 0) {
			teamMember = teamMemberDao.get(menberId);
		}
		if (teamMember == null) {
			oper = Constant.OPER_INSTER;
			teamMember = new TeamMember();
			teamMember.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(teamMember, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			teamMemberDao.insert(teamMember);
		}else{
			teamMemberDao.update(teamMember);
		}
		Map record = getRecordMap(teamMember,true);
		return record;
	}
	
	/** 删除团队成员
	 * @author xzq
	 * @param adminId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteTeamMember(Integer menberId) throws DataAccessException{
		TeamMember teamMember = teamMemberDao.get(menberId);
		return deleteTeamMember(teamMember);
	}
	
	public Map deleteTeamMember(TeamMember teamMember) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (teamMember == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			teamMemberDao.remove(teamMember);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 获取团队
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public Map getTeam(Map criteria, Integer start, Integer pageSize){
		Map result = Maps.newHashMap();
		List<Map> maps = new ArrayList<>();
		List<Team> teams = teamDao.findBy(criteria, start, pageSize);
		Integer count = 0;
		if (ListUtils.isNotEmpty(teams)) {
			for (Team team : teams) {
				Map map = getRecordMap(team, true);
				maps.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count =teams.size();
			}
		}
		result.put("results", teams);
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		return result;
	}
	
	/** 新增或者修改团队
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	public Map setTeam(Map values) throws DataAccessException{
		Integer teamId = getIntValue(values, "teamId");
		int oper = Constant.OPER_UPDATE;
		Team team = null;
		if (teamId > 0) {
			team = teamDao.get(teamId);
		}
		if (team == null) {
			oper = Constant.OPER_INSTER;
			team = new Team();
			team.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(team, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == Constant.OPER_INSTER) {
			teamDao.insert(team);
		}else{
			teamDao.update(team);
		}
		Map record = getRecordMap(team,true);
		return record;
	}
	
	/** 删除团队
	 * @author xzq
	 * @param adminId
	 * @return
	 * @throws DataAccessException
	 */
	public Map deleteTeam(Integer teamId) throws DataAccessException{
		Team team = teamDao.get(teamId);
		return deleteTeam(team);
	}
	
	public Map deleteTeam(Team team) throws DataAccessException{
		Integer code = Constant.RESULT_CODE_SUCCESS;
		String msg = "删除成功！";
		if (team == null) {
			code = Constant.RESULT_CODE_ERROR;
			msg = "删除失败！已经不存在，";
		} else {
			teamDao.remove(team);
		}
		Map result = getReturnMap(msg, code);
		return result;
	}
	
	/** 获取用户Usertoken
	 * @author xzq
	 * @param criteria
	 * @return
	 * @throws DataAccessException
	 */
	public UserToken getUserToken(Map criteria) throws DataAccessException{
		UserToken token = userTokenDao.firstFindBy(criteria); 
		return token;
	}
	
//	/** 获取操作日志列表
//	 * @author lianzw
//	 * @param criteria
//	 * @param start
//	 * @param pageSize
//	 * @return
//	 */
//	public Map getAdminLogs(Map criteria, Integer start, Integer pageSize){
//		Map result = Maps.newHashMap();
//		List<Map> maps = new ArrayList<>();
//		List<VMAdminLog> logs = vmAdminLogDao.findBy(criteria, start, pageSize);
//		Integer count = 0;
//		if (ListUtils.isNotEmpty(logs)) {
//			for (VMAdminLog log : logs) {
//				Map map = getRecordMap(log, true);
//				maps.add(map);
//			}
//			try {
//				count = getRecordCount(criteria);
//			} catch (Exception e) {
//				count = logs.size();
//			}
//		}
//		result.put("results", logs);
//		result.put("totalCount", count);
//		result.put("start", start);
//		result.put("pageSize", pageSize);
//		return result;
//	}
//
//	/** 保存管理员操作日志
//	 * @author lianzw
//	 * @param adminId
//	 * @param module
//	 * @param method
//	 * @param describe
//	 * @return
//	 */
//	public Map saveAdminLog(Integer adminId, String module, String method, String describe){
//		VMAdmin admin = get(adminId);
//		VMAdminLog log = null;
//		if (admin != null) {
//			log = new VMAdminLog();
//			log.setAdminId(adminId);
//			log.setAdminName(admin.getAdminName());
//			log.setModule(module);
//			log.setMethod(method);
//			log.setDescribe(describe);
//			log.setLogTime(new Date());
//			log.setLogState(Constant.BASE_STATE);
//		}
//		return getRecordMap(log, true);
//	}
//	
	
	
	/** 保存用户登录token数据
	 * @author xzq
	 * @param adminId
	 * @param request
	 * @return
	 */
	public UserToken saveUserToken(Integer userId,HttpServletRequest request) throws DataAccessException{
		User user = get(userId);
		UserToken token = null; 
		if (user != null) {
			Map criteria = Maps.newHashMap();
			criteria.put("state", Constant.BASE_STATE);
			criteria.put("userId", userId);
			Integer oper = Constant.OPER_UPDATE;
			token = userTokenDao.firstFindBy(criteria);
			if (token == null) {
				token = new UserToken();
				token.setUserId(userId);
				token.setState(Constant.BASE_STATE);
				oper = Constant.OPER_INSTER;
			}
			token.setUserCode(user.getMobile()+"");
			token.setUserName(user.getUserName());
			token.setToken(WebUtils.getSessionId(request));
			token.setLoginTime(new Date());
			if (oper == Constant.OPER_INSTER) {
				userTokenDao.insert(token);
			}else{
				userTokenDao.update(token);
			}
		}
		return token;
	}
	
	/** 保存短信验证码记录
	 * @author xzq
	 * @param adminId
	 * @param request
	 * @return
	 */
	public Sms saveSms(Integer authCode,String mobile,Date endTime) throws DataAccessException{
		Sms sms=new Sms();
		endTime=new Date();
		sms.setAuthCode(authCode);
		sms.setMobile(mobile);
		sms.setSendTime(endTime);
		smsDao.insert(sms);
		return sms;
	}
	
	/** 保存用户头像
	 * @author xzq
	 * @param adminId
	 * @param request
	 * @return
	 */
	public UserPhoto saveUserPhoto(Integer userId) throws DataAccessException{
		UserPhoto userPhoto=null;
		userPhoto=userPhotoDao.firstFindBy("userId",userId);
		if(userPhoto!=null){
			userPhotoDao.remove(userId);
		}
		Date endTime=new Date();
		userPhoto=new UserPhoto();
		userPhoto.setUserId(userId);
		userPhoto.setPhotoTime(endTime);
		userPhotoDao.insert(userPhoto);
		return userPhoto;
	}
	
	/** 验证短信验证码
	 * @author xzq
	 * @param criteria
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public Sms getSms(Integer authCode, String mobile,Date endTime){
		Map criteria = Maps.newHashMap();
		if(authCode==null||mobile==null){
			return null;
		}
		criteria.put("authCode", authCode);
		criteria.put("mobile", mobile);
//		criteria.put("endTime", endTime);
		Sms smss = smsDao.firstFindBy(criteria);
		Date date=new Date();
		Date endDate=smss.getSendTime();
	    long interval = (date.getTime() - endDate.getTime())/1000;
	    if(interval>600){
	    	return null;
	    }
		return smss;
	}
	
	public String getPicPath(){
		return "/"+Constant.USER_PHOTO;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public OldUserDao getOldUserDao() {
		return oldUserDao;
	}

	public void setOldUserDao(OldUserDao oldUserDao) {
		this.oldUserDao = oldUserDao;
	}

	public UserCodeDao getUserCodeDao() {
		return userCodeDao;
	}

	public void setUserCodeDao(UserCodeDao userCodeDao) {
		this.userCodeDao = userCodeDao;
	}

	public BlackListDao getBlackListDao() {
		return blackListDao;
	}

	public void setBlackListDao(BlackListDao blackListDao) {
		this.blackListDao = blackListDao;
	}

	public TeamMemberDao getTeamMemberDao() {
		return teamMemberDao;
	}

	public void setTeamMemberDao(TeamMemberDao teamMemberDao) {
		this.teamMemberDao = teamMemberDao;
	}

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public UserTokenDao getUserTokenDao() {
		return userTokenDao;
	}

	public void setUserTokenDao(UserTokenDao userTokenDao) {
		this.userTokenDao = userTokenDao;
	}

	public SmsDao getSmsDao() {
		return smsDao;
	}

	public void setSmsDao(SmsDao smsDao) {
		this.smsDao = smsDao;
	}

	public UserPhotoDao getUserPhotoDao() {
		return userPhotoDao;
	}

	public void setUserPhotoDao(UserPhotoDao userPhotoDao) {
		this.userPhotoDao = userPhotoDao;
	}

}