/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.bean;

import com.aldroid.hormid.user.bean.EmployeeBean;

/**
 *
 * @author renaldo
 */
public class TimbangMuatKaryawanBean {
    private Integer id;
    private Integer timbangMuatId;
    private Integer employeeId;
    private String jenisPekerjaan;
    private Double biayaPerKg;
    private String catatan;
    private EmployeeBean employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimbangMuatId() {
        return timbangMuatId;
    }

    public void setTimbangMuatId(Integer timbangMuatId) {
        this.timbangMuatId = timbangMuatId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeBean getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBean employee) {
        this.employee = employee;
    }

    public String getJenisPekerjaan() {
        return jenisPekerjaan;
    }

    public void setJenisPekerjaan(String jenisPekerjaan) {
        this.jenisPekerjaan = jenisPekerjaan;
    }

    public Double getBiayaPerKg() {
        return biayaPerKg;
    }

    public void setBiayaPerKg(Double biayaPerKg) {
        this.biayaPerKg = biayaPerKg;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
