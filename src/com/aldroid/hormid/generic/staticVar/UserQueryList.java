package com.aldroid.hormid.generic.staticVar;



public final class UserQueryList {

    
    public static final String SELECT_USER_BY_USERNAME = "SELECT * from tb_user where username = #{username}";    

    
    
    public static final String SEARCH_USER_BY_NAME = "SELECT username, fullname, area,"
    		+ "flag_Active, login_fail_count, session_instance_count "
    		+ "from tb_user where lower(fullname) like '%'||lower(#{nameSearch}) ||'%'";
    
    public static final String SELECT_USER_ROLE = "SELECT role_code from tb_user_role where username = #{username}";
    
    public static final String SELECT_USER_ROLE_NAME = "SELECT r.role_name from tb_user_role ur inner join tb_role r on r.role_code = ur.role_code where username = #{username}";
    
    public static final String SELECT_ALL_ROLE = "SELECT * from tb_role";
    
    public static final String USER_REGISTRATION = "insert into tb_user "
    		+ "(username,fullname,area,address,phone,email,pwd_expiry_period,created_by) "
    		+ "values(#{username},#{fullname},#{area},#{address},#{phone},#{email},#{passwordExpiryPeriod},#{createdBy})";
    
    public static final String USER_UPDATE = "update tb_user "
    		+ "set fullname=#{fullname},area=#{area},address=#{address},phone=#{phone},"
    		+ "email=#{email},pwd_expiry_period=#{passwordExpiryPeriod},created_by=#{createdBy} "
    		+ "where username = #{username}";

    
    public static final String INSERT_USER_ROLE = "insert into tb_user_role(username,role_code) values(#{username},#{role})";
    
    public static final String USER_DELETE_ROLE = "delete from tb_user_role where username=#{username} and role_code=#{role}";


    public static final String CHECK_DUPLICATE_USER_BY_USERNAME = "SELECT count(1) from tb_user where username = #{username}";  
}