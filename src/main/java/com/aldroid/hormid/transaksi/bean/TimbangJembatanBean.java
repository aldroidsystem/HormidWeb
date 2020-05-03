/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.bean;

import com.aldroid.hormid.lapak.bean.HargaBean;
import com.aldroid.hormid.lapak.bean.VehicleBean;
import com.aldroid.hormid.user.bean.EmployeeBean;
import com.aldroid.hormid.user.bean.UserBean;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public class TimbangJembatanBean {
    private Integer id;
    private String noSlip;
    private Integer driverId;
    private Integer vehicleId;
    private Integer supplierId;
    private Integer productId;
    private Integer branchId;
    private Double beratTimbangMasuk;
    private Date timestampTimbangMasuk;
    private Double beratTimbangKeluar;
    private Date timestampTimbangKeluar;    
    private Double potonganWajib;
    private Double harga;
    private Double potonganLainnya;
    private String keteranganPotongan;
    private Double pulangan;
    private String keteranganPulangan;
    private String satuanPulangan;
    private Double bruto;
    private Double netto;
    private Double totalPotongan;
    private Double totalBerat;
    private Double totalHarga;
    private Double totalBiaya;
    private Double totalBayar;
    private String catatan;
    private Integer timbangMasukBy;
    private Integer timbangKeluarBy;
    private boolean flagCekDicairkan = false;
    private boolean flagDeleted = false;
    private Date timestampDelete;
    private Date timestampCekDicairkan;
    private Integer deletedBy;
    private Integer dicairkanBy;
    private String alasanDelete;
    private Double biayaKuli;
    private Double biayaLainnya;
    private String keteranganBiaya;
    private HargaBean product;
    private VehicleBean vehicle;
    private EmployeeBean driver;
    private UserBean timbangKeluarByUser;
    private UserBean deletedByUser;
    private UserBean dicairkanByUser;

    public TimbangJembatanBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoSlip() {
        return noSlip;
    }

    public void setNoSlip(String noSlip) {
        this.noSlip = noSlip;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public EmployeeBean getDriver() {
        return driver;
    }

    public void setDriver(EmployeeBean driver) {
        this.driver = driver;
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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Double getBeratTimbangMasuk() {
        return beratTimbangMasuk;
    }

    public void setBeratTimbangMasuk(Double beratTimbangMasuk) {
        this.beratTimbangMasuk = beratTimbangMasuk;
    }

    public Date getTimestampTimbangMasuk() {
        return timestampTimbangMasuk;
    }

    public void setTimestampTimbangMasuk(Date timestampTimbangMasuk) {
        this.timestampTimbangMasuk = timestampTimbangMasuk;
    }

    public Double getBeratTimbangKeluar() {
        return beratTimbangKeluar;
    }

    public void setBeratTimbangKeluar(Double beratTimbangKeluar) {
        this.beratTimbangKeluar = beratTimbangKeluar;
    }

    public Date getTimestampTimbangKeluar() {
        return timestampTimbangKeluar;
    }

    public void setTimestampTimbangKeluar(Date timestampTimbangKeluar) {
        this.timestampTimbangKeluar = timestampTimbangKeluar;
    }

    public Double getPotonganWajib() {
        return potonganWajib;
    }

    public void setPotonganWajib(Double potonganWajib) {
        this.potonganWajib = potonganWajib;
    }

    public Double getPotonganLainnya() {
        return potonganLainnya;
    }

    public void setPotonganLainnya(Double potonganLainnya) {
        this.potonganLainnya = potonganLainnya;
    }

    public String getKeteranganPotongan() {
        return keteranganPotongan;
    }

    public void setKeteranganPotongan(String keteranganPotongan) {
        this.keteranganPotongan = keteranganPotongan;
    }

    public Double getPulangan() {
        return pulangan;
    }

    public void setPulangan(Double pulangan) {
        this.pulangan = pulangan;
    }

    public String getKeteranganPulangan() {
        return keteranganPulangan;
    }

    public void setKeteranganPulangan(String keteranganPulangan) {
        this.keteranganPulangan = keteranganPulangan;
    }

    public Double getNetto() {
        return netto;
    }

    public void setNetto(Double netto) {
        this.netto = netto;
    }

    public Double getTotalPotongan() {
        return totalPotongan;
    }

    public void setTotalPotongan(Double totalPotongan) {
        this.totalPotongan = totalPotongan;
    }

    public Double getTotalBerat() {
        return totalBerat;
    }

    public void setTotalBerat(Double totalBerat) {
        this.totalBerat = totalBerat;
    }

    public Double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Integer getTimbangMasukBy() {
        return timbangMasukBy;
    }

    public void setTimbangMasukBy(Integer timbangMasukBy) {
        this.timbangMasukBy = timbangMasukBy;
    }

    public Integer getTimbangKeluarBy() {
        return timbangKeluarBy;
    }

    public void setTimbangKeluarBy(Integer timbangKeluarBy) {
        this.timbangKeluarBy = timbangKeluarBy;
    }

    public boolean isFlagCekDicairkan() {
        return flagCekDicairkan;
    }

    public void setFlagCekDicairkan(boolean flagCekDicairkan) {
        this.flagCekDicairkan = flagCekDicairkan;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Double getBiayaKuli() {
        return biayaKuli;
    }

    public void setBiayaKuli(Double biayaKuli) {
        this.biayaKuli = biayaKuli;
    }

    public Double getBiayaLainnya() {
        return biayaLainnya;
    }

    public void setBiayaLainnya(Double biayaLainnya) {
        this.biayaLainnya = biayaLainnya;
    }

    public String getKeteranganBiaya() {
        return keteranganBiaya;
    }

    public void setKeteranganBiaya(String keteranganBiaya) {
        this.keteranganBiaya = keteranganBiaya;
    }

    public Double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(Double totalBayar) {
        this.totalBayar = totalBayar;
    }    

    public Double getBruto() {
        return bruto;
    }

    public void setBruto(Double bruto) {
        this.bruto = bruto;
    }

    public Double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(Double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }    

    public String getSatuanPulangan() {
        return satuanPulangan;
    }

    public void setSatuanPulangan(String satuanPulangan) {
        this.satuanPulangan = satuanPulangan;
    }

    public Date getTimestampDelete() {
        return timestampDelete;
    }

    public void setTimestampDelete(Date timestampDelete) {
        this.timestampDelete = timestampDelete;
    }

    public Date getTimestampCekDicairkan() {
        return timestampCekDicairkan;
    }

    public void setTimestampCekDicairkan(Date timestampCekDIcairkan) {
        this.timestampCekDicairkan = timestampCekDIcairkan;
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

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public UserBean getTimbangKeluarByUser() {
        return timbangKeluarByUser;
    }

    public void setTimbangKeluarByUser(UserBean timbangKeluarByUser) {
        this.timbangKeluarByUser = timbangKeluarByUser;
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
