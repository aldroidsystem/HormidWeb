/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.core.common.bean;

import com.aldroid.hormid.user.bean.UserBean;

import java.util.Date;

/**
 *
 * @author renaldo
 */
public class SummaryBean {

    private int id;
    private String tablename;
    private int tablekey;
    private String method;
    private String module;
    private String description;
    private Date timestamp;
    private int administratorid;
    private UserBean administrator;

    public SummaryBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public int getTablekey() {
        return tablekey;
    }

    public void setTablekey(int tablekey) {
        this.tablekey = tablekey;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getAdministratorid() {
        return administratorid;
    }

    public void setAdministratorid(int administratorid) {
        this.administratorid = administratorid;
    }

    public UserBean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(UserBean administrator) {
        this.administrator = administrator;
    }
}