package com.shan.org.shan.sxs.service;

import java.util.List;

import com.shan.org.shan.sxs.pojo.User;

public interface UserService {

	User treeIndex(Long userId);

	User findUserByUid(Long userId);

	User findUserTelByUid(Long userId);

	User loginByUsername(String username);

	List<Long> findWalletByUid(Long userId);

}
