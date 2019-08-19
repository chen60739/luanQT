package com.td.tderp.service;

import com.td.tderp.request.AssayForm;
import com.td.tderp.response.LayuiTableResult;

public interface IAssayService {

    LayuiTableResult getData(AssayForm assayForm);
}
