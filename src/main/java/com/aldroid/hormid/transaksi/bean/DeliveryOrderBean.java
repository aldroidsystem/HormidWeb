/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.bean;


/**
 *
 * @author renaldo
 */
public class DeliveryOrderBean {

    private int id;
    private String noslip;
    private int setorid;
    private SetorBean setor;
    private Double bruto;
    private Double netto;
    private int jumlahtandan;
    private Double potongan;
    private Double pulangan;
    private Double harga;
    private String keterangan;
    private boolean flagDeleted=false;

    public DeliveryOrderBean() {
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

    public int getSetorid() {
        return setorid;
    }

    public void setSetorid(int setorid) {
        this.setorid = setorid;
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

    public Double getPotongan() {
        return potongan;
    }

    public void setPotongan(Double potongan) {
        this.potongan = potongan;
    }

    public Double getPulangan() {
        return pulangan;
    }

    public void setPulangan(Double pulangan) {
        this.pulangan = pulangan;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public SetorBean getSetor() {
        return setor;
    }

    public void setSetor(SetorBean setor) {
        this.setor = setor;
    }

}
