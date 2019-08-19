package com.td.tderp.service;

import com.td.tderp.request.SamplingForm;
import com.td.tderp.response.LayuiTableResult;

public interface ISamplingService {

    LayuiTableResult getData(SamplingForm samplingForm);
}
