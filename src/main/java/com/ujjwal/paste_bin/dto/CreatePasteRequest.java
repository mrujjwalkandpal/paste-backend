package com.ujjwal.paste_bin.dto;

public class CreatePasteRequest {
    private String content;
    private int expiryMinutes;

    public String getContent() {
        return content;
    }
    public int getExpiryMinutes() {
        return expiryMinutes;
    }
}
