package com.aldroid.hormid.generic.staticvar;



public final class PetaniQueryList {


    public static final String PETANI_UPDATE = "update tb_user "
    		+ "set CATATAN=#{catatan,jdbcType=VARCHAR}, "
    		+ "DEFAULT_POTONGAN=#{defaultPotongan,jdbcType=INTEGER} "
    		+ "where USERNAME=#{username,jdbcType=VARCHAR}";

    
    public static final String SELECT_PETANI_DETAIL = 
    		"select username, fullname, DEFAULT_POTONGAN, catatan "
    		+ "from tb_user "
    		+ "where username=#{username} "
    		+ "and username in (select username from tbr_user_role where role_code='ROLE_PETANI')";     
    

    public static final String SEARCH_PETANI_BY_FULLNAME = 
    		"select username, fullname, DEFAULT_POTONGAN "
    		+ "from tb_user "
    		+ "where lower(fullname) like '%'||lower(#{fullname}) ||'%' "
    		+ "and username in (select username from tbr_user_role where role_code='ROLE_PETANI')"; 
    
    public static final String SELECT_VEHICLE_OF_PETANI = "select tbvs.vehicle_id, tbv.plate_number "
    		+ "from tbr_user_role_vehicle tbvs "
    		+ "inner join tb_vehicle tbv on tbvs.vehicle_id=tbv.vehicle_id "
    		+ "WHERE tbvs.username = #{username,jdbcType=VARCHAR} "
    		+ "AND tbvs.role_code='ROLE_PETANI'";  
}