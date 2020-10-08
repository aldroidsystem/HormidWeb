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
import com.aldroid.hormid.mapper.transaksi.PabrikMapper;
import com.aldroid.hormid.model.lapak.Pabrik;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class PabrikService{
	private static final Logger logger = Logger.getLogger(PabrikService.class);
	
    @Autowired(required=true)
    PabrikMapper pabrikMapper;
    
    public void upsert(Pabrik bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setUpdatedBy(authUser.getUsername());
            }
    	}
    	
    	if (bean.getPabrikId() == null || bean.getPabrikId() < 1){
        	pabrikMapper.insert(bean);
        	if(logger.isDebugEnabled()){
        		logger.debug("insert successfull!");
        	}
    	} else {
        	pabrikMapper.update(bean);
        	if(logger.isDebugEnabled()){
        		logger.debug("update successfull!");
        	}
    	}
    }

    
    public Pabrik selectPabrikDetil(Integer pabrikId) throws Exception {
        return pabrikMapper.selectPabrik(pabrikId);
    }
    

    public List<Pabrik> selectPabrikAll() throws Exception {
        return pabrikMapper.selectListPabrik();
    }
}