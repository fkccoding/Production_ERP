package com.erp.service.c;

import com.erp.bean.Process;

import java.util.List;

public interface ProcessService {

    List<Process> findAll(Process process);

    boolean insertProcess(Process process);

    boolean delete(String[] ids);

    boolean updateAll(Process process);
}
