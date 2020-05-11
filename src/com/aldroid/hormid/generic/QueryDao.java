package com.aldroid.hormid.generic;

public final class QueryDao {

    public final static String HARGA_INSERT = "call pr_harga_insert"
    		+ "(#{createdBy}"
    		+ ",#{createdDate}"
    		+ ",#{hargaJual}"
    		+ ",#{hargaBeli})";

    public final static String HARGA_SELECT_ALL = "SELECT * FROM TB_HARGA";
    
}
