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
public enum GenderEnum {
    MALE(true),
    FEMALE(false);
    
    private final boolean value;

    private GenderEnum(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
    
    public static GenderEnum getByValues(boolean value){
        return value ? GenderEnum.MALE : GenderEnum.FEMALE;
    }
};
