package com.shan.org.shan.sxs.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.shan.org.shan.sxs.pojo.Tree;
import com.shan.org.shan.sxs.pojo.TreeQuery;

public interface TreeDao {
    int countByExample(TreeQuery example);

    int deleteByExample(TreeQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Tree record);

    int insertSelective(Tree record);

    List<Tree> selectByExample(TreeQuery example);

    Tree selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tree record, @Param("example") TreeQuery example);

    int updateByExample(@Param("record") Tree record, @Param("example") TreeQuery example);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);
}