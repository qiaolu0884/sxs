package com.shan.org.shan.sxs.service;

import java.util.List;

import com.shan.org.shan.sxs.pojo.Card;

public interface CardService {

	List<Card> findCardsByUid(Long long1);

	String insertCard(String name, String identification_card, String card, String phone, Long uid);

}
