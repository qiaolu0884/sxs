package com.shan.org.shan.sxs.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shan.org.shan.sxs.dao.PayDao;
import com.shan.org.shan.sxs.pojo.Pay;
import com.shan.org.shan.sxs.service.PayService;
import com.shan.org.shan.sxs.utils.BatchDateUtil;
@Service
@Transactional
public class PayServiceImpl implements PayService {

	@Autowired
	private PayDao payDao;
	@Override
	public List<Pay> selectpay(Long userId) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		SimpleDateFormat df1 = new SimpleDateFormat("HH:mm");//设置日期格式
		
		List<Pay> list = payDao.selectpay(userId);
		for(Pay pay : list){
			Long createTime = pay.getCreateTime();
			String date = df.format(createTime);
			if(date.equals(BatchDateUtil.getCurrentDateTime())){
				pay.setFormartDate("今天");
				pay.setFDate(df.format(createTime));
			}else if(date.equals(BatchDateUtil.getYsetadyDateTime())){
				pay.setFormartDate("昨天");
				pay.setFDate(df.format(createTime));
			}else{
				pay.setFormartDate(date.substring(5, 9));
				pay.setFDate(df.format(createTime));
			}	
			
		}
		return list;
	}

}
