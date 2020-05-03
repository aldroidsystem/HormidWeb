/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.dao;

import com.aldroid.hormid.transaksi.bean.TimbangJembatanBean;

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
public interface TimbangJembatanDao{
    final String INSERT_TIMBANG_JEMBATAN_MASUK = "insert into tbl_timbangJembatanMasuk "
            + "(noSlip,driverId,vehicleId,supplierId,productId,beratTimbangMasuk,catatan,branchId,timbangMasukBy)"
            + " values "
            + "(#{noSlip},#{driverId},#{vehicleId},#{supplierId},#{productId},#{beratTimbangMasuk},#{catatan},#{branchId},#{timbangMasukBy})";
    final String SELECT_TIMBANG_JEMBATAN_MASUK = "select * from tbl_timbangJembatanMasuk order by timestampTimbangMasuk desc";
    final String SELECT_NEXT_NOSLIP = "select nextval('sec_noslip_timbang_jembatan')";
    final String DELETE_TIMBANG_JEMBATAN_MASUK = "DELETE FROM tbl_timbangJembatanMasuk WHERE noSlip=#{noSlip}";
    final String SELECT_TIMBANG_JEMBATAN_MASUK_BY_NOSLIP = "select * from tbl_timbangJembatanMasuk where noSlip=#{noSlip}";
    
    
    final String INSERT_TIMBANG_JEMBATAN = "insert into tbl_timbangJembatan "
            + "(noSlip,driverId,vehicleId,supplierId,productId,beratTimbangMasuk,catatan,branchId,timbangMasukBy,"
            + "beratTimbangKeluar,potonganwajib,potonganlainnya,keteranganpotongan,pulangan,keteranganpulangan,"
            + "biayaKuli,biayaLainnya,keteranganBiaya,netto,totalPotongan,totalBerat,totalHarga,totalBayar,timbangKeluarBy,"
            + "totalBiaya,bruto,satuanPulangan,harga)"
            + " values "
            + "(#{noSlip},#{driverId},#{vehicleId},#{supplierId},#{productId},#{beratTimbangMasuk},#{catatan},#{branchId},#{timbangMasukBy},"
            + "#{beratTimbangKeluar},#{potonganWajib},#{potonganLainnya},#{keteranganPotongan},#{pulangan},#{keteranganPulangan},"
            + "#{biayaKuli},#{biayaLainnya},#{keteranganBiaya},#{netto},#{totalPotongan},#{totalBerat},#{totalHarga},#{totalBayar},#{timbangKeluarBy},"
            + "#{totalBiaya},#{bruto},#{satuanPulangan},#{harga})";
    
    final String SELECT_TIMBANG_JEMBATAN_BY_NOSLIP = "select * from tbl_timbangJembatan where noSlip=#{noSlip}";
    final String SELECT_TIMBANG_JEMBATAN_ALL_FILTERED = "select t.* from tbl_timbangJembatan t "
            + "inner join tbl_branch b on t.supplierId=b.id and (#{supplierId}::int is null or b.publicId = #{supplierId}) "
            + "where "
            + "flagdeleted = #{isDeleted} "
            + "and (#{timestampTimbangKeluar1}::timestamp is null or timestampTimbangKeluar >= #{timestampTimbangKeluar1}) "
            + "and (#{timestampTimbangKeluar2}::timestamp is null or timestampTimbangKeluar <= #{timestampTimbangKeluar2}) "
            + "and (#{flagCekDicairkan}::boolean is null or flagCekDicairkan = #{flagCekDicairkan}) "
            + "and (#{minNetto}::numeric is null or netto >=#{minNetto}) "
            + "and (#{maxNetto}::numeric is null or netto <=#{maxNetto}) "
            + "and (#{minTotalBayar}::numeric is null or totalBayar >=#{minTotalBayar}) "
            + "and (#{maxTotalBayar}::numeric is null or totalBayar <=#{maxTotalBayar}) "
            + "ORDER BY "
            + "CASE WHEN #{orderBy}::int = 0 and #{asc}::boolean = true THEN timestampTimbangKeluar END ASC, "
            + "CASE WHEN #{orderBy}::int = 0 and #{asc}::boolean = false THEN timestampTimbangKeluar END DESC, "
            + "CASE WHEN #{orderBy}::int = 1 and #{asc}::boolean = true THEN netto END ASC, "
            + "CASE WHEN #{orderBy}::int = 1 and #{asc}::boolean = false THEN netto END DESC, "
            + "CASE WHEN #{orderBy}::int = 2 and #{asc}::boolean = true THEN totalBayar END ASC, "
            + "CASE WHEN #{orderBy}::int = 2 and #{asc}::boolean = false THEN totalBayar END DESC ";
    
    final String UPDATE_CEK_PAID = "UPDATE tbl_timbangJembatan set "
            + "flagCekDicairkan=true,"
            + "timestampCekDicairkan=CURRENT_TIMESTAMP,"
            + "dicairkanBy=#{dicairkanBy} "
            + "where noSlip=#{noSlip}";
    final String DELETE_TIMBANG_JEMBATAN = "UPDATE tbl_timbangJembatan set "
            + "flagDeleted=true,"
            + "timestampDelete=CURRENT_TIMESTAMP,"
            + "deletedBy=#{deletedBy}, "
            + "alasanDelete=#{alasanDelete} "
            + "where noSlip=#{noSlip}";
    
    @Select(SELECT_NEXT_NOSLIP)
    abstract Integer selectNextNoSlip() throws Exception;
    
    @Insert(INSERT_TIMBANG_JEMBATAN_MASUK)
    abstract void insertTimbangMasuk(TimbangJembatanBean bean) throws Exception;
    
    @Select(SELECT_TIMBANG_JEMBATAN_MASUK)
    @Results(value = {
        @Result(property = "driverId", column = "driverId"),
        @Result(property = "driver", column = "driverId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectById")),
        @Result(property = "vehicleId", column = "vehicleId"),
        @Result(property = "vehicle", column = "vehicleId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.VehicleDao.selectById")),
        @Result(property = "supplierId", column = "supplierId"),
        @Result(property = "supplier", column = "supplierId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectById"))
    })
    abstract List<TimbangJembatanBean> selectTimbangMasukAll() throws Exception;
    
    
    @Select(SELECT_TIMBANG_JEMBATAN_BY_NOSLIP)
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
                one=@One(select = "com.aldroid.hormid.common.dao.resource.ProductDao.selectById"))
    })
    abstract TimbangJembatanBean selectTimbangJembatanByNoSlip(@Param("noSlip") String noSlip) throws Exception;
    
    @Select(SELECT_TIMBANG_JEMBATAN_MASUK_BY_NOSLIP)
    abstract TimbangJembatanBean selectTimbangJembatanMasukByNoSlip(@Param("noSlip") String noSlip) throws Exception;
    
    @Select(DELETE_TIMBANG_JEMBATAN_MASUK)
    abstract void deleteTimbangJembatanMasukByNoSlip(@Param("noSlip") String noSlip) throws Exception;
    
    @Insert(INSERT_TIMBANG_JEMBATAN)
    abstract void insertTimbangJembatan(TimbangJembatanBean bean) throws Exception;
    
    @Select(SELECT_TIMBANG_JEMBATAN_ALL_FILTERED)
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
        @Result(property = "timbangKeluarBy", column = "timbangKeluarBy"),
        @Result(property = "timbangKeluarByUser", column = "timbangKeluarBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById")),
        @Result(property = "deletedBy", column = "deletedBy"),
        @Result(property = "deletedByUser", column = "deletedBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById")),
        @Result(property = "dicairkanBy", column = "dicairkanBy"),
        @Result(property = "dicairkanByUser", column = "dicairkanBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById"))
    })
    abstract List<TimbangJembatanBean> selectTimbangJembatanAllFiltered(
            @Param("supplierId") Integer supplierId,
            @Param("timestampTimbangKeluar1") Date timestampTimbangKeluar1,
            @Param("timestampTimbangKeluar2") Date timestampTimbangKeluar2,
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
    
    @Insert(DELETE_TIMBANG_JEMBATAN)
    abstract void deleteTimbangJembatan(@Param("noSlip") String noSlip,
            @Param("deletedBy") Integer deletedBy,
            @Param("alasanDelete") String alasanDelete) throws Exception;
}