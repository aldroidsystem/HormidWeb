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

public interface VehicleMapper{     

    @Update(VehicleQueryList.VEHICLE_UPDATE)
    abstract void update(Vehicle bean) throws Exception;
    
    @Insert(VehicleQueryList.VEHICLE_INSERT)
    abstract void insert(Vehicle bean) throws Exception;

    @Insert(VehicleQueryList.VEHICLE_SUPIR_INSERT)
    abstract void insertVehicleSupir(@Param("vehicleId") Integer vehicleId,@Param("username") String username) throws Exception;


    @Insert(VehicleQueryList.VEHICLE_PETANI_INSERT)
    abstract void insertVehiclePetani(@Param("vehicleId") Integer vehicleId,@Param("username") String username) throws Exception;

    @Delete(VehicleQueryList.VEHICLE_SUPIR_DELETE)
    abstract void deleteVehicleSupir(@Param("vehicleId") Integer vehicleId,@Param("username") String username) throws Exception;

    @Delete(VehicleQueryList.VEHICLE_PETANI_DELETE)
    abstract void deleteVehiclePetani(@Param("vehicleId") Integer vehicleId,@Param("username") String username) throws Exception;

    @Select(VehicleQueryList.SELECT_LAST_VEHICLE_DETAILS)
    @Results({
        @Result(property = "vehicleId", column ="vehicle_id", javaType = Integer.class),
        @Result(property = "plateNumber", column ="plate_number", javaType = String.class),
        @Result(property = "vehicleType", column ="vehicle_type", javaType = String.class),
        @Result(property = "defaultBiayaBongkar", column ="default_Biaya_Bongkar", javaType = Integer.class),
        @Result(property = "catatan", column ="catatan", javaType = String.class)
    })
    abstract Vehicle selectLastVehicle() throws Exception;
    

    @Select(VehicleQueryList.LOAD_VEHICLE_SUPIR)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class)
    })
    abstract List<Supir> selectVehicleSupir(@Param("vehicleId") Integer vehicleId) throws Exception;

    @Select(VehicleQueryList.SEARCH_VEHICLE_BY_PLATENUMBER)
    @Results({
        @Result(property = "vehicleId", column ="vehicle_id", javaType = Integer.class),
        @Result(property = "plateNumber", column ="plate_number", javaType = String.class),
        @Result(property = "vehicleType", column ="vehicle_type", javaType = String.class),
        @Result(property = "defaultBiayaBongkar", column ="default_Biaya_Bongkar", javaType = Integer.class),
        @Result(property = "catatan", column ="catatan", javaType = String.class),
        @Result(property = "supir", javaType = List.class, column="vehicle_Id",
        	many = @Many(select = "selectVehicleSupir"))
    })
    abstract List<Vehicle> searchVehicleByPlateNumber(@Param("plateNumber") String plateNumber) throws Exception;
    

    @Select(VehicleQueryList.SELECT_VEHICLE_BY_VEHICLEID)
    @Results({
        @Result(property = "vehicleId", column ="vehicle_id", javaType = Integer.class),
        @Result(property = "plateNumber", column ="plate_number", javaType = String.class),
        @Result(property = "vehicleType", column ="vehicle_type", javaType = String.class),
        @Result(property = "defaultBiayaBongkar", column ="default_Biaya_Bongkar", javaType = Integer.class),
        @Result(property = "catatan", column ="catatan", javaType = String.class),
        @Result(property = "supir", javaType = List.class, column="vehicle_Id",
        	many = @Many(select = "selectVehicleSupir"))
    })
    abstract Vehicle selectVehicleByVehicleId(@Param("vehicleId") Integer vehicleId) throws Exception;
    

    @Select(VehicleQueryList.CHECK_DUPLICATE_PLATENUMBER) 
    abstract Integer checkDuplicatePlateNumber(@Param("plateNumber") String plateNumber);
    


    @Select(VehicleQueryList.LOAD_ALL_VEHICLE)
    @Results({
        @Result(property = "vehicleId", column ="vehicle_id", javaType = Integer.class),
        @Result(property = "plateNumber", column ="plate_number", javaType = String.class)
    })
    abstract List<Vehicle> loadAllVehicle() throws Exception;
}