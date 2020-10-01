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
import com.aldroid.hormid.mapper.lapak.VehicleMapper;
import com.aldroid.hormid.model.lapak.Supir;
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

    	
    	if(logger.isDebugEnabled()){
    		logger.debug("update successfull!");
    	}
        return selectVehicleByVehicleID(vehicle.getVehicleId());
    }
    

    public void updateVehicleSupir(Vehicle vehicle) throws Exception{
    	List<Supir> existingSupir = vehicleMapper.selectVehicleSupir(vehicle.getVehicleId());
    	
    	if (existingSupir != null){
        	for(Supir dbSupir : existingSupir){
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
        			vehicleMapper.deleteVehicleSupir(vehicle.getVehicleId(), dbSupir.getUsername());
        		}
        	}
    	}
    	
    	if (vehicle.getListSupirUsername() != null){
    		for(String insertSupir : vehicle.getListSupirUsername()){
    			vehicleMapper.insertVehicleSupir(vehicle.getVehicleId(), insertSupir);
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
    	
    	lastVeh.setSupir(loadVehicleSupir(lastVeh.getVehicleId()));
    	
    	if(logger.isDebugEnabled()){
    		logger.debug("insert successfull!");
    	}
    	return lastVeh;
    }
    
    public void insertVehicleSupir(Integer vehicleId, String username) throws Exception{
    	vehicleMapper.insertVehicleSupir(vehicleId, username);
    }
    
    public List<Supir> loadVehicleSupir(Integer vehicleId) throws Exception {
    	return vehicleMapper.selectVehicleSupir(vehicleId);
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
    
    public Map<Integer, String> loadAllVehicle() throws Exception{
    	Map<Integer,String> vehList = new HashMap<Integer, String>();
    	List<Vehicle> result = vehicleMapper.loadAllVehicle();
    	if(result!= null){
    		for (Vehicle veh : result){
    			vehList.put(veh.getVehicleId(), veh.getPlateNumber());
    		}
    	}
    	return vehList;
    }
}