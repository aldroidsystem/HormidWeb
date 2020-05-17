package com.aldroid.hormid.service.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.mapper.lapak.UserMapper;
import com.aldroid.hormid.model.lapak.User;

@Service
public class UserService {
	@Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.registerNewUser(user);
        userMapper.registerNewUserRole(user.getUsername(), "ROLE_ADMIN");
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}