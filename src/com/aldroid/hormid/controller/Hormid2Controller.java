package com.aldroid.hormid.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class Hormid2Controller {
	private static final Logger logger = Logger.getLogger(Hormid2Controller.class);
	
	@RequestMapping(value="/error3",method=RequestMethod.GET)
    public String testError3(Model m){
		logger.info("[RequestMapping:/error3]-"+"method:testError3"); 
    	logger.info("Test INFO");
    	logger.warn("Test WARN");
    	logger.debug("Test DEBUG");
    	logger.error("Test ERROR");
    	logger.fatal("Test FATAL");
    	logger.trace("Test TRACE");
		String a="abc";
		Integer b = Integer.valueOf(a);
		m.addAttribute("param", "error3; harga="+b);
        return "test";
    }

	@RequestMapping(value="/error4",method=RequestMethod.GET)
    public String testError4(Model m) {
		logger.info("[RequestMapping:/error4]-"+"method:testError4"); 
		try{
			String a="abc";
			Integer b = Integer.valueOf(a);		
		} catch (Exception e){
    		StringWriter stack = new StringWriter();
    		e.printStackTrace(new PrintWriter(stack));
    		logger.error(stack.toString());
		}
		m.addAttribute("param", "error4");
        return "test";
    }
	
	@RequestMapping(value="/error5",method=RequestMethod.GET)
    public String testError5(Model m) {
		logger.info("[RequestMapping:/error5]-"+"method:testError5"); 

		logger.error(new Exception("Manual Exception error5"));
		m.addAttribute("param", "error5");
        return "test";
    }
}