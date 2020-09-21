package com.aldroid.hormid.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.service.authentication.SecurityService;
import com.aldroid.hormid.service.generic.UserService;
import com.aldroid.hormid.validator.generic.UserValidator;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;


    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
	

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model,HttpServletRequest request) {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model,HttpServletRequest request) {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.registerUser(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:welcome";
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout,HttpServletRequest request) {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String firstPage(HttpServletRequest request) {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
        return "login";
    }
    
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, HttpServletResponse httpServletResponse,Model model) {
		CommonProcess.logUserActivity(this.getClass().getName(),new Object() {}.getClass().getEnclosingMethod().getName(), request.getServletPath());
		request.getSession().setAttribute("hellow", "ehehehe");
        return "welcome.tiles";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}