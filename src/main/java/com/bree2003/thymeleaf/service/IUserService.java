package com.bree2003.thymeleaf.service;

import com.bree2003.thymeleaf.entity.UserEntity;

import java.util.Optional;

public interface IUserService {

    void createUser(UserEntity user);
    Optional<UserEntity> getUserById(Long id);
    Optional<UserEntity> getUserByUsername(String username);
}
