package com.ismaillagouilly.backend.controller;

import com.ismaillagouilly.backend.model.Message;
import com.ismaillagouilly.backend.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ismail Lagouilly.
 */

@RestController
@RequestMapping("api/message")
public class MessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public @ResponseBody
    ResponseEntity<Object> createEvent(@RequestBody Message message) {

        try {
            Message response = messageService.createOrUpdate(message);
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
