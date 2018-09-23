package com.erp.dao;

import com.erp.bean.Technology;
import com.erp.bean.TechnologyPlan;
import com.erp.bean.device.TechnologyPlanVo;

import java.util.List;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlanVo> selectAll(TechnologyPlan technologyPlan);

    List<TechnologyPlanVo>  selectTechnologyByName(String searchValue);

    List<TechnologyPlanVo> selectAllTec();
}