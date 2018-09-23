package com.erp.service.e;

import com.erp.bean.ProcessMeasureCheck;

import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */
public interface ProcessMeasureCheckService {
    List<ProcessMeasureCheck> selectPartProcessMeasureChecks(Integer page, Integer rows);

    List<ProcessMeasureCheck> search_pMeasureCheck_by_pMeasureCheckId(String searchValue, Integer page, Integer rows);
}
