package com.erp.service.e;

import com.erp.bean.UnqualifyApply;

import java.util.List;

/**
 * @Author:YueZhenLi
 * @Date:Created in 2018/8/30
 */

public interface UnqualifyApplyService {

     List<UnqualifyApply> selectPartUnqualifyApplys(Integer page, Integer rows);

     List<UnqualifyApply> search_unqualify_by_unqualifyId(String searchValue, Integer page, Integer rows);

     List<UnqualifyApply> search_unqualify_by_productName(String searchValue, Integer page, Integer rows);

     Integer insert(UnqualifyApply unqualifyApply);

     Integer update_all(UnqualifyApply unqualifyApply);

     void delete_batch(String[] ids);
}
