package com.aldroid.hormid.model.transaksi;


import java.util.Date;

public class TimbangGantung {

    private String noNota;
	private String username;
	private String fullname;
	private String catatan;
    private String createdBy;
    private Date createdDate;
	private Integer potongan;
	private Integer totalPotongan;
	private Float bruto;
	private Float netto;
	private Integer harga;
	private Integer total;
	private Integer pembulatan;
	
	

	public String getNoNota() {
		return noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public Integer getPotongan() {
		return potongan;
	}
	public void setPotongan(Integer potongan) {
		this.potongan = potongan;
	}
	public Float getBruto() {
		return bruto;
	}
	public void setBruto(Float bruto) {
		this.bruto = bruto;
	}
	public Float getNetto() {
		return netto;
	}
	public void setNetto(Float netto) {
		this.netto = netto;
	}
	public Integer getHarga() {
		return harga;
	}
	public void setHarga(Integer harga) {
		this.harga = harga;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalPotongan() {
		return totalPotongan;
	}
	public void setTotalPotongan(Integer totalPotongan) {
		this.totalPotongan = totalPotongan;
	}
	public Integer getPembulatan() {
		return pembulatan;
	}
	public void setPembulatan(Integer pembulatan) {
		this.pembulatan = pembulatan;
	}
}
