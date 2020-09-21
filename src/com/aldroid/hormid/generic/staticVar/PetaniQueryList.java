package com.aldroid.hormid.generic.staticvar;



public final class PetaniQueryList {

    
    public static final String SELECT_NEW_PETANI = "select username, fullname from tb_user where username not in (select username from tb_petani)";    

    public static final String SELECT_DAFTAR_PETANI = "select username, fullname from tb_user where username in (select username from tb_petani)";    

    public static final String PETANI_UPDATE = "update tb_petani "
    		+ "set CATATAN=#{catatan,jdbcType=VARCHAR}, "
    		+ "DEFAULT_POTONGAN_PERSEN=#{potonganPersen,jdbcType=INTEGER} "
    		+ "where USERNAME=#{username,jdbcType=VARCHAR}";

    public static final String PETANI_INSERT = "insert into tb_petani "
    		+ "(USERNAME,DEFAULT_POTONGAN_PERSEN,CATATAN,CREATED_BY) "
    		+ "values ("
    		+ "#{username,jdbcType=VARCHAR}"
    		+ ",#{potonganPersen,jdbcType=INTEGER}"
    		+ ",#{catatan,jdbcType=VARCHAR}"
    		+ ",#{createdBy,jdbcType=VARCHAR})";
    
    public static final String SELECT_PETANI_DETAIL = 
    		"select tbs.username, tbu.fullname, tbs.DEFAULT_POTONGAN_PERSEN, tbs.TOTAL_HUTANG, tbs.catatan "
    		+ "from tb_petani tbs "
    		+ "inner join tb_user tbu on tbs.username=tbu.username "
    		+ "where tbs.username=#{username}";     
    

    public static final String SEARCH_PETANI_BY_FULLNAME = 
    		"select tbs.username, tbu.fullname, tbs.DEFAULT_POTONGAN_PERSEN, tbs.TOTAL_HUTANG, tbs.catatan "
    		+ "from tb_petani tbs "
    		+ "inner join tb_user tbu on tbs.username=tbu.username "
    		+ "where lower(tbu.fullname) like '%'||lower(#{fullname}) ||'%'";    
    
    public static final String LOAD_PETANI_VEHICLE = "select tbvs.vehicle_id, tbv.plate_number "
    		+ "from tb_vehicle_petani tbvs "
    		+ "inner join tb_vehicle tbv on tbvs.vehicle_id=tbv.vehicle_id "
    		+ "WHERE tbvs.username = #{username,jdbcType=VARCHAR}"; 
}