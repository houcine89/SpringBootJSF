package com.houcine.springboot.service;

import com.houcine.springboot.dto.UserDTO;
import com.houcine.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houcinegasmi on 15/01/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(new UserDTO(user)));
        return users;
    }
}
