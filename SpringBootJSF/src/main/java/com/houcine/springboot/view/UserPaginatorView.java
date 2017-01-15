package com.houcine.springboot.view;

import com.houcine.springboot.dto.UserDTO;
import com.houcine.springboot.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by houcinegasmi on 15/01/2017.
 */
@ManagedBean(name="userPaginatorView")
@Component
@ViewScoped
public class UserPaginatorView {

    @Autowired
    private UserService userService;

    private String username;

    private String password;

    public void save() {
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            userService.createUser(username, password);
            RequestContext.getCurrentInstance().reset("form:panel");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
        }

    }

    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
