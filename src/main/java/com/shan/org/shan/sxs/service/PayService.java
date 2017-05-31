package com.shan.org.shan.sxs.service;

import java.util.List;

import com.shan.org.shan.sxs.pojo.Pay;

public interface PayService {

	List<Pay> selectpay(Long userId);
}
