package com.aldroid.hormid.mapper.transaksi;

public final class TimbangJembatanQueryList {


    public static final String INSERT_TIMBANG_JEMBATAN = "CALL pr_timbangJembatanTemp_insert(" +
        "#{noNota,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{pengirim,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{supir,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{vehicleId,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{plateNumber,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{bruto,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{tare,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{potongan,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{harga,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{biayaBongkar,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{biayaMobil,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{potonganBon,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{biayaLain,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{keteranganBiayaLain,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{catatan,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{timbang1By,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR} " +
        ")";
    
    
    public static final String UPDATE_TIMBANG_JEMBATAN = "CALL pr_timbangJembatanTemp_update(" +
            "#{noNota,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
            "#{pengirim,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
            "#{supir,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
            "#{vehicleId,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{plateNumber,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
            "#{bruto,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{tare,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{potongan,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{harga,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{biayaBongkar,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{biayaMobil,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{potonganBon,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{biayaLain,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{keteranganBiayaLain,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
            "#{catatan,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
            "#{timbang1By,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR} " +
            ")";
    
    
    public static final String UPDATE_TIMBANG_JEMBATAN_BAYAR = "CALL pr_timbangJembatan_payment(" +
            "#{noNota,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
            "#{pengirim,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
            "#{potonganBon,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
            "#{paidBy,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR} " +
            ")";

    public static final String SELECT_TIMBANG_JEMBATAN_TEMP_DETAIL = 
    		"SELECT jtemp.*, pengirim.hutang hutangPengirim, pengirim.catatan catatanPengirim, "
    		+ "supir.catatan catatanSupir, veh.catatan catatanVehicle "
    		+ "FROM tb_timbangJembatanTemp jtemp "
    		+ "inner join tb_user pengirim on pengirim.username=jtemp.pengirim "
    		+ "inner join tb_user supir on supir.username=jtemp.supir "
    		+ "inner join tb_vehicle veh on veh.vehicle_id=jtemp.vehicle_id "
    		+ "WHERE jtemp.no_nota=#{noNota,jdbcType=VARCHAR} ";

    public static final String SELECT_TIMBANG_JEMBATAN_PAID_DETAIL = 
    		"SELECT jtemp.*, pengirim.hutang hutangPengirim "
    		+ "FROM tb_timbangJembatanTemp jtemp "
    		+ "inner join tb_user pengirim on pengirim.username=jtemp.pengirim "
    		+ "WHERE jtemp.no_nota=#{noNota,jdbcType=VARCHAR} ";
    
    public static final String SELECT_TIMBANG_JEMBATAN_NOTCOMPLETE = 
    		"SELECT jt.no_nota, jt.plate_number, pengirim.fullname as pengirim, supir.fullname as supir, jt.bruto, jt.TIMESTAMP_TIMBANG1 "
    		+ "FROM tb_timbangJembatanTemp jt "
    		+ "inner join tb_vehicle v on v.vehicle_id = jt.vehicle_id "
    		+ "inner join tb_user pengirim on pengirim.username = jt.pengirim "
    		+ "inner join tb_user supir on supir.username = jt.supir ";
    

    public static final String SELECT_NEXT_SEQUENCE_ID = 
    		"SELECT sq_timbangJembatan_id.nextval FROM DUAL";
}