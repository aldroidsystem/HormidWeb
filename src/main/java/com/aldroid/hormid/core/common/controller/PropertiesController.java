/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.core.common.controller;

import com.aldroid.hormid.core.common.bean.PropertiesBean;
import com.aldroid.hormid.core.common.bean.SessionBean;
import com.aldroid.hormid.core.common.dao.PropertiesDao;
import com.aldroid.hormid.core.database.SelectResultBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author renaldo
 */
@Service
public class PropertiesController {
    @Autowired
    PropertiesDao propertiesDao;
    
    @Autowired
    SessionBean sessionBean;
    
    
    public void updateById(PropertiesBean bean) throws Exception{
        propertiesDao.updateById(bean);
        sessionBean.updatePropertiesById(bean);
    }
    
    public PropertiesBean selectById(int id) throws Exception{
        return propertiesDao.selectById(id);
    }
    
    public PropertiesBean selectByCode(String code) throws Exception{
        return propertiesDao.selectByCode(code);
    }
    
    public List<PropertiesBean> selectAll() throws Exception{
        return propertiesDao.selectAll();
    }
    
    public SelectResultBean<PropertiesBean> selectPage(SelectResultBean<PropertiesBean> selectBean) throws Exception {
        Integer count=propertiesDao.selectCountAll();
        selectBean.countPage(count);
        
        if(selectBean.getPageCount()>0){
            List<PropertiesBean> data = propertiesDao.selectPage(
                    selectBean.getLimit(), 
                    selectBean.getOffset());
            selectBean.setData(data);
        }
        return selectBean;
    }
}
