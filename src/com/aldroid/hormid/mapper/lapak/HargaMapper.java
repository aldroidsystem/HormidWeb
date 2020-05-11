/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.mapper.lapak;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.aldroid.hormid.generic.QueryDao;
import com.aldroid.hormid.model.lapak.Harga;

/**
 *
 * @author renaldo
 */

public interface HargaMapper{


    
    @Insert(QueryDao.HARGA_INSERT)
    abstract void insert(Harga bean) throws Exception;
    

    @Select(QueryDao.HARGA_SELECT_ALL)
    abstract List<Harga> selectAll() throws Exception;
    

    @Select("SELECT * FROM tb_TABLE_NOTEXIST")
    abstract List<Harga> selectError() throws Exception;
    
    
}