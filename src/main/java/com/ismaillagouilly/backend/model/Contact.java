package com.ismaillagouilly.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Ismail Lagouilly.
 */

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long contactid;

    private Long usersenderid;

    private Long userreceiverid;

    private String status;

    public Long getContactid() {
        return contactid;
    }

    public void setContactid(Long contactid) {
        this.contactid = contactid;
    }

    public Long getUsersenderid() {
        return usersenderid;
    }

    public void setUsersenderid(Long usersenderid) {
        this.usersenderid = usersenderid;
    }

    public Long getUserreceiverid() {
        return userreceiverid;
    }

    public void setUserreceiverid(Long userreceiverid) {
        this.userreceiverid = userreceiverid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
