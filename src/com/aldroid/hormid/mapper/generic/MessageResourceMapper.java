package com.aldroid.hormid.mapper.generic;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aldroid.hormid.generic.staticvar.MessageResourceQueryList;
import com.aldroid.hormid.model.generic.MessageResource;

public interface MessageResourceMapper {


    @Select(MessageResourceQueryList.SELECT_ALL_MESSAGE)
    abstract List<MessageResource> loadAllMessage();
    
    @Update(MessageResourceQueryList.UPDATE_MESSAGE)
    abstract void updateMessage(MessageResource bean);
}
