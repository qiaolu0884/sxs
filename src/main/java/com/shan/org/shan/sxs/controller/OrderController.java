package com.shan.org.shan.sxs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shan.org.shan.sxs.pojo.Card;
import com.shan.org.shan.sxs.pojo.Order;
import com.shan.org.shan.sxs.pojo.User;
import com.shan.org.shan.sxs.service.CardService;
import com.shan.org.shan.sxs.service.OrderService;
import com.shan.org.shan.sxs.service.UserService;
import com.shan.org.shan.sxs.utils.ConvertNum;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CardService cardService;

	@Autowired
	private UserService userService;
	
	/**
	 * 跳转到单个商品支付页面
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value = "/order_pay")
	public String order(Long type, Long count, HttpServletRequest request) {
		//插入一条语句
		Long uid = (Long) request.getSession().getAttribute("loginUser");
		Long orderId = orderService.insertOrder(type, count, uid);
		
		//在进行查询
		Order order = orderService.findOrderByOrderNum(orderId);
		return "redirect:/toorder_pay?id="+order.getId();
	}

	/**
	 * ajax请求，确认商品状态是否未支付
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value = "/orderpayfor")
	public @ResponseBody String orderFor(String id) {
		String replaceAll = id.replaceAll(",", "");
		Order order = orderService.findOrderByPriId(Long.valueOf(replaceAll));
		if (order == null) {
			return "0";
		} else if (order.getStatus()==1) {
			return "1";
		} else if (order.getStatus()==2) {
			return "2";
		}
		return "3";
	}

	/**
	 * 列表跳转到支付页面
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value = "/toorder_pay")
	public String orderTo(String id,Model model) {
		String replaceAll = id.replaceAll(",", "");
		Order order = orderService.findOrderByPriId(Long.valueOf(replaceAll));
		User user = userService.findUserTelByUid(order.getUserId());
		model.addAttribute("telephone",ConvertNum.getTel(user.getTelephone()));
		model.addAttribute("order", order);
	//  根据uid查找银行卡信息
		List<Card> cards = cardService.findCardsByUid(order.getUserId());
		model.addAttribute("cards", cards);
		return "/order_pay";
	}

	/**
	 * 订单状态
	 */
	@RequestMapping(value = "/order_derail")
	public String order_derail(String oid,String type ,Model model){
		if(oid!=null){
			oid = oid.replaceAll(",", "");
			Order order = orderService.findOrderByPriId(Long.parseLong(oid));
			model.addAttribute("order", order);
		}
		model.addAttribute("type", type);
		return "/order_derail";
	}
}
