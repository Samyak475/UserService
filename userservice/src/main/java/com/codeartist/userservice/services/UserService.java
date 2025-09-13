package com.codeartist.userservice.services;

import com.codeartist.userservice.entity.UserInfo;
import com.codeartist.userservice.entity.UserInfoDto;
import com.codeartist.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserInfoDto saveEventIntoDb(UserInfoDto userInfoDto){
        Function<UserInfo,UserInfo> updateUser =(user)->{
            return userRepository.save(userInfoDto.fetchUserInfo());
        };
        Supplier<UserInfo> saveUser = ()->{
            return userRepository.save(userInfoDto.fetchUserInfo());
        };

        UserInfo userInfo = userRepository.findByUserId(userInfoDto.getUserId())
                .map(updateUser)
                .orElseGet(saveUser);
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNo(),
                userInfo.getEmail()
        );
    }

    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception{
        Optional<UserInfo> userInfoOptional = userRepository.findByUserId(userInfoDto.getUserId());
        if(userInfoOptional.isEmpty()) throw  new Exception();
        UserInfo userInfo = userInfoOptional.get();
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNo(),
                userInfo.getEmail()
        );
    }
}
