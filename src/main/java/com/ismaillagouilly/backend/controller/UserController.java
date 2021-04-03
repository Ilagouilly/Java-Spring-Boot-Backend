package com.ismaillagouilly.backend.controller;

import com.ismaillagouilly.backend.model.User;
import com.ismaillagouilly.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public @ResponseBody
    ResponseEntity<Object> createUser(@RequestBody User user) {

        try {
            User response = userService.create(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{userId}")
    public @ResponseBody
    ResponseEntity<Object> getById(@PathVariable(name = "userId", required = true) Long userId) {

        try {
            User response = userService.findById(userId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/extended/{userLastname}")
    public @ResponseBody
    ResponseEntity<Object> getByName(@PathVariable(name = "userLastname", required = true) String userLastname) {

        try {
            List<User> response = userService.findByName(userLastname);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public @ResponseBody
    ResponseEntity<Object> getAll() {

        try {
            List<User> response = userService.findAll();
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
