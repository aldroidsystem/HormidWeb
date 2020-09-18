package com.aldroid.hormid.service.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.generic.process.CommonProcess;
import com.aldroid.hormid.mapper.generic.UserMapper;
import com.aldroid.hormid.model.generic.Role;
import com.aldroid.hormid.model.generic.User;

@Service
public class UserService {
	@Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void registerUser(User user) {
    	String createdBy = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    	user.setCreatedBy(createdBy);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setToken(CommonProcess.generateToken());
        userMapper.registerNewUser(user);
        for(String role : user.getRoles()){
            userMapper.insertUserRole(user.getUsername(), role);
        	
        }
    }


    public void resetPassword(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.resetPassword(user);
    }
    
    public void updateUser(User user) {
    	String createdBy = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    	user.setCreatedBy(createdBy);
        userMapper.updateUser(user);
        updateUserRole(user);
    }

    public void updateProfile(User user) {
        userMapper.updateProfile(user);
    }
    
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public List<User> searchUser(String nameSearch) {
        return userMapper.searchUser(nameSearch);
    }

    public List<Role> selectAllRole() {
        return userMapper.selectAllRole();
    }
    
    
    public void upsert(User user)throws Exception{
    	if(user.getAction().equalsIgnoreCase("c")){
    		registerUser(user);
    	} else if(user.getAction().equalsIgnoreCase("u")){
    		updateUser(user);
    	} else {
    		throw new Exception("userForm action code not found (update or insert)");
    	}
    }
    
    
    public void updateUserRole(User user){
    	List<String> dbRoles = userMapper.loadUserRole(user.getUsername());
    	
    	for(String dbRoleSingle : dbRoles){
    		boolean exists=false;
    		for(String updateRoleSingle : user.getRoles()){
    			if(dbRoleSingle.equals(updateRoleSingle)){
    				user.getRoles().remove(dbRoleSingle);
    				exists=true;
    				break;
    			}
    		}
    		if(!exists){
    			userMapper.deleteUserRole(user.getUsername(), dbRoleSingle);
    		}
    	}
    	
		for(String updateRoleSingle : user.getRoles()){
			userMapper.insertUserRole(user.getUsername(), updateRoleSingle);
		}
    }
    

    
    public Integer checkDuplicateUsername(String username){
    	return userMapper.checkDuplicateUsername(username);    	
    }
}