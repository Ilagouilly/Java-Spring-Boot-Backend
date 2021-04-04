package com.ismaillagouilly.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Ismail Lagouilly.
 */

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long messageid;

    private String message;

    private Long usersenderid;

    private Long userreceiverid;

    private Date time;

    public Long getMessageid() {
        return messageid;
    }

    public void setMessageid(Long messageid) {
        this.messageid = messageid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
