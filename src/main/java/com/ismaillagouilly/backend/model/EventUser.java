package com.ismaillagouilly.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long eventuserid;

    private Long eventit;

    private Long userid;

    public Long getEventuserid() {
        return eventuserid;
    }

    public void setEventuserid(Long eventuserid) {
        this.eventuserid = eventuserid;
    }

    public Long getEventit() {
        return eventit;
    }

    public void setEventit(Long eventit) {
        this.eventit = eventit;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
