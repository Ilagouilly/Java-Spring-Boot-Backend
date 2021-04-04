package com.ismaillagouilly.backend.service;

import com.ismaillagouilly.backend.model.EventUser;
import com.ismaillagouilly.backend.repository.EventUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventUserService {
    private static final Logger logger = LoggerFactory.getLogger(EventUserService.class);

    @Autowired
    private EventUserRepository eventUserRepository;

    public EventUser createOrUpdate(EventUser eventUser) throws Exception {
        try {
            EventUser eventUserSaved = eventUserRepository.save(eventUser);

            return eventUserSaved;
        } catch (Exception e) {
            logger.error("Exception occured Cause {} Message {} exception {}", e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }
}
