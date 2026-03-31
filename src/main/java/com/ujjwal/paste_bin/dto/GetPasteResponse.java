package com.ujjwal.paste_bin.dto;

public class GetPasteResponse {
    private String content;

    public String getContent() {
        return content;
    }


    public GetPasteResponse() {
    }

    public GetPasteResponse(String content) {
        this.content = content;
    }
}
