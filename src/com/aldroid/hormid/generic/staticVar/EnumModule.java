package com.aldroid.hormid.generic.staticvar;

public enum EnumModule {
	PIUTANG ("PG"),
	TIMBANG_GANTUNG("TG"),
	TIMBANG_JEMBATAN("TJ")
	;

	private final String shortCode;

	EnumModule(String code) {
	    this.shortCode = code;
	}
		  
	public String toString() {
	    return this.shortCode;
	}
}
