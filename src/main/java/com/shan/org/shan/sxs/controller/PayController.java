package com.shan.org.shan.sxs.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shan.org.shan.sxs.pojo.Pay;
import com.shan.org.shan.sxs.pojo.Tree;
import com.shan.org.shan.sxs.pojo.User;
import com.shan.org.shan.sxs.service.PayService;
import com.shan.org.shan.sxs.service.TreeService;
import com.shan.org.shan.sxs.service.UserService;
import com.shan.org.shan.sxs.utils.BatchDateUtil;
import com.shan.org.shan.sxs.utils.TreeUtils;

@Controller
public class PayController {

	@Autowired
	private PayService payService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TreeService treeService;
	
	/**
	 * 主要是能量条
	 * @return: String      
	 * @throws
	 */
	
	@RequestMapping("/grow_record")
	public String selectByExample(HttpServletRequest request, Map<String,Object> map){
		Long userId = (Long) request.getSession().getAttribute("loginUser");
		List<Pay> items = payService.selectpay(userId);
		map.put("items", items);
		
		
		//能量进度条
		User user = userService.treeIndex(userId);
		if(user == null || user.getTree() == null){
			Tree tree = treeService.insert(userId);
			user = userService.findUserByUid(userId);
			user.setTree(tree);
		}
		user = userService.treeIndex(userId);
		List<Long> list = TreeUtils.getTreeEner(user.getTree().getEnergy());
		String treeAge = TreeUtils.getTreeAge(user.getTree().getEnergy());
		request.setAttribute("user", user);
		Long b = user.getTree().getEnergy() - list.get(0);
		Long a = (list.get(1)-list.get(0));
		request.setAttribute("jdt",b*100/a);//进度条，百分比
		request.setAttribute("age", treeAge);
		request.setAttribute("begin", list.get(0));
		if(list.get(1) == 100001l){
			request.setAttribute("end", 10000l);
		} else {
			request.setAttribute("end", list.get(1));
		}
		request.setAttribute("img", list.get(2));
		
		return "grow_record";
	}
}
