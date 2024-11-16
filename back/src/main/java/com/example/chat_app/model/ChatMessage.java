package com.example.chat_app.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Document(collection = "messages")
public class ChatMessage {
    @Id
    private String id;
    private String content;
    private String sender;
    private LocalDateTime timestamp;

    public String getContent() {
        return "";
    }


}
