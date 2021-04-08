package com.ismaillagouilly.backend.controller;

import com.ismaillagouilly.backend.model.AppUser;
import com.ismaillagouilly.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ismail Lagouilly.
 */

@RestController
@RequestMapping("api/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public @ResponseBody
    ResponseEntity<Object> createUser(@RequestBody AppUser user) {

        try {
            AppUser response = userService.createOrUpdate(user);
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
    @PostMapping("/delete/{userId}")
    public @ResponseBody
    ResponseEntity<Object> deleteUser(@PathVariable(name = "userId", required = true) Long userId) {

        try {
            userService.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/update/{userId}")
    public @ResponseBody
    ResponseEntity<Object> updateUser(@PathVariable(name = "userId", required = true) Long userId,  @RequestBody AppUser user) {

        try {
            AppUser refuser = userService.findByUserid(userId);
            user.setUserid(refuser.getUserid());
            AppUser response = userService.createOrUpdate(user);
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
            AppUser response = userService.findByUserid(userId);
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
    @GetMapping("/getByLastname/{userLastname}")
    public @ResponseBody
    ResponseEntity<Object> getByName(@PathVariable(name = "userLastname", required = true) String userLastname) {

        try {
            List<AppUser> response = userService.findByName(userLastname);
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
    @GetMapping("/all")
    public @ResponseBody
    ResponseEntity<Object> getAll() {

        try {
            List<AppUser> response = userService.findAll();
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
