/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.mapper.lapak;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.aldroid.hormid.generic.staticvar.PetaniQueryList;
import com.aldroid.hormid.generic.staticvar.UserQueryList;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Vehicle;

/**
 *
 * @author renaldo
 */

public interface PetaniMapper{   
   

    @Update(PetaniQueryList.PETANI_UPDATE)
    abstract void update(User bean) throws Exception;
    
    

    @Select(PetaniQueryList.SELECT_PETANI_DETAIL)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class),
        @Result(property = "defaultPotongan", column ="DEFAULT_POTONGAN", javaType = Integer.class),
        @Result(property = "catatan", column ="catatan", javaType = String.class),
        @Result(property = "vehicles", javaType = List.class, column="username",
    		many = @Many(select = "selectVehicleOfPetani"))
    })
    abstract User selectPetani(@Param("username")String username) throws Exception;

    @Select(PetaniQueryList.SEARCH_PETANI_BY_FULLNAME)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class),
        @Result(property = "defaultPotongan", column ="DEFAULT_POTONGAN", javaType = Integer.class),
        @Result(property = "catatan", column ="catatan", javaType = String.class),
        @Result(property = "vehicles", javaType = List.class, column="username",
    		many = @Many(select = "selectVehicleOfPetani")),
        @Result(property = "roles", javaType = List.class, column="username",
    		many = @Many(select = "loadUserRoleName"))
    })
    abstract List<User> searchPetaniByFullname(@Param("fullname") String fullname) throws Exception;
    

    @Select(UserQueryList.SELECT_USER_ROLE_NAME)
    abstract List<String> loadUserRoleName(@Param("username") String username);


    @Select(PetaniQueryList.SELECT_VEHICLE_OF_PETANI)
    @Results({
        @Result(property = "vehicleId", column ="vehicle_id", javaType = Integer.class),
        @Result(property = "plateNumber", column ="plate_number", javaType = String.class)
    })
    abstract List<Vehicle> selectVehicleOfPetani(@Param("username") String username) throws Exception;
    
}