package com.aldroid.hormid.generic.staticvar;


public enum EnumRole {
ADMIN ("ROLE_ADMIN"),
PETANI("ROLE_PETANI"),
AGEN("ROLE_AGEN"),
KULI("ROLE_KULI"),
SUPIR("ROLE_SUPIR"),
KASIR("ROLE_KASIR")
;

private final String shortCode;

EnumRole(String code) {
    this.shortCode = code;
}
	  
public String toString() {
    return this.shortCode;
}
}
