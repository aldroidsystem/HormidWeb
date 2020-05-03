/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.lapak.bean;

import com.aldroid.hormid.user.bean.EmployeeBean;
import com.aldroid.hormid.user.bean.UserBean;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public  class VehicleBean{
    private Integer id;
    private Integer publicId;
    private String plateNumber;
    private String vehicleType;
    private String notes;
    private Integer employeeId;
    private EmployeeBean employee;
    private Integer branchId;
    private Integer lastUpdatedBy;
    private UserBean lastUpdatedUser;
    private Date timestampStatus;

    public  VehicleBean() {
    }

    
    public  Integer getId() {
        return id;
    }

    
    public  void setId(Integer id) {
        this.id = id;
    }

    
    public  Integer getPublicId() {
        return publicId;
    }

    
    public  void setPublicId(Integer publicId) {
        this.publicId = publicId;
    }

    
    public  String getPlateNumber() {
        return plateNumber;
    }

    
    public  void setPlateNumber(String platenumber) {
        this.plateNumber = platenumber;
    }

    
    public  String getVehicleType() {
        return vehicleType;
    }

    
    public  void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    
    public  String getNotes() {
        return notes;
    }

    
    public  void setNotes(String notes) {
        this.notes = notes;
    }

    
    public  Integer getEmployeeId() {
        return employeeId;
    }

    
    public  void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    
    public  EmployeeBean getEmployee() {
        return employee;
    }

    
    public  void setEmployee(EmployeeBean employee) {
        this.employee = employee;
    }

    
    public  Integer getBranchId() {
        return branchId;
    }

    
    public  void setBranchId(Integer branchid) {
        this.branchId = branchid;
    }
    
    public  Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    
    public  void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    
    public  UserBean getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    
    public  void setLastUpdatedUser(UserBean lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser;
    }

    
    public  Date getTimestampStatus() {
        return timestampStatus;
    }

    
    public  void setTimestampStatus(Date timestampStatus) {
        this.timestampStatus = timestampStatus;
    }
}
