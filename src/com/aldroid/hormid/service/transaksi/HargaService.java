/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.service.transaksi;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.mapper.transaksi.HargaMapper;
import com.aldroid.hormid.model.transaksi.Harga;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class HargaService{
	private static final Logger logger = Logger.getLogger(HargaService.class);
	
    @Autowired(required=true)
    HargaMapper hargaMapper;

    @Autowired
	private GlobalSessionObject globalSessionObject;

    public void insert(Harga bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setCreatedBy(authUser.getUsername());
            }  
    	}
    	
    	hargaMapper.insert(bean);
    }

    public List<Harga> select() throws Exception {
    	List<Harga> harga = hargaMapper.selectAll();
        return harga;
    }

    public Harga getHargaSekarang() throws Exception {
    	return hargaMapper.getHargaSekarang();
    }
}