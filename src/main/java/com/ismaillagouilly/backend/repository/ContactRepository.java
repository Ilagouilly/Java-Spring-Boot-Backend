package com.ismaillagouilly.backend.repository;

import com.ismaillagouilly.backend.model.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ismail Lagouilly.
 */

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
