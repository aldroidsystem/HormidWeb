package com.aldroid.hormid.service.authentication;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import com.aldroid.hormid.generic.process.DatabaseDrivenMessageSource;

@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger logger = Logger.getLogger(CustomAuthenticationFailureHandler.class);
    @Autowired @Qualifier("messageSource")
    private DatabaseDrivenMessageSource messageSource;
	

    @Autowired @Qualifier("localeResolver")
    private SessionLocaleResolver localeResolver;
    
    
 
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		setDefaultFailureUrl("/login?error=true");

		super.onAuthenticationFailure(request, response, exception);

        final Locale locale = localeResolver.resolveLocale(request);

        String errorMessage = messageSource.getMessage("message.login.badCredentials", null, locale);

        if(exception != null && exception.getMessage() != null) {
    		logger.info(exception.getMessage());
            if (exception.getMessage().equalsIgnoreCase("userNotFound")) {
                errorMessage = messageSource.getMessage("message.login.userNotFound", null, locale);
            } else if (exception.getMessage().equalsIgnoreCase("inactive")) {
                errorMessage = messageSource.getMessage("message.login.inactive", null, locale);
            } else if (exception.getMessage().equalsIgnoreCase("locked")) {
                errorMessage = messageSource.getMessage("message.login.locked", null, locale);
            }         	
        }

        request.getSession()
            .setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
	}
    
}