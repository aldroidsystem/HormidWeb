package com.aldroid.hormid.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aldroid.hormid.service.generic.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class);

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
    public String selectUser(Model m) throws Exception {
		logger.info("[RequestMapping:/user]-"+"method:selectUser"); 
        return "user";
    }
}