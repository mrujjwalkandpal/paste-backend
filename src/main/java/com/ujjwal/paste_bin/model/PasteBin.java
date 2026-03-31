package com.ujjwal.paste_bin.model;

import java.time.LocalDateTime;

public class PasteBin {
    private String id;
    private String text;
    private LocalDateTime expiry;


    //Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }


    //Getters
    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    //Constructors

    public PasteBin(String id, String text, LocalDateTime expiry) {
        this.id = id;
        this.text = text;
        this.expiry = expiry;
    }

    public PasteBin() {
    }

}
