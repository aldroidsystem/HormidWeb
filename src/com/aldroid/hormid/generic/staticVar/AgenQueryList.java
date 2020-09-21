package com.aldroid.hormid.generic.staticvar;



public final class AgenQueryList {

    
    public static final String SELECT_NEW_AGEN = "select username, fullname from tb_user where username not in (select username from tb_agen)";    


    public static final String AGEN_UPDATE = "update tb_agen "
    		+ "set CATATAN=#{catatan,jdbcType=VARCHAR}, "
    		+ "DEFAULT_POTONGAN_PERSEN=#{potonganPersen,jdbcType=INTEGER} "
    		+ "where USERNAME=#{username,jdbcType=VARCHAR}";

    public static final String AGEN_INSERT = "insert into tb_agen "
    		+ "(USERNAME,DEFAULT_POTONGAN_PERSEN,CATATAN,CREATED_BY) "
    		+ "values ("
    		+ "#{username,jdbcType=VARCHAR}"
    		+ ",#{potonganPersen,jdbcType=INTEGER}"
    		+ ",#{catatan,jdbcType=VARCHAR}"
    		+ ",#{createdBy,jdbcType=VARCHAR})";
    
    public static final String SELECT_AGEN_DETAIL = 
    		"select tbs.username, tbu.fullname, tbs.DEFAULT_POTONGAN_PERSEN, tbs.TOTAL_HUTANG, tbs.catatan "
    		+ "from tb_agen tbs "
    		+ "inner join tb_user tbu on tbs.username=tbu.username "
    		+ "where tbs.username=#{username}";     
    

    public static final String SEARCH_AGEN_BY_FULLNAME = 
    		"select tbs.username, tbu.fullname, tbs.DEFAULT_POTONGAN_PERSEN, tbs.TOTAL_HUTANG, tbs.catatan "
    		+ "from tb_agen tbs "
    		+ "inner join tb_user tbu on tbs.username=tbu.username "
    		+ "where lower(tbu.fullname) like '%'||lower(#{fullname}) ||'%'";    
    
    public static final String LOAD_AGEN_VEHICLE = "select tbvs.vehicle_id, tbv.plate_number "
    		+ "from tb_vehicle_agen tbvs "
    		+ "inner join tb_vehicle tbv on tbvs.vehicle_id=tbv.vehicle_id "
    		+ "WHERE tbvs.username = #{username,jdbcType=VARCHAR}";     
    
    public static final String LOAD_AGEN_PETANI = "select tbp.username, tbu.fullname "
    		+ "from tb_agen_petani tbap "
    		+ "inner join tb_petani tbp on tbap.petani=tbp.username "
    		+ "inner join tb_user tbu on tbu.username=tbp.username "
    		+ "WHERE tbap.agen = #{username,jdbcType=VARCHAR}"; 


    public static final String AGEN_PETANI_INSERT = "insert into tb_agen_petani "
    		+ "(agen,petani) "
    		+ "values ("
    		+ "#{agen,jdbcType=VARCHAR}"
    		+ ",#{petani,jdbcType=VARCHAR})"; 
    
    public static final String AGEN_PETANI_DELETE = "delete from tb_agen_petani "
    		+ "where agen=#{agen,jdbcType=VARCHAR} "
    		+ "and petani=#{petani,jdbcType=VARCHAR}";  
}