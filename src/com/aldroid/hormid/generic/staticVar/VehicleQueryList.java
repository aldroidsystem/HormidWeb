package com.aldroid.hormid.generic.staticvar;



public final class VehicleQueryList {

    

    public static final String VEHICLE_INSERT = "insert into tb_vehicle "
    		+ "(PLATE_NUMBER,VEHICLE_TYPE,DEFAULT_BIAYA_BONGKAR,CATATAN,CREATED_BY) "
    		+ "values ("
    		+ "#{plateNumber,jdbcType=VARCHAR}"
    		+ ",#{vehicleType,jdbcType=VARCHAR}"
    		+ ",#{defaultBiayaBongkar,jdbcType=INTEGER}"
    		+ ",#{catatan,jdbcType=VARCHAR}"
    		+ ",#{createdBy,jdbcType=VARCHAR})";  

    public static final String VEHICLE_UPDATE = "update tb_vehicle "
    		+ "set PLATE_NUMBER=#{plateNumber,jdbcType=VARCHAR}"
    		+ ",VEHICLE_TYPE=#{vehicleType,jdbcType=VARCHAR}"
    		+ ",DEFAULT_BIAYA_BONGKAR=#{defaultBiayaBongkar,jdbcType=INTEGER}"
    		+ ",catatan=#{catatan,jdbcType=VARCHAR} "
    		+ "where vehicle_id = #{vehicleId,jdbcType=INTEGER}";  
    
    public static final String VEHICLE_SUPIR_INSERT = "insert into tb_vehicle_supir "
    		+ "(vehicle_id,username) "
    		+ "values ("
    		+ "#{vehicleId,jdbcType=INTEGER}"
    		+ ",#{username,jdbcType=VARCHAR})";  
    
    public static final String VEHICLE_PETANI_INSERT = "insert into tb_vehicle_petani "
    		+ "(vehicle_id,username) "
    		+ "values ("
    		+ "#{vehicleId,jdbcType=INTEGER}"
    		+ ",#{username,jdbcType=VARCHAR})"; 
    
    public static final String VEHICLE_SUPIR_DELETE = "delete from tb_vehicle_supir "
    		+ "where vehicle_id=#{vehicleId,jdbcType=INTEGER} "
    		+ "and username=#{username,jdbcType=VARCHAR}";  
    
    public static final String VEHICLE_PETANI_DELETE = "delete from tb_vehicle_petani "
    		+ "where vehicle_id=#{vehicleId,jdbcType=INTEGER} "
    		+ "and username=#{username,jdbcType=VARCHAR}";  
    
    
    public static final String SELECT_LAST_VEHICLE_DETAILS = "select * from tb_vehicle where vehicle_id=(select max(vehicle_id) from tb_vehicle)";  

    public static final String LOAD_VEHICLE_SUPIR = "select tbvs.username, tbu.fullname "
    		+ "from tb_vehicle_supir tbvs "
    		+ "inner join tb_user tbu on tbvs.username=tbu.username "
    		+ "WHERE tbvs.vehicle_id = #{vehicleId,jdbcType=INTEGER}";  

    public static final String SEARCH_VEHICLE_BY_PLATENUMBER = "SELECT * from tb_vehicle "
    		+ "where lower(plate_number) like '%'||lower(#{plateNumber}) ||'%'";
    
    
    public static final String SELECT_VEHICLE_BY_VEHICLEID = "SELECT * from tb_vehicle "
    		+ "where vehicle_id= #{vehicleId,jdbcType=INTEGER}";
    
    public static final String CHECK_DUPLICATE_PLATENUMBER = "SELECT count(1) from tb_vehicle where lower(plate_number) like lower(#{plateNumber})";  

    public static final String LOAD_ALL_VEHICLE = "SELECT VEHICLE_ID, PLATE_NUMBER FROM TB_VEHICLE";
}