package com.aldroid.hormid.validator.transaksi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.transaksi.TimbangJembatan;
import com.aldroid.hormid.service.generic.UserService;

@Component
public class TimbangJembatanBayarValidator implements Validator {


    @Autowired
    private UserService userService;
    
    
    @Override
    public boolean supports(Class<?> aClass) {
        return TimbangJembatan.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	TimbangJembatan bean = (TimbangJembatan) o;
    	BindingResult bindingResult = (BindingResult) errors;
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "vehicleId", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "supir", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "pengirim", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "bruto", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "tare", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "potongan", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "harga", "validation.notEmpty");

    	
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "bruto", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "tare", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "harga", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "potongan", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "biayaBongkar", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "biayaMobil", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "biayaLain", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "potonganBon", "validation.notNumber");
    	
    	if (bean.getPotonganBon() != null && bean.getPotonganBon() > 0){

            User user = userService.selectPenggunaTransaction(bean.getPengirim());
            if (bean.getPotonganBon() > user.getHutang()){
            	CommonProcess.validationRejectValue(bindingResult, "potonganBon", "validation.toomuch.jembatanForm.potonganBon");
            }
    	}
    }
}