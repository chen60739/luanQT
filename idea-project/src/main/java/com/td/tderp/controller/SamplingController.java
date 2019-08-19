package com.td.tderp.controller;

import com.td.tderp.request.SamplingForm;
import com.td.tderp.response.LayuiTableResult;
import com.td.tderp.service.ISamplingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sampling")
public class SamplingController {

    @Autowired
    ISamplingService samplingService;

    @RequestMapping("/list")
    public String list(){
        return "samplinglist.jsp";
    }

    @RequestMapping("/listdata")
    @ResponseBody
    public LayuiTableResult listData(SamplingForm samplingForm){
        LayuiTableResult data = samplingService.getData(samplingForm);
        return data;
    }
}
