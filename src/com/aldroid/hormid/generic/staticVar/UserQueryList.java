package com.aldroid.hormid.generic.staticvar;



public final class UserQueryList {

    
    public static final String SELECT_USER_BY_USERNAME = "SELECT * from tb_user where username = #{username}";      
    
    public static final String SEARCH_USER_BY_NAME = "SELECT username, fullname, area "
    		+ "from tb_user where lower(fullname) like '%'||lower(#{nameSearch}) ||'%'";
    
    public static final String SELECT_USER_ROLE = "SELECT role_code from tbr_user_role where username = #{username}";
    
    public static final String SELECT_USER_ROLE_NAME = "SELECT r.role_name from tbr_user_role ur inner join tb_role r on r.role_code = ur.role_code where username = #{username}";
    
    public static final String SELECT_ALL_ROLE = "SELECT * from tb_role";
    
    public static final String USER_REGISTRATION = "insert into tb_user "
    		+ "(username,password,fullname,area,address,phone,email,pwd_expiry_period,flag_never_locked,flag_Active,created_by,catatan) "
    		+ "values("
    		+ "#{username,jdbcType=VARCHAR},"
    		+ "#{password,jdbcType=VARCHAR},"
    		+ "#{fullname,jdbcType=VARCHAR},"
    		+ "#{area,jdbcType=VARCHAR},"
    		+ "#{address,jdbcType=VARCHAR},"
    		+ "#{phone,jdbcType=VARCHAR},"
    		+ "#{email,jdbcType=VARCHAR},"
    		+ "#{passwordExpiryPeriod,jdbcType=SMALLINT},"
    		+ "#{flagNeverDisable,jdbcType=SMALLINT},"
    		+ "#{flagActive,jdbcType=SMALLINT},"
    		+ "#{createdBy,jdbcType=VARCHAR}),"
    		+ "#{catatan,jdbcType=VARCHAR})";
    
    public static final String USER_UPDATE = "update tb_user "
    		+ "set fullname=#{fullname,jdbcType=VARCHAR},"
    		+ "area=#{area,jdbcType=VARCHAR},"
    		+ "address=#{address,jdbcType=VARCHAR},"
    		+ "phone=#{phone,jdbcType=VARCHAR},"
    		+ "email=#{email,jdbcType=VARCHAR},"
    		+ "catatan=#{catatan,jdbcType=VARCHAR},"
    		+ "pwd_expiry_period=#{passwordExpiryPeriod,jdbcType=SMALLINT},"
    		+ "flag_never_locked=#{flagNeverDisable,jdbcType=SMALLINT},"
    		+ "flag_Active=#{flagActive,jdbcType=SMALLINT} "
    		+ "where username = #{username,jdbcType=VARCHAR}";

    public static final String USER_UPDATE_PROFILE = "update tb_user "
    		+ "set fullname=#{fullname,jdbcType=VARCHAR},"
    		+ "area=#{area,jdbcType=VARCHAR},"
    		+ "address=#{address,jdbcType=VARCHAR},"
    		+ "phone=#{phone,jdbcType=VARCHAR},"
    		+ "email=#{email,jdbcType=VARCHAR} "
    		+ "where username = #{username,jdbcType=VARCHAR}";
    
    public static final String INSERT_USER_ROLE = "insert into tbr_user_role(username,role_code) values(#{username},#{role})";
    
    public static final String USER_DELETE_ROLE = "delete from tbr_user_role where username=#{username} and role_code=#{role}";

    public static final String CHECK_DUPLICATE_USER_BY_USERNAME = "SELECT count(1) from tb_user where username = #{username}";  

    public static final String USER_RESET_PASSWORD = "update tb_user "
    		+ "set password=#{password,jdbcType=VARCHAR} "
    		+ "where username = #{username,jdbcType=VARCHAR}";
    
    public static final String SELECT_LIST_PETANI = "select username, fullname from tb_user where username in (select username from tbr_user_role where role_code='ROLE_PETANI')";    

    public static final String SELECT_LIST_SUPIR = "select username, fullname from tb_user where username in (select username from tbr_user_role where role_code='ROLE_SUPIR')";  

    public static final String SELECT_PENGGUNA_TRANSACTION = "SELECT username, fullname, default_potongan, hutang, catatan from tb_user where username = #{username}"; }