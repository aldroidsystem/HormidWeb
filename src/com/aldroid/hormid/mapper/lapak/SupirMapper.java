/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.mapper.lapak;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aldroid.hormid.generic.staticvar.SupirQueryList;
import com.aldroid.hormid.generic.staticvar.UserQueryList;
import com.aldroid.hormid.generic.staticvar.VehicleQueryList;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.lapak.Supir;
import com.aldroid.hormid.model.lapak.Vehicle;

/**
 *
 * @author renaldo
 */

public interface SupirMapper{   

    @Select(SupirQueryList.SELECT_NEW_SUPIR)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class)
    })
    abstract List<User> selectNewSupir() throws Exception;
    

    @Insert(SupirQueryList.SUPIR_INSERT)
    abstract void insert(Supir bean) throws Exception;

    @Update(SupirQueryList.SUPIR_UPDATE)
    abstract void update(Supir bean) throws Exception;
    

    @Select(SupirQueryList.SELECT_SUPIR_DETAIL)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class),
        @Result(property = "catatan", column ="catatan", javaType = String.class),
        @Result(property = "vehicles", javaType = List.class, column="username",
    		many = @Many(select = "selectSupirVehicle"))
    })
    abstract Supir selectSupir(@Param("username")String username) throws Exception;

    @Select(SupirQueryList.SEARCH_SUPIR_BY_FULLNAME)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class),
        @Result(property = "catatan", column ="catatan", javaType = String.class),
        @Result(property = "vehicles", javaType = List.class, column="username",
    		many = @Many(select = "selectSupirVehicle")),
        @Result(property = "roles", javaType = List.class, column="username",
    		many = @Many(select = "loadUserRoleName"))
    })
    abstract List<Supir> searchSupirByFullname(@Param("fullname") String fullname) throws Exception;
    
    
    @Select(SupirQueryList.SELECT_SUPIR_LIST)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class)
    })
    abstract List<Supir> selectSupirList() throws Exception;
    

    @Select(SupirQueryList.LOAD_SUPIR_VEHICLE)
    @Results({
        @Result(property = "vehicleId", column ="vehicle_id", javaType = Integer.class),
        @Result(property = "plateNumber", column ="plate_number", javaType = String.class)
    })
    abstract List<Vehicle> selectSupirVehicle(@Param("username") String username) throws Exception;
    

    @Select(UserQueryList.SELECT_USER_ROLE_NAME)
    abstract List<String> loadUserRoleName(@Param("username") String username);
    
}