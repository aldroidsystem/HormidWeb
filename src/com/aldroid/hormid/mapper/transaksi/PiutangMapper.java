/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.mapper.transaksi;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.aldroid.hormid.generic.staticvar.PiutangQueryList;
import com.aldroid.hormid.generic.staticvar.UserQueryList;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.transaksi.Piutang;

/**
 *
 * @author renaldo
 */

public interface PiutangMapper{


    
    @Insert(PiutangQueryList.PIUTANG_INSERT)
    abstract void insert(Piutang bean) throws Exception;
    

    @Select(PiutangQueryList.SELECT_PEMINJAM_DETAIL)
    @Results({
        @Result(property = "username", column ="username"),
        @Result(property = "fullname", column ="fullname"),
        @Result(property = "area", column ="area"),
        @Result(property = "hutang", column ="hutang")
        })
    abstract Piutang selectListUserHutang(@Param("username")String username) throws Exception;
    
    @Select(PiutangQueryList.SELECT_PIUTANG_HISTORY)
    @Results({
        @Result(property = "piutangId", column ="piutang_id"),
        @Result(property = "hutang", column ="hutang"),
        @Result(property = "bayar", column ="bayar"),
        @Result(property = "sisaHutang", column ="SISA_HUTANG"),
        @Result(property = "keterangan", column ="KETERANGAN"),
        @Result(property = "createdBy", column ="fullname"),
        @Result(property = "createdDate", column ="CREATED_DATE")
        })
    abstract List<Piutang> selectPiutangHistory(Piutang piutang) throws Exception;

    @Select(PiutangQueryList.SELECT_NEXT_SEQUENCE_ID)
    abstract Integer selectNextSequenceID() throws Exception;
    
    @Select(PiutangQueryList.SELECT_PIUTANG_DETAIL)
    @Results({
        @Result(property = "piutangId", column ="piutang_id"),
        @Result(property = "hutang", column ="hutang"),
        @Result(property = "bayar", column ="bayar"),
        @Result(property = "sisaHutang", column ="SISA_HUTANG"),
        @Result(property = "keterangan", column ="KETERANGAN"),
        @Result(property = "createdBy", column ="createdBy"),
        @Result(property = "fullname", column ="fullname"),
        @Result(property = "createdDate", column ="CREATED_DATE")
        })
    abstract Piutang selectPiutangDetail(@Param("piutangId")String piutangId) throws Exception;
    
    

    @Select(PiutangQueryList.SEARCH_USER_PIUTANG_BY_FULLNAME) 
    @Results({
        @Result(property = "username", column ="username"),
        @Result(property = "fullname", column ="fullname"),
        @Result(property = "hutang", column ="hutang"),
        @Result(property = "area", column ="area"),
        @Result(property = "terakhirBayar", column ="terakhir_bayar"),
        @Result(property = "terakhirPinjam", column ="terakhir_pinjam")

    })
    abstract List<User> searchUserPiutangByFullname(@Param("nameSearch") String nameSearch);
}