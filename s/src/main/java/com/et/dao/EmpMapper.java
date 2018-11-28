package com.et.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.et.bean.Emp;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empId);
    
    int deleteBatchByPrimaryKay(List<Integer> delList);

    int insert(Emp record);

    Emp selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
    
    List<Emp> getEmps(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    int getEmpTotal();

}