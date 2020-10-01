package com.aldroid.hormid.generic.process;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class CommonProcess {

	private static final Logger logger = Logger.getLogger("activityLogger");
	
	

	
	public static void logUserActivity(String className,String method, String servletPath){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
	         
	 		logger.info(
	 				"class:"+className
	 				+",sessionId:"+((WebAuthenticationDetails)authentication.getDetails()).getSessionId()
	 				+",user:"+authentication.getName()
	 				+ ",method:"+method
	 				+ ",RequestMapping:"+servletPath); 
		} else {
	 		logger.info(
	 				"class:"+className
	 				+",sessionId:,user:"
	 				+ ",method:"+method
	 				+ ",RequestMapping:"+servletPath); 
		}
	}
	
	public static void logException(Exception e, Class kelas){
		StringWriter stack = new StringWriter();
		e.printStackTrace(new PrintWriter(stack));
		Logger.getLogger(kelas).error(stack.toString());
	}
	
	public static void validationRejectIfEmptyOrWhitespace(BindingResult bindingResult, String field,
			String errorCode, Object[] errorArgs, String defaultMessage) {
		Assert.notNull(bindingResult, "Errors object must not be null");
		Object value = bindingResult.getFieldValue(field);
		if ((value == null) || (!(StringUtils.hasText(value.toString()))))
			validationRejectValue(bindingResult,field, errorCode, errorArgs, defaultMessage);
	}
	
	
	public static void validationRejectValue(BindingResult bindingResult,String field, String errorCode, Object[] errorArgs,
			String defaultMessage) {
		if (("".equals(bindingResult.getNestedPath())) && (!(StringUtils.hasLength(field)))) {
			bindingResult.reject(errorCode, errorArgs, defaultMessage);
			return;
		}
		String fixedField = fixedField(bindingResult,field);
		Object newVal = bindingResult.getFieldValue(fixedField);

		FieldError fe = new FieldError(bindingResult.getObjectName(), fixedField, newVal,
				false, new String[]{errorCode}, errorArgs,
				defaultMessage);
		bindingResult.addError(fe);
	}
	
	private static String fixedField(BindingResult bindingResult,String field) {
		if (StringUtils.hasLength(field)) {
			return new StringBuilder().append(bindingResult.getNestedPath())
					.append(field).toString();
		}

		String path = bindingResult.getNestedPath();

		return ((path.endsWith(".")) ? path.substring(0,
				path.length() - ".".length()) : path);
	}
	
    
    public static String generateToken() {
    	StringBuilder token = new StringBuilder();

    	return token.append(UUID.randomUUID().toString())
    			.append(UUID.randomUUID().toString()).toString();
    }
    
}
