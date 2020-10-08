package com.aldroid.hormid.validator.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.service.generic.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
    	BindingResult bindingResult = (BindingResult) errors;

        if(user.getAction()!=null && user.getAction().equalsIgnoreCase("c")){
        	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "username", "NotEmpty");
        	if (user.getUsername().length() <3 || user.getUsername().length() > 32) {
	        	CommonProcess.validationRejectValue(bindingResult, "username", "validation.Size.userForm.username");
	        }
	        Integer checkUsername = userService.checkDuplicateUsername(user.getUsername());
	        if (checkUsername != null && checkUsername >0) {	        	
	        	CommonProcess.validationRejectValue(bindingResult, "username", "validation.Duplicate.userForm.username");
	        }
        }
    }
    

    public void validatePasswordAdmin(Object o, Errors errors) {
        User user = (User) o;
    	BindingResult bindingResult = (BindingResult) errors;

//    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "password", "NotEmpty",null,null);
//    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "passwordConfirm", "NotEmpty",null,null);
//
//        if (user.getPassword().length() < 8 || user.getPassword().length() > 16) {
//        	CommonProcess.validationRejectValue(bindingResult, "password", "validation.Size.userForm.password", null, null);
//        }
//
//        if (user.getPassword().length() < 8 || user.getPassword().length() > 16) {
//        	CommonProcess.validationRejectValue(bindingResult, "passwordConfirm", "validation.Size.userForm.password", null, null);
//        }
        
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
        	CommonProcess.validationRejectValue(bindingResult, "passwordConfirm", "validation.Diff.userForm.passwordConfirm");
//            errors.rejectValue("passwordConfirm", "validation.Diff.userForm.passwordConfirm");
        }
    }
}