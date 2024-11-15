package com.example.tchat_app.repositories;

import com.example.tchat_app.model.TchatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TchatMessageRepository extends MongoRepository<TchatMessage, String> {
    // Méthodes de gestion des messages de chat
}