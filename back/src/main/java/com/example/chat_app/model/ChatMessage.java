package com.example.chat_app.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

import java.time.LocalDateTime;


@Data // Génère getters, setters, equals, hashCode, toString
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Document(collection = "messages")
public class ChatMessage {
    @Id
    private String id;
    private String content;
    private String sender;
    private LocalDateTime timestamp;
}
