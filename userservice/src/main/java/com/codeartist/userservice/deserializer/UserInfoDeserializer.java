package com.codeartist.userservice.deserializer;


import com.codeartist.userservice.entity.UserInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.internals.Deserializers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey){}

    @Override
    public UserInfoDto  deserialize(String var1, byte[] var2){
        ObjectMapper objectMapper= new ObjectMapper();
        UserInfoDto user = null;
        try{
            user=objectMapper.readValue(var2,UserInfoDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public void close() {}
}
