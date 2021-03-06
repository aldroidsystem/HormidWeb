/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.mapper.lapak;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aldroid.hormid.mapper.generic.UserQueryList;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Vehicle;

/**
 *
 * @author renaldo
 */

public interface AgenMapper{   

    @Select(AgenQueryList.SELECT_NEW_AGEN)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class)
    })
    abstract List<User> selectNewAgen() throws Exception;
    
    @Update(AgenQueryList.AGEN_UPDATE)
    abstract void update(User bean) throws Exception;
    
    @Select(AgenQueryList.SELECT_AGEN_DETAIL)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class),
        @Result(property = "defaultPotongan", column ="DEFAULT_POTONGAN", javaType = Integer.class),
        @Result(property = "catatan", column ="catatan", javaType = String.class),
        @Result(property = "vehicles", javaType = List.class, column="username",
    		many = @Many(select = "selectVehicleOfAgen")),
        @Result(property = "petani", javaType = List.class, column="username",
    		many = @Many(select = "selectAgenPetani"))
    })
    abstract User selectAgen(@Param("username")String username) throws Exception;

    @Select(AgenQueryList.SEARCH_AGEN_BY_FULLNAME)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class),
        @Result(property = "defaultPotongan", column ="DEFAULT_POTONGAN", javaType = Integer.class),
        @Result(property = "vehicles", javaType = List.class, column="username",
    		many = @Many(select = "selectVehicleOfAgen")),
        @Result(property = "roles", javaType = List.class, column="username",
    		many = @Many(select = "loadUserRoleName"))
    })
    abstract List<User> searchAgenByFullname(@Param("fullname") String fullname) throws Exception;   

    @Select(UserQueryList.SELECT_USER_ROLE_NAME)
    abstract List<String> loadUserRoleName(@Param("username") String username);

    @Select(AgenQueryList.LOAD_AGEN_PETANI)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class)
    })
    abstract List<User> selectAgenPetani(@Param("username") String username) throws Exception;
    

    @Insert(AgenQueryList.AGEN_PETANI_INSERT)
    abstract void insertAgenPetani(@Param("agen") String agen,@Param("petani") String petani) throws Exception;

    @Delete(AgenQueryList.AGEN_PETANI_DELETE)
    abstract void deleteAgenPetani(@Param("agen") String agen,@Param("petani") String petani) throws Exception;


    @Select(AgenQueryList.SELECT_VEHICLE_OF_AGEN)
    @Results({
        @Result(property = "vehicleId", column ="vehicle_id", javaType = Integer.class),
        @Result(property = "plateNumber", column ="plate_number", javaType = String.class)
    })
    abstract List<Vehicle> selectVehicleOfAgen(@Param("username") String username) throws Exception;

}