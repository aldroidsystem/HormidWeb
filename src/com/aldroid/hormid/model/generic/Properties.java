/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.model.generic;

import java.util.List;
/**
 *
 * @author renaldo
 */
public class Properties {

    private String code;
    private String propertyDesc;
    private String tipeData;
    private String value;
    private String kata;
    private Integer angka;
    private Float desimal;
    private List<String> daftarKata;
    private List<Integer> daftarAngka;
    private List<Float> daftarDesimal;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPropertyDesc() {
		return propertyDesc;
	}
	public void setPropertyDesc(String description) {
		this.propertyDesc = description;
	}
	public String getTipeData() {
		return tipeData;
	}
	public void setTipeData(String dataType) {
		this.tipeData = dataType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKata() {
		return kata;
	}
	public void setKata(String kata) {
		this.kata = kata;
	}
	public Integer getAngka() {
		return angka;
	}
	public void setAngka(Integer angka) {
		this.angka = angka;
	}
	public Float getDesimal() {
		return desimal;
	}
	public void setDesimal(Float desimal) {
		this.desimal = desimal;
	}
	public List<String> getDaftarKata() {
		return daftarKata;
	}
	public void setDaftarKata(List<String> daftarKata) {
		this.daftarKata = daftarKata;
	}
	public List<Integer> getDaftarAngka() {
		return daftarAngka;
	}
	public void setDaftarAngka(List<Integer> daftarAngka) {
		this.daftarAngka = daftarAngka;
	}
	public List<Float> getDaftarDesimal() {
		return daftarDesimal;
	}
	public void setDaftarDesimal(List<Float> daftarDesimal) {
		this.daftarDesimal = daftarDesimal;
	}
}
