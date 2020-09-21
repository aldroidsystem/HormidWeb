package com.aldroid.hormid.generic.staticvar;

public final class HargaQueryList {

    public static final String HARGA_INSERT = "  insert into tb_harga "
    		+ "(TANGGAL_MULAI,HARGA_JUAL,HARGA_BELI_JEMBATAN,HARGA_BELI_GANTUNG,CREATEDBY) "
    		+ "values ("
    		+ "#{tanggalMulai,jdbcType=DATE}"
    		+ ",#{hargaJual,jdbcType=SMALLINT}"
    		+ ",#{hargaBeliJembatan,jdbcType=SMALLINT}"
    		+ ",#{hargaBeliGantung,jdbcType=SMALLINT}"
    		+ ",#{createdBy,jdbcType=VARCHAR})";
    
    public static final String HARGA_SELECT_ALL = "SELECT * FROM TB_HARGA";
    

    public static final String HARGA_SELECT_CURRENT = "select * from tb_harga where hargaid in ("
    		+ "select hargaid from ("
    			+ "select hargaid from tb_harga where trunc(tanggal_mulai) <= trunc(sysdate) order by tanggal_mulai desc, hargaid desc"
			+ ") where rownum=1)";
}