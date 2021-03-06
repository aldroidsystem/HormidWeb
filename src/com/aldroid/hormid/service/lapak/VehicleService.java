/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.service.lapak;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aldroid.hormid.generic.staticvar.EnumRole;
import com.aldroid.hormid.mapper.lapak.VehicleMapper;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Vehicle;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class VehicleService{

	private static final Logger logger = Logger.getLogger(VehicleService.class);
	
    @Autowired(required=true)
    VehicleMapper vehicleMapper;


    public Vehicle upsert(Vehicle vehicle)throws Exception{
    	if(vehicle.getAction() != null && vehicle.getAction().equalsIgnoreCase("c")){
    		return insert(vehicle);
    	} else if(vehicle.getAction() != null && vehicle.getAction().equalsIgnoreCase("u") && vehicle.getVehicleId() != null){
    		return update(vehicle);
    	} 
    	
    	throw new Exception("vehicleForm action code not found (update or insert)");
    	
    }
    

    public Vehicle update(Vehicle vehicle) throws Exception {
    	vehicleMapper.update(vehicle);
        updateVehicleSupir(vehicle);
        
        return selectVehicleByVehicleID(vehicle.getVehicleId());
    }
    

    public void updateVehicleSupir(Vehicle vehicle) throws Exception{
    	List<User> existingSupir = vehicleMapper.selectUserOfVehicleRole(vehicle.getVehicleId(), EnumRole.SUPIR.toString());
    	
    	if (existingSupir != null){
        	for(User dbSupir : existingSupir){
        		boolean exists=false;
        		if(vehicle.getListSupirUsername() != null){//check kalau semua supir dihapus
            		for(String updateSupir : vehicle.getListSupirUsername()){
            			if(dbSupir.getUsername().equals(updateSupir)){
            				vehicle.getListSupirUsername().remove(updateSupir);
            				exists=true;
            				break;
            			}
            		}
        		}
        		if(!exists){
        			vehicleMapper.deleteUserRoleVehicle(vehicle.getVehicleId(), dbSupir.getUsername(), EnumRole.SUPIR.toString());
        		}
        	}
    	}
    	
    	if (vehicle.getListSupirUsername() != null){
    		for(String insertSupir : vehicle.getListSupirUsername()){
    			vehicleMapper.insertUserRoleVehicle(vehicle.getVehicleId(), insertSupir, EnumRole.SUPIR.toString());
    		}
    	}
    }
    
    public Vehicle insert(Vehicle vehicle) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			vehicle.setCreatedBy(authUser.getUsername());
            }  
    	}
    	
    	vehicleMapper.insert(vehicle);
    	
    	Vehicle lastVeh = vehicleMapper.selectLastVehicle();
    	for (String supir : vehicle.getListSupirUsername()){
    		insertVehicleSupir(lastVeh.getVehicleId(), supir);
    	}
    	
    	lastVeh.setSupir(selectSupirOfVehicle(lastVeh.getVehicleId()));
    	return lastVeh;
    }
    
    public void insertVehicleSupir(Integer vehicleId, String username) throws Exception{
		vehicleMapper.insertUserRoleVehicle(vehicleId, username, EnumRole.SUPIR.toString());
    }
    
    public List<User> selectSupirOfVehicle(Integer vehicleId) throws Exception {
    	return vehicleMapper.selectUserOfVehicleRole(vehicleId, EnumRole.SUPIR.toString());
    }
    
    public List<Vehicle> findByPlateNumber(String plateNumber) throws Exception {
        return vehicleMapper.searchVehicleByPlateNumber(plateNumber);
    }
    public Vehicle selectVehicleByVehicleID(Integer vehicleId) throws Exception {
        return vehicleMapper.selectVehicleByVehicleId(vehicleId);
    }

    public Integer checkDuplicatePlateNumber(String plateNumber){
    	return vehicleMapper.checkDuplicatePlateNumber(plateNumber);    	
    }
    
    public List<Vehicle> loadAllVehicle() throws Exception{
    	return vehicleMapper.loadAllVehicle();
    }
    
    public Vehicle selectVehicleDetailTransaction(Integer vehicleId) throws Exception{
    	return vehicleMapper.selectVehicleDetailTransaction(vehicleId);
    }

    
    public Map<String,String> selectSupirOfVehicleMap(Integer vehicleId) throws Exception{
    	List<User> listUser = vehicleMapper.selectSupirOfVehicle(vehicleId);
    	Map<String,String> mapUser = new HashMap<>();
    	if(listUser != null){
    		for (User user: listUser){
    			mapUser.put(user.getUsername(), user.getFullname());
    		}
    	}
    	return mapUser;
    }
    
    public Map<String,String> selectPengirimOfVehicleMap(Integer vehicleId) throws Exception{
    	List<User> listUser = vehicleMapper.selectPengirimOfVehicle(vehicleId);
    	Map<String,String> mapUser = new HashMap<>();
    	if(listUser != null){
    		for (User user: listUser){
    			mapUser.put(user.getUsername(), user.getFullname());
    		}
    	}
    	return mapUser;
    }
    
}