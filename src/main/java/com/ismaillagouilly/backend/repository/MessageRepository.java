package com.ismaillagouilly.backend.repository;

import com.ismaillagouilly.backend.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
