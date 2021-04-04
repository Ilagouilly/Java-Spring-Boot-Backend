package com.ismaillagouilly.backend.service;

import com.ismaillagouilly.backend.model.Message;
import com.ismaillagouilly.backend.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ismail Lagouilly.
 */

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private MessageRepository messageRepository;

    public Message createOrUpdate(Message message) throws Exception
    {
        try
        {
            Message messageSaved = messageRepository.save(message);

            return messageSaved;
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }
}
