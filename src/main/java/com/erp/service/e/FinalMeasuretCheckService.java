package com.erp.service.e;

import com.erp.bean.FinalMeasuretCheck;

import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/31
 */
public interface FinalMeasuretCheckService {
    List<FinalMeasuretCheck> selectPartFinalMeasuretChecks(Integer page, Integer rows);

    List<FinalMeasuretCheck> search_fMeasureCheck_by_fMeasureCheckId(String searchValue, Integer page, Integer rows);

    List<FinalMeasuretCheck> search_fMeasureCheck_by_orderId(String searchValue, Integer page, Integer rows);

    Integer insert(FinalMeasuretCheck finalMeasuretCheck);

    void delete_batch(String[] ids);
}

