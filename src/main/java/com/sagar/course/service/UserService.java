package com.sagar.course.service;

import com.sagar.course.entity.AppUserEntity;

import java.util.List;

public interface UserService {
    List<AppUserEntity> getAllUsers();

    AppUserEntity createUser(AppUserEntity appUser);

    AppUserEntity getUserById(int userId);

    AppUserEntity updateUser(String userId, AppUserEntity appUserDetails);

    void deleteUser(String userId);
}
