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
public enum UserTypeEnum {
    ADMINISTRATOR(0),
    KASIR(1);
    
    private final int value;

    private UserTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static UserTypeEnum getByValues(int value){
        for(UserTypeEnum user : values())
            if(user.getValue() == value)
                return user;
                
        return UserTypeEnum.KASIR;
    }
};
