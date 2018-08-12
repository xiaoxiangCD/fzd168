package cn.com.voge.gzvm.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.dao.DataAccessException;

import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.OrderProduct;
import cn.com.voge.gzvm.beans.UserOrder;
import cn.com.voge.gzvm.dao.OrderProductDao;
import cn.com.voge.gzvm.dao.UserOrderDao;

import com.google.common.collect.Maps;
import com.voyageci.core.manage.AbstractEntityManage;
import com.voyageci.tools.utils.ListUtils;

/** 
 * @author lianzw 
 * @version ����ʱ�䣺2017��4��18�� ����3:21:25 
 * ��˵�� 
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class OrderManager extends AbstractEntityManage<UserOrder, UserOrderDao>{

	private UserOrderDao userOrderDao;
	private OrderProductDao orderProductDao;

	@Override
	public Map getRecordDetail(UserOrder object) throws DataAccessException {
		Map record = super.getRecordDetail(object);
		return record;
	}
	
	public Map getOrders(int instanceId, Map param,Integer start, Integer pageSize) throws DataAccessException {
		Map criteria = Maps.newHashMap();
//		criteria.put("instanceId", instanceId);
		if (param!=null) {
			criteria.putAll(param);
		}
		List<UserOrder> uods = findBy(criteria,start,pageSize);
		List<Map> results = new ArrayList<Map>();
		int count = 0;
		if (ListUtils.isNotEmpty(uods)) {
			for (UserOrder uo : uods) {
				Map map = getRecordDetail(uo);
				results.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = uods.size();
				System.err.println(e.getMessage());
			}
		}
		
		Map result = Maps.newHashMap();
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		result.put("results", results);
		return result;
	}
	
	
	public Map getOrder(int instanceId, Integer orderId,Map criteria) throws DataAccessException {
		UserOrder uo = null;
		if (orderId != null && orderId > 0) {
			uo = get(orderId);
		}else{
			uo = firstFindBy(criteria);
		}
		if (uo == null) {
			return null;
		}
		return getRecordDetail(uo);
	}
	
	public Map saveOrder(int intanceId,Map values) throws DataAccessException {
		int orderId = getIntValue(values, "orderId");
		int oper = 1;
		UserOrder uo = null;
		if (orderId > 0) {
			uo = get(orderId);
		}
		if (uo == null) {
			oper = 0;
			uo = new UserOrder();
			uo.setState(Constant.BASE_STATE);
		}
		try {
			BeanUtils.copyProperties(uo, values);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (oper == 0) {
			insert(uo);
		}else{
			update(uo);
		}
		return getRecordDetail(uo);
	}
	
	public Map getProducts(int instanceId, Map param,Integer start, Integer pageSize){
		Map criteria = Maps.newHashMap();
//		criteria.put("instanceId", instanceId);
		if (param!=null) {
			criteria.putAll(param);
		}
		List<OrderProduct> pdts = orderProductDao.findBy(criteria,start,pageSize);
		List<Map> results = new ArrayList<Map>();
		int count = 0;
		if (ListUtils.isNotEmpty(pdts)) {
			for (OrderProduct product : pdts) {
				Map map = getRecordMap(product, true);
				results.add(map);
			}
			try {
				count = getRecordCount(criteria);
			} catch (Exception e) {
				count = pdts.size();
				System.err.println(e.getMessage());
			}
		}
		
		Map result = Maps.newHashMap();
		result.put("totalCount", count);
		result.put("start", start);
		result.put("pageSize", pageSize);
		result.put("results", results);
		return result;
	}
	
	public UserOrderDao getUserOrderDao() {
		return userOrderDao;
	}

	public void setUserOrderDao(UserOrderDao userOrderDao) {
		this.userOrderDao = userOrderDao;
	}

	public OrderProductDao getOrderProductDao() {
		return orderProductDao;
	}

	public void setOrderProductDao(OrderProductDao orderProductDao) {
		this.orderProductDao = orderProductDao;
	}
	
}
