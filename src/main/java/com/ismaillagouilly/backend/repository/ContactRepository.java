package com.ismaillagouilly.backend.repository;

import com.ismaillagouilly.backend.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
