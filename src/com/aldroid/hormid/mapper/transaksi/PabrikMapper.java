/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.mapper.transaksi;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.aldroid.hormid.model.lapak.Pabrik;

/**
 *
 * @author renaldo
 */

public interface PabrikMapper{


    
    @Insert(PabrikQueryList.INSERT_PABRIK)
    abstract void insert(Pabrik bean) throws Exception;
    
    @Insert(PabrikQueryList.UPDATE_PABRIK)
    abstract void update(Pabrik bean) throws Exception;
    

    @Select(PabrikQueryList.SELECT_PABRIK_ALL)
    @Results({
        @Result(property = "pabrikId", column ="pabrik_Id"),
        @Result(property = "namaPerusahaan", column ="nama_Perusahaan"),
        @Result(property = "uangJalanTruk", column ="uang_Jalan_Truk"),
        @Result(property = "uangJalanTronton", column ="uang_Jalan_Tronton"),
        @Result(property = "biayaMobilTruk", column ="biaya_Mobil_Truk"),
        @Result(property = "biayaMobilTronton", column ="biaya_Mobil_Tronton"),
        @Result(property = "catatan", column ="catatan")
        })
    abstract List<Pabrik> selectListPabrik() throws Exception;

    @Select(PabrikQueryList.SELECT_PABRIK)
    @Results({
        @Result(property = "pabrikId", column ="pabrik_Id"),
        @Result(property = "namaPerusahaan", column ="nama_Perusahaan"),
        @Result(property = "uangJalanTruk", column ="uang_Jalan_Truk"),
        @Result(property = "uangJalanTronton", column ="uang_Jalan_Tronton"),
        @Result(property = "biayaMobilTruk", column ="biaya_Mobil_Truk"),
        @Result(property = "biayaMobilTronton", column ="biaya_Mobil_Tronton"),
        @Result(property = "catatan", column ="catatan")
        })
    abstract Pabrik selectPabrik(@Param("pabrikId")Integer pabrikId) throws Exception;
    
}