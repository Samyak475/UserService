package com.codeartist.userservice.controller;

import com.codeartist.userservice.entity.UserInfo;
import com.codeartist.userservice.entity.UserInfoDto;
import com.codeartist.userservice.services.UserService;
import lombok.Getter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    ResponseEntity<UserInfoDto> saveOrUpdateUser(@RequestBody UserInfoDto userInfoDto){
        try {
            UserInfoDto user = userService.saveEventIntoDb(userInfoDto);
            return new ResponseEntity(HttpStatus.CREATED).ok().body(user);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getUser")
    ResponseEntity<UserInfoDto> getUser(@RequestBody UserInfoDto userInfoDto){
        try{
           return new ResponseEntity<>(HttpStatus.FOUND).ok().body(userService.getUser(userInfoDto) );
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
