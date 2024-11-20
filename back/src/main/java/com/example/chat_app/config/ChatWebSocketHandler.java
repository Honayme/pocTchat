package com.example.chat_app.config;

import com.example.chat_app.model.ChatMessage;
import com.example.chat_app.repositories.ChatMessageRepository;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final ChatMessageRepository chatMessageRepository;

    // Utilisation de CopyOnWriteArraySet pour gérer les accès concurrents
    private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

    // Constructor injection pour ChatMessageRepository
    public ChatWebSocketHandler(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("Nouvelle connexion établie : " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("Message reçu : " + payload);

        try {
            // Sauvegarder le message dans MongoDB
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setContent(payload);
            chatMessage.setSender(session.getId()); // Utiliser l'ID de session comme "sender" par défaut
            chatMessage.setTimestamp(LocalDateTime.now());
            chatMessageRepository.save(chatMessage); // Sauvegarde dans MongoDB

            // Diffuser le message à tous les clients connectés
            for (WebSocketSession s : sessions) {
                if (s.isOpen()) {
                    s.sendMessage(new TextMessage(payload));
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la gestion du message : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Supprimer la session de la liste des sessions connectées
        sessions.remove(session);
        System.out.println("Connexion fermée : " + session.getId());
    }

}



