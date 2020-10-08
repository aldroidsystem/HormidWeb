package com.aldroid.hormid.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aldroid.hormid.generic.process.CommonParsing;
import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Vehicle;
import com.aldroid.hormid.service.generic.UserService;
import com.aldroid.hormid.service.lapak.VehicleService;



@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UserService userService;
	
    @Autowired
	private GlobalSessionObject globalSessionObject;
    
    
	@RequestMapping(value="/ajaxVehicle", 
			params = {"vehicleId"},
			method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String  ajaxVehicle(@RequestParam(value = "vehicleId")Integer vehicleId, HttpServletResponse response) throws Exception {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        Vehicle vehicle = vehicleService.selectVehicleDetailTransaction(vehicleId);
        return CommonParsing.generateJsonString(vehicle);
    }
	@RequestMapping(value="/ajaxPengguna", 
			params = {"username"},
			method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String  ajaxSupir(@RequestParam(value = "username")String username, HttpServletResponse response) throws Exception {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        if (username == null || username.isEmpty() || username.equals("")){
        	return null;
        }
        User user = userService.selectPenggunaTransaction(username);
        if (user == null) {
        	user = new User();
        }
        if (user.getDefaultPotongan() == null || user.getDefaultPotongan() <= 0){
        	user.setDefaultPotongan(globalSessionObject.getPropertiesByCode("defaultPotongan").getAngka());
        } 
        return CommonParsing.generateJsonString(user);
    }
}