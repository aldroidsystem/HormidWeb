/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.lapak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.core.database.BaseController;
import com.aldroid.hormid.lapak.bean.VehicleBean;
import com.aldroid.hormid.lapak.dao.VehicleDao;

import java.util.List;

import javax.annotation.PostConstruct;

/**
 *
 * @author renaldo
 */
@Service
public class VehicleController extends BaseController<VehicleBean>{

    @Autowired
    VehicleDao dao;
    
    @PostConstruct
    void setDao(){
        super.dao = this.dao;
    }
    
    public List<VehicleBean> selectByBranch(int branchPublicId) throws Exception{
        return dao.selectByBranch(branchPublicId);
    }

    public void deleteByBranchId(int branchId, int userId) throws Exception {
        List<VehicleBean> vehList = selectByBranch(branchId);
        if(vehList!= null && !vehList.isEmpty()){
            for(VehicleBean veh : vehList)
                dao.deleteByPublicId(veh.getPublicId(), userId);
        }
    }
    
    
}
