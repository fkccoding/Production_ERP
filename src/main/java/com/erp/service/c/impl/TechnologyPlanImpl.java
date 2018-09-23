package com.erp.service.c.impl;

import com.erp.bean.Process;
import com.erp.bean.Technology;
import com.erp.bean.TechnologyPlan;
import com.erp.bean.device.TechnologyPlanVo;
import com.erp.dao.TechnologyPlanMapper;
import com.erp.service.c.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("/planService")
public class TechnologyPlanImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper planMapper;

    @Override
    public List<TechnologyPlanVo> findAll(TechnologyPlan technologyPlan) {

        return planMapper.selectAll(technologyPlan);
    }

    @Override
    public List<TechnologyPlanVo> findByName(String searchValue) {
        List<TechnologyPlanVo> list = planMapper.selectTechnologyByName(searchValue);
        return list;
    }

    @Override
    public List<TechnologyPlanVo> findAlltechnology() {
        return planMapper.selectAllTec();
    }

    @Override
    public boolean insert(TechnologyPlan technologyPlan) {
        int i = planMapper.insert(technologyPlan);
        return i==1;
    }

    @Override
    public boolean delete(String[] ids) {
        boolean b=true;
        for (String technologyRequirementId:ids){
            int i=planMapper.deleteByPrimaryKey(technologyRequirementId);
            if (i==0){
                b=false;
            }
        }
        return b;
    }

    @Override
    public boolean updateAll(TechnologyPlan technologyPlan) {

        int i = planMapper.updateByPrimaryKey(technologyPlan);
        return i==1;
    }

}
