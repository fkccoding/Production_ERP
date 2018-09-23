package com.erp.dao;

import com.erp.bean.Technology;
import com.erp.bean.TechnologyRequirement;
import com.erp.bean.device.TechnologyRequirementVo;

import java.util.List;

public interface TechnologyRequirementMapper {
    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirementVo selectByRequirement(TechnologyRequirement technologyRequirement);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirementVo> selectAll();

    TechnologyRequirement selectById(String technologyRequirementId);

    List<TechnologyRequirementVo> selectByName(Technology technology);

    Technology selectTechnology(String technologyName);

}