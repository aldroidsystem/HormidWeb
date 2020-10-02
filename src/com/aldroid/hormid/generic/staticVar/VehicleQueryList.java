package com.aldroid.hormid.generic.staticvar;



public final class VehicleQueryList {  

    public static final String INSERT_VEHICLE = "insert into tb_vehicle "
    		+ "(PLATE_NUMBER,VEHICLE_TYPE,DEFAULT_BIAYA_BONGKAR,CATATAN,CREATED_BY) "
    		+ "values ("
    		+ "#{plateNumber,jdbcType=VARCHAR}"
    		+ ",#{vehicleType,jdbcType=VARCHAR}"
    		+ ",#{defaultBiayaBongkar,jdbcType=INTEGER}"
    		+ ",#{catatan,jdbcType=VARCHAR}"
    		+ ",#{createdBy,jdbcType=VARCHAR})";  

    public static final String UPDATE_VEHICLE = "update tb_vehicle "
    		+ "set PLATE_NUMBER=#{plateNumber,jdbcType=VARCHAR}"
    		+ ",VEHICLE_TYPE=#{vehicleType,jdbcType=VARCHAR}"
    		+ ",DEFAULT_BIAYA_BONGKAR=#{defaultBiayaBongkar,jdbcType=INTEGER}"
    		+ ",catatan=#{catatan,jdbcType=VARCHAR} "
    		+ "where vehicle_id = #{vehicleId,jdbcType=INTEGER}";  
    
    public static final String INSERT_USER_ROLE_VEHICLE = "insert into tbr_user_role_vehicle "
    		+ "(vehicle_id,username, role_code) "
    		+ "values ("
    		+ "#{vehicleId,jdbcType=INTEGER}"
    		+ ",#{username,jdbcType=VARCHAR}"
    		+ ",#{roleCode,jdbcType=VARCHAR})";  
    
    public static final String DELETE_USER_ROLE_VEHICLE = "delete from tbr_user_role_vehicle "
    		+ "where vehicle_id=#{vehicleId,jdbcType=INTEGER} "
    		+ "and username=#{username,jdbcType=VARCHAR} "
    		+ "and role_code=#{roleCode,jdbcType=VARCHAR}";  
    
    public static final String SELECT_LAST_VEHICLE_DETAILS = "select * from tb_vehicle where vehicle_id=(select max(vehicle_id) from tb_vehicle)";  

    public static final String SELECT_USER_OF_VEHICLE_ROLE = "select tbvs.username, tbu.fullname "
    		+ "from tbr_user_role_vehicle tbvs "
    		+ "inner join tb_user tbu on tbvs.username=tbu.username "
    		+ "WHERE tbvs.vehicle_id = #{vehicleId,jdbcType=INTEGER} "
    		+ "and tbvs.role_code = #{roleCode,jdbcType=INTEGER}";  
    
    public static final String SELECT_VEHICLE_OF_USER_ROLE = "select tbvs.vehicle_id, tbv.plate_number "
    		+ "from tbr_user_role_vehicle tbvs "
    		+ "inner join tb_vehicle tbv on tbvs.vehicle_id=tbv.vehicle_id "
    		+ "WHERE tbvs.username = #{username,jdbcType=VARCHAR} "
    		+ "AND tbvs.role_code=#{roleCode,jdbcType=VARCHAR}";  

    public static final String SEARCH_VEHICLE_BY_PLATENUMBER = "SELECT * from tb_vehicle "
    		+ "where lower(plate_number) like '%'||lower(#{plateNumber}) ||'%'";
    
    public static final String SELECT_VEHICLE_BY_VEHICLEID = "SELECT * from tb_vehicle "
    		+ "where vehicle_id= #{vehicleId,jdbcType=INTEGER}";
    
    public static final String CHECK_DUPLICATE_PLATENUMBER = "SELECT count(1) from tb_vehicle where lower(plate_number) like lower(#{plateNumber})";  

    public static final String LOAD_ALL_VEHICLE = "SELECT VEHICLE_ID, PLATE_NUMBER FROM TB_VEHICLE";
    
    public static final String SELECT_SUPIR_OF_VEHICLE = "select tbvs.username, tbu.fullname "
    		+ "from tbr_user_role_vehicle tbvs "
    		+ "inner join tb_user tbu on tbvs.username=tbu.username "
    		+ "WHERE tbvs.vehicle_id = #{vehicleId,jdbcType=INTEGER} "
    		+ "and tbvs.role_code = 'ROLE_SUPIR'";  
    
}