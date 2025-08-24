package com.codeartist.userservice.consumer;

import com.codeartist.userservice.entity.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class AuthServiceConsumer {
    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}" ,topics = "${spring.kafka.topic-json.name}")
    public void listner(UserInfoDto  userInfoDto){
        try {
            System.out.println("Printing user info dto as coming from auth service"+userInfoDto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
