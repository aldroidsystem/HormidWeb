/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.core.common.bean;

import com.aldroid.hormid.core.common.controller.PropertiesController;
import com.aldroid.hormid.lapak.bean.HargaBean;
import com.aldroid.hormid.lapak.controller.HargaController;
import com.aldroid.hormid.user.bean.UserBean;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author renaldo
 */
@Component
public class SessionBean {
    
    private List<PropertiesBean> properties;
    
    private UserBean user;
    
    private HargaBean product;
    
    @Autowired
    PropertiesController propertiesController;
    
    @Autowired
    HargaController productController;

    public SessionBean() {
    }
    
    @PostConstruct
    void iniVariables() throws Exception {
        properties = propertiesController.selectAll();
//        loadProduct();
    }
    
    public void updatePropertiesByCode(PropertiesBean newBean) throws Exception{
        PropertiesBean bean = getPropertiesByCode(newBean.getCode());
        bean.setValue(newBean.getValue());
    }
    
    public void updatePropertiesById(PropertiesBean newBean) throws Exception{
        PropertiesBean bean = getPropertiesById(newBean.getId());
        bean.setValue(newBean.getValue());
    }
    
    public PropertiesBean getPropertiesByCode(String code) throws Exception{
        if (properties !=null && !properties.isEmpty()){
            Iterator<PropertiesBean> iterator = properties.iterator();
            while(iterator.hasNext()){
                PropertiesBean propertyTemp = iterator.next();
                if(propertyTemp.getCode().equals(code)){
                   return propertyTemp;
                }
            }
        }
        return null;
    }
    
    public PropertiesBean getPropertiesById(int id) throws Exception{
        if (properties !=null && !properties.isEmpty()){
            Iterator<PropertiesBean> iterator = properties.iterator();
            while(iterator.hasNext()){
                PropertiesBean propertyTemp = iterator.next();
                if(propertyTemp.getId()==id){
                   return propertyTemp;
                }
            }
        }
        return null;
    }
    
    public PropertiesBean getPropertiesByIndex(int id) throws Exception{
        if (id >=0 && properties != null && !properties.isEmpty()){
            return properties.get(id);
        }
        return null;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<PropertiesBean> getProperties() {
        return properties;
    }

    public HargaBean getProduct() {
        return product;
    }

//    
//    public void loadProduct() throws Exception {
//        product = productController.selectByPublicId(0);
//    }
}
