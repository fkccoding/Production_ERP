package com.erp.service.c;

import com.erp.bean.TechnologyRequirement;
import com.erp.bean.device.TechnologyRequirementVo;

import java.util.List;

public interface TechnologyRequirementInterface {
    List<TechnologyRequirementVo> findAll();

    List<TechnologyRequirementVo> selectTechnologyRequirementByName(String searchValue);

    TechnologyRequirementVo selectTechnologyRequirementById(String searchValue);

    boolean insert(TechnologyRequirement requirement);

    boolean delete(String[] ids);

    boolean updateAll(TechnologyRequirement requirement);
}
