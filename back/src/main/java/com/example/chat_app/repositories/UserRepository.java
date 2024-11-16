package com.example.chat_app.repositories;

import com.example.chat_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Méthodes de gestion des utilisateurs
}
