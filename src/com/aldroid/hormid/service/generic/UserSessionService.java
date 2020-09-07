package com.aldroid.hormid.service.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.mapper.generic.UserMapper;

@Service
public class UserSessionService {
	@Autowired
    private UserMapper userMapper;

	
	
}