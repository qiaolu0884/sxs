package com.shan.org.shan.sxs.service;

import java.math.BigDecimal;
import java.util.List;

import com.shan.org.shan.sxs.pojo.Order;

public interface OrderService {

	List<Order> findOrderByUser(Long userId, Integer pageNo);

	Long insertOrder(Long type, Long count, Long uid);

	List<Order> findOrderByUserAndQuery(Long userId, String begin, String end, Integer pageNo) throws Exception;

	Order findOrderByPriId(Long valueOf);

	Order findOrderByOrderNum(Long orderId);

}
