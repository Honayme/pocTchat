/*
package com.example.chat_app.controller;

import com.example.chat_app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    // Injecte le SimpMessagingTemplate pour envoyer des messages programmatiquement si besoin
    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

*/
/**
     * Cette méthode reçoit les messages envoyés par les clients sur la destination
     * "/app/chat.sendMessage". Elle diffuse ensuite ces messages à tous les abonnés
     * de "/topic/public".
     *
     * @param message Le message envoyé par le client
     * @return Le message à diffuser*//*



    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) {
        // Logique d'ajout éventuel : validation ou modification du message
        System.out.println("Message reçu : " + message.getContent());
        return message; // Diffuse le message tel quel à tous les abonnés
    }

*/
/**
     * Méthode utilitaire pour envoyer un message programmatique à un client spécifique ou à un groupe.
     *
     * @param destination La destination STOMP (par exemple "/topic/public")
     * @param message     Le message à envoyer*//*



    public void broadcastMessage(String destination, ChatMessage message) {
        messagingTemplate.convertAndSend(destination, message);
    }
}
*/
