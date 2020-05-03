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
public class AuditTrailBean {

    private String className;
    private String method;
    private String module;
    private Date timestamp;
    private int administratorid;
    private String message;
    private String parameter;
    private String detail;
    private UserBean administrator;

    public AuditTrailBean() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public UserBean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(UserBean administrator) {
        this.administrator = administrator;
    }

}
