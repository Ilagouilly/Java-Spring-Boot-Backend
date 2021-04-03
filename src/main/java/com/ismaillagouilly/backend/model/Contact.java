package com.ismaillagouilly.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long contactid;

    private Long usersenderid;

    private Long userreceiverid;

    private String status;


}
