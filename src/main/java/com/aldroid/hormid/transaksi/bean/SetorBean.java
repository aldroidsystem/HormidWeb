/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.bean;

import com.aldroid.hormid.lapak.bean.HargaBean;
import com.aldroid.hormid.lapak.bean.VehicleBean;
import com.aldroid.hormid.user.bean.EmployeeBean;

/**
 *
 * @author renaldo
 */
public class SetorBean {

    private int id;
    private String noslip;
    private int driverid;
    private int vehicleid;
    private int productid;
    private Double bruto;
    private Double netto;
    private int jumlahtandan;
    private String keterangansetor;
    private EmployeeBean driver;
    private VehicleBean vehicle;
    private HargaBean product;
    private int branchId;
    private boolean flagDeleted=false;

    public SetorBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoslip() {
        return noslip;
    }

    public void setNoslip(String noslip) {
        this.noslip = noslip;
    }

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public Double getBruto() {
        return bruto;
    }

    public void setBruto(Double bruto) {
        this.bruto = bruto;
    }

    public Double getNetto() {
        return netto;
    }

    public void setNetto(Double netto) {
        this.netto = netto;
    }

    public int getJumlahtandan() {
        return jumlahtandan;
    }

    public void setJumlahtandan(int jumlahtandan) {
        this.jumlahtandan = jumlahtandan;
    }

    public String getKeterangansetor() {
        return keterangansetor;
    }

    public void setKeterangansetor(String keterangansetor) {
        this.keterangansetor = keterangansetor;
    }

    public EmployeeBean getDriver() {
        return driver;
    }

    public void setDriver(EmployeeBean driver) {
        this.driver = driver;
    }

    public VehicleBean getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleBean vehicle) {
        this.vehicle = vehicle;
    }

    public HargaBean getProduct() {
        return product;
    }

    public void setProduct(HargaBean product) {
        this.product = product;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

}
