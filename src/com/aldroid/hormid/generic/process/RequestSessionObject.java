package com.aldroid.hormid.generic.process;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aldroid.hormid.model.generic.User;

@Component
@Scope("session")
public class RequestSessionObject {

	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
