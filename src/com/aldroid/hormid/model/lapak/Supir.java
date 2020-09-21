package com.aldroid.hormid.model.lapak;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Supir {

	private String username;
	private String fullname;
    private Integer flagActive;
    private Integer flagDeleted;
    private String createdBy;
    private Date createdDate;
    private String catatan;
    private List<Vehicle> vehicles;
    private List<Integer> listVehicleId;
    private List<String> listVehiclePlate;
    private List<String> roles;
    private String action;
    
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getFlagActive() {
		return flagActive;
	}
	public void setFlagActive(Integer flagActive) {
		this.flagActive = flagActive;
	}
	public Integer getFlagDeleted() {
		return flagDeleted;
	}
	public void setFlagDeleted(Integer flagDeleted) {
		this.flagDeleted = flagDeleted;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Integer> getListVehicleId() {
		if(listVehicleId == null && vehicles != null){
			listVehicleId = new ArrayList<Integer>();
			for (Vehicle v : vehicles){
				listVehicleId.add(v.getVehicleId());
			}
		}
		
		return listVehicleId;
	}
	public void setListVehicleId(List<Integer> listVehicleId) {
		this.listVehicleId = listVehicleId;
	}
	public List<String> getListVehiclePlate() {
		if(listVehiclePlate == null && vehicles != null){
			listVehiclePlate = new ArrayList<String>();
			for (Vehicle v : vehicles){
				listVehiclePlate.add(v.getPlateNumber());
			}
		}
		return listVehiclePlate;
	}
	public void setListVehiclePlate(List<String> listVehiclePlate) {
		this.listVehiclePlate = listVehiclePlate;
	} 
	
}