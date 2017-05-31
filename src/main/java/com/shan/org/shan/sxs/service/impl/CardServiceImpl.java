package com.shan.org.shan.sxs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shan.org.shan.sxs.dao.CardDao;
import com.shan.org.shan.sxs.pojo.Card;
import com.shan.org.shan.sxs.pojo.CardQuery;
import com.shan.org.shan.sxs.service.CardService;
import com.shan.org.shan.sxs.utils.BatchDateUtil;
import com.shan.org.shan.sxs.utils.ConvertNum;

@Service
@Transactional
public class CardServiceImpl implements CardService{

	@Autowired
	private CardDao cardDao;
	
	@Override
	public List<Card> findCardsByUid(Long uid) {
		CardQuery query = new CardQuery();
		query.createCriteria().andUserIdEqualTo(uid);
		List<Card> cards = cardDao.selectByExample(query);
		for (Card card : cards) {
			String cardNo = ConvertNum.getCardNo(card.getCard());
			card.setCardnum(cardNo);
		}
		return cards;
	}
	@Override
	public String insertCard(String name, String identification_card, String cardNo, String phone, Long uid) {
		Card card = new Card();
		card.setBank("**yh");//TODO 由银行卡号判断
		card.setCard(Long.parseLong(cardNo));
		card.setCreateTime(BatchDateUtil.getBatch(new Date()));
		card.setIdentificationCard(identification_card);
		card.setName(name);
		card.setPhone(Long.parseLong(phone));
		card.setUserId(uid);
		cardDao.insert(card);
		return null;//返回银行卡绑定状态
	}

}
