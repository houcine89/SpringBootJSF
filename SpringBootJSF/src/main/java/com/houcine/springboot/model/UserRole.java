package com.houcine.springboot.model;

import javax.persistence.*;

/**
 * Created by houcinegasmi on 15/01/2017.
 */
@Entity(name = "user_roles")
public class UserRole {
    @Id
    @Column(name = "user_role_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
