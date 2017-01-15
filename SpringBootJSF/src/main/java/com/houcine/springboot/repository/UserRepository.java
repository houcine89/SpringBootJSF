package com.houcine.springboot.repository;

import com.houcine.springboot.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by houcinegasmi on 15/01/2017.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
