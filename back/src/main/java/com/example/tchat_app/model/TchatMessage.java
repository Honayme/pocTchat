package com.example.tchat_app.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import lombok.Data;

@Document(collection = "messages")
public class TchatMessage {
    @Id
    private String id;
    private String content;
    private String sender;
    private LocalDateTime timestamp;

    // Getters et setters
}
