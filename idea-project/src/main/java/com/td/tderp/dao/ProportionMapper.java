package com.td.tderp.dao;

import com.td.tderp.pojo.Proportion;

public interface ProportionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Proportion record);

    int insertSelective(Proportion record);

    Proportion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Proportion record);

    int updateByPrimaryKey(Proportion record);
}