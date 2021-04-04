package com.ismaillagouilly.backend.controller;

import com.ismaillagouilly.backend.model.Contact;
import com.ismaillagouilly.backend.service.ContactService;
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
@RequestMapping("api/contact")
public class ContactController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public @ResponseBody
    ResponseEntity<Object> createContact(@RequestParam(name = "usersenderid", required = true) Long usersenderid,
                                         @RequestParam(name = "userreceiverid", required = true) Long userreceiverid,
                                         @RequestParam(name = "status", required = true) String status) {

        try {
            Contact contact = new Contact();
            contact.setUsersenderid(usersenderid);
            contact.setUserreceiverid(userreceiverid);
            contact.setStatus(status);

            Contact response = contactService.createOrUpdate(contact);
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
