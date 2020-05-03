/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.bean;

import com.aldroid.hormid.lapak.bean.HargaBean;
import com.aldroid.hormid.user.bean.EmployeeBean;
import com.aldroid.hormid.user.bean.UserBean;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public class TimbangBiasaBean {
    private Integer id;
    private String noSlip;
    private Integer employeeId;
    private Integer supplierId;
    private Integer productId;
    private Integer branchId;
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
    private Integer timbangBy;
    private boolean flagCekDicairkan = false;
    private boolean flagDeleted = false;
    private Date timestampDelete;
    private Date timestampCekDicairkan;
    private Date timestampTimbang;
    private Integer deletedBy;
    private Integer dicairkanBy;
    private String alasanDelete;
    private Double biayaKuli;
    private Double biayaLainnya;
    private String keteranganBiaya;
    private EmployeeBean employee;
    private HargaBean product;
    private UserBean timbangByUser;
    private UserBean deletedByUser;
    private UserBean dicairkanByUser;
    

    public TimbangBiasaBean() {
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeBean getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBean employee) {
        this.employee = employee;
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
    
    public Double getPotonganWajib() {
        return potonganWajib;
    }

    public void setPotonganWajib(Double potonganWajib) {
        this.potonganWajib = potonganWajib;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
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

    public String getSatuanPulangan() {
        return satuanPulangan;
    }

    public void setSatuanPulangan(String satuanPulangan) {
        this.satuanPulangan = satuanPulangan;
    }

    public Double getBruto() {
        return bruto;
    }

    public void setBruto(Double bruto) {
        this.bruto = bruto;
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

    public Double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(Double totalBiaya) {
        this.totalBiaya = totalBiaya;
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

    public Integer getTimbangBy() {
        return timbangBy;
    }

    public void setTimbangBy(Integer timbangBy) {
        this.timbangBy = timbangBy;
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

    public Date getTimestampDelete() {
        return timestampDelete;
    }

    public void setTimestampDelete(Date timestampDelete) {
        this.timestampDelete = timestampDelete;
    }

    public Date getTimestampCekDicairkan() {
        return timestampCekDicairkan;
    }

    public void setTimestampCekDicairkan(Date timestampCekDicairkan) {
        this.timestampCekDicairkan = timestampCekDicairkan;
    }

    public Date getTimestampTimbang() {
        return timestampTimbang;
    }

    public void setTimestampTimbang(Date timestampTimbang) {
        this.timestampTimbang = timestampTimbang;
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

    public UserBean getTimbangByUser() {
        return timbangByUser;
    }

    public void setTimbangByUser(UserBean timbangByUser) {
        this.timbangByUser = timbangByUser;
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
