package com.codeartist.userservice.repository;

import com.codeartist.userservice.entity.UserInfo;
import com.codeartist.userservice.entity.UserInfoDto;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends CrudRepository<UserInfo,String> {
  Optional <UserInfo> findByUserId(String userId);
}
