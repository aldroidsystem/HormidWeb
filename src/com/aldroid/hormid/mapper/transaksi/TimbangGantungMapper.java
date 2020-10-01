package com.aldroid.hormid.mapper.transaksi;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.aldroid.hormid.generic.staticvar.TimbangGantungQueryList;
import com.aldroid.hormid.model.transaksi.TimbangGantung;

/**
 *
 * @author renaldo
 */

public interface TimbangGantungMapper{


    
    @Insert(TimbangGantungQueryList.TIMBANG_GANTUNG_INSERT)
    abstract void insert(TimbangGantung bean) throws Exception;


    @Select(TimbangGantungQueryList.SELECT_TIMBANG_GANTUNG_DETAIL)
    @Results({
        @Result(property = "noNota", column ="no_nota"),
        @Result(property = "username", column ="username"),
        @Result(property = "fullname", column ="fullname"),
        @Result(property = "potongan", column ="potongan"),
        @Result(property = "bruto", column ="bruto"),
        @Result(property = "totalPotongan", column ="total_potongan"),
        @Result(property = "netto", column ="netto"),
        @Result(property = "harga", column ="harga"),
        @Result(property = "pembulatan", column ="pembulatan"),
        @Result(property = "total", column ="total"),
        @Result(property = "createdBy", column ="created_By"),
        @Result(property = "createdDate", column ="CREATED_DATE")
        })
    abstract TimbangGantung selectTimbangGantungDetail(@Param("noNota")String noNota) throws Exception;


    @Select(TimbangGantungQueryList.SELECT_NEXT_SEQUENCE_ID)
    abstract Integer selectNextSequenceID() throws Exception;
    
    
}