package com.aldroid.hormid.service.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.aldroid.hormid.mapper.lapak.UserMapper;
import com.aldroid.hormid.model.lapak.User;

@Service
public class UserService {
	@Autowired
    private UserMapper userMapper;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(userMapper.findAll()));
//        userMapper.save(user);
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}