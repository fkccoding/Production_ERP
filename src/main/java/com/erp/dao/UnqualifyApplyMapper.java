package com.erp.dao;

import com.erp.bean.UnqualifyApply;

import java.util.HashMap;
import java.util.List;

public interface UnqualifyApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    List<UnqualifyApply> selectPartUnqualifyApplys(HashMap map);

    Integer selectCountUnqualifyApplys();

    List<UnqualifyApply> search_unqualify_by_unqualifyId(HashMap<Object, Object> hashMap);

    List<UnqualifyApply> search_unqualify_by_productName(HashMap<Object, Object> hashMap);

    Integer selectCountUnqualifyApplysByCondition(UnqualifyApply unqualifyApply);

    List<UnqualifyApply> selectUnqualifyApplysByCondition(HashMap map);

    Integer selectCountUnqualifyApplysByName(UnqualifyApply unqualifyApply);
}