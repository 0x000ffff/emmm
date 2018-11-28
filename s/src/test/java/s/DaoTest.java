package s;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.et.bean.Emp;
import com.et.dao.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class DaoTest {

    @Autowired
    private EmpMapper empMapper;
    
    @Test
    public void DBtest() {
//        Emp emp = new Emp();
//        emp.setEmpName("a");
//        emp.setGender("m");
//        emp.setEmail("233424@fdsdfa.com");
//        emp.setDeptId(1);
//        for (int i = 0; i < 100; i++)
//            System.out.println(empMapper.insert(emp));
          System.out.println(empMapper.getEmps(0,100));
    }
}
