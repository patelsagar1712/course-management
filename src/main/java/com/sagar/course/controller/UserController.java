package com.sagar.course.controller;

import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Secured({"SYSTEM_ADMIN"})
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * @return
     */
    @GetMapping(path = "/appUser", headers = HttpHeaders.AUTHORIZATION)
    public List<AppUserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * @param appUser
     * @return
     */
    @PostMapping(path = "/appUser", headers = HttpHeaders.AUTHORIZATION)
    public AppUserEntity createUser(@RequestBody AppUserEntity appUser) {
        return userService.createUser(appUser);
    }

    /**
     * @param userId
     * @return
     */
    @GetMapping(path = "/appUser/{userId}", headers = HttpHeaders.AUTHORIZATION)
    public ResponseEntity<AppUserEntity> getUserById(@PathVariable String userId) {
        AppUserEntity appUser = userService.getUserById(Integer.parseInt(userId));
        return ResponseEntity.ok(appUser);
    }

    /**
     * @param userId
     * @param appUserDetails
     * @return
     */
    @PutMapping(path = "/appUser/{userId}", headers = HttpHeaders.AUTHORIZATION)
    public ResponseEntity<AppUserEntity> updateUser(@PathVariable String userId, @RequestBody AppUserEntity appUserDetails) {
        AppUserEntity appUser = userService.updateUser(userId, appUserDetails);
        return ResponseEntity.ok(appUser);
    }

    /**
     * @param userId
     * @return
     */
    @DeleteMapping(path = "/appUser/{userId}", headers = HttpHeaders.AUTHORIZATION)
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
