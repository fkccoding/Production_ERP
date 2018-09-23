package com.erp.service.c;

import com.erp.bean.Process;
import com.erp.bean.TechnologyPlan;
import com.erp.bean.device.TechnologyPlanVo;

import java.util.List;

public interface TechnologyPlanService {

    List<TechnologyPlanVo> findAll(TechnologyPlan technologyPlan);

    List<TechnologyPlanVo> findByName(String searchValue);

    List<TechnologyPlanVo> findAlltechnology();

    boolean insert(TechnologyPlan technologyPlan);

    boolean delete(String[] ids);

    boolean updateAll(TechnologyPlan technologyPlan);
}
