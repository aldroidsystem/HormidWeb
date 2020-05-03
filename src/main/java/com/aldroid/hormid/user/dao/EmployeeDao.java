/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.user.dao;

import com.aldroid.hormid.core.database.BaseDaoI;
import com.aldroid.hormid.user.bean.EmployeeBean;

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
public interface EmployeeDao extends BaseDaoI<EmployeeBean> {
    final static String INSERT = "INSERT INTO tbl_employee "
            + "(fullname,dateofbirth,dateofjoin,liabilities,phone,email,idtype,idnumber,"
            + "gender,fieldofwork,address,branchId,notes,lastupdatedby,userpublicid,statusId) "
            + "VALUES ("
            + "#{fullname},"
            + "#{dateOfBirth},"
            + "#{dateOfJoin},"
            + "#{liabilities},"
            + "#{phone},"
            + "#{email},"
            + "#{idType},"
            + "#{idNumber},"
            + "#{gender},"
            + "#{fieldOfWork},"
            + "#{address},"
            + "#{branchId},"
            + "#{notes},"
            + "#{lastUpdatedBy},"
            + "#{userPublicId},"
            + "1)";
    
    final static String UPDATE_BY_PUBLICID = "INSERT INTO tbl_employee "
            + "(publicid,fullname,dateofbirth,dateofjoin,liabilities,phone,email,idtype,idnumber,"
            + "gender,fieldofwork,address,branchId,notes,lastupdatedby,userpublicid,statusId) "
            + "VALUES ("
            + "#{publicId},"
            + "#{fullname},"
            + "#{dateOfBirth},"
            + "#{dateOfJoin},"
            + "#{liabilities},"
            + "#{phone},"
            + "#{email},"
            + "#{idType},"
            + "#{idNumber},"
            + "#{gender},"
            + "#{fieldOfWork},"
            + "#{address},"
            + "#{branchId},"
            + "#{notes},"
            + "#{lastUpdatedBy},"
            + "#{userPublicId},"
            + "3)";
    final static String DELETE_BY_PUBLICID = "INSERT INTO tbl_employee "
            + "(publicid,fullname,dateofbirth,dateofjoin,liabilities,phone,email,idtype,idnumber,gender,"
            + "fieldofwork,address,branchId,notes,lastupdatedby,statusId,userpublicid) "
            + "SELECT "
            + "publicid,fullname,dateofbirth,dateofjoin,liabilities,phone,email,idtype,idnumber,gender,"
            + "fieldofwork,address,branchId,notes,#{lastUpdatedBy}::int,2,userpublicid "
            + "FROM vw_employee WHERE publicid=#{publicId}";
    final static String SELECT_BY_ID = "SELECT * FROM tbl_employee WHERE ID=#{id}";
    final static String SELECT_BY_PUBLICID = "SELECT * FROM vw_employee WHERE publicid=#{publicid}";
    final static String SELECT_LAST_BY_PUBLICID = "SELECT * FROM vw_employee_last WHERE publicid=#{publicid}";
    final static String SELECT_PAGE = "SELECT * FROM vw_employee limit #{limit} offset #{offset}";
    final static String SELECT_COUNT = "SELECT count(1) FROM vw_employee";
    final static String SELECT_BY_BRANCH = "SELECT * FROM vw_employee where branchid=#{branchPublicId}";
    final static String SELECT_EMPLOYEE_CORP_NOUSER = "SELECT * FROM vw_employee where branchid=-1 and userpublicid is null";
    
    @Override
    @Delete(DELETE_BY_PUBLICID)
    abstract void deleteByPublicId(
            @Param("publicId")int publicId,
            @Param("lastUpdatedBy") int lastUpdatedBy) throws Exception;
    
    @Override
    @Insert(INSERT)
    abstract void insert(EmployeeBean bean) throws Exception;
    
    @Override
    @Update(UPDATE_BY_PUBLICID)
    abstract void updateByPublicId(EmployeeBean bean) throws Exception;
    
    @Override
    @Select(SELECT_BY_ID)
    abstract EmployeeBean selectById(@Param("id") int id) throws Exception;
    
    @Override
    @Select(SELECT_BY_PUBLICID)
    @Results(value = {
        @Result(property = "branch", column = "branchId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectByPublicId")),
        @Result(property = "lastUpdatedUser", column = "lastUpdatedBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectByPublicId"))
    })
    abstract EmployeeBean selectByPublicId(@Param("publicid") int publicid) throws Exception;
    
    @Override
    @Select(SELECT_LAST_BY_PUBLICID)
    @Results(value = {
        @Result(property = "branch", column = "branchId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectLastByPublicId")),
        @Result(property = "lastUpdatedUser", column = "lastUpdatedBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectLastByPublicId"))
    })
    abstract EmployeeBean selectLastByPublicId(@Param("publicid") int publicid) throws Exception;
    
    @Override
    @Select(SELECT_PAGE)
    abstract List<EmployeeBean> selectPage(
            @Param("limit") int limit,
            @Param("offset") int offset) throws Exception;
    
    @Override
    @Select(SELECT_COUNT)
    abstract Integer selectCountAll() throws Exception;
    
    @Select(SELECT_BY_BRANCH)
    abstract List<EmployeeBean> selectByBranch(
            @Param("branchPublicId") int branchPublicId) throws Exception;
    
    @Select(SELECT_EMPLOYEE_CORP_NOUSER)
    abstract List<EmployeeBean> selectEmployeeCorpNoUser() throws Exception;
}