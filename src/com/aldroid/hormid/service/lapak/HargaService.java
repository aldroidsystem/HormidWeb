/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.service.lapak;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aldroid.hormid.mapper.lapak.HargaMapper;
import com.aldroid.hormid.model.lapak.Harga;


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
    

    public void insert(Harga bean) throws Exception {
    	hargaMapper.insert(bean);
    }

    public List<Harga> select() throws Exception {
    	List<Harga> harga = hargaMapper.selectAll();
		for(Harga har : harga){
			logger.info(har.getTanggalMulai()+","+har.getCreatedBy()+","+har.getHargaBeli());
		}
        return harga;
    }

    public String selectError() {
    	System.out.println("---------------selectError()");
    	logger.info("Test INFO");
    	logger.warn("Test WARN");
    	logger.debug("Test DEBUG");
    	logger.error("Test ERROR");
    	logger.fatal("Test FATAL");
    	logger.trace("Test TRACE");
		String a="abc";
		Integer b = Integer.valueOf(a);
		return b.toString();
    }
    

    public String selectError2() {
    	System.out.println("---------------selectError2()");
    	try{
    		logger.error(new Exception("Test manual Exception"));
    		logger.error("Test manual Error");
    		String a="abc";
    		Integer b = Integer.valueOf(a);
    		return b.toString();
    	} catch(Exception e){
    		StringWriter stack = new StringWriter();
    		e.printStackTrace(new PrintWriter(stack));
    		logger.error(stack.toString());
    	}
    	return null;
    }
}