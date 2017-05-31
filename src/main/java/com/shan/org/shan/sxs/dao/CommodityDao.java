package com.shan.org.shan.sxs.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.shan.org.shan.sxs.pojo.Commodity;
import com.shan.org.shan.sxs.pojo.CommodityQuery;

public interface CommodityDao {
    int countByExample(CommodityQuery example);

    int deleteByExample(CommodityQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExample(CommodityQuery example);

    Commodity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityQuery example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityQuery example);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}