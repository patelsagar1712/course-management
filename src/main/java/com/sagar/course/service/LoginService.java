package com.sagar.course.service;

import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.entity.dto.LoginResponse;

public interface LoginService {

    LoginResponse getAccessToken(String userName);

    AppUserEntity register(AppUserEntity emeritusUser);
}
