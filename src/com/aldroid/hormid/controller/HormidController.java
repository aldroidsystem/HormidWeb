package com.aldroid.hormid.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.aldroid.hormid.model.lapak.Harga;
import com.aldroid.hormid.service.lapak.HargaService;


@Controller
public class HormidController {
	private static final Logger logger = Logger.getLogger("activityLogger");
	
	@Autowired
	private HargaService hargaService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
    public String addViewControllers(ViewControllerRegistry registry) {
		logger.info("[RequestMapping:/test]-"+"method:addViewControllers"); 
        return "test";
    }

	@RequestMapping(value="/",method=RequestMethod.GET)
    public String addView(Model m) {
		logger.info("[RequestMapping:/]-"+"method:addView"); 
        return "root";
    }
	
	@RequestMapping(value="/harga",method=RequestMethod.GET)
    public String selectHarga(Model m) throws Exception {
		logger.info("[RequestMapping:/harga]-"+"method:selectHarga"); 
		List<Harga> harga = hargaService.select();
		m.addAttribute("harga",harga);
        return "harga";
    }

	@RequestMapping(value="/error",method=RequestMethod.GET)
    public String testError(ViewControllerRegistry registry){
		logger.info("[RequestMapping:/error]-"+"method:testError"); 
		String harga = hargaService.selectError();
        return "test";
    }

	@RequestMapping(value="/error2",method=RequestMethod.GET)
    public String testError2(ViewControllerRegistry registry) {
		logger.info("[RequestMapping:/error2]-"+"method:testError2"); 
		String harga = hargaService.selectError2();
        return "test";
    }
}