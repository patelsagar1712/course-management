package com.sagar.course.util;

public enum ApplicationRoles {
    SYSTEM_ADMIN("SYSTEM_ADMIN"),
    STUDENT("STUDENT"),
    INSTRUCTOR("INSTRUCTOR");
    String role;

    ApplicationRoles(String role) {
        this.role = role;
    }

    public String getApplicationRoles() {
        return this.role;
    }
}
