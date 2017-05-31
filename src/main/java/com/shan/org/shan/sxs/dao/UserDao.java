package com.shan.org.shan.sxs.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.shan.org.shan.sxs.pojo.User;
import com.shan.org.shan.sxs.pojo.UserQuery;

public interface UserDao {
    int countByExample(UserQuery example);

    int deleteByExample(UserQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserQuery example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserQuery example);

    int updateByExample(@Param("record") User record, @Param("example") UserQuery example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> selectByUserQuery(UserQuery query);
	
	int countByUserQuery(UserQuery query);

	List<User> importUser(UserQuery query);

	User treeIndex(Long userId);

	User findUserTelByUid(Long userId);

	User findUserByUsername(String username);

}