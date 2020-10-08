package com.aldroid.hormid.service.transaksi;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aldroid.hormid.generic.staticvar.HardcodeConfiguration;
import com.aldroid.hormid.generic.staticvar.Module;
import com.aldroid.hormid.mapper.transaksi.TimbangJembatanMapper;
import com.aldroid.hormid.model.transaksi.TimbangJembatan;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class TimbangJembatanService{
	private static final Logger logger = Logger.getLogger(TimbangJembatanService.class);
	
    @Autowired(required=true)
    TimbangJembatanMapper timbangJembatanMapper;

    public void upsert(TimbangJembatan bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setTimbang1By(authUser.getUsername());
            }
    	}
    	
    	if (bean.getNoNota() == null || bean.getNoNota().equals("")){
    		insert(bean);
    	} else {
    		timbangJembatanMapper.update(bean);
    	}
    }

    public void bayar(TimbangJembatan bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setTimbang1By(authUser.getUsername());
            }
    	}
    	if (bean.getNoNota() == null || bean.getNoNota().equals("")){
    		insert(bean);
    	} else {
    		timbangJembatanMapper.update(bean);
    	}
    	timbangJembatanMapper.bayar(bean);
    }

    public void insert(TimbangJembatan bean) throws Exception {
    	bean.setNoNota(generateNoNota());
    	timbangJembatanMapper.insert(bean);
    }

    public TimbangJembatan selectTimbangJembatanTempDetail(String noNota) throws Exception {
        return timbangJembatanMapper.selectTimbangJembatanTempDetail(noNota);
    }

    public TimbangJembatan selectTimbangJembatanPaidDetail(String noNota) throws Exception {
        return timbangJembatanMapper.selectTimbangJembatanPaidDetail(noNota);
    }
    
    private String generateNoNota() throws Exception{
		long current = Calendar.getInstance().getTimeInMillis();
    	int diff = (int)((current-HardcodeConfiguration.APPS_BASE_DATE_MILIS)/ (1000*60*60*24));
    	Integer seqID = timbangJembatanMapper.selectNextSequenceID();
        return HardcodeConfiguration.APPS_AREA
        		+Module.TIMBANG_JEMBATAN.toString()
        		+Integer.toHexString(diff).toUpperCase()
        		+Integer.toHexString(seqID).toUpperCase();
    }    
    
    public List<TimbangJembatan> selectTimbangJembatanNotComplete() throws Exception{
    	return timbangJembatanMapper.selectTimbangJembatanNotComplete();
    }
}