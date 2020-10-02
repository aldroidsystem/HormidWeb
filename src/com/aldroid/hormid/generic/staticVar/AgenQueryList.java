package com.aldroid.hormid.generic.staticvar;



public final class AgenQueryList {
    
    public static final String SELECT_NEW_AGEN = "select username, fullname from tb_user where username not in (select username from tb_agen)";    

    public static final String AGEN_UPDATE = "update tb_user "
    		+ "set CATATAN=#{catatan,jdbcType=VARCHAR}, "
    		+ "DEFAULT_POTONGAN=#{defaultPotongan,jdbcType=INTEGER} "
    		+ "where USERNAME=#{username,jdbcType=VARCHAR}";

    
    public static final String SELECT_AGEN_DETAIL = 
    		"select username, fullname, DEFAULT_POTONGAN, catatan "
    		+ "from tb_user "
    		+ "where username=#{username} "
    		+ "and username in (select username from tbr_user_role where role_code='ROLE_AGEN')";     
    

    public static final String SEARCH_AGEN_BY_FULLNAME = 
    		"select username, fullname, DEFAULT_POTONGAN "
    		+ "from tb_user "
    		+ "where username in (select username from tbr_user_role where role_code='ROLE_AGEN') "
    		+ "AND lower(fullname) like '%'||lower(#{fullname}) ||'%'";   
    
    public static final String LOAD_AGEN_PETANI = "select tbu.username, tbu.fullname "
    		+ "from tb_agen_petani tbap "
    		+ "inner join tb_user tbu on tbu.username=tbap.petani "
    		+ "WHERE tbap.agen = #{username,jdbcType=VARCHAR} "; 

    public static final String AGEN_PETANI_INSERT = "insert into tb_agen_petani "
    		+ "(agen,petani) "
    		+ "values ("
    		+ "#{agen,jdbcType=VARCHAR}"
    		+ ",#{petani,jdbcType=VARCHAR})"; 
    
    public static final String AGEN_PETANI_DELETE = "delete from tb_agen_petani "
    		+ "where agen=#{agen,jdbcType=VARCHAR} "
    		+ "and petani=#{petani,jdbcType=VARCHAR}";  
    
    public static final String SELECT_VEHICLE_OF_AGEN = "select tbvs.vehicle_id, tbv.plate_number "
    		+ "from tbr_user_role_vehicle tbvs "
    		+ "inner join tb_vehicle tbv on tbvs.vehicle_id=tbv.vehicle_id "
    		+ "WHERE tbvs.username = #{username,jdbcType=VARCHAR} "
    		+ "AND tbvs.role_code='ROLE_AGEN'";  
}