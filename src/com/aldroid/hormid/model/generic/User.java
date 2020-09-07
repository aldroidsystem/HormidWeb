package com.aldroid.hormid.model.generic;

import java.util.Date;
import java.util.List;


public class User {

	private String username;
    private String fullname;
    private String area;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String passwordConfirm;
    private Integer loginFailCount; 
    private Date passwordChangeDate; 
    private Integer passwordExpiryPeriod;
    private Integer sessionInstanceCount;
    private Integer flagActive;
    private Integer flagNeverDisable;
    private Integer flagDeleted;
    private Integer flagLocked;
    private Integer flagChgPassword;
    private String createdBy;
    private Date createdDate;
    private Date updatedDate;
    private List<String> roles;
    private Integer flagPasswordExpired;
    private String action;
    private String token;
    private String tokenCreationDate;
    

	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getTokenCreationDate() {
		return tokenCreationDate;
	}


	public void setTokenCreationDate(String tokenCreationDate) {
		this.tokenCreationDate = tokenCreationDate;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getUsername() {
		return username;
	}


	public String getPasswordConfirm() {
		return passwordConfirm;
	}


	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginFailCount() {
		return loginFailCount;
	}


	public void setLoginFailCount(Integer loginFailCount) {
		this.loginFailCount = loginFailCount;
	}


	public Date getPasswordChangeDate() {
		return passwordChangeDate;
	}


	public void setPasswordChangeDate(Date passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}


	public Integer getPasswordExpiryPeriod() {
		return passwordExpiryPeriod;
	}


	public void setPasswordExpiryPeriod(Integer passwordExpiryPeriod) {
		this.passwordExpiryPeriod = passwordExpiryPeriod;
	}


	public Integer getSessionInstanceCount() {
		return sessionInstanceCount;
	}


	public void setSessionInstanceCount(Integer sessionInstanceCount) {
		this.sessionInstanceCount = sessionInstanceCount;
	}


	public Integer getFlagActive() {
		return flagActive;
	}


	public void setFlagActive(Integer flagActive) {
		this.flagActive = flagActive;
	}


	public Integer getFlagNeverDisable() {
		return flagNeverDisable;
	}


	public void setFlagNeverDisable(Integer flagNeverDisable) {
		this.flagNeverDisable = flagNeverDisable;
	}


	public Integer getFlagDeleted() {
		return flagDeleted;
	}


	public void setFlagDeleted(Integer flagDeleted) {
		this.flagDeleted = flagDeleted;
	}


	public Integer getFlagChgPassword() {
		return flagChgPassword;
	}


	public void setFlagChgPassword(Integer flagChgPassword) {
		this.flagChgPassword = flagChgPassword;
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


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Integer getFlagLocked() {
		return flagLocked;
	}

	public void setFlagLocked(Integer flagLocked) {
		this.flagLocked = flagLocked;
	}

	public Integer getFlagPasswordExpired() {
		return flagPasswordExpired;
	}

	public void setFlagPasswordExpired(Integer flagPasswordExpired) {
		this.flagPasswordExpired = flagPasswordExpired;
	}

	public boolean getBooleanFlagDeleted() {
		return getFlagDeleted().compareTo(1)==0;
	}

	public boolean getBooleanFlagChgPassword() {
		return getFlagChgPassword().compareTo(1)==0;
	}

	public boolean getBooleanFlagNeverDisable() {
		return getFlagNeverDisable().compareTo(1)==0;
	}
	
	public boolean getBooleanFlagActive() {
		return getFlagActive().compareTo(1)==0;
	}
	
	public boolean getBooleanFlagLocked() {
		return getFlagLocked().compareTo(1)==0;
	}

	public boolean getBooleanFlagPasswordExpired() {
		return getFlagPasswordExpired().compareTo(1)==0;

	}
}