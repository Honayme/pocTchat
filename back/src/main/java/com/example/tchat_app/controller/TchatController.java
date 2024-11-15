package com.example.tchat_app.controller;

import com.example.tchat_app.model.TchatMessage;
import com.example.tchat_app.services.TchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class TchatController {

    @Autowired
    private TchatService chatService;

    @PostMapping("/sendMessage")
    public TchatMessage sendMessage(@RequestBody TchatMessage message) {
        return chatService.saveMessage(message);
    }

    @GetMapping("/messages")
    public List<TchatMessage> getAllMessages() {
        return chatService.findAllMessages();
    }
}
