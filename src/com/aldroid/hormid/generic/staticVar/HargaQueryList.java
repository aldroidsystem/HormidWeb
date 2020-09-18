package com.aldroid.hormid.generic.staticvar;



public final class HargaQueryList {

    public static final String HARGA_INSERT = "call pr_harga_insert"
    		+ "(#{createdBy}"
    		+ ",#{createdDate}"
    		+ ",#{hargaJual}"
    		+ ",#{hargaBeli})";
    
    public static final String HARGA_SELECT_ALL = "SELECT * FROM TB_HARGA";
}