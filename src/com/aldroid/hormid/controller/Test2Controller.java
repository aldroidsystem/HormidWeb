package com.aldroid.hormid.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.aldroid.hormid.service.lapak.HargaService;


@Controller
public class Test2Controller {
	private static final Logger logger = Logger.getLogger(Test2Controller.class);
	
	@Autowired
	private HargaService hargaService;
	

	@RequestMapping(value="/error3",method=RequestMethod.GET)
    public String testError3(ViewControllerRegistry registry){
		logger.info("[RequestMapping:/error]-"+"method:testError"); 
		logger.info("Test INFO");
    	logger.warn("Test WARN");
    	logger.debug("Test DEBUG");
    	logger.error("Test ERROR");
    	logger.fatal("Test FATAL");
    	logger.trace("Test TRACE");
        return "test";
    }

	@RequestMapping(value="/error4",method=RequestMethod.GET)
    public String testError4(ViewControllerRegistry registry) {
		String a="abc";
		Integer b = Integer.valueOf(a);
        return "test";
    }
}