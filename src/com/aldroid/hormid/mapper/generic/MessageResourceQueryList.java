package com.aldroid.hormid.mapper.generic;



public final class MessageResourceQueryList {

    public static final String SELECT_ALL_MESSAGE = "select * from tb_message_resource";
    
    public static final String UPDATE_MESSAGE = "update tb_message_resource set "
    		+ "message_id=#{message_id},"
    		+ "message_en=#{message_en} "
    		+ "where resource_key=#{resource_key}";
}