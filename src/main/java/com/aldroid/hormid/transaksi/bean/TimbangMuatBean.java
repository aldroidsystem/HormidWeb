/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.bean;

import com.aldroid.hormid.lapak.bean.HargaBean;
import com.aldroid.hormid.lapak.bean.VehicleBean;
import com.aldroid.hormid.user.bean.UserBean;

import java.util.Date;
import java.util.List;

/**
 *
 * @author renaldo
 */
public class TimbangMuatBean {
    private Integer id;
    private String noMuat;
    private Integer productId;
    private Integer vehicleId;
    private String catatan;
    private Integer branchId;
    private Integer createdBy;
    private Boolean flagDeleted;
    private Boolean flagCekDicairkan;
    private Boolean timestampDelete;
    private Date timestampCekDicairkan;
    private Date timestampMuat;
    private Integer deletedBy;
    private Integer dicairkanBy;
    private String alasanDelete;
    private HargaBean product;
    private Double totalNetto;
    private Double totalBayar;
    private List<TimbangMuatKaryawanBean> timbangMuatKaryawan;
    private List<TimbangMuatSupplierBean> timbangMuatSupplier;
    private VehicleBean vehicle;
    private UserBean createdByUser;
    private UserBean deletedByUser;
    private UserBean dicairkanByUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoMuat() {
        return noMuat;
    }

    public void setNoMuat(String noMuat) {
        this.noMuat = noMuat;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public HargaBean getProduct() {
        return product;
    }

    public void setProduct(HargaBean product) {
        this.product = product;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagCekDicairkan() {
        return flagCekDicairkan;
    }

    public void setFlagCekDicairkan(Boolean flagCekDicairkan) {
        this.flagCekDicairkan = flagCekDicairkan;
    }

    public Boolean getTimestampDelete() {
        return timestampDelete;
    }

    public void setTimestampDelete(Boolean timestampDelete) {
        this.timestampDelete = timestampDelete;
    }

    public Date getTimestampCekDicairkan() {
        return timestampCekDicairkan;
    }

    public void setTimestampCekDicairkan(Date timestampCekDicairkan) {
        this.timestampCekDicairkan = timestampCekDicairkan;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Integer getDicairkanBy() {
        return dicairkanBy;
    }

    public void setDicairkanBy(Integer dicairkanBy) {
        this.dicairkanBy = dicairkanBy;
    }

    public String getAlasanDelete() {
        return alasanDelete;
    }

    public void setAlasanDelete(String alasanDelete) {
        this.alasanDelete = alasanDelete;
    }

    public List<TimbangMuatKaryawanBean> getTimbangMuatKaryawan() {
        return timbangMuatKaryawan;
    }

    public void setTimbangMuatKaryawan(List<TimbangMuatKaryawanBean> timbangMuatKaryawan) {
        this.timbangMuatKaryawan = timbangMuatKaryawan;
    }

    public List<TimbangMuatSupplierBean> getTimbangMuatSupplier() {
        return timbangMuatSupplier;
    }

    public void setTimbangMuatSupplier(List<TimbangMuatSupplierBean> timbangMuatSupplier) {
        this.timbangMuatSupplier = timbangMuatSupplier;
    }

    public Date getTimestampMuat() {
        return timestampMuat;
    }

    public void setTimestampMuat(Date timestampMuat) {
        this.timestampMuat = timestampMuat;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleBean getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleBean vehicle) {
        this.vehicle = vehicle;
    }

    public Double getTotalNetto() {
        return totalNetto;
    }

    public void setTotalNetto(Double totalNetto) {
        this.totalNetto = totalNetto;
    }

    public Double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(Double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public UserBean getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UserBean createdByUser) {
        this.createdByUser = createdByUser;
    }

    public UserBean getDeletedByUser() {
        return deletedByUser;
    }

    public void setDeletedByUser(UserBean deletedByUser) {
        this.deletedByUser = deletedByUser;
    }

    public UserBean getDicairkanByUser() {
        return dicairkanByUser;
    }

    public void setDicairkanByUser(UserBean dicairkanByUser) {
        this.dicairkanByUser = dicairkanByUser;
    }
}
