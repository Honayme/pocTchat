package com.example.chat_app.repositories;

import com.example.chat_app.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    // Méthodes de gestion des messages de chat
}