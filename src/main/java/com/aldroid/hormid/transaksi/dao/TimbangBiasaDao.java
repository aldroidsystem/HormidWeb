/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.dao;

import com.aldroid.hormid.transaksi.bean.TimbangBiasaBean;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *
 * @author renaldo
 */
@Repository
public interface TimbangBiasaDao{
    final String SELECT_NEXT_NOSLIP = "select nextval('sec_noslip_timbang_biasa')";
    final String INSERT_TIMBANG_BIASA = "insert into tbl_timbangBiasa "
            + "(noSlip,employeeId,supplierId,productId,catatan,branchId,timbangBy,"
            + "potonganwajib,potonganlainnya,keteranganpotongan,biayaKuli,biayaLainnya,"
            + "keteranganBiaya,netto,totalPotongan,totalBerat,totalHarga,totalBayar,"
            + "totalBiaya,bruto,harga,pulangan,keteranganpulangan,satuanPulangan)"
            + " values "
            + "(#{noSlip},#{employeeId},#{supplierId},#{productId},#{catatan},#{branchId},#{timbangBy},"
            + "#{potonganWajib},#{potonganLainnya},#{keteranganPotongan},#{biayaKuli},#{biayaLainnya},"
            + "#{keteranganBiaya},#{netto},#{totalPotongan},#{totalBerat},#{totalHarga},#{totalBayar},"
            + "#{totalBiaya},#{bruto},#{harga},#{pulangan},#{keteranganPulangan},#{satuanPulangan})";
    
    final String SELECT_TIMBANG_BIASA_BY_NOSLIP = "select * from tbl_timbangBiasa where noSlip=#{noSlip}";
    final String SELECT_TIMBANG_BIASA_ALL_FILTERED = "select t.* from tbl_timbangBiasa t "
            + "inner join tbl_branch b on t.supplierId=b.id and (#{supplierId}::int is null or b.publicId = #{supplierId}) "
            + "where "
            + "flagdeleted = #{isDeleted} "
            + "and (#{timestampTimbang1}::timestamp is null or timestampTimbang >= #{timestampTimbang1}) "
            + "and (#{timestampTimbang2}::timestamp is null or timestampTimbang <= #{timestampTimbang2}) "
            + "and (#{flagCekDicairkan}::boolean is null or flagCekDicairkan = #{flagCekDicairkan}) "
            + "and (#{minNetto}::numeric is null or netto >=#{minNetto}) "
            + "and (#{maxNetto}::numeric is null or netto <=#{maxNetto}) "
            + "and (#{minTotalBayar}::numeric is null or totalBayar >=#{minTotalBayar}) "
            + "and (#{maxTotalBayar}::numeric is null or totalBayar <=#{maxTotalBayar}) "
            + "ORDER BY "
            + "CASE WHEN #{orderBy}::int = 0 and #{asc}::boolean = true THEN timestampTimbang END ASC, "
            + "CASE WHEN #{orderBy}::int = 0 and #{asc}::boolean = false THEN timestampTimbang END DESC, "
            + "CASE WHEN #{orderBy}::int = 1 and #{asc}::boolean = true THEN netto END ASC, "
            + "CASE WHEN #{orderBy}::int = 1 and #{asc}::boolean = false THEN netto END DESC, "
            + "CASE WHEN #{orderBy}::int = 2 and #{asc}::boolean = true THEN totalBayar END ASC, "
            + "CASE WHEN #{orderBy}::int = 2 and #{asc}::boolean = false THEN totalBayar END DESC ";
    
    final String UPDATE_CEK_PAID = "UPDATE tbl_timbangBiasa set "
            + "flagCekDicairkan=true,"
            + "timestampCekDicairkan=CURRENT_TIMESTAMP,"
            + "dicairkanBy=#{dicairkanBy} "
            + "where noSlip=#{noSlip}";
    final String DELETE_TIMBANG_BIASA = "UPDATE tbl_timbangBiasa set "
            + "flagDeleted=true,"
            + "timestampDelete=CURRENT_TIMESTAMP,"
            + "deletedBy=#{deletedBy}, "
            + "alasanDelete=#{alasanDelete} "
            + "where noSlip=#{noSlip}";
    
    
    @Select(SELECT_NEXT_NOSLIP)
    abstract Integer selectNextNoSlip() throws Exception;
    
    
    @Select(SELECT_TIMBANG_BIASA_BY_NOSLIP)
    @Results(value = {
        @Result(property = "driverId", column = "driverId"),
        @Result(property = "driver", column = "driverId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectById")),
        @Result(property = "vehicleId", column = "vehicleId"),
        @Result(property = "vehicle", column = "vehicleId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.VehicleDao.selectById")),
        @Result(property = "supplierId", column = "supplierId"),
        @Result(property = "supplier", column = "supplierId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectById")),
        @Result(property = "productId", column = "productId"),
        @Result(property = "product", column = "productId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.ProductDao.selectById")),
        @Result(property = "timbangBy", column = "timbangBy"),
        @Result(property = "timbangByUser", column = "timbangBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById")),
        @Result(property = "deletedBy", column = "deletedBy"),
        @Result(property = "deletedByUser", column = "deletedBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById")),
        @Result(property = "dicairkanBy", column = "dicairkanBy"),
        @Result(property = "dicairkanByUser", column = "dicairkanBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById"))
    })
    abstract TimbangBiasaBean selectTimbangByNoSlip(@Param("noSlip") String noSlip) throws Exception;
    
    @Insert(INSERT_TIMBANG_BIASA)
    abstract void insertTimbang(TimbangBiasaBean bean) throws Exception;
    
    @Select(SELECT_TIMBANG_BIASA_ALL_FILTERED)
    @Results(value = {
        @Result(property = "driverId", column = "driverId"),
        @Result(property = "driver", column = "driverId",
                one = @One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectById")),
        @Result(property = "vehicleId", column = "vehicleId"),
        @Result(property = "vehicle", column = "vehicleId",
                one = @One(select = "com.aldroid.hormid.common.dao.resource.VehicleDao.selectById")),
        @Result(property = "supplierId", column = "supplierId"),
        @Result(property = "supplier", column = "supplierId",
                one = @One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectById")),
        @Result(property = "timbangBy", column = "timbangBy"),
        @Result(property = "timbangByUser", column = "timbangBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById")),
        @Result(property = "deletedBy", column = "deletedBy"),
        @Result(property = "deletedByUser", column = "deletedBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById")),
        @Result(property = "dicairkanBy", column = "dicairkanBy"),
        @Result(property = "dicairkanByUser", column = "dicairkanBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById"))
    })
    abstract List<TimbangBiasaBean> selectTimbangAllFiltered(
            @Param("supplierId") Integer supplierId,
            @Param("timestampTimbang1") Date timestampTimbang1,
            @Param("timestampTimbang2") Date timestampTimbang2,
            @Param("flagCekDicairkan") Boolean flagCekDicairkan,
            @Param("minNetto") Double minNetto,
            @Param("maxNetto") Double maxNetto,
            @Param("minTotalBayar") Double minTotalBayar,
            @Param("maxTotalBayar") Double maxTotalBayar,
            @Param("orderBy") int orderBy,
            @Param("asc") boolean asc,
            @Param("isDeleted") boolean isDeleted
    ) throws Exception;
    
    @Insert(UPDATE_CEK_PAID)
    abstract void updateCekPaid(@Param("noSlip") String noSlip,
            @Param("dicairkanBy") Integer dicairkanBy) throws Exception;
    
    @Insert(DELETE_TIMBANG_BIASA)
    abstract void deleteTimbang(@Param("noSlip") String noSlip,
            @Param("deletedBy") Integer deletedBy,
            @Param("alasanDelete") String alasanDelete) throws Exception;
}