package com.ismaillagouilly.backend.service;

import com.ismaillagouilly.backend.model.Event;
import com.ismaillagouilly.backend.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private EventRepository eventRepository;

    public Event createOrUpdate(Event event) throws Exception
    {
        try
        {
            Event eventSaved = eventRepository.save(event);

            return eventSaved;
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }
}
