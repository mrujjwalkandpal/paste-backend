package com.ujjwal.paste_bin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujjwal.paste_bin.dto.GetPasteResponse;
import com.ujjwal.paste_bin.service.PasteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PasteViewControlller {
    private final PasteService pasteService;
    public PasteViewControlller(PasteService pastService){
        this.pasteService=pastService;
    }

    @GetMapping("/")
    public String home() {
        return "Backend is running";
    }
    @GetMapping("/p/{id}")
    public GetPasteResponse viewPaste(@PathVariable String id) {
        String content= pasteService.getPasteResponse(id);
        return new GetPasteResponse(content);
    }
    
}
