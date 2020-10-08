package com.aldroid.hormid.service.transaksi;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aldroid.hormid.generic.staticvar.HardcodeConfiguration;
import com.aldroid.hormid.generic.staticvar.Module;
import com.aldroid.hormid.mapper.transaksi.TimbangGantungMapper;
import com.aldroid.hormid.model.transaksi.TimbangGantung;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class TimbangGantungService{
	private static final Logger logger = Logger.getLogger(TimbangGantungService.class);
	
    @Autowired(required=true)
    TimbangGantungMapper timbangGantungMapper;

    public void insert(TimbangGantung bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setCreatedBy(authUser.getUsername());
            }
    	}
    	
    	bean.setNoNota(generateNoNota());
    	timbangGantungMapper.insert(bean);
    }

    public TimbangGantung selectTimbangGantungDetail(String noNota) throws Exception {
        return timbangGantungMapper.selectTimbangGantungDetail(noNota);
    }
    
    
    private String generateNoNota() throws Exception{
		long current = Calendar.getInstance().getTimeInMillis();
    	int diff = (int)((current-HardcodeConfiguration.APPS_BASE_DATE_MILIS)/ (1000*60*60*24));
    	Integer seqID = timbangGantungMapper.selectNextSequenceID();
        return HardcodeConfiguration.APPS_AREA
        		+Module.TIMBANG_GANTUNG.toString()
        		+Integer.toHexString(diff).toUpperCase()
        		+Integer.toHexString(seqID).toUpperCase();
    }    
}