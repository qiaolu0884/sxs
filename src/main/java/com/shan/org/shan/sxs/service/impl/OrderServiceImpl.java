package com.shan.org.shan.sxs.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shan.org.shan.sxs.dao.CommodityDao;
import com.shan.org.shan.sxs.dao.OrderDao;
import com.shan.org.shan.sxs.pojo.Commodity;
import com.shan.org.shan.sxs.pojo.CommodityQuery;
import com.shan.org.shan.sxs.pojo.Order;
import com.shan.org.shan.sxs.pojo.OrderQuery;
import com.shan.org.shan.sxs.pojo.OrderQuery.Criteria;
import com.shan.org.shan.sxs.service.OrderService;
import com.shan.org.shan.sxs.utils.BatchDateUtil;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	private static SimpleDateFormat F_D = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat F_S = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CommodityDao commodityDao;
	
	/**
	 * 跳转界面
	 */
	@Override
	public List<Order> findOrderByUser(Long userId,Integer pageNo) {
		//设置查询寻条件
		OrderQuery query = new OrderQuery();
		Long b = BatchDateUtil.get30Days(new Date());
		Long e = BatchDateUtil.getBatch(new Date());
		query.createCriteria().andUserIdEqualTo(userId).andCreateTimeBetween(b,e);
		if(pageNo == null || pageNo == 1){
			query.setPageNo(1);//分页
		} else {
			query.setPageNo(pageNo);//分页
		}
		query.setPageSize(5);
		//查询
		List<Order> orders = orderDao.selectByExample(query);
		if(orders != null && orders.size()>0){
			for (Order order : orders) {
				//处理结果集
				Long status = order.getStatus();
				if(status == 0l){
					Long nowTime = BatchDateUtil.getBatch(new Date());
					Long createTime = order.getCreateTime();
					Long time = nowTime - createTime;
					if(createTime != null && time < 1800){
						order.setDjs(1800-time);
						order.setStatusS("未支付");
					} else {
						order.setStatus(2l);
						orderDao.updateByPrimaryKeySelective(order);
 						order.setStatusS("已关闭");
					}
				} else if(status == 1l){
					order.setStatusS("已支付");
				} else {
					order.setStatusS("已关闭");
				}
				Long commodityId = order.getCommodityId();
				if(commodityId == 1){
					order.setCommS("善心币");
				} else {
					order.setCommS("善种子");
				}
				order.setFormatTime(BatchDateUtil.getDATE(order.getCreateTime()));
			}
			
			return orders;
		}
		return  null;
	}
	
	/**
	 * 直接购买跳转插入页面
	 */
	@Override
	public Long insertOrder(Long type, Long count,Long uid) {
		//先查找商品，根据type
		CommodityQuery query = new CommodityQuery();
		query.createCriteria().andIdEqualTo(type);
		List<Commodity> list = commodityDao.selectByExample(query);
		//创建一个新的商品对象
		Order order = new Order();
		order.setCommodityId(type);
		order.setCreateTime(BatchDateUtil.getBatch(new Date()));
		//设置总金额数量 
		BigDecimal m = list.get(0).getMoney() ;
		Long t = (Long) (m.intValue() * count);
		order.setMoney(new BigDecimal(t));
		order.setOrderCount(count);//设置购买数量
		//设置orderNumber，是用当前时间和6位随机数生成的 
		String format = F_D.format(new Date());
		String replace = format.replaceAll("-", "").replace(":", "").replace(" ", "") + getRan();
		Long orderNumber = Long.valueOf(replace);
		order.setOrderNumber(orderNumber);
		
		
		order.setStatus(0l);
		order.setUserId(uid);
		orderDao.insertSelective(order);//插入一条记录
		return orderNumber;
	}

	/**
	 * 
	 */
	@Override
	public Order findOrderByOrderNum(Long id) {
		OrderQuery query = new OrderQuery();
		query.createCriteria().andOrderNumberEqualTo(id);
		List<Order> orders = orderDao.selectByExample(query);
		if(orders != null && orders.size()>0){
			Order order = orders.get(0);
			Long djs = BatchDateUtil.getOrderDjs(order);
			order.setDjs(djs);
			if(order.getCommodityId() == 1){
				order.setCommS("善心币");
			} else {
				order.setCommS("善种子");
			}
			return order;
		}
		return null;
	}

	 public static String getRan() {
        Integer x;//定义两变量
        Random ne=new Random();//实例化一个random的对象ne
        x=ne.nextInt(99999-10000+1)+10000;//为变量赋随机值1000-9999
        return x.toString();
	 }

	@Override
	public List<Order> findOrderByUserAndQuery(Long userId, String begin, String end,Integer pageNo) throws Exception {
		//设置查询寻条件
		OrderQuery query = new OrderQuery();
		Criteria criteria = query.createCriteria();
		criteria.andUserIdEqualTo(userId);
		//.andCreateTimeBetween(, );
		Long b = BatchDateUtil.get30Days(new Date());
		Long e = BatchDateUtil.getBatch(new Date());
		if(begin != null ){
			b = BatchDateUtil.getBatch(F_S.parse(begin));
		}
		if(end != null ){
			e = BatchDateUtil.getBatch(F_S.parse(end))+86400;//多加一天的 
		}
		
		criteria.andCreateTimeBetween(b, e);
		if(pageNo == null || pageNo == 1){
			query.setPageNo(1);//分页
		} else {
			query.setPageNo(pageNo);//分页
		}
		query.setPageSize(5);
		//查询
		List<Order> orders = orderDao.selectByExample(query);
		if(orders != null && orders.size()>0){
			for (Order order : orders) {
				//处理结果集
				Long status = order.getStatus();
				if(status == 0l){
					Long nowTime = BatchDateUtil.getBatch(new Date());
					Long createTime = order.getCreateTime();
					Long time = nowTime - createTime;
					if(createTime != null && time < 1800){
						order.setDjs(1800-time);
						order.setStatusS("未支付");
					} else {
						order.setStatus(2l);
						orderDao.updateByPrimaryKeySelective(order);
 						order.setStatusS("已关闭");
					}
				} else if(status == 1l){
					order.setStatusS("已支付");
				} else {
					order.setStatusS("已关闭");
				}
				Long commodityId = order.getCommodityId();
				if(commodityId == 1){
					order.setCommS("善心币");
				} else {
					order.setCommS("善种子");
				}
				order.setFormatTime(BatchDateUtil.getDATE(order.getCreateTime()));
			}
			
			return orders;
		}
		return null;
	}

	@Override
	public Order findOrderByPriId(Long valueOf) {
		Order order = orderDao.selectByPrimaryKey(valueOf);
		if(order != null){
			
			Long djs = BatchDateUtil.getOrderDjs(order);
			order.setDjs(djs);
			order.setFormatTime(BatchDateUtil.getDATE(order.getCreateTime()));
			if(order.getCommodityId() == 1){
				order.setCommS("善心币");
			} else {
				order.setCommS("善种子");
			}
		}
		return order;
	}
	 
}
