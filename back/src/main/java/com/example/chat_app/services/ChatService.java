package com.example.chat_app.services;

import com.example.chat_app.model.ChatMessage;
import com.example.chat_app.repositories.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> findAllMessages() {
        return chatMessageRepository.findAll();
    }

    // Autres méthodes pour la gestion des messages de chat
}
