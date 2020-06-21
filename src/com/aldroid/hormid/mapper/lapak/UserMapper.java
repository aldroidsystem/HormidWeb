package com.aldroid.hormid.mapper.lapak;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import com.aldroid.hormid.generic.QueryDao;
import com.aldroid.hormid.model.lapak.User;

public interface UserMapper {


    @Select(QueryDao.SELECT_USER_BY_USERNAME) 
    @Results({
        @Result(property = "username", column ="username"),
        @Result(property = "fullname", column ="fullname"),
        @Result(property = "area", column ="area"),
        @Result(property = "address", column ="address"),
        @Result(property = "phone", column ="phone"),
        @Result(property = "email", column ="email"),
        @Result(property = "password", column ="password"),
        @Result(property = "flagActive", javaType = Integer.class, column ="flagActive"),
        @Result(property = "loginFailCount", javaType = Integer.class, column ="login_fail_count"),
        @Result(property = "flagDeleted", javaType = Integer.class, column ="flagDeleted"),
        @Result(property = "flagChgPassword", javaType = Integer.class, column ="flagChgPassword"),
        @Result(property = "roles", javaType = List.class, column="username",
                many = @Many(select = "loadUserRole"))})
    abstract User findByUsername(@Param("username") String username);
    

    @Select(QueryDao.SELECT_USER_ROLE) 
    abstract List<String> loadUserRole(@Param("username") String username);
    
    
    
    

    @Insert(QueryDao.USER_REGISTRATION)
    abstract void registerNewUser(User bean);

    @Insert(QueryDao.USER_REGISTRATION_ROLE)
    abstract void registerNewUserRole(@Param("username") String username,@Param("role") String role);
}