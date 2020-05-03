/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.bean;

import com.aldroid.hormid.user.bean.UserBean;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public class TimbangMuatSupplierBean {

    private Integer id;
    private Integer timbangMuatId;
    private String noSlip;
    private Integer supplierId;
    private Double beratTimbang;
    private Double harga;
    private Double potonganWajib;
    private Double potonganLainnya;
    private String keteranganPotongan;
    private Double biayaKuli;
    private Double biayaLainnya;
    private String keteranganBiaya;
    private Double netto;
    private Double bruto;
    private Double totalPotongan;
    private Double totalBerat;
    private Double totalBiaya;
    private Double totalHarga;
    private Double totalBayar;
    private String catatan;
    private Boolean flagDeleted;
    private Boolean flagCekDicairkan = false;
    private Boolean timestampDelete;
    private Date timestamp;
    private Integer deletedBy;
    private Integer dicairkanBy;
    private String alasanDelete;
    private UserBean deletedByUser;
    private UserBean dicairkanByUser;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimbangMuatId() {
        return timbangMuatId;
    }

    public void setTimbangMuatId(Integer timbangMuatId) {
        this.timbangMuatId = timbangMuatId;
    }

    public String getNoSlip() {
        return noSlip;
    }

    public void setNoSlip(String noslip) {
        this.noSlip = noslip;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierid) {
        this.supplierId = supplierid;
    }

    public Double getBeratTimbang() {
        return beratTimbang;
    }

    public void setBeratTimbang(Double beratTimbang) {
        this.beratTimbang = beratTimbang;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
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

    public Double getNetto() {
        return netto;
    }

    public void setNetto(Double netto) {
        this.netto = netto;
    }

    public Double getBruto() {
        return bruto;
    }

    public void setBruto(Double bruto) {
        this.bruto = bruto;
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

    public Double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(Double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public Double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(Double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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
