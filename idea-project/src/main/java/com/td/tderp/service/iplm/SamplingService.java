package com.td.tderp.service.iplm;

import com.td.tderp.dao.SamplingMapper;
import com.td.tderp.pojo.Sampling;
import com.td.tderp.request.SamplingForm;
import com.td.tderp.response.LayuiTableResult;
import com.td.tderp.service.ISamplingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SamplingService implements ISamplingService {

    @Autowired
    SamplingMapper samplingMapper;


    @Override
    public LayuiTableResult getData(SamplingForm samplingForm) {
        List<Sampling> samplings = samplingMapper.selectSampling(samplingForm);
        int count = samplingMapper.selectCount(samplingForm);
        return new LayuiTableResult(count,samplings);
    }
}
