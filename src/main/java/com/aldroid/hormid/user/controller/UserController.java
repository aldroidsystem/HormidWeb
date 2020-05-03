/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.core.common.bean.SessionBean;
import com.aldroid.hormid.core.database.BaseController;
import com.aldroid.hormid.user.bean.UserBean;
import com.aldroid.hormid.user.dao.UserDao;

import javax.annotation.PostConstruct;

/**
 *
 * @author renaldo
 */
@Service
public class UserController extends BaseController<UserBean>{

    @Autowired
    UserDao dao;
    
    @Autowired
    SessionBean sessionBean;
    
    @Autowired
    EmployeeController employeeController;
    
    public UserController() {
    }
    
    @PostConstruct
    void setDao(){
        super.dao = this.dao;
    }
    
    public boolean isUserExists(String username) {
        return dao.countUsername(username) > 0;
    }
    
    public UserBean login(UserBean bean) throws Exception{        
    	UserBean user=dao.login(bean);
        sessionBean.setUser(user);
        return user;
    }

    @Override
    public UserBean selectByPublicId(int id) throws Exception {
        UserBean user = dao.selectByPublicId(id);
        if(user!=null && user.getReferenceId() != null){
            user.setEmployee(employeeController.selectByPublicId(user.getReferenceId()));
        }
        return user;
    }

    public void deleteByEmployeeId(int empId, int userId) throws Exception {
        super.deleteById(empId, userId);
    }
    
    
}