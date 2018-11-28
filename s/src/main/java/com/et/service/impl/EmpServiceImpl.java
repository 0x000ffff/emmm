package com.et.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.bean.Emp;
import com.et.bean.Page;
import com.et.dao.EmpMapper;
import com.et.service.IEmpService;

@Service(value="EmpServiceImpl")
public class EmpServiceImpl implements IEmpService{
    
    @Autowired
    EmpMapper mapper;
    @Override
    public String deleteByPrimaryKey(Integer empId) {
        // TODO Auto-generated method stub
        int result = mapper.deleteByPrimaryKey(empId);
        StringBuffer sb = new StringBuffer("");
        if(result<=0) {
            sb.append("删除失败");
        }else {
            sb.append("删除成功");
        }
        return sb.toString();
    }
    
    public String deleteBatchByPrimaryKay(List<Integer> delList) {
        int result = mapper.deleteBatchByPrimaryKay(delList);
        StringBuffer sb = new StringBuffer("");
        if(result<=0) {
            sb.append("删除失败");
        }else {
            sb.append("删除"+result+"条记录");
        }
        return sb.toString();
    }

    @Override
    public String insert(Emp record) {
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
    public Emp selectByPrimaryKey(Integer empId) {
        // TODO Auto-generated method stub
        
        Emp emp = mapper.selectByPrimaryKey(empId);
        return emp;
    }

    @Override
    public String updateByPrimaryKeySelective(Emp record) {
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
    public String updateByPrimaryKey(Emp record) {
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
    public Page<Emp> getEmps(Integer pageNumber,Integer pageSize) {
        // TODO Auto-generated method stub
        int total = mapper.getEmpTotal();
        Page<Emp> ret = new Page<Emp>();
        ret.setPageNumber(pageNumber);
        ret.setPageSize(pageSize);
        ret.setTotal(total);
        List<Emp> list = mapper.getEmps(ret.getStart(),ret.getPageSize());
        ret.setData(list);
        return ret;
    }

}
