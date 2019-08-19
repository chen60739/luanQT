package com.td.tderp.dao;

import com.td.tderp.pojo.AssayDetails;

public interface AssayDetailsMapper {
    int deleteByPrimaryKey(String id);

    int insert(AssayDetails record);

    int insertSelective(AssayDetails record);

    AssayDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AssayDetails record);

    int updateByPrimaryKey(AssayDetails record);
}