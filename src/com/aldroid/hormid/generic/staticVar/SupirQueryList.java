package com.aldroid.hormid.generic.staticvar;



public final class SupirQueryList {

    
    public static final String SELECT_NEW_SUPIR = "select username, fullname from tb_user where username not in (select username from tb_supir)";    


    public static final String SUPIR_UPDATE = "update tb_supir "
    		+ "set CATATAN=#{catatan,jdbcType=VARCHAR} "
    		+ "where USERNAME=#{username,jdbcType=VARCHAR}";

    public static final String SUPIR_INSERT = "insert into tb_supir "
    		+ "(USERNAME,CATATAN,CREATED_BY) "
    		+ "values ("
    		+ "#{username,jdbcType=VARCHAR}"
    		+ ",#{catatan,jdbcType=VARCHAR}"
    		+ ",#{createdBy,jdbcType=VARCHAR})";
    
    public static final String SELECT_SUPIR_DETAIL = "select tbs.username, tbu.fullname, tbs.catatan "
    		+ "from tb_supir tbs "
    		+ "inner join tb_user tbu on tbs.username=tbu.username  where tbs.username=#{username}";    

    public static final String SELECT_SUPIR_LIST = "select tbs.username, tbu.fullname "
    		+ "from tb_supir tbs "
    		+ "inner join tb_user tbu on tbs.username=tbu.username";  
    

    public static final String SEARCH_SUPIR_BY_FULLNAME = "select tbs.username, tbu.fullname, tbs.catatan "
    		+ "from tb_supir tbs "
    		+ "inner join tb_user tbu on tbs.username=tbu.username "
    		+ "where lower(tbu.fullname) like '%'||lower(#{fullname}) ||'%'";    
    
    public static final String LOAD_SUPIR_VEHICLE = "select tbvs.vehicle_id, tbv.plate_number "
    		+ "from tb_vehicle_supir tbvs "
    		+ "inner join tb_vehicle tbv on tbvs.vehicle_id=tbv.vehicle_id "
    		+ "WHERE tbvs.username = #{username,jdbcType=VARCHAR}"; 
}