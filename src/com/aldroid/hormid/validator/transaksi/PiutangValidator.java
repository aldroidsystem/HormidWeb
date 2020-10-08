package com.aldroid.hormid.validator.transaksi;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.model.transaksi.Piutang;

@Component
public class PiutangValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> aClass) {
        return Piutang.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Piutang bean = (Piutang) o;
    	BindingResult bindingResult = (BindingResult) errors;
    	
    	if (bean.getJenisTransaksi()== null 
    			|| (!bean.getJenisTransaksi().equals("bayar") && !bean.getJenisTransaksi().equals("pinjam"))){
        	CommonProcess.validationRejectValue(bindingResult, "jenisTransaksi", "validation.notEmpty");
    	}
    	CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "amount", "validation.notEmpty");		
        
    }
}