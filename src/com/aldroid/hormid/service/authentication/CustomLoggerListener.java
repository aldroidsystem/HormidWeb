package com.aldroid.hormid.service.authentication;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import com.aldroid.hormid.service.generic.LoginService;


public class CustomLoggerListener implements ApplicationListener<ApplicationEvent>{
    
    private static Logger logger = Logger.getLogger(CustomLoggerListener.class);

    @Autowired
    private LoginService loginService;
    
    @Override
    public void onApplicationEvent(ApplicationEvent e) {
        
        
        if ( e instanceof AuthenticationCredentialsNotFoundEvent ) {
            logger.info( "AuthenticationCredentialsNotFoundEvent: " + e );
        }
        else if ( e instanceof AuthorizationFailureEvent ) {
            AuthorizationFailureEvent a = (AuthorizationFailureEvent)e;
            logger.info( "AUTH-FAIL [" + a.getSource() + "]");
        }
        else if ( e instanceof PublicInvocationEvent ) {
            logger.trace( "PublicInvocationEvent: " + e );
        }  
        else if ( e instanceof AuthenticationFailureBadCredentialsEvent ) {
            AuthenticationFailureBadCredentialsEvent f = (AuthenticationFailureBadCredentialsEvent)e;
            Authentication a = f.getAuthentication();
            logger.info( "AUTH-FAIL BAD-CREDENTIALS [" + f.getSource() + "]" );
            if (a.getPrincipal()!= null && a.getPrincipal() instanceof String) {
            	try {
                	loginService.userLoginFailed(a.getPrincipal().toString());
				} catch (Exception ex) {
		    		StringWriter stack = new StringWriter();
		    		ex.printStackTrace(new PrintWriter(stack));
		    		logger.error(stack.toString());
				}
            }
        }
        else if ( e instanceof AuthenticationSuccessEvent ) {
            AuthenticationSuccessEvent s = (AuthenticationSuccessEvent)e;
            Authentication a = s.getAuthentication();
            logger.info( "AUTH-SUCCESS [" + a + "]");
            if (a.getPrincipal()!= null && a.getPrincipal() instanceof User) {
            	loginService.userLoginSucceeded(((User)a.getPrincipal()).getUsername());
//            	try {
//					String bb = loginService.getCurrentUrl();
//				} catch (MalformedURLException | URISyntaxException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
            }
            
        }
        else if ( e instanceof ServletRequestHandledEvent ) {
            ServletRequestHandledEvent r = (ServletRequestHandledEvent)e;
            logger.trace( "request[ USR=" + r.getUserName() +", "+r.getMethod() +", URL="+r.getRequestUrl() + ", client="+r.getClientAddress() + "]" );
        }
        
        else {
            logger.trace( "evento ricevuto: " + e.getClass().getCanonicalName() );
            logger.trace( "event: "+e );
        }
        
    }
    
}