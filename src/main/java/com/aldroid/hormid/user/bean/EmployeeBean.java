/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.user.bean;

import com.aldroid.hormid.core.common.bean.GenderEnum;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public class EmployeeBean{

    private Integer id;
    private Integer publicId;
    private String fullname;
    private Date dateOfBirth;
    private Date dateOfJoin;
    private Integer liabilities = 0;
    private String phone;
    private String email;
    private String idType;
    private String idNumber;
    private GenderEnum gender;
    private String fieldOfWork;
    private String address;
    private String notes;
    private Integer branchId;
    private Integer lastUpdatedBy;
    private UserBean lastUpdatedUser;
    private Date timestampStatus;
    private Integer userPublicId;
    private UserBean user;

    public EmployeeBean() {
    }

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public Integer getPublicId() {
        return publicId;
    }

    
    public void setPublicId(Integer publicId) {
        this.publicId = publicId;
    }

    
    public String getFullname() {
        return fullname;
    }

    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    
    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }
    
    
    public Integer getLiabilities() {
        return liabilities;
    }

    
    public void setLiabilities(Integer liabilities) {
        this.liabilities = liabilities;
    }

    
    public String getPhone() {
        return phone;
    }

    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getIdType() {
        return idType;
    }

    
    public void setIdType(String idType) {
        this.idType = idType;
    }

    
    public String getIdNumber() {
        return idNumber;
    }

    
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    
    public GenderEnum getGenderEnum() {
        return gender;
    }

    
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    
    public String getFieldOfWork() {
        return fieldOfWork;
    }

    
    public void setFieldOfWork(String fieldOfWork) {
        this.fieldOfWork = fieldOfWork;
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address;
    }

    
    public String getNotes() {
        return notes;
    }

    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    public Integer getBranchId() {
        return branchId;
    }

    
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    
    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    
    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    
    public UserBean getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    
    public void setLastUpdatedUser(UserBean lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser;
    }

    
    public Date getTimestampStatus() {
        return timestampStatus;
    }

    
    public void setTimestampStatus(Date timestampStatus) {
        this.timestampStatus = timestampStatus;
    }

    public Integer getUserPublicId() {
        return userPublicId;
    }

    public void setUserPublicId(Integer userPublicId) {
        this.userPublicId = userPublicId;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
    
    
    public boolean getGender() {
        return gender!=null ? gender.getValue() : true;
    }
    
    
    public void setGender(boolean gender) {
        this.gender = GenderEnum.getByValues(gender);
    }
}
