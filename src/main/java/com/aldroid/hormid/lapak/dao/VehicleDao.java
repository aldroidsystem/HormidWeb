/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.lapak.dao;

import com.aldroid.hormid.core.database.BaseDaoI;
import com.aldroid.hormid.lapak.bean.VehicleBean;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 *
 * @author renaldo
 */
@Repository
public interface VehicleDao extends BaseDaoI<VehicleBean>{
    
    final static String INSERT = "INSERT INTO tbl_vehicle "
            + "(platenumber,vehicleType,notes,branchid,employeeid,lastupdatedby,statusid) "
            + "VALUES ("
            + "#{plateNumber},"
            + "#{vehicleType},"
            + "#{notes},"
            + "#{branchId},"
            + "#{employeeId},"
            + "#{lastUpdatedBy},"
            + "1)";
    
    final static String UPDATE_BY_PUBLICID = "INSERT INTO tbl_vehicle "
            + "(publicId,platenumber,vehicleType,notes,branchid,employeeid,lastupdatedby,statusid) "
            + "VALUES ("
            + "#{publicId},"
            + "#{plateNumber},"
            + "#{vehicleType},"
            + "#{notes},"
            + "#{branchId},"
            + "#{employeeId},"
            + "#{lastUpdatedBy},"
            + "3)";
    final static String DELETE_BY_PUBLICID = "INSERT INTO tbl_vehicle ("
            + "publicId,"
            + "platenumber,"
            + "vehicleType,"
            + "notes,"
            + "branchid,"
            + "employeeid,"
            + "statusid,"
            + "lastupdatedby) "
            + "SELECT "
            + "publicId,"
            + "platenumber,"
            + "vehicleType,"
            + "notes,"
            + "branchid,"
            + "employeeid,"
            + "2,"
            + "#{publicId} "
            + "FROM vw_vehicle where publicid=#{lastUpdatedBy}";
    final static String SELECT_BY_ID = "SELECT * FROM tbl_vehicle WHERE ID=#{id}";
    final String SELECT_BY_PUBLICID = "SELECT * FROM vw_vehicle WHERE publicid=#{publicid}";
    final String SELECT_LAST_BY_PUBLICID = "SELECT * FROM vw_vehicle_last WHERE publicid=#{publicid}";
    final static String SELECT_PAGE = "SELECT * FROM vw_vehicle limit #{limit} offset #{offset}";
    final static String SELECT_COUNT = "SELECT count(1) FROM vw_vehicle";
    final static String SELECT_BY_BRANCH = "SELECT e.* FROM vw_vehicle e "
            + "INNER JOIN vw_branch b on e.branchid=b.publicid "
            + "WHERE b.publicid=${branchPublicId}";
    
    
    @Override
    @Delete(DELETE_BY_PUBLICID)
    abstract void deleteByPublicId(
            @Param("publicId")int publicId,
            @Param("lastUpdatedBy") int lastUpdatedBy) throws Exception;
    
    
    @Override
    @Insert(INSERT)
    abstract void insert(VehicleBean bean) throws Exception;
    
    
    @Override
    @Update(UPDATE_BY_PUBLICID)
    abstract void updateByPublicId(VehicleBean bean) throws Exception;
    
    @Override
    @Select(SELECT_BY_ID)
    abstract VehicleBean selectById(@Param("id") int id) throws Exception;
    
    
    @Override
    @Select(SELECT_BY_PUBLICID)
    @Results(value = {
        @Result(property = "employee", column = "employeeId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectByPublicId")),
        @Result(property = "branch", column = "branchId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectByPublicId")),
        @Result(property = "lastUpdatedUser", column = "lastUpdatedBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectByPublicId"))
    })
    abstract VehicleBean selectByPublicId(@Param("publicid") int publicid) throws Exception;
    
    
    @Override
    @Select(SELECT_LAST_BY_PUBLICID)
    @Results(value = {
        @Result(property = "employee", column = "employeeId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectByPublicId")),
        @Result(property = "branch", column = "branchId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectLastByPublicId")),
        @Result(property = "lastUpdatedUser", column = "lastUpdatedBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectLastByPublicId"))
    })
    abstract VehicleBean selectLastByPublicId(@Param("publicid") int publicid) throws Exception;
    
    
    @Override
    @Select(SELECT_PAGE)
    abstract List<VehicleBean> selectPage(
            @Param("limit")int limit,
            @Param("offset") int offset) throws Exception;
    
    
    @Override
    @Select(SELECT_COUNT)
    abstract Integer selectCountAll() throws Exception;
    
    @Select(SELECT_BY_BRANCH)
    @Results(value = {
        @Result(property = "employee", column = "employeeId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectByPublicId")),
        @Result(property = "lastUpdatedUser", column = "lastUpdatedBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectLastByPublicId"))
    })
    abstract List<VehicleBean> selectByBranch(@Param("branchPublicId") int branchPublicId) throws Exception;
}