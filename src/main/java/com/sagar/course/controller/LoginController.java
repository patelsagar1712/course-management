package com.sagar.course.controller;

import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.entity.dto.LoginRequest;
import com.sagar.course.entity.dto.LoginResponse;
import com.sagar.course.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.getAccessToken(loginRequest.getUserName());
        if (loginResponse == null) {
            return new ResponseEntity<>("User not exists", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody @Validated AppUserEntity appUserEntity) {
        AppUserEntity savedEmeritusUser = loginService.register(appUserEntity);
        return new ResponseEntity<>(savedEmeritusUser, HttpStatus.CREATED);
    }
}
