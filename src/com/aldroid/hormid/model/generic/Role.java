package com.aldroid.hormid.model.generic;


public class Role {

	private String code;
    private String name;
    private String description;
    private Integer flagActive;
    private Integer flagDeleted;
    
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
}
