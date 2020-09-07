/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.service.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.generic.process.DatabaseDrivenMessageSource;
import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.mapper.generic.MessageResourceMapper;
import com.aldroid.hormid.model.generic.MessageResource;

/**
 *
 * @author renaldo
 */
@Service
public class MessageResourceService{

    @Autowired
    MessageResourceMapper messageResourceMapper;

    @Autowired
	private GlobalSessionObject globalSessionObject;

    public List<MessageResource> loadAllMessage() {
    	List<MessageResource> listMessage = messageResourceMapper.loadAllMessage();
        return listMessage;
    }
    
    public void updateMessage(MessageResource bean) {
    	messageResourceMapper.updateMessage(bean);
    }
    
    
    private void reloadDatabaseMessages(Object messageSource) {
        //Reload Messages
        if (messageSource instanceof DatabaseDrivenMessageSource) {
            ((DatabaseDrivenMessageSource)messageSource).reload();
        } else if (messageSource instanceof DelegatingMessageSource) {
            DelegatingMessageSource myMessage = ((DelegatingMessageSource)messageSource);
            if (myMessage.getParentMessageSource()!=null && myMessage.getParentMessageSource() instanceof DatabaseDrivenMessageSource) {
                ((DatabaseDrivenMessageSource) myMessage.getParentMessageSource()).reload();
            }
        }
    }
    
}