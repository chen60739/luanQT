package com.td.tderp.dao;

import com.td.tderp.pojo.Assay;
import com.td.tderp.request.AssayForm;

import java.util.List;

public interface AssayMapper {
    int deleteByPrimaryKey(String id);

    int insert(Assay record);

    int insertSelective(Assay record);

    Assay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Assay record);

    int updateByPrimaryKeyWithBLOBs(Assay record);

    int updateByPrimaryKey(Assay record);

    List<Assay> selectAll(AssayForm assayForm);

    int selectCount(AssayForm assayForm);
}