package com.ismaillagouilly.backend.service;

import com.ismaillagouilly.backend.model.Contact;
import com.ismaillagouilly.backend.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private static final Logger logger = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private ContactRepository contactRepository;

    public Contact createOrUpdate(Contact contact) throws Exception {
        try {
            Contact contactSaved = contactRepository.save(contact);

            return contactSaved;
        } catch (Exception e) {
            logger.error("Exception occured Cause {} Message {} exception {}", e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }

    }
}
