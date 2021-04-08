package com.ismaillagouilly.backend.repository;

import com.ismaillagouilly.backend.model.AppUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ismail Lagouilly.
 */

import java.util.List;

public interface UserRepository extends CrudRepository<AppUser, Long> {

    List<AppUser> findByLastname(String userLastname);
    AppUser findByUserid(long id);
}
