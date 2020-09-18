package com.aldroid.hormid.generic.staticvar;



public final class PropertiesQueryList {

    public static final String SELECT_PROPERTIES_ALL = "select * from tb_properties";
    
    public static final String UPDATE_PROPERTIES = "update tb_properties set "
//    		+ "dataType=#{dataType}, "
//    		+ "property_desc=#{description}, "
    		+ "property_value=#{value} "
    		+ "where property_code=#{code}";
}