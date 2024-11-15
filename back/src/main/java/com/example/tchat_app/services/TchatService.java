package com.example.tchat_app.services;

import com.example.tchat_app.model.TchatMessage;
import com.example.tchat_app.repositories.TchatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TchatService {
    @Autowired
    private TchatMessageRepository tchatMessageRepository;

    public TchatMessage saveMessage(TchatMessage message) {
        return tchatMessageRepository.save(message);
    }

    public List<TchatMessage> findAllMessages() {
        return tchatMessageRepository.findAll();
    }

    // Autres méthodes pour la gestion des messages de chat
}
