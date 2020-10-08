package com.aldroid.hormid.mapper.transaksi;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;

import com.aldroid.hormid.generic.staticvar.TimbangJembatanQueryList;
import com.aldroid.hormid.model.transaksi.TimbangJembatan;

/**
 *
 * @author renaldo
 */

public interface TimbangJembatanMapper{


    
    @Insert(TimbangJembatanQueryList.INSERT_TIMBANG_JEMBATAN)
    abstract void insert(TimbangJembatan bean) throws Exception;
    
    @Insert(TimbangJembatanQueryList.UPDATE_TIMBANG_JEMBATAN)
    abstract void update(TimbangJembatan bean) throws Exception;
    
    
    @Insert(TimbangJembatanQueryList.UPDATE_TIMBANG_JEMBATAN_BAYAR)
    abstract void bayar(TimbangJembatan bean) throws Exception;


    @Select(TimbangJembatanQueryList.SELECT_TIMBANG_JEMBATAN_TEMP_DETAIL)
    @Results({
        @Result(property = "noNota", column ="no_nota"),
        @Result(property = "pengirim", column ="pengirim"),
        @Result(property = "supir", column ="SUPIR"),
        @Result(property = "vehicleId", column ="VEHICLE_ID"),
        @Result(property = "bruto", column ="bruto"),
        @Result(property = "tare", column ="tare"),
        @Result(property = "netto", column ="netto"),
        @Result(property = "potongan", column ="potongan"),
        @Result(property = "totalPotongan", column ="total_potongan"),
        @Result(property = "beratBersih", column ="BERATBERSIH"),
        @Result(property = "harga", column ="harga"),
        @Result(property = "total", column ="total"),
        @Result(property = "biayaBongkar", column ="BIAYA_BONGKAR"),
        @Result(property = "biayaMobil", column ="BIAYA_MOBIL"),
        @Result(property = "potonganBon", column ="POTONGAN_BON"),
        @Result(property = "sisaBon", column ="SISA_BON"),
        @Result(property = "biayaLain", column ="BIAYA_LAIN"),
        @Result(property = "keteranganBiayaLain", column ="KETERANGAN_BIAYA_LAIN"),
        @Result(property = "totalBayar", column ="TOTAL_BAYAR"),
        @Result(property = "pembulatan", column ="pembulatan"),
        @Result(property = "catatan", column ="catatan"),
        @Result(property = "createdDate", column ="CREATED_DATE")
        })
    abstract TimbangJembatan selectTimbangJembatanTempDetail(@Param("noNota")String noNota) throws Exception;



    @Select(TimbangJembatanQueryList.SELECT_TIMBANG_JEMBATAN_PAID_DETAIL)
    @Results({
        @Result(property = "noNota", column ="no_nota"),
        @Result(property = "pengirim", column ="pengirim"),
        @Result(property = "supir", column ="SUPIR"),
        @Result(property = "vehicleId", column ="VEHICLE_ID"),
        @Result(property = "bruto", column ="bruto"),
        @Result(property = "tare", column ="tare"),
        @Result(property = "netto", column ="netto"),
        @Result(property = "potongan", column ="potongan"),
        @Result(property = "totalPotongan", column ="total_potongan"),
        @Result(property = "beratBersih", column ="BERATBERSIH"),
        @Result(property = "harga", column ="harga"),
        @Result(property = "total", column ="total"),
        @Result(property = "biayaBongkar", column ="BIAYA_BONGKAR"),
        @Result(property = "biayaMobil", column ="BIAYA_MOBIL"),
        @Result(property = "potonganBon", column ="POTONGAN_BON"),
        @Result(property = "sisaBon", column ="SISA_BON"),
        @Result(property = "biayaLain", column ="BIAYA_LAIN"),
        @Result(property = "keteranganBiayaLain", column ="KETERANGAN_BIAYA_LAIN"),
        @Result(property = "totalBayar", column ="TOTAL_BAYAR"),
        @Result(property = "pembulatan", column ="pembulatan"),
        @Result(property = "catatan", column ="catatan"),
        @Result(property = "createdDate", column ="CREATED_DATE")
        })
    abstract TimbangJembatan selectTimbangJembatanPaidDetail(@Param("noNota")String noNota) throws Exception;



    @Select(TimbangJembatanQueryList.SELECT_TIMBANG_JEMBATAN_NOTCOMPLETE)
    @Results({
        @Result(property = "noNota", column ="no_nota"),
        @Result(property = "pengirim", column ="pengirim"),
        @Result(property = "supir", column ="SUPIR"),
        @Result(property = "plateNumber", column ="plate_number"),
        @Result(property = "bruto", column ="bruto"),
        @Result(property = "timestampTimbang1", column ="TIMESTAMP_TIMBANG1")
        })
    abstract List<TimbangJembatan> selectTimbangJembatanNotComplete() throws Exception;


    @Select(TimbangJembatanQueryList.SELECT_NEXT_SEQUENCE_ID)
    abstract Integer selectNextSequenceID() throws Exception;
    
    
}