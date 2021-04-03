package com.ismaillagouilly.backend.repository;

import com.ismaillagouilly.backend.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
