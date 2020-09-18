package com.aldroid.hormid.mapper.generic;

import java.util.List;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aldroid.hormid.generic.staticvar.PropertiesQueryList;
import com.aldroid.hormid.model.generic.Properties;

public interface PropertiesMapper {


    @Select(PropertiesQueryList.SELECT_PROPERTIES_ALL) 
    @Results({
        @Result(property = "code", column ="property_code"),
        @Result(property = "propertyDesc", column ="property_desc"),
        @Result(property = "tipeData", column ="datatype"),
        @Result(property = "value", column ="property_value")})
    abstract List<Properties> selectAllProperties();
    

    @Update(PropertiesQueryList.UPDATE_PROPERTIES)
    abstract void updateProperties(Properties bean);
}
