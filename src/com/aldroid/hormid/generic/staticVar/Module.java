package com.aldroid.hormid.generic.staticvar;

public enum Module {
	PIUTANG ("PG"),
	TIMBANG_GANTUNG("TG"),
	TIMBANG_JEMBATAN("TJ")
	;

	private final String shortCode;

	Module(String code) {
	    this.shortCode = code;
	}
		  
	public String toString() {
	    return this.shortCode;
	}
}
