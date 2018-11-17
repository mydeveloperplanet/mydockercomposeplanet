package com.mydeveloperplanet.mydockercomposeplanet.domain;

import java.util.Date;

/**
 * A POJO representing an event which occurs on a Show object
 */
public class ShowEvent {
    private String id;
    private Date date;

    public ShowEvent() {
        super();
    }

    public ShowEvent(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
