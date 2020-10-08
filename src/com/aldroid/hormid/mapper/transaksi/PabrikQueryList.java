package com.aldroid.hormid.mapper.transaksi;



public final class PabrikQueryList {

    public static final String SELECT_PABRIK_ALL = "select * from tb_pabrik";
    public static final String SELECT_PABRIK = "select * from tb_pabrik where pabrik_id=#{pabrikId}";
    
    public static final String UPDATE_PABRIK = "update tb_pabrik set "
    		+ "nama_Perusahaan=#{namaPerusahaan,jdbcType=VARCHAR} "
    		+ ",uang_jalan_truk=#{uangJalanTruk,jdbcType=INTEGER} "
    		+ ",biaya_Mobil_Truk=#{biayaMobilTruk,jdbcType=INTEGER} "
    		+ ",uang_jalan_Tronton=#{uangJalanTronton,jdbcType=INTEGER} "
    		+ ",biaya_Mobil_Tronton=#{biayaMobilTronton,jdbcType=INTEGER} "
    		+ ",catatan=#{catatan} "
    		+ ",updated_by=#{updatedBy} "
    		+ ",updated_date=current_timestamp "
    		+ "where pabrik_id=#{pabrikId,jdbcType=INTEGER}";

    
    public static final String INSERT_PABRIK = "insert into tb_pabrik "
    		+ "(nama_Perusahaan, uang_jalan_truk, biaya_Mobil_Truk, uang_jalan_Tronton, "
    		+ "biaya_Mobil_Tronton, catatan, updated_by) "
    		+ "values (#{namaPerusahaan,jdbcType=VARCHAR}, #{uangJalanTruk,jdbcType=INTEGER}, #{biayaMobilTruk,jdbcType=INTEGER}, #{uangJalanTronton,jdbcType=INTEGER}, "
    		+ "#{biayaMobilTronton,jdbcType=INTEGER}, #{catatan}, #{updatedBy})";
    
}