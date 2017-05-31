package com.shan.org.shan.sxs.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shan.org.shan.sxs.pojo.Card;
import com.shan.org.shan.sxs.service.CardService;


@Controller
public class CardController {

	@Autowired
	private CardService cardService;
	
	
	/**
	 * 跳转到我的银行卡列表
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value = "/mycard")
	public String toMycard(String uid,Model model){
		List<Card> cards = null;
		if(uid != null){
			uid = uid.replaceAll(",", "");
			cards = cardService.findCardsByUid(Long.parseLong(uid));
		}
		model.addAttribute("cards", cards);
		return "/mycard";
	}
	
	/**
	 * 发送ajax请求，验证银行卡的数量
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value = "/card_yz")
	public @ResponseBody String yzCard(HttpServletRequest request) {
		Long uid = (Long) request.getSession().getAttribute("loginUser");
		List<Card> cards = cardService.findCardsByUid(uid);
		if (cards != null && cards.size() >= 5) {
			return "0";
		}
		return "1";
	}
	
	/**
	 * 去添加银行卡界面
	 */
	@RequestMapping(value = "/tocard_add")
	public String tocard_add(){
		return "/card_add";
	}
	
	/**
	 * 添加银行卡
	 */
	@RequestMapping(value = "/card_add")
	public String  card_add(HttpServletRequest request,String name,
			String identification_card, String card, String phone){
		Long uid = (Long) request.getSession().getAttribute("loginUser");
		//返回状态码，看是否绑定成功
		String ztm = cardService.insertCard(name,identification_card,card,phone,uid);
		return "redirect:/mycard?uid="+uid;
	}

}
