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

import com.aldroid.hormid.mapper.lapak.PetaniMapper;
import com.aldroid.hormid.mapper.lapak.VehicleMapper;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Petani;
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

    public Petani upsert(Petani petani)throws Exception {
    	if(petani.getAction() != null && petani.getAction().equalsIgnoreCase("c")){
    		insert(petani);
    		
    		return selectPetaniDetail(petani.getUsername());
    	} else if(petani.getAction() != null && petani.getAction().equalsIgnoreCase("u") && petani.getUsername() != null){
    		update(petani);
    		return selectPetaniDetail(petani.getUsername());
    	} 
    	
    	throw new Exception("vehicleForm action code not found (update or insert)");
    }
    

    public void update(Petani petani) throws Exception {
    	petaniMapper.update(petani);
    	updatePetaniVehicle(petani);        
    }

    public void updatePetaniVehicle(Petani petani) throws Exception{
    	List<Vehicle> existingVehicle = petaniMapper.selectPetaniVehicle(petani.getUsername());
    	
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
        			vehicleMapper.deleteVehiclePetani(dbVeh.getVehicleId(), petani.getUsername());
        		}
        	}
    	}
    	
    	if (petani.getListVehicleId() != null){
    		for(Integer insertVehicle : petani.getListVehicleId()){
    			vehicleMapper.insertVehiclePetani(insertVehicle, petani.getUsername());
    		}
    	}
    }
    
    public Map<String,String> selectNewPetani() throws Exception {
    	List<User> listUser = petaniMapper.selectNewPetani();
    	Map<String,String> mapUser = new HashMap<String, String>();
    	for(User user : listUser){
    		mapUser.put(user.getUsername(), user.getFullname());
    	}
    	return mapUser;
    }
    

    public void insert(Petani bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setCreatedBy(authUser.getUsername());
            }  
    	}
    	
    	petaniMapper.insert(bean);

    	if(bean.getListVehicleId() != null){
        	for (Integer vehId : bean.getListVehicleId()){
        		insertPetaniVehicle(vehId, bean.getUsername());
        	}
    		
    	}
    }

    public void insertPetaniVehicle(Integer vehicleId, String username) throws Exception{
    	vehicleMapper.insertVehiclePetani(vehicleId, username);
    }
    
    public Petani selectPetaniDetail(String username) throws Exception{
    	return petaniMapper.selectPetani(username);
    }

    public List<Petani> searchPetaniByFullname(String fullname) throws Exception{
    	return petaniMapper.searchPetaniByFullname(fullname);
    }
    public Map<String,String> loadDaftarPetani() throws Exception{
    	List<Petani> listPetani = petaniMapper.loadDaftarPetani();
    	Map<String,String> mapPetani = new HashMap<String, String>();
    	for(Petani petani : listPetani){
    		mapPetani.put(petani.getUsername(), petani.getFullname());
    	}
    	return mapPetani;
    }
}