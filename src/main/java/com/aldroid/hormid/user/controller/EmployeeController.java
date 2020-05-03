/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.core.database.BaseController;
import com.aldroid.hormid.user.bean.EmployeeBean;
import com.aldroid.hormid.user.dao.EmployeeDao;

import java.util.List;

import javax.annotation.PostConstruct;

/**
 *
 * @author renaldo
 */
@Service
public class EmployeeController extends BaseController<EmployeeBean>{

    @Autowired
    EmployeeDao dao;
    
    @Autowired
    UserController userController;
    
    @PostConstruct
    void setDao(){
        super.dao = this.dao;
    }
    
    public List<EmployeeBean> selectByBranch(int branchPublicId) throws Exception{
        return dao.selectByBranch(branchPublicId);
    }
    
    public List<EmployeeBean> selectEmployeeCorpNoUser() throws Exception{
        return dao.selectEmployeeCorpNoUser();
    }

    @Override
    public void deleteById(int id, int userId) throws Exception {
        userController.deleteByEmployeeId(id, userId);
        dao.deleteByPublicId(id, userId); 
    }
    
    public void deleteByBranchId(int branchId, int userId) throws Exception {
        List<EmployeeBean> employeeList = selectByBranch(branchId);
        if (employeeList!= null && ! employeeList.isEmpty()){
            for(EmployeeBean emp : employeeList){
                deleteById(emp.getPublicId(), userId);                
            }
        }
    }
    
}
