package com.orlovskiy.rss.service;

import com.orlovskiy.rss.entity.UserEntity;

import java.util.List;


public interface IUserService {

    List<UserEntity> findAll();

    UserEntity findOne(Long id);

    UserEntity findOne(String username);

    UserEntity findOneWithAllBlogs(Long id);

    UserEntity findOneWithAllBlogs(String name);

    void saveUser(UserEntity userEntity);

    void removeUser(Long id);

}
