/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.mapper.transaksi;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.aldroid.hormid.generic.staticvar.HargaQueryList;
import com.aldroid.hormid.model.transaksi.Harga;

/**
 *
 * @author renaldo
 */

public interface HargaMapper{


    
    @Insert(HargaQueryList.HARGA_INSERT)
    abstract void insert(Harga bean) throws Exception;
    

    @Select(HargaQueryList.HARGA_SELECT_ALL)
    abstract List<Harga> selectAll() throws Exception;
    
    @Select(HargaQueryList.HARGA_SELECT_CURRENT)
    @Results({
        @Result(property = "createdDate", column ="CREATEDDATE", javaType = Date.class),
        @Result(property = "tanggalMulai", column ="TANGGAL_MULAI", javaType = Date.class),
        @Result(property = "hargaJual", column ="HARGA_JUAL", javaType = Integer.class),
        @Result(property = "hargaBeliJembatan", column ="HARGA_BELI_JEMBATAN", javaType = Integer.class),
        @Result(property = "hargaBeliGantung", column ="HARGA_BELI_GANTUNG", javaType = Integer.class)
    })
    abstract Harga getHargaSekarang() throws Exception;


    
}