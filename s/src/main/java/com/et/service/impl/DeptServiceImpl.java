package com.et.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.bean.Dept;
import com.et.dao.DeptMapper;
import com.et.service.IDeptService;

@Service("DeptServiceImpl")
public class DeptServiceImpl implements IDeptService{

    @Autowired
    DeptMapper mapper;
    
    @Override
    public String deleteByPrimaryKey(Integer deptId) {
        // TODO Auto-generated method stub
        int result = mapper.deleteByPrimaryKey(deptId);
        StringBuffer sb = new StringBuffer("");
        if(result<=0) {
            sb.append("删除失败");
        }else {
            sb.append("删除成功");
        }
        return sb.toString();
    }

    @Override
    public String insert(Dept record) {
        // TODO Auto-generated method stub
        int result = mapper.insert(record);
        StringBuffer sb = new StringBuffer("");
        if(result<=0) {
            sb.append("添加失败");
        }else {
            sb.append("添加成功");
        }
        return sb.toString();
    }

    @Override
    public Dept selectByPrimaryKey(Integer deptId) {
        // TODO Auto-generated method stub
        Dept dept = mapper.selectByPrimaryKey(deptId);
        return dept;
    }

    @Override
    public String updateByPrimaryKeySelective(Dept record) {
        // TODO Auto-generated method stub
        int result = mapper.updateByPrimaryKeySelective(record);
        StringBuffer sb = new StringBuffer("");
        if(result<=0) {
            sb.append("修改失败");
        }else {
            sb.append("修改成功");
        }
        return sb.toString();
    }

    @Override
    public String updateByPrimaryKey(Dept record) {
        // TODO Auto-generated method stub
        int result = mapper.updateByPrimaryKey(record);
        StringBuffer sb = new StringBuffer("");
        if(result<=0) {
            sb.append("修改失败");
        }else {
            sb.append("修改成功");
        }
        return sb.toString();
    }

    @Override
    public List<Dept> getDepts() {
        // TODO Auto-generated method stub
        List<Dept> list = mapper.getDepts();
        return list;
    }
    
}
