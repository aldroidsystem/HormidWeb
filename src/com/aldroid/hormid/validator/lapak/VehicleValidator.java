package com.aldroid.hormid.validator.lapak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.model.lapak.Vehicle;
import com.aldroid.hormid.service.lapak.VehicleService;

@Component
public class VehicleValidator implements Validator {
    @Autowired
    private VehicleService vehicleService;
    
    @Override
    public boolean supports(Class<?> aClass) {
        return Vehicle.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	Vehicle veh = (Vehicle) o;
    	BindingResult bindingResult = (BindingResult) errors;
    	
    	
    	if ( veh.getAction() != null && veh.getAction().equalsIgnoreCase("c")){
            Integer checkUsername = vehicleService.checkDuplicatePlateNumber(veh.getPlateNumber());
            if (checkUsername != null && checkUsername >0) {	        	
            	CommonProcess.validationRejectValue(bindingResult, "plateNumber", "validation.Duplicate.vehicleForm.platenumber", null, null);
            }    		
    	}        
        
    }
}