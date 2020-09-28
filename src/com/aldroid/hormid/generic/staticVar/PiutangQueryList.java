package com.aldroid.hormid.generic.staticvar;

public final class PiutangQueryList {

    public static final String PIUTANG_INSERT = "CALL pr_piutang_insert(" +
        "#{piutangId,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{username,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{amount,   mode=IN,  javaType = java.lang.Integer,  jdbcType=INTEGER}, " +
        "#{jenisTransaksi,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{keterangan,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{catatan,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR}, " +
        "#{createdBy,   mode=IN,  javaType = java.lang.String,  jdbcType=VARCHAR} " +
//        "#{output,  mode=OUT, javaType = java.lang.String,  jdbcType=VARCHAR}"
        ")";
    
    public static final String SELECT_PEMINJAM_DETAIL = 
    		"SELECT u.username, u.fullname, u.hutang "
    		+ " FROM TB_USER u WHERE u.username=#{username,jdbcType=VARCHAR}";
    
       
    public static final String SELECT_PIUTANG_HISTORY = 
    		"SELECT tbp.piutang_id, tbp.HUTANG, tbp.BAYAR, tbp.SISA_HUTANG, tbp.KETERANGAN, u.fullname, tbp.CREATED_DATE "
    		+ " FROM tb_piutang tbp "
    		+ "inner join TB_USER u on u.username = tbp.created_by "
    		+ "WHERE tbp.username=#{username,jdbcType=VARCHAR} "
    		+ "AND (#{dariTanggal,jdbcType=DATE} IS NULL OR trunc(tbp.CREATED_DATE) >= #{dariTanggal,jdbcType=DATE}) "
    		+ "AND (#{sampaiTanggal,jdbcType=DATE} IS NULL OR trunc(tbp.CREATED_DATE) <= #{sampaiTanggal,jdbcType=DATE}) "
    		+ "AND (#{jenisTransaksi,jdbcType=VARCHAR} NOT LIKE 'bayar' or (#{jenisTransaksi,jdbcType=VARCHAR} LIKE 'bayar' AND tbp.bayar > 0)) "
    		+ "AND (#{jenisTransaksi,jdbcType=VARCHAR} NOT LIKE 'pinjam' or (#{jenisTransaksi,jdbcType=VARCHAR} LIKE 'pinjam' AND tbp.hutang > 0)) "
    		+ "order by tbp.CREATED_DATE desc ";
    
    

    public static final String SELECT_NEXT_SEQUENCE_ID = 
    		"SELECT sq_hutang_id.nextval FROM DUAL";
    
    public static final String SELECT_PIUTANG_DETAIL = 
    		"SELECT tbp.piutang_id, tbp.HUTANG, tbp.BAYAR, tbp.SISA_HUTANG, tbp.KETERANGAN, "
    		+ "u1.fullname createdBy, u2.fullname fullname, tbp.CREATED_DATE "
    		+ " FROM tb_piutang tbp "
    		+ "inner join TB_USER u1 on u1.username = tbp.created_by "
    		+ "inner join TB_USER u2 on u2.username = tbp.username "
    		+ "WHERE tbp.piutang_id=#{piutangId,jdbcType=VARCHAR} ";
    

    
    
    public static final String SEARCH_USER_PIUTANG_BY_FULLNAME = "SELECT username, fullname, hutang, area,"
    		+ " terakhir_Bayar, terakhir_Pinjam "
    		+ "from tb_user where lower(fullname) like '%'||lower(#{nameSearch}) ||'%'";
}