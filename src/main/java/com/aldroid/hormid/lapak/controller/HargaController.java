/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.lapak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.core.common.bean.SessionBean;
import com.aldroid.hormid.lapak.bean.HargaBean;
import com.aldroid.hormid.lapak.dao.HargaDao;


/**
 *
 * @author renaldo
 */
@Service
public class HargaController{

    @Autowired
    HargaDao dao;
    
    @Autowired
    SessionBean sessionBean;
    

    public void insert(HargaBean bean) throws Exception {
        dao.insert(bean);
}
}