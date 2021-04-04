package com.ismaillagouilly.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Ismail Lagouilly.
 */

@Entity
public class EventUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long eventuserid;

    private Long eventid;

    private Long userid;

    public Long getEventuserid() {
        return eventuserid;
    }

    public void setEventuserid(Long eventuserid) {
        this.eventuserid = eventuserid;
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
