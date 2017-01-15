package com.houcine.springboot.dto;

import com.houcine.springboot.model.User;
import com.houcine.springboot.model.UserRole;

import java.io.Serializable;
import java.util.stream.Collectors;

/**
 * Created by houcinegasmi on 15/01/2017.
 */
public class UserDTO implements Serializable {

    private String username;
    private String roles;

    public UserDTO(User user) {
        this.username = user.getUsername();

        StringBuilder builder = new StringBuilder();
        this.roles = user.getRoles().stream().map(UserRole::getRole).collect(Collectors.joining(","));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
