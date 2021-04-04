package com.ismaillagouilly.backend.repository;

import com.ismaillagouilly.backend.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ismail Lagouilly.
 */

public interface MessageRepository extends CrudRepository<Message, Long> {
}
