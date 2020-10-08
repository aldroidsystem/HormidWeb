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
import com.aldroid.hormid.generic.staticvar.Role;
import com.aldroid.hormid.mapper.lapak.AgenMapper;
import com.aldroid.hormid.mapper.lapak.VehicleMapper;
import com.aldroid.hormid.model.generic.User;
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

    

    public void update(User bean) throws Exception {
    	agenMapper.update(bean);
    	updateAgenVehicle(bean);   
    	updateAgenPetani(bean);
    }

    public void updateAgenVehicle(User bean) throws Exception{
    	List<Vehicle> existingVehicle = agenMapper.selectVehicleOfAgen(bean.getUsername());
    	
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
        			vehicleMapper.deleteUserRoleVehicle(dbVeh.getVehicleId(), bean.getUsername(), Role.AGEN.toString());
        		}
        	}
    	}
    	
    	if (bean.getListVehicleId() != null){
    		for(Integer insertVehicle : bean.getListVehicleId()){
    			vehicleMapper.insertUserRoleVehicle(insertVehicle, bean.getUsername(), Role.AGEN.toString());
    		}
    	}
    }

    public void updateAgenPetani(User bean) throws Exception{
    	List<User> existingPetani = agenMapper.selectAgenPetani(bean.getUsername());
    	
    	if (existingPetani != null){
        	for(User dbPet : existingPetani){
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
      


    public void insertAgenVehicle(Integer vehicleId, String username) throws Exception{
    	vehicleMapper.insertUserRoleVehicle(vehicleId, username, Role.AGEN.toString());
    }

    public void insertAgenPetani(String agen, String petani) throws Exception{
    	agenMapper.insertAgenPetani(agen, petani);
    }
    
    public User selectAgenDetail(String username) throws Exception{
    	return agenMapper.selectAgen(username);
    }

    public List<User> searchAgenByFullname(String fullname) throws Exception{
    	return agenMapper.searchAgenByFullname(fullname);
    }

    public List<Vehicle> selectVehicleOfAgent(String username) throws Exception{
    	return agenMapper.selectVehicleOfAgen(username);
    }


//    @Select(AgenQueryList.LOAD_AGEN_VEHICLE)
//    @Results({
//        @Result(property = "vehicleId", column ="vehicle_id", javaType = Integer.class),
//        @Result(property = "plateNumber", column ="plate_number", javaType = String.class)
//    })
//    abstract List<Vehicle> selectAgenVehicle(@Param("username") String username) throws Exception;
}