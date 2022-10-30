package com.sagar.course.service.impl;


import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.exception.RecordNotFoundException;
import com.sagar.course.repository.AppUserRepository;
import com.sagar.course.service.UserService;
import com.sagar.course.util.ApplicationRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final static String ERROR_USER_NOT_FOUND = "User not Found with userID ";

    @Autowired
    private final AppUserRepository appUserRepository;

    public UserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    /**
     * @return
     */
    @Override
    public List<AppUserEntity> getAllUsers() {
        return appUserRepository.findByIsActiveTrue();
    }

    /**
     *
     */
    public Iterable<AppUserEntity> getAllUsers(String role) {
        String finalRole = role;
        Optional<ApplicationRoles> optionalRoles = Arrays.stream(ApplicationRoles.values()).filter(roles -> roles.getApplicationRoles().equalsIgnoreCase(finalRole)).findFirst();
        if (optionalRoles.isPresent()) {
            return appUserRepository.findAllByUserRole(optionalRoles.get().getApplicationRoles());
        }
        throw new RecordNotFoundException(AppUserEntity.class.getSimpleName());
    }

    /**
     * @param appUser
     * @return
     */
    @Override
    public AppUserEntity createUser(AppUserEntity appUser) {
        appUser.setIsActive(Boolean.TRUE);
        return appUserRepository.save(appUser);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public AppUserEntity getUserById(int userId) {
        return appUserRepository.findById(userId)
                .orElseThrow(() -> new RecordNotFoundException(ERROR_USER_NOT_FOUND + userId));
    }

    /**
     * @param userId
     * @param appUserDetails
     * @return
     */
    @Override
    public AppUserEntity updateUser(String userId, AppUserEntity appUserDetails) {
        getUserById(Integer.parseInt(userId));
        return appUserRepository.save(appUserDetails);
    }

    /**
     * @param userId
     */
    @Override
    public void deleteUser(String userId) {
        AppUserEntity appUserEntity = getUserById(Integer.parseInt(userId));
        appUserEntity.setIsActive(Boolean.FALSE);
        appUserRepository.save(appUserEntity);
    }
}
