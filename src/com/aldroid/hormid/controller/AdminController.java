package com.aldroid.hormid.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.model.generic.Properties;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.service.generic.PropertiesService;
import com.aldroid.hormid.service.generic.UserService;
import com.aldroid.hormid.validator.PropertiesValidator;
import com.aldroid.hormid.validator.UserValidator;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PropertiesService propertiesService;

	@Autowired
	private PropertiesValidator propertiesValidator;

	@Autowired
	private UserValidator userValidator;
	
    @Autowired
	private GlobalSessionObject globalSessionObject;

    @Autowired
    private UserService userService;

    
	@RequestMapping(value="/user",method=RequestMethod.GET)
    public String loadUser(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		model.addAttribute("listUser", new ArrayList<User>());
        model.addAttribute("userSearchForm", new User());
        return "user";
    }

	@RequestMapping(value="/user",method=RequestMethod.POST)
    public String userSearch(@ModelAttribute("userForm") User user, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("userSearchForm", user);
		model.addAttribute("listUser", userService.searchUser(user.getFullname()));
        return "user";
    }
	
	@RequestMapping(value="/userForm", 
			method=RequestMethod.GET)
    public String userForm(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("userForm", new User());
        model.addAttribute("properties_village", globalSessionObject.getPropertiesByCode("village").getDaftarKata());
        model.addAttribute("properties_roles", globalSessionObject.getRole());
        model.addAttribute("properties_rolemap", globalSessionObject.getRoleMap());
        return "userForm";
    }
	
	@RequestMapping(value="/userForm", 
			params = {"username"},
			method=RequestMethod.GET)
    public String userForm(@RequestParam(value = "username")String username,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		User user;
		if(username == null || username.equals("")){
            return "redirect:user";
		} else {
			user = userService.findByUsername(username);
			
			if (user == null || user.getUsername() == null){
	            return "redirect:user";
			}
		}
		
        model.addAttribute("userForm", user);
        model.addAttribute("properties_village", globalSessionObject.getPropertiesByCode("village").getDaftarKata());
        model.addAttribute("properties_roles", globalSessionObject.getRole());
        model.addAttribute("properties_rolemap", globalSessionObject.getRoleMap());
        return "userForm";
    }
	

	@RequestMapping(value="/userForm",method=RequestMethod.POST)
    public String userUpsertAction(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		userValidator.validate(user, bindingResult);
		
        if (bindingResult.hasErrors()) {
            model.addAttribute("userForm", user);
            return "userForm";
        }

		userService.upsert(user);
        return "redirect:properties";
    }
	
	@RequestMapping(value="/properties",method=RequestMethod.GET)
    public String properties(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		model.addAttribute("listProperties", globalSessionObject.getProperties());
        model.addAttribute("propertiesSearchForm", new Properties());
        return "properties";
    }

	@RequestMapping(value="/properties",method=RequestMethod.POST)
    public String propertiesSearch(@ModelAttribute("propertiesForm") Properties properties, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("propertiesSearchForm", properties);
		model.addAttribute("listProperties", globalSessionObject.searchPropertiesNameDetails(properties.getPropertyDesc()));
        return "properties";
    }
	
	@RequestMapping(value="/propertiesForm", 
			params = {"code"},
			method=RequestMethod.GET)
    public String propertiesAddForm(@RequestParam(value = "code")String code,Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		Properties properties;
		if(code == null || code.equals("")){
            return "redirect:properties";
		} else {
			properties = globalSessionObject.getPropertiesByCode(code);
			
			if (properties == null){
	            return "redirect:properties";
			}
		}
		
        model.addAttribute("propertiesForm", properties);
        return "propertiesForm";
    }
	
	
	@RequestMapping(value="/propertiesForm",method=RequestMethod.POST)
    public String propertiesUpdateAction(Properties properties, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		propertiesValidator.validate(properties, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("propertiesForm", properties);
            return "propertiesForm";
        }


    	Properties updateProperties = globalSessionObject.getPropertiesByCode(properties.getCode());
        try{
        	propertiesService.update(properties, updateProperties);
            model.addAttribute("propertiesForm", properties);
            model.addAttribute("notification", "success");
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());        
            model.addAttribute("propertiesForm", updateProperties);
            model.addAttribute("notification", "fail");
        }
        return "propertiesForm";
    }
}