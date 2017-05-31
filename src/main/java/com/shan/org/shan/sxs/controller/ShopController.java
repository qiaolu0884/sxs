package com.shan.org.shan.sxs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shan.org.shan.sxs.pojo.Order;
import com.shan.org.shan.sxs.service.OrderService;
import com.shan.org.shan.sxs.service.ShopService;
import com.shan.org.shan.sxs.utils.BatchDateUtil;

@Controller
public class ShopController {

	private static SimpleDateFormat F_S = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 商城下面的订单列表
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value = "/shop_online")
	public String toShop(HttpServletRequest request,Integer pageNo){
		Long userId = (Long) request.getSession().getAttribute("loginUser");
		List<Order> orders = orderService.findOrderByUser(userId,pageNo);
		request.setAttribute("orders", orders);
		//默认查询时间
		//, 
		request.setAttribute("begin", F_S.format(BatchDateUtil.getDate(BatchDateUtil.get30Days(new Date()))));
		request.setAttribute("end", F_S.format(BatchDateUtil.getDate(BatchDateUtil.getBatch(new Date()))));
		return "shop_online";
	}
	
	//条件查询
	@RequestMapping(value = "/shop_onlineByQuery")
	public String toShopByQuery(String begin ,String end,HttpServletRequest request,Integer pageNo) throws Exception{
		Long userId = (Long) request.getSession().getAttribute("loginUser");
		List<Order> orders = orderService.findOrderByUserAndQuery(userId,begin,end,pageNo);
		request.setAttribute("orders", orders);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		return "shop_online";
	}
	
}
