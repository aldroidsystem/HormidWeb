package com.aldroid.hormid.service.authentication;

import com.aldroid.hormid.service.generic.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private LoginService loginService;
    
//    @Autowired
//    private LoginAttemptService loginAttemptService;
    
//    @Autowired
//    private HttpServletRequest request;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	String ip = getClientIP();
//        if (loginAttemptService.isBlocked(ip)) {
//            throw new RuntimeException("blocked");
//        }
        
    	com.aldroid.hormid.model.generic.User user = loginService.loginByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user == null) {
        	throw new RuntimeException("userNotFound");
        } else if(user.getBooleanFlagActive() == false){
        	throw new RuntimeException("inactive");        	
        } else if (user.getBooleanFlagLocked()){
        	throw new RuntimeException("locked");       
        } 
        
        for (String role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
//        		user.getBooleanFlagActive(), !user.getBooleanFlagPasswordExpired(), true, !user.getBooleanFlagLocked(),
//        		grantedAuthorities);
        
        
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
//	private String getClientIP() {
////		using the X-Forwarded-For header to get to the original IP
//	    String xfHeader = request.getHeader("X-Forwarded-For");
//	    if (xfHeader == null){
//	        return request.getRemoteAddr();
//	    }
//	    return xfHeader.split(",")[0];
//	}
}