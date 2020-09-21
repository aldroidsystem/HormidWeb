package com.aldroid.hormid.model.lapak;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Vehicle {

    private Integer vehicleId;
	private String plateNumber;
	private String vehicleType;
    private Integer defaultBiayaBongkar;
    private Integer flagDeleted;
    private Integer flagActive;
    private String createdBy;
    private Date createdDate;
    private String catatan;
    private List<Supir> supir;
    private List<String> listSupirUsername;
    private List<String> listSupirFullname;
    private String action;
    
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
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Integer getDefaultBiayaBongkar() {
		return defaultBiayaBongkar;
	}
	public void setDefaultBiayaBongkar(Integer defaultBiayaBongkar) {
		this.defaultBiayaBongkar = defaultBiayaBongkar;
	}
	public Integer getFlagDeleted() {
		return flagDeleted;
	}
	public void setFlagDeleted(Integer flagDeleted) {
		this.flagDeleted = flagDeleted;
	}
	public Integer getFlagActive() {
		return flagActive;
	}
	public void setFlagActive(Integer flagActive) {
		this.flagActive = flagActive;
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
	public String getCatatan() {
		return catatan;
	}
	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Supir> getSupir() {
		return supir;
	}
	public void setSupir(List<Supir> supir) {
		this.supir = supir;
	}
	public List<String> getListSupirUsername() {
		if(listSupirUsername == null && supir != null){
			listSupirUsername = new ArrayList<String>();
			for (Supir s : supir){
				listSupirUsername.add(s.getUsername());
			}
		}
		return listSupirUsername;
	}
	public void setListSupirUsername(List<String> listSupirUsername) {
		this.listSupirUsername = listSupirUsername;
	}
	public List<String> getListSupirFullname() {
		if(listSupirFullname == null && supir != null){
			listSupirFullname = new ArrayList<String>();
			for (Supir s : supir){
				listSupirFullname.add(s.getFullname());
			}
		}
		return listSupirFullname;
	}
	public void setListSupirFullname(List<String> listSupirFullname) {
		this.listSupirFullname = listSupirFullname;
	}
	
}