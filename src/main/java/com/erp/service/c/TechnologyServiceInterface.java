package com.erp.service.c;

import com.erp.bean.Technology;

import java.util.List;

public interface TechnologyServiceInterface {
    List<Technology> findTechnology();

    Technology selectTechnologyById(String technologyId);

    List<Technology> selectTechnologyByName(String technologyName);

    void insertTechnology(Technology technology);

    boolean deleteTechnologyById(String id);

    void updateAll(Technology technology);
}
