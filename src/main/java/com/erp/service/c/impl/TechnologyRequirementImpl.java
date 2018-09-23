package com.erp.service.c.impl;

import com.erp.bean.Technology;
import com.erp.bean.TechnologyRequirement;
import com.erp.bean.device.TechnologyRequirementVo;
import com.erp.dao.TechnologyRequirementMapper;
import com.erp.service.c.TechnologyRequirementInterface;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("requirementService")
public class TechnologyRequirementImpl implements TechnologyRequirementInterface {

    @Autowired
    TechnologyRequirementMapper requirementMapper;
    @Autowired
    private SqlSessionFactory sessionFactory;

    @Override
    public List<TechnologyRequirementVo> findAll() {
        List<TechnologyRequirementVo> list = requirementMapper.selectAll();
        return list;
    }

    @Override
    public List<TechnologyRequirementVo> selectTechnologyRequirementByName(String searchValue) {
        Technology technology=requirementMapper.selectTechnology(searchValue);
        List<TechnologyRequirementVo> list=requirementMapper.selectByName(technology);

        return list;
    }

    @Override
    public TechnologyRequirementVo selectTechnologyRequirementById(String searchValue) {
        TechnologyRequirement requirement=requirementMapper.selectById(searchValue);
        TechnologyRequirementVo requirementVo = requirementMapper.selectByRequirement(requirement);
        return requirementVo;
    }

    @Override
    public boolean insert(TechnologyRequirement requirement) {
        int insert = requirementMapper.insert(requirement);
        return insert==1;
    }

    @Override
    public boolean delete(String[] ids) {
        boolean b=true;
        for (String technologyRequirementId:ids){
            int i=requirementMapper.deleteByPrimaryKey(technologyRequirementId);
            if (i==0){
                b=false;
            }
        }
        return b;
    }

    @Override
    public boolean updateAll(TechnologyRequirement requirement) {
        int i = requirementMapper.updateByPrimaryKey(requirement);
        return i==1;
    }
}
