package com.codeartist.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.aspectj.apache.bcel.classfile.Unknown;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@Getter
@Setter
public class UserInfoDto {

    @JsonProperty("user_id")
    public String userId;
    @JsonProperty("first_name")
    public String firstName;
    @JsonProperty("last_name")
    public String lastName;
    @JsonProperty( "email")
    public String email;
    @JsonProperty("phone_no")
    public String phoneNo;

    public UserInfo fetchUserInfo(){
        return UserInfo.builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNo(phoneNo)
                .email(email).build();
    }
}
