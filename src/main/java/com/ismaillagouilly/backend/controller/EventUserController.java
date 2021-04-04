package com.ismaillagouilly.backend.controller;

import com.ismaillagouilly.backend.model.EventUser;
import com.ismaillagouilly.backend.service.EventUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/eventuser")
public class EventUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventUserController.class);

    @Autowired
    private EventUserService eventUserService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public @ResponseBody
    ResponseEntity<Object> createContact(@RequestBody EventUser eventUser) {

        try {
            EventUser response = eventUserService.createOrUpdate(eventUser);
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
