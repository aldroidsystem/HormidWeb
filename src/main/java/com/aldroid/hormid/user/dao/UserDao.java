/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.user.dao;

import com.aldroid.hormid.core.database.BaseDaoI;
import com.aldroid.hormid.user.bean.UserBean;

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
public interface UserDao extends BaseDaoI<UserBean>{
    final String INSERT = "INSERT INTO tbl_user "
            + "(username, password,email,phone,flagactive,flaglocked,userType,referenceId,statusId,lastupdatedby) "
            + "VALUES (" 
            + "#{username}," 
            + "#{password}," 
            + "#{email}," 
            + "#{phone}," 
            + "#{flagActive}," 
            + "#{flagLocked}," 
            + "#{userType},"
            + "#{referenceId}," 
            + "1," 
            + "#{lastUpdatedBy})";
    final String UPDATE_BY_ID = "INSERT INTO tbl_user "
            + "(publicId,username, password,email,phone,flagactive,flaglocked,userType,referenceId,statusId,lastupdatedby) "
            + "VALUES (" 
            + "#{publicId}," 
            + "#{username}," 
            + "#{password}," 
            + "#{email}," 
            + "#{phone}," 
            + "#{flagActive}," 
            + "#{flagLocked}," 
            + "#{userType},"
            + "#{referenceId}," 
            + "3," 
            + "#{lastUpdatedBy})";
    final String DELETE_BY_ID = "INSERT INTO tbl_user "
            + "(publicId,username, password,email,phone,flagactive,flaglocked,userType,referenceId,statusId,lastupdatedby) "
            + "SELECT publicId,username, password,email,phone,flagactive,flaglocked,userType,referenceId,2,#{lastUpdatedBy} "
            + "FROM vw_user WHERE publicId=#{publicId}";
    final String DELETE_BY_EMPLOYEEID = "INSERT INTO tbl_user "
            + "(publicId,username, password,email,phone,flagactive,flaglocked,userType,referenceId,statusId,lastupdatedby) "
            + "SELECT publicId,username, password,email,phone,flagactive,flaglocked,userType,referenceId,2,#{lastUpdatedBy} "
            + "FROM vw_user WHERE referenceId=#{referenceId}";
    final String SELECT_BY_ID = "SELECT * FROM tbl_user WHERE id=#{id}";
    final String SELECT_BY_PUBLICID = "SELECT * FROM vw_user WHERE publicid=#{publicid}";
    final String SELECT_LAST_BY_PUBLICID = "SELECT * FROM vw_user_last WHERE publicid=#{publicid}";
    final String SELECT_PAGE = "SELECT * FROM vw_user limit #{limit} offset #{offset}";
    final String SELECT_COUNT_ALL = "SELECT count(1) FROM vw_user";
    final String SELECT_COUNT_USERNAME = "SELECT count(1) FROM vw_user where username=#{username}";
    final String USER_LOGIN = "UPDATE tbl_user SET lastlogin=current_timestamp "
            + "WHERE id=(SELECT max(id) from vw_user where username=#{username} and password = #{password}); "
            + "SELECT * from vw_user where username=#{username} and password = #{password}";
    final String SELECT_ALL = "SELECT * FROM vw_user";
    
    @Override
    @Delete(DELETE_BY_ID)
    abstract void deleteByPublicId(
            @Param("publicId")int publicId,
            @Param("lastUpdatedBy") int lastUpdatedBy) throws Exception;
    
    @Delete(DELETE_BY_ID)
    abstract void deleteByPublicEmployeeId(
            @Param("referenceId")int referenceId,
            @Param("lastUpdatedBy") int lastUpdatedBy) throws Exception;
    
    @Override
    @Insert(INSERT)
    abstract void insert(UserBean bean) throws Exception;
    
    @Override
    @Update(UPDATE_BY_ID)
    abstract void updateByPublicId(UserBean bean) throws Exception;
    
    @Override
    @Select(SELECT_BY_PUBLICID)
    @Results(value = {
        @Result(property = "lastUpdatedUser", column = "lastUpdatedBy", one=@One(select = "selectLastByPublicId"))
    })
    abstract UserBean selectByPublicId(@Param("publicid") int publicid) throws Exception;

    @Override
    @Select(SELECT_BY_ID)
    abstract UserBean selectById(@Param("id") int id) throws Exception;
    
    @Select(SELECT_LAST_BY_PUBLICID)
    @Override
    abstract UserBean selectLastByPublicId(@Param("publicid") int publicid) throws Exception;
    
    @Override
    @Select(SELECT_PAGE)
    abstract List<UserBean> selectPage(
            @Param("limit")int limit,
            @Param("offset") int offset) throws Exception;
    
    @Override
    @Select(SELECT_COUNT_ALL)
    abstract Integer selectCountAll() throws Exception;
    
    @Select(SELECT_COUNT_USERNAME)
    abstract int countUsername(@Param("username") String username);
    

    @Select(USER_LOGIN)
    @Results(value = {
        @Result(property = "employee", column = "referenceId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectByPublicId"))
    })
    abstract UserBean login(UserBean bean) throws Exception;

    @Override
    @Select(SELECT_ALL)
    public List<UserBean> selectAll() throws Exception;
}