package com.aldroid.hormid.mapper.generic;



public final class PropertiesQueryList {

    public static final String SELECT_PROPERTIES_ALL = "select * from tb_properties";
    
    public static final String UPDATE_PROPERTIES = "update tb_properties set "
    		+ "property_value=#{value} "
    		+ "where property_code=#{code}";
}