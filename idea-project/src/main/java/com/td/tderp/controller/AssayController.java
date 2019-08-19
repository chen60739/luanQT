package com.td.tderp.controller;

import com.td.tderp.request.AssayForm;
import com.td.tderp.response.LayuiTableResult;
import com.td.tderp.service.IAssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/assay")
public class AssayController {

    @Autowired
    IAssayService assayService;

    @RequestMapping("/List.do")
    public String list(){
        return "assaylist.jsp";
    }

    @RequestMapping("/listdata")
    @ResponseBody
    public LayuiTableResult listData(AssayForm assayForm){
        LayuiTableResult data = assayService.getData(assayForm);
        return data;
    }
}
