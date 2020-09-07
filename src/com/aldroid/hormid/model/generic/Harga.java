/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.model.generic;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public class Harga {
	
    private Integer hargaId;
    private String createdBy;
    private Date createdDate;
    private Date tanggalMulai;
    private Integer hargaJual;
    private Integer hargaBeli;
    

    public Harga() {
    }

	public Integer getHargaId() {
		return hargaId;
	}

	public void setHargaId(Integer hargaId) {
		this.hargaId = hargaId;
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


	public Date getTanggalMulai() {
		return tanggalMulai;
	}

	public void setTanggalMulai(Date tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}

	public Integer getHargaJual() {
		return hargaJual;
	}


	public void setHargaJual(Integer hargaJual) {
		this.hargaJual = hargaJual;
	}


	public Integer getHargaBeli() {
		return hargaBeli;
	}


	public void setHargaBeli(Integer hargaBeli) {
		this.hargaBeli = hargaBeli;
	}
}
