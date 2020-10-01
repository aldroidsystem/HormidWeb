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

import com.aldroid.hormid.mapper.lapak.AgenMapper;
import com.aldroid.hormid.mapper.lapak.VehicleMapper;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Agen;
import com.aldroid.hormid.model.lapak.Petani;
import com.aldroid.hormid.model.lapak.Vehicle;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class AgenService{

	private static final Logger logger = Logger.getLogger(AgenService.class);
	
    @Autowired(required=true)
    AgenMapper agenMapper;

    @Autowired(required=true)
    VehicleMapper vehicleMapper;

    public Agen upsert(Agen bean)throws Exception {
    	if(bean.getAction() != null && bean.getAction().equalsIgnoreCase("c")){
    		insert(bean);
        	
        	if(logger.isDebugEnabled()){
        		logger.debug("insert successfull!");
        	}
    		
    		return selectAgenDetail(bean.getUsername());
    	} else if(bean.getAction() != null && bean.getAction().equalsIgnoreCase("u") && bean.getUsername() != null){
    		update(bean);
        	
        	if(logger.isDebugEnabled()){
        		logger.debug("update successfull!");
        	}
    		return selectAgenDetail(bean.getUsername());
    	} 
    	
    	throw new Exception("vehicleForm action code not found (update or insert)");
    }
    

    public void update(Agen bean) throws Exception {
    	agenMapper.update(bean);
    	updateAgenVehicle(bean);   
    	updateAgenPetani(bean);
    }

    public void updateAgenVehicle(Agen bean) throws Exception{
    	List<Vehicle> existingVehicle = agenMapper.selectAgenVehicle(bean.getUsername());
    	
    	if (existingVehicle != null){
        	for(Vehicle dbVeh : existingVehicle){
        		boolean exists=false;
        		if(bean.getListVehicleId() != null){//check kalau semua kendaraan dihapus
            		for(Integer updateVeh : bean.getListVehicleId()){
            			if(dbVeh.getVehicleId().compareTo(updateVeh) == 0){
            				bean.getListVehicleId().remove(updateVeh);
            				exists=true;
            				break;
            			}
            		}
        		}
        		if(!exists){
        			vehicleMapper.deleteVehicleAgen(dbVeh.getVehicleId(), bean.getUsername());
        		}
        	}
    	}
    	
    	if (bean.getListVehicleId() != null){
    		for(Integer insertVehicle : bean.getListVehicleId()){
    			vehicleMapper.insertVehicleAgen(insertVehicle, bean.getUsername());
    		}
    	}
    }

    public void updateAgenPetani(Agen bean) throws Exception{
    	List<Petani> existingPetani = agenMapper.selectAgenPetani(bean.getUsername());
    	
    	if (existingPetani != null){
        	for(Petani dbPet : existingPetani){
        		boolean exists=false;
        		if(bean.getListPetaniUsername() != null){//check kalau semua kendaraan dihapus
            		for(String updatePet : bean.getListPetaniUsername()){
            			if(dbPet.getUsername().equals(updatePet)){
            				bean.getListPetaniUsername().remove(updatePet);
            				exists=true;
            				break;
            			}
            		}
        		}
        		if(!exists){
        			agenMapper.deleteAgenPetani(bean.getUsername(), dbPet.getUsername());
        		}
        	}
    	}
    	
    	if (bean.getListPetaniUsername() != null){
    		for(String insertPet : bean.getListPetaniUsername()){
    			agenMapper.insertAgenPetani(bean.getUsername(), insertPet);
    		}
    	}
    }
    
    public Map<String,String> selectNewAgen() throws Exception {
    	List<User> listUser = agenMapper.selectNewAgen();
    	Map<String,String> mapUser = new HashMap<String, String>();
    	for(User user : listUser){
    		mapUser.put(user.getUsername(), user.getFullname());
    	}
    	return mapUser;
    }
    

    public void insert(Agen bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setCreatedBy(authUser.getUsername());
            }  
    	}
    	
    	agenMapper.insert(bean);

    	if(bean.getListVehicleId() != null){
        	for (Integer vehId : bean.getListVehicleId()){
        		insertAgenVehicle(vehId, bean.getUsername());
        	}
    	}

    	if(bean.getListPetaniUsername() != null){
        	for (String petani : bean.getListPetaniUsername()){
        		insertAgenPetani(bean.getUsername(),petani);
        	}
    	}
    }

    public void insertAgenVehicle(Integer vehicleId, String username) throws Exception{
    	vehicleMapper.insertVehicleAgen(vehicleId, username);
    }

    public void insertAgenPetani(String agen, String petani) throws Exception{
    	agenMapper.insertAgenPetani(agen, petani);
    }
    
    public Agen selectAgenDetail(String username) throws Exception{
    	return agenMapper.selectAgen(username);
    }

    public List<Agen> searchAgenByFullname(String fullname) throws Exception{
    	return agenMapper.searchAgenByFullname(fullname);
    }
}