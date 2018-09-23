package com.erp.service.e.impl;

import com.erp.bean.Employee;
import com.erp.bean.FinalMeasuretCheck;
import com.erp.bean.Product;
import com.erp.bean.UnqualifyApply;
import com.erp.dao.EmployeeMapper;
import com.erp.dao.FinalMeasuretCheckMapper;
import com.erp.service.e.FinalMeasuretCheckService;
import com.erp.utils.PageModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */
@Service
public class FinalMeasuretCheckServiceImply implements FinalMeasuretCheckService{
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<FinalMeasuretCheck> selectPartFinalMeasuretChecks(Integer page, Integer rows) {

        HashMap<Object, Object> hashMap = new HashMap<>();

        //设置分页显示的数据，并把limit,offset 存入map中
        Integer count = finalMeasuretCheckMapper.selectCountUnqualifyApplys();
        PageModelHelper.ModelHelper(page, rows, count, hashMap);

        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectPartFinalMeasuretChecks(hashMap);

        //设置员工名称
        for (FinalMeasuretCheck finalMeasuretCheck : finalMeasuretChecks) {
            String empId = finalMeasuretCheck.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            finalMeasuretCheck.setEmpName(empName);
        }
        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> search_fMeasureCheck_by_fMeasureCheckId(String searchValue, Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        //模糊查询参数
        String likeSearchValue = "%"+ searchValue + "%";

        FinalMeasuretCheck  finalMeasuretCheck  = new FinalMeasuretCheck ();
        finalMeasuretCheck.setfMeasureCheckId(likeSearchValue);
        hashMap.put("finalMeasuretCheck",finalMeasuretCheck);
        //查找出符合条件数据的总数，封装进分页工具中
        Integer count = finalMeasuretCheckMapper.selectCountFinalMeasuretChecksByCondition(finalMeasuretCheck);
        PageModelHelper.ModelHelper(page, rows, count, hashMap);


        //查找出符合查找条件并符合分页要求的数据
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectFinalMeasuretChecksByCondition(hashMap);

        //设置员工名称
        for (FinalMeasuretCheck fmc : finalMeasuretChecks) {
            String empId = fmc.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            fmc.setEmpName(empName);
        }
        return finalMeasuretChecks;
    }

    @Override
    public List<FinalMeasuretCheck> search_fMeasureCheck_by_orderId(String searchValue, Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        //模糊查询参数
        String likeSearchValue = "%"+ searchValue + "%";

        FinalMeasuretCheck  finalMeasuretCheck  = new FinalMeasuretCheck ();
        finalMeasuretCheck.setOrderId(likeSearchValue);
        hashMap.put("finalMeasuretCheck",finalMeasuretCheck);
        //查找出符合条件数据的总数，封装进分页工具中
        Integer count = finalMeasuretCheckMapper.selectCountFinalMeasuretChecksByCondition(finalMeasuretCheck);
        PageModelHelper.ModelHelper(page, rows, count, hashMap);


        //查找出符合查找条件并符合分页要求的数据
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.selectFinalMeasuretChecksByCondition(hashMap);

        //设置员工名称
        for (FinalMeasuretCheck fmc : finalMeasuretChecks) {
            String empId = fmc.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            fmc.setEmpName(empName);
        }
        return finalMeasuretChecks;
    }

    @Override
    public Integer insert(FinalMeasuretCheck finalMeasuretCheck) {
        int insert = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
        return insert;
    }

    @Override
    public void delete_batch(String[] ids) {
            for (String id : ids) {
                finalMeasuretCheckMapper.deleteByPrimaryKey(id);
            }
    }
}
