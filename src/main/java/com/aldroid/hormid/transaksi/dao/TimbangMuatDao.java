/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.dao;

import com.aldroid.hormid.transaksi.bean.TimbangMuatBean;
import com.aldroid.hormid.transaksi.bean.TimbangMuatKaryawanBean;
import com.aldroid.hormid.transaksi.bean.TimbangMuatSupplierBean;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
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
public interface TimbangMuatDao{
    final String SELECT_NEXT_NOSLIP = "select nextval('sec_noslip_timbang_muat')";
    final String INSERT_TIMBANG_MUAT = "insert into tbl_timbangMuat "
            + "(noMuat,vehicleId,productId,catatan,branchId,createdBy)"
            + " values "
            + "(#{noMuat},#{vehicleId},#{productId},#{catatan},#{branchId},#{createdBy})";
    final String INSERT_TIMBANG_MUAT_KARYAWAN = "insert into tbl_timbangMuatKaryawan "
            + "(timbangMuatId,employeeId,jenisPekerjaan,biayaPerKg,catatan)"
            + " values "
            + "(#{timbangMuatId},#{employeeId},#{jenisPekerjaan},#{biayaPerKg},#{catatan})";
    final String INSERT_TIMBANG_MUAT_SUPPLIER = "insert into tbl_timbangMuatSupplier "
            + "(timbangMuatId,noSlip,supplierid,beratTimbang,harga,"
            + "potonganwajib,potonganlainnya,keteranganpotongan,biayaKuli,"
            + "biayaLainnya,keteranganBiaya,netto,bruto,totalPotongan,totalBerat,"
            + "totalBiaya,totalHarga,totalBayar,catatan)"
            + " values "
            + "(#{timbangMuatId},#{noSlip},#{supplierId},#{beratTimbang},#{harga},"
            + "#{potonganWajib},#{potonganLainnya},#{keteranganPotongan},#{biayaKuli},"
            + "#{biayaLainnya},#{keteranganBiaya},#{netto},#{bruto},#{totalPotongan},#{totalBerat},"
            + "#{totalBiaya},#{totalHarga},#{totalBayar},#{catatan})";
    final String SELECT_TIMBANG_BY_NOSLIP = "select * from tbl_timbangMuat where noMuat=#{noMuat}";
    final String SELECT_TIMBANG_MUAT_SUPPLIER_BY_NOSLIP = "SELECT * FROM tbl_timbangmuatsupplier where noslip=#{noSlip}";
    final String SELECT_TIMBANG_MUAT_SUPPLIER_BY_TIMBANGMUATID = "SELECT * FROM tbl_timbangmuatsupplier where timbangMuatId=#{timbangMuatId}";
    final String SELECT_TIMBANG_MUAT_KARYAWAN_BY_TIMBANGMUATID = "SELECT * FROM tbl_timbangmuatkaryawan where timbangMuatId=#{timbangMuatId}";

    final String SELECT_TIMBANG_ALL_FILTERED = "select t.*,tms.totalNetto,tms.totalBayar "
            + "from tbl_timbangMuat t "
            + "inner join ("
                + "select sum(netto) totalNetto,timbangmuatid,sum(totalBayar) totalBayar "
                + "from tbl_timbangMuatSupplier group by timbangmuatid) tms on t.id = tms.timbangmuatid "
            + "inner join tbl_vehicle v on v.id = t.vehicleid "
                + "and (#{vehicleId}::int is null or v.publicId = #{vehicleId}) "
            + "inner join tbl_user u on u.id = t.createdBy "
                + "and (#{userId}::int is null or u.publicId = #{userId}) "
            + "where "
            + "flagdeleted = #{isDeleted} "
            + "and (#{timestampMuat1}::timestamp is null or timestampMuat >= #{timestampMuat1}) "
            + "and (#{timestampMuat2}::timestamp is null or timestampMuat <= #{timestampMuat2}) "
            + "and (#{minNetto}::numeric is null or tms.totalnetto >=#{minNetto}) "
            + "and (#{maxNetto}::numeric is null or tms.totalnetto <=#{maxNetto}) "
            + "and (#{minTotalBayar}::numeric is null or tms.totalBayar >=#{minTotalBayar}) "
            + "and (#{maxTotalBayar}::numeric is null or tms.totalBayar <=#{maxTotalBayar}) "
            + "ORDER BY "
            + "CASE WHEN #{orderBy}::int = 0 and #{asc}::boolean = true THEN timestampMuat END ASC, "
            + "CASE WHEN #{orderBy}::int = 0 and #{asc}::boolean = false THEN timestampMuat END DESC, "
            + "CASE WHEN #{orderBy}::int = 1 and #{asc}::boolean = true THEN tms.totalnetto END ASC, "
            + "CASE WHEN #{orderBy}::int = 1 and #{asc}::boolean = false THEN tms.totalnetto END DESC, "
            + "CASE WHEN #{orderBy}::int = 2 and #{asc}::boolean = true THEN tms.totalBayar END ASC, "
            + "CASE WHEN #{orderBy}::int = 2 and #{asc}::boolean = false THEN tms.totalBayar END DESC ";
    
    final String UPDATE_CEK_PAID = "UPDATE tbl_timbangMuatSupplier set "
            + "flagCekDicairkan=true,"
            + "timestampCekDicairkan=CURRENT_TIMESTAMP,"
            + "dicairkanBy=#{dicairkanBy} "
            + "where noSlip=#{noSlip}";
    final String DELETE_TIMBANG = "UPDATE tbl_timbangMuat set "
            + "flagDeleted=true,"
            + "timestampDelete=CURRENT_TIMESTAMP,"
            + "deletedBy=#{deletedBy}, "
            + "alasanDelete=#{alasanDelete} "
            + "where noMuat=#{noMuat}";
    
    
    @Select(SELECT_NEXT_NOSLIP)
    abstract Integer selectNextNoSlip() throws Exception;
    
    
    @Select(SELECT_TIMBANG_BY_NOSLIP)
    @Results(value = {
        @Result(property = "vehicleId", column = "vehicleId"),
        @Result(property = "vehicle", column = "vehicleId",
                one = @One(select = "com.aldroid.hormid.common.dao.resource.VehicleDao.selectById")),
        @Result(property = "timbangMuatKaryawan", column = "id", 
                many = @Many(select = "selectTimbangMuatKaryawanByTimbangMuatId")),
        @Result(property = "id", column = "id"),
        @Result(property = "timbangMuatSupplier", column = "id", 
                many = @Many(select = "selectTimbangMuatSupplierByTimbangMuatId"))
    })
    abstract TimbangMuatBean selectTimbangByNoSlip(@Param("noMuat") String noSlip) throws Exception;
    
    @Select(SELECT_TIMBANG_MUAT_SUPPLIER_BY_NOSLIP)
    @Results(value = {
        @Result(property = "supplierId", column = "supplierId"),
        @Result(property = "supplier", column = "supplierId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectById")),
        @Result(property = "deletedBy", column = "deletedBy"),
        @Result(property = "deletedByUser", column = "deletedBy",
                one = @One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById"))
    })
    abstract TimbangMuatSupplierBean selectTimbangMuatSupplierByNoSlip(@Param("noSlip") String noSlip) throws Exception;
    
    @Select(SELECT_TIMBANG_MUAT_SUPPLIER_BY_TIMBANGMUATID)
    @Results(value = {
        @Result(property = "supplierId", column = "supplierId"),
        @Result(property = "supplier", column = "supplierId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectById")),
        @Result(property = "deletedBy", column = "deletedBy"),
        @Result(property = "deletedByUser", column = "deletedBy",
                one = @One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById")),
        @Result(property = "dicairkanBy", column = "dicairkanBy"),
        @Result(property = "dicairkanByUser", column = "dicairkanBy", 
                one=@One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById"))
    })
    abstract TimbangMuatSupplierBean selectTimbangMuatSupplierByTimbangMuatId(@Param("timbangMuatId") Integer timbangMuatId) throws Exception;
    
    @Select(SELECT_TIMBANG_MUAT_KARYAWAN_BY_TIMBANGMUATID)
    @Results(value = {
        @Result(property = "employeeId", column = "employeeId"),
        @Result(property = "employee", column = "employeeId", 
                one=@One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectById")),
    })
    abstract List<TimbangMuatKaryawanBean> selectTimbangMuatKaryawanByTimbangMuatId(@Param("timbangMuatId") Integer timbangMuatId) throws Exception;
    
    
    @Insert(INSERT_TIMBANG_MUAT)
    abstract void insertTimbangMuat(TimbangMuatBean bean) throws Exception;
    
    @Insert(INSERT_TIMBANG_MUAT_KARYAWAN)
    abstract void insertTimbangMuatKaryawan(TimbangMuatKaryawanBean bean) throws Exception;

    @Insert(INSERT_TIMBANG_MUAT_SUPPLIER)
    abstract void insertTimbangMuatSupplier(TimbangMuatSupplierBean bean) throws Exception;
    
    @Select(SELECT_TIMBANG_ALL_FILTERED)
    @Results(value = {
        @Result(property = "employeeId", column = "employeeId"),
        @Result(property = "employee", column = "employeeId",
                one = @One(select = "com.aldroid.hormid.common.dao.resource.EmployeeDao.selectById")),
        @Result(property = "supplierId", column = "supplierId"),
        @Result(property = "supplier", column = "supplierId",
                one = @One(select = "com.aldroid.hormid.common.dao.resource.BranchDao.selectById")),
        @Result(property = "vehicleId", column = "vehicleId"),
        @Result(property = "vehicle", column = "vehicleId",
                one = @One(select = "com.aldroid.hormid.common.dao.resource.VehicleDao.selectById")),
        @Result(property = "createdBy", column = "createdBy"),
        @Result(property = "createdByUser", column = "createdBy",
                one = @One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById")),
        @Result(property = "deletedBy", column = "deletedBy"),
        @Result(property = "deletedByUser", column = "deletedBy",
                one = @One(select = "com.aldroid.hormid.common.dao.user.UserDao.selectById"))
    })
    abstract List<TimbangMuatBean> selectTimbangAllFiltered(
            @Param("vehicleId") Integer vehicleId,
            @Param("userId") Integer userId,
            @Param("timestampMuat1") Date timestampMuat1,
            @Param("timestampMuat2") Date timestampMuat2,
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
    
    @Insert(DELETE_TIMBANG)
    abstract void deleteTimbang(@Param("noMuat") String noMuat,
            @Param("deletedBy") Integer deletedBy,
            @Param("alasanDelete") String alasanDelete) throws Exception;
}