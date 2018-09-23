package com.erp.service.c.impl;

import com.erp.bean.Technology;
import com.erp.dao.TechnologyMapper;
import com.erp.service.c.TechnologyServiceInterface;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("technologyService")
public class TechnologyServiceImpl implements TechnologyServiceInterface {

    @Autowired
    TechnologyMapper technologyMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Technology> findTechnology() {

        List<Technology> list=technologyMapper.selectTechnology();
        return list;
    }

    @Override
    public Technology selectTechnologyById(String technologyId) {

        return technologyMapper.selectByPrimaryKey(technologyId);
    }

    @Override
    public List<Technology> selectTechnologyByName(String technologyName) {
        return technologyMapper.selectByName(technologyName);
    }

    @Override
    public void insertTechnology(Technology technology) {
        technologyMapper.insert(technology);
    }

    @Override
    public boolean deleteTechnologyById(String id) {
        int i = technologyMapper.deleteByPrimaryKey(id);
        return i==1;
    }

    @Override
    public void updateAll(Technology technology) {
        technologyMapper.updateByPrimaryKeySelective(technology);
    }
}
