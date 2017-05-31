package com.shan.org.shan.sxs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.TreeUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shan.org.shan.sxs.pojo.Tree;
import com.shan.org.shan.sxs.pojo.User;
import com.shan.org.shan.sxs.service.TreeService;
import com.shan.org.shan.sxs.service.UserService;
import com.shan.org.shan.sxs.utils.BatchDateUtil;
import com.shan.org.shan.sxs.utils.TreeUtils;

@Controller
@Transactional
public class IndexController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TreeService treeService;
	
	@RequestMapping(value = "/login")
	public String login(String username,HttpServletRequest request){
		User user = userService.loginByUsername(username);
		request.getSession().setAttribute("loginUser", 23333l);
//		request.getSession().setAttribute("loginUser", user.getUserId());
		return "redirect:/index";
	}
	/**
	 * 进入首页的方法
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,HttpServletResponse response){
		Long userId = (Long) request.getSession().getAttribute("loginUser");
		User user = userService.treeIndex(userId);//判断用户是否有树
		if(user == null || user.getTree() == null){
			Tree tree = treeService.insert(userId);
			user = userService.findUserByUid(userId);
			user.setTree(tree);
		}
		user = userService.treeIndex(userId);//获取树
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
		
		//查询用户钱包
		List<Long> moneys = userService.findWalletByUid(userId);
		request.setAttribute("szzCount", moneys.get(0));
		request.setAttribute("sxbCount", moneys.get(1));
		return "index";
	}
	
}
