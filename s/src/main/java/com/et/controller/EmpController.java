package com.et.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.bean.Emp;
import com.et.bean.Page;
import com.et.service.IEmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    @Qualifier("EmpServiceImpl")
    IEmpService service;

    @RequestMapping("/getEmps")
    @ResponseBody
    public Page<Emp> getEmps(Integer pageNumber, Integer pageSize) {
        Page<Emp> ret = service.getEmps(pageNumber, pageSize);
        return ret;
    }

    @RequestMapping("/deleteEmps")
    @ResponseBody
    public Map<String, String> deleteEmps(@RequestParam List<Integer> delList) {
        String result = service.deleteBatchByPrimaryKay(delList);
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("result", result);
        return ret;
    }

    @RequestMapping("/deleteEmp")
    @ResponseBody
    public Map<String, String> deleteByPrimaryKey(@RequestParam("empId") Integer empId) {
        String result = service.deleteByPrimaryKey(empId);
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("result", result);
        return ret;
    }

    @RequestMapping("/insertEmp")
    @ResponseBody
    public Map<String, String> insert(Emp emp) {
        System.out.println(emp);
        Map<String,String> ret = new HashMap<String,String>();
        String result = service.insert(emp);
        ret.put("result",result);
        return ret;
    }
}
