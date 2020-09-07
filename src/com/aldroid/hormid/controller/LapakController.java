package com.aldroid.hormid.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aldroid.hormid.service.generic.HargaService;


@Controller
@RequestMapping("/lapak")
public class LapakController {
	private static final Logger logger = Logger.getLogger("activityLogger");
	
	@Autowired
	private HargaService hargaService;

	
	@RequestMapping(value="/eeq",method=RequestMethod.GET)
    public String addViewControllers(Model m) {
		logger.info("[RequestMapping:/test]-"+"method:addViewControllers"); 
		m.addAttribute("param", "eeq");
        return "test";
    }
	
	@RequestMapping(value="/harga",method=RequestMethod.GET)
    public String selectHarga(Model m) throws Exception {
		logger.info("[RequestMapping:/harga]-"+"method:selectHarga"); 
//		List<Harga> harga = hargaService.select();
//		m.addAttribute("harga",harga);
        return "harga";
    }


	@RequestMapping(value="/error",method=RequestMethod.GET)
    public String testError(Model m){
		logger.info("[RequestMapping:/error]-"+"method:testError"); 
		String harga = hargaService.selectError();
		m.addAttribute("param", "error; harga="+harga);
        return "test";
    }

	@RequestMapping(value="/error2",method=RequestMethod.GET)
    public String testError2(Model m) {
		logger.info("[RequestMapping:/error2]-"+"method:testError2"); 
		String harga = hargaService.selectError2();
		m.addAttribute("param", "error2; harga="+harga);
        return "test";
    }
}