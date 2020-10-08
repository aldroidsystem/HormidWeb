package com.aldroid.hormid.validator.lapak;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.model.transaksi.Harga;

@Component
public class HargaValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> aClass) {
        return Harga.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Harga harga = (Harga) o;
    	BindingResult bindingResult = (BindingResult) errors;
    	
        CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "tanggalMulai", "validation.notEmpty");
        CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "hargaJual", "validation.notEmpty");
        CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "hargaBeliJembatan", "validation.notEmpty");
        CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "hargaBeliGantung", "validation.notEmpty");

		try{
			Integer.valueOf(harga.getHargaJual()!=null?harga.getHargaJual():0);
		} catch (NumberFormatException ex){
	        CommonProcess.validationRejectValue(bindingResult, "hargaJual", "validation.numberFormat.propertiesForm.value");
	        CommonProcess.logException(ex, getClass());
		}

		try{
			Integer.valueOf(harga.getHargaBeliJembatan()!=null?harga.getHargaBeliJembatan():0);
		} catch (NumberFormatException ex){
	        CommonProcess.validationRejectValue(bindingResult, "hargaBeliJembatan", "validation.numberFormat.propertiesForm.value");
	        CommonProcess.logException(ex, getClass());
		}
		
		try{
			Integer.valueOf(harga.getHargaBeliGantung()!=null?harga.getHargaBeliGantung():0);
		} catch (NumberFormatException ex){
	        CommonProcess.validationRejectValue(bindingResult, "hargaBeliGantung", "validation.numberFormat.propertiesForm.value");
	        CommonProcess.logException(ex, getClass());
		}
    }
}