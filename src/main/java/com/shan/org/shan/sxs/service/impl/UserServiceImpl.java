package com.shan.org.shan.sxs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shan.org.shan.sxs.dao.UserDao;
import com.shan.org.shan.sxs.pojo.User;
import com.shan.org.shan.sxs.pojo.UserQuery;
import com.shan.org.shan.sxs.port.GetWalletPort;
import com.shan.org.shan.sxs.port.LoginPort;
import com.shan.org.shan.sxs.port.getwallet.Basegetwallet;
import com.shan.org.shan.sxs.port.getwallet.GetWallet;
import com.shan.org.shan.sxs.port.login.Baselogin;
import com.shan.org.shan.sxs.port.login.Login;
import com.shan.org.shan.sxs.service.UserService;
import com.shan.org.shan.sxs.utils.BatchDateUtil;

import net.sf.json.JSONObject;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User treeIndex(Long userId) {
		return userDao.treeIndex(userId);
	}
	@Override
	public User findUserByUid(Long userId) {
		UserQuery query = new UserQuery();
		query.createCriteria().andUserIdEqualTo(userId);
		List<User> list = userDao.selectByExample(query);
		if(list != null&& list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public User findUserTelByUid(Long userId) {
		User user = userDao.findUserTelByUid(userId);
		return user;
	}
	//登陆
	@Override
	public User loginByUsername(String username) {
		User user = userDao.findUserByUsername(username);
		String login = LoginPort.login(username);
		JSONObject fromObject = JSONObject.fromObject(login);
		Baselogin bean = (Baselogin) JSONObject.toBean(fromObject, Baselogin.class);
		Login data = bean.getData().getData();
		if(user == null){
			User nuser = new User();
			nuser.setCreateTime(BatchDateUtil.getBatch(new Date()));
			nuser.setName(data.getName());
			nuser.setTelephone(Long.parseLong(data.getPhone()));
			nuser.setToken(bean.getToken());
			nuser.setUserGrade(data.getClassification());
			nuser.setUserId(Long.parseLong(data.getUser_id()));
			nuser.setUsername(data.getUsername());
			userDao.insertSelective(nuser);
		} else {
			user.setName(data.getName());
			user.setTelephone(Long.parseLong(data.getPhone()));
			user.setToken(bean.getToken());
			user.setUserGrade(data.getClassification());
		}
		return userDao.findUserByUsername(username);
	}
	@Override
	public List<Long> findWalletByUid(Long userId) {
		String wallet = GetWalletPort.getWallet(userId.toString());
		JSONObject fromObject = JSONObject.fromObject(wallet);
		//调用获取钱包的接口
		Basegetwallet bean = (Basegetwallet) JSONObject.toBean(fromObject, Basegetwallet.class);
		List<Long> moneys = new ArrayList<>();
		GetWallet[] wallets = bean.getData().getData();
		for (GetWallet w : wallets) {
			moneys.add(Long.parseLong(w.getMoney()));
		}
		return moneys;
	}
	
}
