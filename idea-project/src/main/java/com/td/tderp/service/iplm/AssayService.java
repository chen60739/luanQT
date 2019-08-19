package com.td.tderp.service.iplm;

import com.td.tderp.dao.AssayMapper;
import com.td.tderp.pojo.Assay;
import com.td.tderp.request.AssayForm;
import com.td.tderp.response.LayuiTableResult;
import com.td.tderp.service.IAssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssayService implements IAssayService {

    @Autowired
    AssayMapper assayMapper;

    @Override
    public LayuiTableResult getData(AssayForm assayForm) {
        List<Assay> assays = assayMapper.selectAll(assayForm);
        int count = assayMapper.selectCount(assayForm);
        return new LayuiTableResult(count,assays);
    }
}
