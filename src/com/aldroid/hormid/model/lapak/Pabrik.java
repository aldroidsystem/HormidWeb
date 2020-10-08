package com.aldroid.hormid.model.lapak;

import java.util.Date;


public class Pabrik {

    private Integer pabrikId;
	private String namaPerusahaan;
    private Integer uangJalanTruk;
    private Integer biayaMobilTruk;
    private Integer uangJalanTronton;
    private Integer biayaMobilTronton;
    private String catatan;
    private String updatedBy;
    private Date updatedDate;
    
	public Integer getPabrikId() {
		return pabrikId;
	}
	public void setPabrikId(Integer pabrikId) {
		this.pabrikId = pabrikId;
	}
	public String getNamaPerusahaan() {
		return namaPerusahaan;
	}
	public void setNamaPerusahaan(String namaPerusahaan) {
		this.namaPerusahaan = namaPerusahaan;
	}
	public Integer getUangJalanTruk() {
		return uangJalanTruk;
	}
	public void setUangJalanTruk(Integer uangJalanTruk) {
		this.uangJalanTruk = uangJalanTruk;
	}
	public Integer getBiayaMobilTruk() {
		return biayaMobilTruk;
	}
	public void setBiayaMobilTruk(Integer biayaMobilTruk) {
		this.biayaMobilTruk = biayaMobilTruk;
	}
	public Integer getUangJalanTronton() {
		return uangJalanTronton;
	}
	public void setUangJalanTronton(Integer uangJalanTronton) {
		this.uangJalanTronton = uangJalanTronton;
	}
	public Integer getBiayaMobilTronton() {
		return biayaMobilTronton;
	}
	public void setBiayaMobilTronton(Integer biayaMobilTronton) {
		this.biayaMobilTronton = biayaMobilTronton;
	}
	public String getCatatan() {
		return catatan;
	}
	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}