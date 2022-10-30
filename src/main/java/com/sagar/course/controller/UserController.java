package com.sagar.course.controller;

import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Secured({"SYSTEM_ADMIN"})
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(headers = HttpHeaders.AUTHORIZATION)
    @Secured({"SYSTEM_ADMIN"})
    public Iterable<AppUserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{userName}", headers = HttpHeaders.AUTHORIZATION)
    @Secured({"SYSTEM_ADMIN"})
    public ResponseEntity<?> getUser(@Validated @PathVariable("userName") String userName) {
        AppUserEntity appUserEntity = userService.getUserById(Integer.parseInt(userName));
        return new ResponseEntity<>(appUserEntity, HttpStatus.OK);
    }

    @GetMapping(path = "/role/{role}", headers = HttpHeaders.AUTHORIZATION)
    @Secured({"SYSTEM_ADMIN"})
    public Iterable<AppUserEntity> getAllUsers(@Validated @PathVariable("role") String role) {
        return userService.getAllUsers(role);
    }

    @PostMapping(headers = HttpHeaders.AUTHORIZATION)
    @Secured({"SYSTEM_ADMIN"})
    public ResponseEntity<?> saveUser(@RequestBody AppUserEntity AppUserEntity) {
        AppUserEntity userServiceUser = userService.createUser(AppUserEntity);
        return new ResponseEntity<>(userServiceUser, HttpStatus.CREATED);
    }

    @Secured({"SYSTEM_ADMIN"})
    @DeleteMapping(path = "/{userName}", headers = HttpHeaders.AUTHORIZATION)
    public void deleteUser(@Validated @PathVariable("userName") String userName) {
        userService.deleteUser(userName);
    }

    @Secured({"SYSTEM_ADMIN"})
    @PutMapping(path = "/{userName}", headers = HttpHeaders.AUTHORIZATION)
    public ResponseEntity<?> updateUser(@PathVariable("userName") String userName, @Validated @RequestBody AppUserEntity AppUserEntity) {
        AppUserEntity appUserEntity = userService.updateUser(userName, AppUserEntity);
        return new ResponseEntity<>(appUserEntity, HttpStatus.OK);
    }

}
