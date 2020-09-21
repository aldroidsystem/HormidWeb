/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.service.lapak;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aldroid.hormid.generic.staticvar.HargaQueryList;
import com.aldroid.hormid.generic.staticvar.SupirQueryList;
import com.aldroid.hormid.mapper.lapak.SupirMapper;
import com.aldroid.hormid.mapper.lapak.VehicleMapper;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Harga;
import com.aldroid.hormid.model.lapak.Supir;
import com.aldroid.hormid.model.lapak.Vehicle;


/**
 *
 * @author renaldo
 */
@Service
@Transactional
public class SupirService{

	private static final Logger logger = Logger.getLogger(SupirService.class);
	
    @Autowired(required=true)
    SupirMapper supirMapper;

    @Autowired(required=true)
    VehicleMapper vehicleMapper;

    public Supir upsert(Supir supir)throws Exception {
    	if(supir.getAction() != null && supir.getAction().equalsIgnoreCase("c")){
    		insert(supir);
    		
    		return selectSupirDetail(supir.getUsername());
    	} else if(supir.getAction() != null && supir.getAction().equalsIgnoreCase("u") && supir.getUsername() != null){
    		update(supir);
    		return selectSupirDetail(supir.getUsername());
    	} 
    	
    	throw new Exception("vehicleForm action code not found (update or insert)");
    }
    

    public void update(Supir supir) throws Exception {
    	supirMapper.update(supir);
    	updateSupirVehicle(supir);        
    }

    public void updateSupirVehicle(Supir supir) throws Exception{
    	List<Vehicle> existingVehicle = supirMapper.selectSupirVehicle(supir.getUsername());
    	
    	if (existingVehicle != null){
        	for(Vehicle dbVeh : existingVehicle){
        		boolean exists=false;
        		if(supir.getListVehicleId() != null){//check kalau semua supir dihapus
            		for(Integer updateVeh : supir.getListVehicleId()){
            			if(dbVeh.getVehicleId().compareTo(updateVeh) == 0){
            				supir.getListVehicleId().remove(updateVeh);
            				exists=true;
            				break;
            			}
            		}
        		}
        		if(!exists){
        			vehicleMapper.deleteVehicleSupir(dbVeh.getVehicleId(), supir.getUsername());
        		}
        	}
    	}
    	
    	if (supir.getListVehicleId() != null){
    		for(Integer insertVehicle : supir.getListVehicleId()){
    			vehicleMapper.insertVehicleSupir(insertVehicle, supir.getUsername());
    		}
    	}
    }
    
    public Map<String,String> selectNewSupir() throws Exception {
    	List<User> listUser = supirMapper.selectNewSupir();
    	Map<String,String> mapUser = new HashMap<String, String>();
    	for(User user : listUser){
    		mapUser.put(user.getUsername(), user.getFullname());
    	}
    	return mapUser;
    }
    

    public void insert(Supir bean) throws Exception {
    	Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
    	if (obj instanceof org.springframework.security.core.userdetails.User){
    		org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User) obj;
    		if (authUser != null && authUser.getUsername() !=null || authUser.getUsername().equals("")) {
    			bean.setCreatedBy(authUser.getUsername());
            }  
    	}
    	
    	supirMapper.insert(bean);

    	if(bean.getListVehicleId() != null){
        	for (Integer vehId : bean.getListVehicleId()){
        		insertSupirVehicle(vehId, bean.getUsername());
        	}
    		
    	}
    }

    public void insertSupirVehicle(Integer vehicleId, String username) throws Exception{
    	vehicleMapper.insertVehicleSupir(vehicleId, username);
    }
    
    public Supir selectSupirDetail(String username) throws Exception{
    	return supirMapper.selectSupir(username);
    }

    public Map<String,String> selectSupirList() throws Exception {
    	List<Supir> listSupir = supirMapper.selectSupirList();
    	Map<String,String> mapSupir = new HashMap<String, String>();
    	for(Supir supir : listSupir){
    		mapSupir.put(supir.getUsername(), supir.getFullname());
    	}
    	return mapSupir;
    }
    
    public List<Supir> searchSupirByFullname(String fullname) throws Exception{
    	return supirMapper.searchSupirByFullname(fullname);
    }
}