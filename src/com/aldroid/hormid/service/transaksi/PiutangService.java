/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.service.transaksi;


import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aldroid.hormid.generic.staticvar.HardcodeConfiguration;
import com.aldroid.hormid.generic.staticvar.Module;
import com.aldroid.hormid.mapper.transaksi.PiutangMapper;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.transaksi.Piutang;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class PiutangService{
	private static final Logger logger = Logger.getLogger(PiutangService.class);
	
    @Autowired(required=true)
    PiutangMapper piutangMapper;

    public void insert(Piutang bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setCreatedBy(authUser.getUsername());
            }  
    	}
    	
    	bean.setPiutangId(generatePiutangID());
    	piutangMapper.insert(bean);
    	
    	if(logger.isDebugEnabled()){
    		logger.debug("insert successfull!");
    	}
    }

    public Piutang selectUserPiutangDetail(String username) throws Exception {
        return piutangMapper.selectListUserHutang(username);
    }
    
    
    public List<Piutang> searchUserPiutangHistory(Piutang bean) throws Exception {
        return piutangMapper.selectPiutangHistory(bean);
    }
    
    private String generatePiutangID() throws Exception{
		long current = Calendar.getInstance().getTimeInMillis();
    	int diff = (int)((current-HardcodeConfiguration.APPS_BASE_DATE_MILIS)/ (1000*60*60*24));
    	Integer seqID = piutangMapper.selectNextSequenceID();
        return HardcodeConfiguration.APPS_AREA
        		+Module.PIUTANG.toString()
        		+Integer.toHexString(diff).toUpperCase()
        		+Integer.toHexString(seqID).toUpperCase();
    }


    public Piutang selectPiutangDetail(String piutangId) throws Exception {
        return piutangMapper.selectPiutangDetail(piutangId);
    }
    
    public List<User> searchUserPiutangByFullname(String fullname){
    	return piutangMapper.searchUserPiutangByFullname(fullname);
    }
}