package com.aldroid.hormid.generic;

public final class QueryDao {

    public final static String HARGA_INSERT = "call pr_harga_insert"
    		+ "(#{createdBy}"
    		+ ",#{createdDate}"
    		+ ",#{hargaJual}"
    		+ ",#{hargaBeli})";

    public final static String HARGA_SELECT_ALL = "SELECT * FROM TB_HARGA";
    
    public final static String SELECT_USER_BY_USERNAME = "SELECT username, fullname, area, address, phone, email, password, flagActive, login_fail_count, flagDeleted, flagChgPassword "
    		+ "from tb_user where username = #{username}";
    

    public final static String SELECT_USER_ROLE = "SELECT role_code from tb_user_role where username = #{username}";
    
    
    public final static String USER_REGISTRATION = "insert into tb_user(username,password) values(#{username},#{password})";
    public final static String USER_REGISTRATION_ROLE = "insert into tb_user_role(username,role_code) values(#{username},#{role})";
}
