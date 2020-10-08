/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.service.lapak;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aldroid.hormid.generic.staticvar.EnumRole;
import com.aldroid.hormid.mapper.lapak.PetaniMapper;
import com.aldroid.hormid.mapper.lapak.VehicleMapper;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Vehicle;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class PetaniService{

	private static final Logger logger = Logger.getLogger(PetaniService.class);
	
    @Autowired(required=true)
    PetaniMapper petaniMapper;

    @Autowired(required=true)
    VehicleMapper vehicleMapper;   

    public void update(User petani) throws Exception {
    	petaniMapper.update(petani);
    	updatePetaniVehicle(petani);        
    }

    public void updatePetaniVehicle(User petani) throws Exception{
    	List<Vehicle> existingVehicle = petaniMapper.selectVehicleOfPetani(petani.getUsername());
    	
    	if (existingVehicle != null){
        	for(Vehicle dbVeh : existingVehicle){
        		boolean exists=false;
        		if(petani.getListVehicleId() != null){//check kalau semua kendaraan dihapus
            		for(Integer updateVeh : petani.getListVehicleId()){
            			if(dbVeh.getVehicleId().compareTo(updateVeh) == 0){
            				petani.getListVehicleId().remove(updateVeh);
            				exists=true;
            				break;
            			}
            		}
        		}
        		if(!exists){
        			vehicleMapper.deleteUserRoleVehicle(dbVeh.getVehicleId(), petani.getUsername(), EnumRole.PETANI.toString());
        		}
        	}
    	}
    	
    	if (petani.getListVehicleId() != null){
    		for(Integer insertVehicle : petani.getListVehicleId()){
    			vehicleMapper.insertUserRoleVehicle(insertVehicle, petani.getUsername(), EnumRole.PETANI.toString());
    		}
    	}
    }
    
    

    public void insertPetaniVehicle(Integer vehicleId, String username) throws Exception{
    	vehicleMapper.insertUserRoleVehicle(vehicleId, username, EnumRole.PETANI.toString());
    }
    
    public User selectPetaniDetail(String username) throws Exception{
    	return petaniMapper.selectPetani(username);
    }

    public List<User> searchPetaniByFullname(String fullname) throws Exception{
    	return petaniMapper.searchPetaniByFullname(fullname);
    }
}