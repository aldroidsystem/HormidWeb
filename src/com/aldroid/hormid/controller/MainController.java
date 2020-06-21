package com.aldroid.hormid.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aldroid.hormid.model.lapak.User;
import com.aldroid.hormid.service.generic.SecurityService;
import com.aldroid.hormid.service.generic.UserService;
import com.aldroid.hormid.validator.UserValidator;


@Controller
@RequestMapping("/")
public class MainController {
	private static final Logger logger = Logger.getLogger("activityLogger");
	

    @Autowired
    private UserService userService;


    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
	

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:welcome";
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String firstPage(Model model) {
        return "login";
    }
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome.tiles";
    }
}