package com.aldroid.hormid.validator.generic;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.model.generic.Properties;
import com.aldroid.hormid.service.generic.PropertiesService;

@Component
public class PropertiesValidator implements Validator {
    @Autowired
    private PropertiesService propertiesService;

    @Autowired
	private GlobalSessionObject globalSessionObject;
    
    @Override
    public boolean supports(Class<?> aClass) {
        return Properties.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Properties properties = (Properties) o;
    	BindingResult bindingResult = (BindingResult) errors;
        CommonProcess.validationRejectIfEmptyOrWhitespace(bindingResult, "value", "validation.notEmpty");

        if(properties.getValue() != null && (StringUtils.hasLength(properties.getValue())) ) {
        	if (properties.getTipeData().equals("Angka")) {
        		try{
        			Integer.parseInt(properties.getValue());
        		} catch (NumberFormatException ex){
        	        CommonProcess.validationRejectValue(bindingResult, "value", "validation.numberFormat.propertiesForm.value");
        	        CommonProcess.logException(ex, getClass());
        		}
    		} else if (properties.getTipeData().equals("Daftar Angka")) {
        		try{
        			List<String> daftarKata = Arrays.asList(properties.getValue().split(","));
        			for(String kata : daftarKata){
        				Integer.parseInt(kata);
        			}
        		} catch (NumberFormatException ex){
        	        CommonProcess.validationRejectValue(bindingResult, "value", "validation.numberFormat.propertiesForm.value");
        	        CommonProcess.logException(ex, getClass());
        		}
    		} else if (properties.getTipeData().equals("Desimal")) {

        		try{
        			Float.valueOf(properties.getValue());
        		} catch (NumberFormatException ex){
        	        CommonProcess.validationRejectValue(bindingResult, "value", "validation.numberFormat.propertiesForm.value");
        	        CommonProcess.logException(ex, getClass());
        		}
    		} else if (properties.getTipeData().equals("Daftar Desimal")) {
        		try{
        			List<String> daftarKata = Arrays.asList(properties.getValue().split(","));
        			for(String kata : daftarKata){
        				Float.valueOf(kata);
        			}
        		} catch (NumberFormatException ex){
        	        CommonProcess.validationRejectValue(bindingResult, "value", "validation.numberFormat.propertiesForm.value");
        	        CommonProcess.logException(ex, getClass());
        		}
    		}
        }
    }
}