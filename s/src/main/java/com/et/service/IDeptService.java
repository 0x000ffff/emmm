package com.et.service;

import java.util.List;

import com.et.bean.Dept;

public interface IDeptService {
    
    String deleteByPrimaryKey(Integer deptId);

    String insert(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    String updateByPrimaryKeySelective(Dept record);

    String updateByPrimaryKey(Dept record);
     
    List<Dept> getDepts();
}
