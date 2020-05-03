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
public enum StatusTimbangEnum {
   TIMBANG_PERTAMA(0),
   TIMBANG_KEDUA(1),
   CEK_DICAIRKAN(3);
    
    private int status=0;

    private StatusTimbangEnum(int type) {
    this.status=type;
    } 
}
