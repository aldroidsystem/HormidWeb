package com.aldroid.hormid.generic.staticvar;

public final class TimbangGantungQueryList {
	
    public static final String TIMBANG_GANTUNG_INSERT = "CALL pr_timbangGantung_insert(" +
        "#{noNota,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{username,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{potongan,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{bruto,   mode=IN,  javaType = java.lang.Float,  jdbcType=FLOAT}, " +
        "#{harga,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{catatan,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{createdBy,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR} " +
        ")";
    
    public static final String SELECT_TIMBANG_GANTUNG_DETAIL = 
    		"SELECT tbtg.*, "
    		+ "u1.fullname createdBy, u2.fullname fullname "
    		+ " FROM tb_timbangGantung tbtg "
    		+ "inner join TB_USER u1 on u1.username = tbtg.created_by "
    		+ "inner join TB_USER u2 on u2.username = tbtg.username "
    		+ "WHERE tbtg.no_nota=#{noNota,jdbcType=VARCHAR} ";
    

    public static final String SELECT_NEXT_SEQUENCE_ID = 
    		"SELECT sq_timbangGantung_id.nextval FROM DUAL";
    
}