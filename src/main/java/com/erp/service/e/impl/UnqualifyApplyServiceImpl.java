package com.erp.service.e.impl;

import com.erp.bean.Employee;
import com.erp.bean.Product;
import com.erp.bean.UnqualifyApply;
import com.erp.dao.EmployeeMapper;
import com.erp.dao.ProductMapper;
import com.erp.dao.UnqualifyApplyMapper;
import com.erp.service.e.UnqualifyApplyService;
import com.erp.utils.PageModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/30
 */

@Service
public class UnqualifyApplyServiceImpl implements UnqualifyApplyService {

    @Autowired
    UnqualifyApplyMapper  unqualifyApplyMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<UnqualifyApply> selectPartUnqualifyApplys(Integer page, Integer rows) {

        HashMap<Object, Object> hashMap = new HashMap<>();

        //设置分页显示的数据，并把limit,offset 存入map中
        Integer count = unqualifyApplyMapper.selectCountUnqualifyApplys();
        PageModelHelper.ModelHelper(page, rows, count, hashMap);

        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectPartUnqualifyApplys(hashMap);
        for (UnqualifyApply unqualifyApplie : unqualifyApplies) {
            String productId = unqualifyApplie.getProductId();
            Product product = productMapper.selectByPrimaryKey(productId);
            String productName = product.getProductName();
            unqualifyApplie.setProductName(productName);

            String empId = unqualifyApplie.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            unqualifyApplie.setEmpName(empName);
        }
        return unqualifyApplies;
    }


    //按搜索条件中的ID进行模糊查询，返回数据
    @Override
    public List<UnqualifyApply> search_unqualify_by_unqualifyId(String searchValue, Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        //模糊查询参数
        String likeSearchValue = "%"+ searchValue + "%";

        UnqualifyApply unqualifyApply = new UnqualifyApply();
        unqualifyApply.setUnqualifyApplyId(likeSearchValue);
        hashMap.put("unqualifyApply",unqualifyApply);
        //查找出符合条件数据的总数，封装进分页工具中
        Integer count = unqualifyApplyMapper.selectCountUnqualifyApplysByCondition(unqualifyApply);
        PageModelHelper.ModelHelper(page, rows, count, hashMap);


        //查找出符合查找条件并符合分页要求的数据
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectUnqualifyApplysByCondition(hashMap);

        //设置产品名称,员工姓名
        for (UnqualifyApply unqualifyApplie : unqualifyApplies) {
            String productId = unqualifyApplie.getProductId();
            Product product = productMapper.selectByPrimaryKey(productId);
            String productName = product.getProductName();
            unqualifyApplie.setProductName(productName);

            String empId = unqualifyApplie.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            unqualifyApplie.setEmpName(empName);
        }
        return unqualifyApplies;
    }



    @Override
    public List<UnqualifyApply> search_unqualify_by_productName(String searchValue, Integer page, Integer rows) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        //模糊查询参数
        String likeSearchValue = "%"+ searchValue + "%";


        UnqualifyApply unqualifyApply = new UnqualifyApply();
        unqualifyApply.setProductName(likeSearchValue);
        hashMap.put("unqualifyApply",unqualifyApply);
        //查找出符合条件数据的总数，封装进分页工具中
        Integer count = unqualifyApplyMapper.selectCountUnqualifyApplysByName(unqualifyApply);
        PageModelHelper.ModelHelper(page, rows, count, hashMap);


        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.search_unqualify_by_productName(hashMap);

        //设置产品名称,员工姓名
        for (UnqualifyApply unqualifyApplie : unqualifyApplies) {
            String productId = unqualifyApplie.getProductId();
            Product product = productMapper.selectByPrimaryKey(productId);
            String productName = product.getProductName();
            unqualifyApplie.setProductName(productName);

            String empId = unqualifyApplie.getEmpId();
            Employee employee = employeeMapper.selectByPrimaryKey(empId);
            String empName = employee.getEmpName();
            unqualifyApplie.setEmpName(empName);
        }
        return unqualifyApplies;
    }

    @Override
    public Integer insert(UnqualifyApply unqualifyApply) {
        int insert = unqualifyApplyMapper.insert(unqualifyApply);
        return insert;
    }

    @Override
    public Integer update_all(UnqualifyApply unqualifyApply) {

        int i = unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);
        return i;
    }

    @Override
    public void delete_batch(String[] ids) {
        for (String id : ids) {
           unqualifyApplyMapper.deleteByPrimaryKey(id);
        }
    }
}
