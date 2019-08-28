package com.example.myapplication;

import java.util.Date;

public class Event {
    private String formateur_linkedin_url;
    private String username ;
    private Date event_date ;
    private int price ;

    public Event() {
    }

    public Event(String formateur_linkedin_url, String username, Date event_date, int price, Date deadline_to_applay) {
        this.formateur_linkedin_url = formateur_linkedin_url;
        this.username = username;
        this.event_date = event_date;
        this.price = price;
        this.deadline_to_applay = deadline_to_applay;
    }

    public void setFormateur_linkedin_url(String formateur_linkedin_url) {
        this.formateur_linkedin_url = formateur_linkedin_url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDeadline_to_applay(Date deadline_to_applay) {
        this.deadline_to_applay = deadline_to_applay;
    }

    public String getFormateur_linkedin_url() {
        return formateur_linkedin_url;
    }

    public String getUsername() {
        return username;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public int getPrice() {
        return price;
    }

    public Date getDeadline_to_applay() {
        return deadline_to_applay;
    }

    private Date deadline_to_applay;
}
