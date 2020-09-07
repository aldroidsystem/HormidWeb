package com.aldroid.hormid.model.generic;

public class MessageResource {


	private String resource_key;
	private String locale;
    private String message;
    

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getResource_key() {
		return resource_key;
	}
	
	public void setResource_key(String resource_Key) {
		this.resource_key = resource_Key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
