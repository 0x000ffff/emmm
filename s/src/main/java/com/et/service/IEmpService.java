package com.et.service;

import java.util.List;

import com.et.bean.Emp;
import com.et.bean.Page;

public interface IEmpService {
    
    String deleteByPrimaryKey(Integer empId);
    
    String deleteBatchByPrimaryKay(List<Integer> delList);

    String insert(Emp record);

    Emp selectByPrimaryKey(Integer empId);

    String updateByPrimaryKeySelective(Emp record);

    String updateByPrimaryKey(Emp record);
    
    Page<Emp> getEmps(Integer pageNumber,Integer pageSize);
}
