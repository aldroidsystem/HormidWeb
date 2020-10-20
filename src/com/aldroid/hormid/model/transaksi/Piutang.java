/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.model.transaksi;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public class Piutang {
    private String piutangId;
	private String username;
	private String fullname;
	private Integer hutang;
	private Integer bayar;
	private Integer sisaHutang;
	private Integer defaultCicilan;
	private String keterangan;
	private String catatan;
    private String createdBy;
    private Date createdDate;
    private Integer amount;
    private String jenisTransaksi;
    private Date dariTanggal;
    private Date sampaiTanggal;
    
    
	public Integer getDefaultCicilan() {
		return defaultCicilan;
	}
	public void setDefaultCicilan(Integer defaultCicilan) {
		this.defaultCicilan = defaultCicilan;
	}
	public String getPiutangId() {
		return piutangId;
	}
	public void setPiutangId(String piutangId) {
		this.piutangId = piutangId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getHutang() {
		return hutang;
	}
	public void setHutang(Integer hutang) {
		this.hutang = hutang;
	}
	public Integer getBayar() {
		return bayar;
	}
	public void setBayar(Integer bayar) {
		this.bayar = bayar;
	}
	public Integer getSisaHutang() {
		return sisaHutang;
	}
	public void setSisaHutang(Integer sisaHutang) {
		this.sisaHutang = sisaHutang;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getCatatan() {
		return catatan;
	}
	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getJenisTransaksi() {
		return jenisTransaksi;
	}
	public void setJenisTransaksi(String jenisTransaksi) {
		this.jenisTransaksi = jenisTransaksi;
	}
	public Date getDariTanggal() {
		return dariTanggal;
	}
	public void setDariTanggal(Date dariTanggal) {
		this.dariTanggal = dariTanggal;
	}
	public Date getSampaiTanggal() {
		return sampaiTanggal;
	}
	public void setSampaiTanggal(Date sampaiTanggal) {
		this.sampaiTanggal = sampaiTanggal;
	}
	
}
