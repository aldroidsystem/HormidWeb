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
public enum RelationTypeEnum {
    CORPORATE(0),
    SUPPLIER(1),
    COLLECTOR(2),
    SUPPLIER_COLLECTOR(3);
    
     private final int value;

    private RelationTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static RelationTypeEnum getByValues(int value){
        for(RelationTypeEnum relation : values())
            if(relation.getValue() == value)
                return relation;
                
        return RelationTypeEnum.CORPORATE;
    }
}