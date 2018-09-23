package com.erp.service.c.impl;

import com.erp.bean.Process;
import com.erp.dao.ProcessMapper;
import com.erp.service.c.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("/processService")
public class ProcessImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> findAll(Process process) {
        List<Process> list=processMapper.selectAll(process);
        return list;
    }

    @Override
    public boolean insertProcess(Process process) {
        int i = processMapper.insert(process);
        return i==1;
    }

    @Override
    public boolean delete(String[] ids) {
        boolean b=true;
        for (String processId:ids){
            int i=processMapper.deleteByPrimaryKey(processId);
            if (i==0){
                b=false;
            }
        }
        return b;
    }

    @Override
    public boolean updateAll(Process process) {
        int i = processMapper.updateByPrimaryKey(process);

        return i==1;
    }

}
