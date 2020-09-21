package com.aldroid.hormid.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.service.generic.UserService;
import com.aldroid.hormid.validator.generic.UserValidator;


@Controller
@RequestMapping("/lapak")
public class LapakController {
	private static final Logger logger = Logger.getLogger("activityLogger");

    @Autowired
	private GlobalSessionObject globalSessionObject;

    @Autowired
    private UserService userService;
    
	@Autowired
	private UserValidator userValidator;
	
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


	

	@RequestMapping(value="/profile",
			method=RequestMethod.GET)
    public String profile(Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());

		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
        if (authUser == null || authUser.getUsername()==null || authUser.getUsername().equals("")) {
        	return "notfound";
        }  
        String username=authUser.getUsername();
		User user = userService.findByUsername(username);
			
		if (user == null || user.getUsername() == null){
            return "notfound";
		}
		
        model.addAttribute("userForm", user);
        model.addAttribute("passwordForm", new User());
        model.addAttribute("properties_village", globalSessionObject.getPropertiesByCode("village").getDaftarKata());
        return "profile";
    }
	

	@RequestMapping(value="/resetPassword",method=RequestMethod.POST)
    public String resetPassword(@ModelAttribute("passwordForm") User user, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		userValidator.validatePasswordAdmin(user, bindingResult);


        model.addAttribute("userForm", userService.findByUsername(user.getUsername()));
        model.addAttribute("properties_village", globalSessionObject.getPropertiesByCode("village").getDaftarKata());
        
        if (bindingResult.hasErrors()) {
            return "profile";
        }

        try{
        	userService.resetPassword(user);
            model.addAttribute("notification", "success");
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());        
            model.addAttribute("notification", "fail");
        }
        
        user.setPassword(null);
		user.setPasswordConfirm(null);
        model.addAttribute("passwordForm", user);
        return "profile";
    }
	
	

	@RequestMapping(value="/profileUpdate",method=RequestMethod.POST)
    public String profileUpdate(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model, HttpServletRequest request) throws Exception {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		userValidator.validate(user, bindingResult);


        model.addAttribute("properties_village", globalSessionObject.getPropertiesByCode("village").getDaftarKata());
        model.addAttribute("passwordForm", new User());
        
        if (bindingResult.hasErrors()) {
            return "profile";
        }

        try{
        	userService.updateProfile(user);
            model.addAttribute("notification", "success");
        } catch (Exception e){
        	CommonProcess.logException(e, getClass());        
            model.addAttribute("notification", "fail");
        }

        model.addAttribute("userForm", userService.findByUsername(user.getUsername()));
        return "profile";
    }
}