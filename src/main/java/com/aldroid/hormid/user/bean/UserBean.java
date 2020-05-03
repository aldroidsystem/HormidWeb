/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.user.bean;

import com.aldroid.hormid.core.common.bean.UserTypeEnum;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public class UserBean {

    private Integer id;
    private Integer publicId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Boolean flagActive = false;
    private Boolean flagLocked = true;
    private Date lastLogin;
    private String token;
    private UserTypeEnum userType;
    private Integer referenceId;
    private EmployeeBean employee;
    private Integer lastUpdatedBy;
    private UserBean lastUpdatedUser;
    private Date timestampStatus;

    public UserBean() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getFlagActive() {
        return flagActive;
    }

    public void setFlagActive(Boolean flagActive) {
        this.flagActive = flagActive;
    }

    public Boolean getFlagLocked() {
        return flagLocked;
    }

    public void setFlagLocked(Boolean flagLocked) {
        this.flagLocked = flagLocked;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userType;
    }

    public int getUserType() {
        return userType.getValue();
    }
    
    public void setUserType(int userType) {
        this.userType = UserTypeEnum.getByValues(userType);
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getTimestampStatus() {
        return timestampStatus;
    }

    public void setTimestampStatus(Date timestampStatus) {
        this.timestampStatus = timestampStatus;
    }

    public UserBean getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    public void setLastUpdatedUser(UserBean lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser;
    }

    public EmployeeBean getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBean employee) {
        this.employee = employee;
    }
}
