package com.td.tderp.dao;

import com.td.tderp.pojo.OpLog;

public interface OpLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(OpLog record);

    int insertSelective(OpLog record);

    OpLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKey(OpLog record);
}