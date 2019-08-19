package com.td.tderp.dao;

import com.td.tderp.pojo.Sampling;
import com.td.tderp.request.SamplingForm;

import java.util.List;

public interface SamplingMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sampling record);

    int insertSelective(Sampling record);

    Sampling selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sampling record);

    int updateByPrimaryKey(Sampling record);

    List<Sampling> selectSampling(SamplingForm samplingForm);

    int selectCount(SamplingForm samplingForm);
}