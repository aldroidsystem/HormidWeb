package com.aldroid.hormid.generic.process;

import com.aldroid.hormid.generic.staticvar.HardcodeConfiguration;
import com.aldroid.hormid.model.generic.MessageResource;
import com.aldroid.hormid.service.generic.MessageResourceService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DatabaseDrivenMessageSource extends AbstractMessageSource implements ResourceLoaderAware {

    private Logger logger = Logger.getLogger(getClass());
    
    private ResourceLoader resourceLoader;
    

    private final Map<String,Map<String,String>> properties = new HashMap<>();

    @Autowired
    private MessageResourceService messageResourceService;

    public DatabaseDrivenMessageSource() {
        reload();
    }

    public DatabaseDrivenMessageSource(MessageResourceService messageResourceService) {
        this.messageResourceService = messageResourceService;
        reload();
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String msg = getText(code, locale);
        MessageFormat result = createMessageFormat(msg, locale);
        return result;
    }

    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        return getText(code, locale);
    }

    private String getText(String code, Locale locale) {
        Map<String, String> localized = properties.get(code);
        String textForCurrentLanguage = null;
        if (localized != null) {
            textForCurrentLanguage = localized.get(locale.getLanguage());
            if (textForCurrentLanguage == null) {
                textForCurrentLanguage = localized.get(HardcodeConfiguration.INDONESIA.getLanguage());
            }
        }
        if (textForCurrentLanguage==null) {
            //Check parent message
            logger.debug("Fallback to properties message");
            try {
                textForCurrentLanguage = getParentMessageSource().getMessage(code, null, locale);
            } catch (Exception e) {
                logger.error("Cannot find message with code: " + code);
            }
        }
        return textForCurrentLanguage != null ? textForCurrentLanguage : code;
    }

    public void reload() {
        properties.clear();
        properties.putAll(loadTexts());
    }

    protected Map<String, Map<String, String>> loadTexts() {
        logger.info("load all message properties");
        Map<String, Map<String, String>> m = new HashMap<String, Map<String, String>>();
        List<MessageResource> texts = messageResourceService.loadAllMessage();
        for (MessageResource text : texts) {
            Map<String, String> v = new HashMap<String, String>();
            v.put(text.getLocale(), text.getMessage());
            m.put(text.getResource_key(), v);
        }
        return m;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = (resourceLoader != null ? resourceLoader : new DefaultResourceLoader());
    }
}