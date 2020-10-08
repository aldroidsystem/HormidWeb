package com.aldroid.hormid.model.transaksi;

import java.util.Date;

public class Penjualan {
	private String noNota;
	private String vehicleId;
	private String plateNumber;
	private String supir;
	private Integer bruto;
	private Integer tare;
	private Integer netto;
	private Integer potongan;
	private Integer totalPotongan;
	private Integer beratBersih;
	private Integer harga;
	private Integer total;
	private Integer pajak;
	private Integer totalPajak;
	private Integer totalBayar;
	private Date tanggal;
	private Integer uangJalan;
	private Integer biayaKendaraan;
	private Integer gajiSupir;
	private Integer gajiKuli;
	private Integer flagKuliBayar;
	private Integer flagSupirBayar;
	
	
	public String getNoNota() {
		return noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getSupir() {
		return supir;
	}
	public void setSupir(String supir) {
		this.supir = supir;
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
	public Integer getPajak() {
		return pajak;
	}
	public void setPajak(Integer pajak) {
		this.pajak = pajak;
	}
	public Integer getTotalPajak() {
		return totalPajak;
	}
	public void setTotalPajak(Integer totalPajak) {
		this.totalPajak = totalPajak;
	}
	public Integer getTotalBayar() {
		return totalBayar;
	}
	public void setTotalBayar(Integer totalBayar) {
		this.totalBayar = totalBayar;
	}
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	public Integer getUangJalan() {
		return uangJalan;
	}
	public void setUangJalan(Integer uangJalan) {
		this.uangJalan = uangJalan;
	}
	public Integer getBiayaKendaraan() {
		return biayaKendaraan;
	}
	public void setBiayaKendaraan(Integer biayaKendaraan) {
		this.biayaKendaraan = biayaKendaraan;
	}
	public Integer getGajiSupir() {
		return gajiSupir;
	}
	public void setGajiSupir(Integer gajiSupir) {
		this.gajiSupir = gajiSupir;
	}
	public Integer getGajiKuli() {
		return gajiKuli;
	}
	public void setGajiKuli(Integer gajiKuli) {
		this.gajiKuli = gajiKuli;
	}
	public Integer getFlagKuliBayar() {
		return flagKuliBayar;
	}
	public void setFlagKuliBayar(Integer flagKuliBayar) {
		this.flagKuliBayar = flagKuliBayar;
	}
	public Integer getFlagSupirBayar() {
		return flagSupirBayar;
	}
	public void setFlagSupirBayar(Integer flagSupirBayar) {
		this.flagSupirBayar = flagSupirBayar;
	}
}
