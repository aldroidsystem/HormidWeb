package com.aldroid.hormid.validator.transaksi;


import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.model.transaksi.TimbangGantung;

@Component
public class TimbangGantungValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> aClass) {
        return TimbangGantung.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	BindingResult bindingResult = (BindingResult) errors;
    	
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "username", "validation.notEmpty", null, null);
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "bruto", "validation.notEmpty", null, null);
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "potongan", "validation.notEmpty", null, null);
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "harga", "validation.notEmpty", null, null);
    	
    }
}