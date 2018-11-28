package com.et.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.bean.Dept;
import com.et.service.IDeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
    
    @Autowired
    @Qualifier("DeptServiceImpl")
    IDeptService service;
    
    @RequestMapping("/getDepts")
    @ResponseBody
    public List<Dept> getDepts(){
        List<Dept> ret = service.getDepts();
        return ret;
    }
    
}
