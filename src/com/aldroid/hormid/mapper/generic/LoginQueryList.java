package com.aldroid.hormid.mapper.generic;



public final class LoginQueryList {

    public static final String SELECT_USER_BY_USERNAME_LOGIN = "SELECT username, password, flag_Active, login_fail_count, flag_deleted, flag_force_reset_pwd, flag_locked, session_instance_count, "
    		+ "(case when pwd_expiry_period is null or pwd_expiry_period <= 0 then 0 "
    		+ "when trunc(sysdate) - trunc(pwd_chg_date) > pwd_expiry_period then 1 "
    		+ "else 0 end) flagPasswordExpired "
    		+ "from tb_user where username = #{username}";  
    
    
    
    public static final String SELECT_USER_ROLE = "SELECT role_code from tbr_user_role where username = #{username}";
    
    public static final String SELECT_USER_ROLE_NAME = "SELECT r.role_name from tbr_user_role ur inner join tb_role r on r.role_code = ur.role_code where username = #{username}";
    
    public static final String SELECT_ALL_ROLE = "SELECT * from tb_role";
    
    public static final String USER_UPDATE_PASSWORD = "update tb_user set password=#{password}, pwd_chg_date=current_timestamp where username=#{username}";

    public static final String USER_LOGIN_FAILED = "update tb_user "
    		+ "set login_fail_count=login_fail_count+1, "
    		+ "flag_locked = (case when flag_never_locked = 1 then 0 when login_fail_count+1 >= #{maxLoginCount} and #{maxLoginCount} > 0 then 1 else 0 end) "
    		+ "where username=#{username}";

    public static final String USER_LOGIN_SUCCEDED = "update tb_user set login_fail_count=0 where username=#{username} and login_fail_count<>0";

}