package com.sagar.course.service.impl;

import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.entity.dto.LoginResponse;
import com.sagar.course.exception.AccessRestrictedException;
import com.sagar.course.exception.RecordNotFoundException;
import com.sagar.course.service.LoginService;
import com.sagar.course.service.UserService;
import com.sagar.course.util.ApplicationRoles;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserService userService;

    @Value("${jwt.secret.privateKey}")
    private String secretKey;

    public static final String BEARER = "Bearer ";

    /**
     * @param userName
     * @return
     */
    public LoginResponse getAccessToken(String userName) {
        String token = getToken(userName);
        LoginResponse accessResponse = new LoginResponse();
        accessResponse.setUserName(userName);
        accessResponse.setAccessToken(token);
        return accessResponse;
    }

    /**
     * @param username
     * @return
     */
    private String getToken(String username) {
        List<GrantedAuthority> grantedAuthorities = getGrants(username);

        String token = Jwts
                .builder()
                .setId("Jwts")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1800000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return String.join("", BEARER, token);
    }

    /**
     * @param username
     * @return
     */
    private List<GrantedAuthority> getGrants(String username) {
        AppUserEntity userEntity = userService.getUserById(Integer.parseInt(username));
        if (userEntity == null) {
            throw new RecordNotFoundException(AppUserEntity.class.getSimpleName());
        }
        return AuthorityUtils
                .commaSeparatedStringToAuthorityList(userEntity.getUserRole());
    }

    /**
     * @param appUserEntity
     * @return
     */
    public AppUserEntity register(AppUserEntity appUserEntity) {
        if (!ApplicationRoles.SYSTEM_ADMIN.getApplicationRoles().equalsIgnoreCase(appUserEntity.getUserRole())) {
            throw new AccessRestrictedException(appUserEntity.getUserRole());
        }
        return userService.createUser(appUserEntity);
    }
}
