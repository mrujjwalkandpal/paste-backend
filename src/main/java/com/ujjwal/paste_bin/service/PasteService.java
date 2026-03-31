package com.ujjwal.paste_bin.service;

import org.springframework.stereotype.Service;

import com.ujjwal.paste_bin.model.PasteBin;
import com.ujjwal.paste_bin.repository.PasteRepository;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class PasteService {
    private final PasteRepository pasteRepository;

    public PasteService(PasteRepository pasteRepository){
        this.pasteRepository=pasteRepository;
    }

    public String getId(String content, int expiry){
        if(content==null || content.isBlank()){
            throw new IllegalArgumentException("Content Cannot be Enpty");
        }
        if(content.length()>500000) throw new IllegalArgumentException("Content is too long");

        String id=generateId();

        LocalDateTime expiryTime= LocalDateTime.now().plusMinutes(expiry);

        PasteBin paste = new PasteBin(id,content,expiryTime);

        pasteRepository.save(paste);
        return id;
        
    }

    public String getPasteResponse(String id){
        PasteBin paste = pasteRepository.findById(id);

        if(paste==null) throw new IllegalArgumentException("Paste Not Found");

        if(paste.getExpiry().isBefore(LocalDateTime.now())) throw new IllegalArgumentException("Paste is Expired");
        return paste.getText();
    }

    public String generateId(){
        String id;
        do{
            id=UUID.randomUUID().toString().substring(0,6);
        }
        while(pasteRepository.existsById(id));

        return id;
    }

}
