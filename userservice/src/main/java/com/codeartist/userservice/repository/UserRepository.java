package com.codeartist.userservice.repository;

import com.codeartist.userservice.entity.UserInfoDto;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfoDto,String> {
    UserInfoDto findByUserId(String userId);
}
