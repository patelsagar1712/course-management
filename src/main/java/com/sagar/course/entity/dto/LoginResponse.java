package com.sagar.course.entity.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String userName;
    private String accessToken;
}
