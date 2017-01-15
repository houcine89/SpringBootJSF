package com.houcine.springboot.view;

import com.houcine.springboot.dto.UserDTO;
import com.houcine.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

}
