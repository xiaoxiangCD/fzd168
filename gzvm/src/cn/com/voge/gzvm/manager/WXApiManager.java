package cn.com.voge.gzvm.manager;

import java.util.Date;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.WXApiToken;
import cn.com.voge.gzvm.dao.WXApiTokenDao;
import cn.com.voge.gzvm.dao.WXUserDao;

import com.voyageci.core.manage.AbstractEntityManage;
import com.voyageci.tools.utils.DateUtils;

@SuppressWarnings({ "rawtypes"})
public class WXApiManager extends AbstractEntityManage<WXApiToken, WXApiTokenDao>{

	private WXApiTokenDao wxApiTokenDao;
	private WXUserDao wxUserDao;

	@Override
	public Map getRecordDetail(WXApiToken object) throws DataAccessException {
		return super.getRecordDetail(object);
	}
	
	public Map updateToken(String value, String tokenType,Integer exires) throws DataAccessException{
		if(value == null){
			return null;
		}
		WXApiToken token = firstFindBy("tokenType", tokenType);
		Date date = new Date();
		Date expiresTime = DateUtils.addSeconds(date, exires);
		if(token == null){
			token = new WXApiToken();
			token.setTokenType(tokenType);
			token.setState(Constant.BASE_STATE);
			token.setToken(value);	
			token.setUpdateTime(date);
			token.setExpiresTime(expiresTime);
			insert(token);
		}else{
			token.setToken(value);
			token.setUpdateTime(date);
			token.setExpiresTime(expiresTime);
			update(token);
		}
		
		return getRecordDetail(token);
	}
	
	public WXApiToken getToken(String tokenType) throws DataAccessException{
		WXApiToken token = firstFindBy("tokenType", tokenType);
		return token;
	}
	
	public WXApiTokenDao getWxApiTokenDao() {
		return wxApiTokenDao;
	}

	public void setWxApiTokenDao(WXApiTokenDao wxApiTokenDao) {
		this.wxApiTokenDao = wxApiTokenDao;
	}

	public WXUserDao getWxUserDao() {
		return wxUserDao;
	}

	public void setWxUserDao(WXUserDao wxUserDao) {
		this.wxUserDao = wxUserDao;
	}
	
}
