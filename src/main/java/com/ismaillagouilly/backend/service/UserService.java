package com.ismaillagouilly.backend.service;

import com.ismaillagouilly.backend.model.User;
import com.ismaillagouilly.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Ismail Lagouilly.
 */

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User createOrUpdate(User user) throws Exception
    {
        try
        {
            User userSaved = userRepository.save(user);

            return userSaved;
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }

    public void deleteById(Long userid) throws Exception
    {
        try
        {
            userRepository.deleteById(userid);
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }

    public User findByUserid(Long userId) throws Exception
    {
        try
        {

            Optional<User> userOptional = userRepository.findById(userId);
            if(userOptional.isPresent())
                return userOptional.get();
            else
                throw new Exception("The resource you were trying to reach is not found");
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }

    public List<User> findByName(String userLastname) throws Exception
    {
        try
        {

            List<User> userList = userRepository.findByLastname(userLastname);
            if(!Objects.isNull(userList))
                return userList;
            else
                throw new Exception("The resource you were trying to reach is not found");
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }

    public List<User> findAll() throws Exception
    {
        try
        {

            List<User> userList = (List<User>) userRepository.findAll();
            if(!Objects.isNull(userList))
                return userList;
            else
                throw new Exception("The resource you were trying to reach is not found");
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }
}
