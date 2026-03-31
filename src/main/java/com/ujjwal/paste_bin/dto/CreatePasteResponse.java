package com.ujjwal.paste_bin.dto;

public class CreatePasteResponse {
    private String id;
    private String url;
    public String getId() {
        return id;
    }
    public String getUrl() {
        return url;
    }
    public CreatePasteResponse(String id, String url) {
        this.id = id;
        this.url = url;
    }
    


}
