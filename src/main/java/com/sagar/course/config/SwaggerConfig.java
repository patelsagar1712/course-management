package com.sagar.course.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("emeritus")
                .packagesToScan("com.emeritus.course.controller")
                .build();
    }
}
