package com.ujjwal.paste_bin.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ujjwal.paste_bin.dto.CreatePasteRequest;
import com.ujjwal.paste_bin.dto.CreatePasteResponse;
import com.ujjwal.paste_bin.dto.GetPasteResponse;
import com.ujjwal.paste_bin.service.PasteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;





@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://paste-frontend-chi.vercel.app"
})
@RestController
@RequestMapping("/api/pastes")
public class PasteApiController{
    // This creates APIs that are called by Front end tech like React JS using fetch or axios methods.. this is not for the viewer or browser to access at any point

    private final PasteService pasteService;
    public PasteApiController(PasteService pastService){
        this.pasteService=pastService;
    }

    @PostMapping
    public CreatePasteResponse createPaste(@RequestBody CreatePasteRequest entity) {
        String content = entity.getContent();
        int expiry=entity.getExpiryMinutes();

        String id=pasteService.getId(content,expiry);
        

        return new CreatePasteResponse(id, "/p/"+id);
    }

    @GetMapping("/")
public String home() {
    return "Backend is running";
}

    @GetMapping("/{id}")
    public GetPasteResponse getPaste(@PathVariable String id){
        String content= pasteService.getPasteResponse(id);
        return new GetPasteResponse(content);
    }
    
}
