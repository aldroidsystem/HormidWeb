package com.aldroid.hormid.mapper.generic;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aldroid.hormid.model.generic.Role;
import com.aldroid.hormid.model.generic.User;

public interface UserMapper {


    @Select(UserQueryList.SELECT_USER_BY_USERNAME) 
    @Results({
        @Result(property = "username", column ="username"),
        @Result(property = "fullname", column ="fullname"),
        @Result(property = "area", column ="area"),
        @Result(property = "address", column ="address"),
        @Result(property = "catatan", column ="catatan"),
        @Result(property = "phone", column ="phone"),
        @Result(property = "email", column ="email"),
        @Result(property = "password", column ="password"),
        @Result(property = "passwordExpiryPeriod", javaType = Integer.class, column ="pwd_expiry_period"),
        @Result(property = "flagActive", javaType = Integer.class, column ="flag_Active"),
        @Result(property = "loginFailCount", javaType = Integer.class, column ="login_fail_count"),
        @Result(property = "flagDeleted", javaType = Integer.class, column ="flag_deleted"),
        @Result(property = "flagChgPassword", javaType = Integer.class, column ="flag_force_reset_pwd"),
        @Result(property = "sessionInstanceCount", javaType = Integer.class, column ="session_instance_count"),
        @Result(property = "flagPasswordExpired", javaType = Integer.class, column ="flagPasswordExpired"),
        @Result(property = "flagLocked", javaType = Integer.class, column ="flag_locked"),
        @Result(property = "flagNeverDisable", javaType = Integer.class, column ="flag_never_locked"),
        @Result(property = "roles", javaType = List.class, column="username",
                many = @Many(select = "loadUserRole"))})
    abstract User findByUsername(@Param("username") String username);

    
    @Select(UserQueryList.SELECT_USER_ROLE)
    abstract List<String> loadUserRole(@Param("username") String username);
    

    @Select(UserQueryList.SELECT_USER_ROLE_NAME)
    abstract List<String> loadUserRoleName(@Param("username") String username);
    
    
    @Insert(UserQueryList.USER_REGISTRATION)
    abstract void registerNewUser(User bean);

    
    @Update(UserQueryList.USER_UPDATE)
    abstract void updateUser(User bean);

    @Update(UserQueryList.USER_UPDATE_PROFILE)
    abstract void updateProfile(User bean);
    
    @Insert(UserQueryList.INSERT_USER_ROLE)
    abstract void insertUserRole(@Param("username") String username,@Param("role") String role);

    
    @Delete(UserQueryList.USER_DELETE_ROLE)
    abstract void deleteUserRole(@Param("username") String username,@Param("role") String role);
    
    
    @Select(UserQueryList.SELECT_ALL_ROLE)
    @Results({
        @Result(property = "code", column ="role_code"),
        @Result(property = "name", column ="role_name"),
        @Result(property = "description", column ="role_desc"),
        @Result(property = "flagActive", javaType = Integer.class, column ="flagActive"),
        @Result(property = "flagDeleted", javaType = Integer.class, column ="flagDeleted")
    })
    abstract List<Role> selectAllRole();

    
    @Select(UserQueryList.SEARCH_USER_BY_NAME) 
    @Results({
        @Result(property = "username", column ="username"),
        @Result(property = "fullname", column ="fullname"),
        @Result(property = "hutang", column ="hutang"),
        @Result(property = "area", column ="area"),
        @Result(property = "roles", javaType = List.class, column="username",
                many = @Many(select = "loadUserRoleName"))})
    abstract List<User> searchUser(@Param("nameSearch") String nameSearch);
    

    @Select(UserQueryList.CHECK_DUPLICATE_USER_BY_USERNAME) 
    abstract Integer checkDuplicateUsername(@Param("username") String username);
    

    @Update(UserQueryList.USER_RESET_PASSWORD)
    abstract void resetPassword(User bean);

    @Select(UserQueryList.SELECT_LIST_PETANI)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class)
    })
    abstract List<User> selectListPetani() throws Exception;

    @Select(UserQueryList.SELECT_LIST_SUPIR)
    @Results({
        @Result(property = "username", column ="username", javaType = String.class),
        @Result(property = "fullname", column ="fullname", javaType = String.class)
    })
    abstract List<User> selectListSupir() throws Exception;
    


    @Select(UserQueryList.SELECT_PENGGUNA_TRANSACTION) 
    @Results({
        @Result(property = "username", column ="username"),
        @Result(property = "hutang", column ="hutang"),
        @Result(property = "defaultPotongan", column ="default_potongan"),
        @Result(property = "catatan", column ="catatan"),
        @Result(property = "fullname", column ="fullname", javaType = String.class)
        })
    abstract User selectPenggunaTransaction(@Param("username") String username);
}
