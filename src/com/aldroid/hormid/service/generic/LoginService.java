package com.aldroid.hormid.service.generic;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.mapper.generic.LoginMapper;
import com.aldroid.hormid.model.generic.User;

@Service
public class LoginService {
	
	@Autowired
    private LoginMapper loginMapper;

    @Autowired
	private GlobalSessionObject globalSessionObject;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired 
    private HttpServletRequest request;
    
    public User loginByUsername(String username){
    	return loginMapper.loginByUsername(username);
    }
    
  
    public void userLoginSucceeded(String username) {
    	loginMapper.userLoginSucceeded(username);
    }
 
    public void userLoginFailed(String username) throws Exception {
    	loginMapper.userLoginFailed(username, globalSessionObject.getPropertiesByCode("maxLoginAttempt").getAngka());
    }

    

    public String generateURL() {
    	String abc = request.getContextPath();
    	String def =request.getPathInfo();
    	String ghi = request.getRequestURL().toString();
    	
    	
    	return abc+","+def+","+ghi;
    }
    
    public String getCurrentUrl() throws MalformedURLException, URISyntaxException{
        URL url = new URL(request.getRequestURL().toString());
        String host  = url.getHost();
        String userInfo = url.getUserInfo();
        String scheme = url.getProtocol();
        int port = url.getPort();
        String path = (String)request.getAttribute("javax.servlet.forward.request_uri");
        String query = (String)request.getAttribute("javax.servlet.forward.query_string");

        URI uri = new URI(scheme,userInfo,host,port,path,query,null);
   	
    	return uri.toString()+ request.getContextPath()+"/reset-password?token=";
    }
}