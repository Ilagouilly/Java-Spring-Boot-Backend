package com.ismaillagouilly.backend.controller;

import com.ismaillagouilly.backend.model.Event;
import com.ismaillagouilly.backend.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/event")
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public @ResponseBody
    ResponseEntity<Object> createEvent(@RequestBody Event event) {

        try {
            Event response = eventService.createOrUpdate(event);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
