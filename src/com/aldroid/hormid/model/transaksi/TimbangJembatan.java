package com.aldroid.hormid.model.transaksi;

import java.util.Date;

public class TimbangJembatan {

    private String noNota;
	private String pengirim;
	private String namaPengirim;
	private String supir;
	private String namaSupir;
	private Integer vehicleId;
	private String plateNumber;
	private Integer bruto;
	private Integer tare;
	private Integer netto;
	private Integer potongan;
	private Integer totalPotongan;
	private Integer beratBersih;
	private Integer harga;
	private Integer total;
	private Integer biayaBongkar;
	private Integer biayaMobil;
	private Integer potonganBon;
	private Integer sisaBon;
	private Integer biayaLain;
	private String keteranganBiayaLain;
	private Integer pembulatan;
	private Integer totalBayar;
	private String catatan;
	private Integer flagLunas; 
	private Integer flagKros; 
	private Integer flagKuliLunas; 
    private String timbang1By;
    private String timbang2By;
    private String paidBy;
    private Date createdDate;
    private Date timestampTimbang1;
    private Date timestampTimbang2;
	private String catatanPengirim;
	private Integer hutangPengirim;
	private String catatanSupir;
	private String catatanVehicle;
    
    
	public String getCatatanPengirim() {
		return catatanPengirim;
	}
	public void setCatatanPengirim(String catatanPengirim) {
		this.catatanPengirim = catatanPengirim;
	}
	public Integer getHutangPengirim() {
		return hutangPengirim;
	}
	public void setHutangPengirim(Integer hutangPengirim) {
		this.hutangPengirim = hutangPengirim;
	}
	public String getCatatanSupir() {
		return catatanSupir;
	}
	public void setCatatanSupir(String catatanSupir) {
		this.catatanSupir = catatanSupir;
	}
	public String getCatatanVehicle() {
		return catatanVehicle;
	}
	public void setCatatanVehicle(String catatanVehicle) {
		this.catatanVehicle = catatanVehicle;
	}
	public String getNoNota() {
		return noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	public String getPengirim() {
		return pengirim;
	}
	public void setPengirim(String pengirim) {
		this.pengirim = pengirim;
	}
	public String getNamaPengirim() {
		return namaPengirim;
	}
	public void setNamaPengirim(String namaPengirim) {
		this.namaPengirim = namaPengirim;
	}
	public String getSupir() {
		return supir;
	}
	public void setSupir(String supir) {
		this.supir = supir;
	}
	public String getNamaSupir() {
		return namaSupir;
	}
	public void setNamaSupir(String namaSupir) {
		this.namaSupir = namaSupir;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public Integer getBruto() {
		return bruto;
	}
	public void setBruto(Integer bruto) {
		this.bruto = bruto;
	}
	public Integer getTare() {
		return tare;
	}
	public void setTare(Integer tare) {
		this.tare = tare;
	}
	public Integer getNetto() {
		return netto;
	}
	public void setNetto(Integer netto) {
		this.netto = netto;
	}
	public Integer getPotongan() {
		return potongan;
	}
	public void setPotongan(Integer potongan) {
		this.potongan = potongan;
	}
	public Integer getTotalPotongan() {
		return totalPotongan;
	}
	public void setTotalPotongan(Integer totalPotongan) {
		this.totalPotongan = totalPotongan;
	}
	public Integer getBeratBersih() {
		return beratBersih;
	}
	public void setBeratBersih(Integer beratBersih) {
		this.beratBersih = beratBersih;
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
	public Integer getBiayaBongkar() {
		return biayaBongkar;
	}
	public void setBiayaBongkar(Integer biayaBongkar) {
		this.biayaBongkar = biayaBongkar;
	}
	public Integer getPotonganBon() {
		return potonganBon;
	}
	public void setPotonganBon(Integer potonganBon) {
		this.potonganBon = potonganBon;
	}
	public Integer getSisaBon() {
		return sisaBon;
	}
	public void setSisaBon(Integer sisaBon) {
		this.sisaBon = sisaBon;
	}
	public Integer getBiayaLain() {
		return biayaLain;
	}
	public void setBiayaLain(Integer biayaLain) {
		this.biayaLain = biayaLain;
	}
	public String getKeteranganBiayaLain() {
		return keteranganBiayaLain;
	}
	public void setKeteranganBiayaLain(String keteranganBiayaLain) {
		this.keteranganBiayaLain = keteranganBiayaLain;
	}
	public Integer getPembulatan() {
		return pembulatan;
	}
	public void setPembulatan(Integer pembulatan) {
		this.pembulatan = pembulatan;
	}
	public Integer getTotalBayar() {
		return totalBayar;
	}
	public void setTotalBayar(Integer totalBayar) {
		this.totalBayar = totalBayar;
	}
	public String getCatatan() {
		return catatan;
	}
	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}
	public Integer getFlagLunas() {
		return flagLunas;
	}
	public void setFlagLunas(Integer flagLunas) {
		this.flagLunas = flagLunas;
	}
	public Integer getFlagKros() {
		return flagKros;
	}
	public void setFlagKros(Integer flagKros) {
		this.flagKros = flagKros;
	}
	public Integer getFlagKuliLunas() {
		return flagKuliLunas;
	}
	public void setFlagKuliLunas(Integer flagKuliLunas) {
		this.flagKuliLunas = flagKuliLunas;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getTimestampTimbang1() {
		return timestampTimbang1;
	}
	public void setTimestampTimbang1(Date timestampTimbang1) {
		this.timestampTimbang1 = timestampTimbang1;
	}
	public Date getTimestampTimbang2() {
		return timestampTimbang2;
	}
	public void setTimestampTimbang2(Date timestampTimbang2) {
		this.timestampTimbang2 = timestampTimbang2;
	}
	public Integer getBiayaMobil() {
		return biayaMobil;
	}
	public void setBiayaMobil(Integer biayaMobil) {
		this.biayaMobil = biayaMobil;
	}
	public String getTimbang1By() {
		return timbang1By;
	}
	public void setTimbang1By(String timbang1By) {
		this.timbang1By = timbang1By;
	}
	public String getTimbang2By() {
		return timbang2By;
	}
	public void setTimbang2By(String timbang2By) {
		this.timbang2By = timbang2By;
	}
	public String getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}
}
