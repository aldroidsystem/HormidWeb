/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.core.common.dao;

import com.aldroid.hormid.core.common.bean.PropertiesBean;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 *
 * @author renaldo
 */
@Repository
public interface PropertiesDao {
    
    final static String UPDATE_BY_ID = "UPDATE TB_PROPERTIES SET"
            + " value=#{value}"
            + " WHERE ID=#{id}";
    final static String SELECT_BY_ID = "SELECT * FROM tb_properties WHERE ID=#{id}";
    final String SELECT_BY_CODE = "SELECT * FROM tb_properties WHERE CODE=#{code} LIMIT 1";
    final static String SELECT_PAGE = "SELECT * FROM tb_properties limit #{limit} offset #{offset}";
    final static String SELECT_COUNT = "SELECT count(1) FROM tb_properties";
    final static String SELECT_ALL = "SELECT * FROM tb_properties";
    
    
    @Update(UPDATE_BY_ID)
    abstract void updateById(PropertiesBean bean) throws Exception;
    
    @Select(SELECT_BY_ID)
    abstract PropertiesBean selectById(@Param("id") int id) throws Exception;
    
    @Select(SELECT_BY_CODE)
    abstract PropertiesBean selectByCode(@Param("code") String code) throws Exception;
    
    @Select(SELECT_PAGE)
    abstract List<PropertiesBean> selectPage(
            @Param("limit")int limit,
            @Param("offset") int offset) throws Exception;
    
    @Select(SELECT_COUNT)
    abstract Integer selectCountAll() throws Exception;
    
    @Select(SELECT_ALL)
    abstract List<PropertiesBean> selectAll() throws Exception;
}
