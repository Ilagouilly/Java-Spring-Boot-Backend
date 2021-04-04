package com.ismaillagouilly.backend.repository;

import com.ismaillagouilly.backend.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ismail Lagouilly.
 */

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastname(String userLastname);
    User findByUserid(long id);
}
