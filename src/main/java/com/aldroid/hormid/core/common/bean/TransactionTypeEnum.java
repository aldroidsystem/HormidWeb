/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.core.common.bean;

/**
 *
 * @author renaldo
 */
public enum TransactionTypeEnum {
    TIMBANG_BIASA("TB"),
    TIMBANG_JEMBATAN("TJ"),
    TIMBANG_MUAT("TM");
    
    private final String value;

    private TransactionTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static TransactionTypeEnum getByValues(String value) throws Exception {
        for(TransactionTypeEnum user : values())
            if(user.getValue().equals(user))
                return user;
                
        throw new Exception("Transaction Type Not Found!");
    }
};
