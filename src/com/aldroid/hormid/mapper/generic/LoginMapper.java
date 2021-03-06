package com.aldroid.hormid.mapper.generic;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aldroid.hormid.model.generic.User;

public interface LoginMapper {


   
    @Select(LoginQueryList.SELECT_USER_BY_USERNAME_LOGIN) 
    @Results({
        @Result(property = "username", column ="username"),
        @Result(property = "password", column ="password"),
        @Result(property = "flagActive", javaType = Integer.class, column ="flag_Active"),
        @Result(property = "loginFailCount", javaType = Integer.class, column ="login_fail_count"),
        @Result(property = "flagDeleted", javaType = Integer.class, column ="flag_deleted"),
        @Result(property = "flagChgPassword", javaType = Integer.class, column ="flag_force_reset_pwd"),
        @Result(property = "sessionInstanceCount", javaType = Integer.class, column ="session_instance_count"),
        @Result(property = "flagPasswordExpired", javaType = Integer.class, column ="flagPasswordExpired"),
        @Result(property = "flagLocked", javaType = Integer.class, column ="flag_locked"),
        @Result(property = "roles", javaType = List.class, column="username",
                many = @Many(select = "loadUserRole"))})
    abstract User loginByUsername(@Param("username") String username);
    

    @Select(LoginQueryList.SELECT_USER_ROLE)
    abstract List<String> loadUserRole(@Param("username") String username);
    
        
    @Update(LoginQueryList.USER_UPDATE_PASSWORD)
    abstract void updateUserPassword(User bean);


    @Update(LoginQueryList.USER_LOGIN_FAILED)
    abstract void userLoginFailed(@Param("username") String username, @Param("maxLoginCount") Integer maxLoginCount);

    @Update(LoginQueryList.USER_LOGIN_SUCCEDED)
    abstract void userLoginSucceeded(@Param("username") String username);
    
}
