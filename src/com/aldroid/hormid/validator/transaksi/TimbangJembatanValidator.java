package com.aldroid.hormid.validator.transaksi;


import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.model.transaksi.TimbangGantung;
import com.aldroid.hormid.model.transaksi.TimbangJembatan;

@Component
public class TimbangJembatanValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> aClass) {
        return TimbangGantung.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	TimbangJembatan bean = (TimbangJembatan) o;
    	BindingResult bindingResult = (BindingResult) errors;    	
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "bruto", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "vehicleId", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "potongan", "validation.notEmpty");
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "harga", "validation.notEmpty");
    	
    	
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "bruto", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "harga", "validation.notNumber");
    	CommonProcess.validationRejectIfNotInteger(bindingResult, "potongan", "validation.notNumber");
    }
}