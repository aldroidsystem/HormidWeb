/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.core.common.bean.SessionBean;
import com.aldroid.hormid.core.database.BaseController;
import com.aldroid.hormid.user.bean.UserBean;
import com.aldroid.hormid.user.controller.EmployeeController;

import javax.annotation.PostConstruct;

/**
 *
 * @author renaldo
 */
@Service
public class TestController extends BaseController<UserBean>{

    @Autowired
    TestDao dao;
    
    @Autowired
    SessionBean sessionBean;
    
    @Autowired
    EmployeeController employeeController;
    
    public TestController() {
    }
    
    @PostConstruct
    void setDao(){
        super.dao = this.dao;
    }
    
    public String selectDual() throws Exception {
        return dao.selectDual().get(0);
    }
    
    
}