import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

interface ChatMessage {
  sender: string;
  content: string;
  timestamp: string;
}

@Injectable({
  providedIn: 'root',
})
export class ChatService {
  private socket!: WebSocket;
  private messagesSubject = new BehaviorSubject<ChatMessage[]>([]);
  public messages$ = this.messagesSubject.asObservable();

  constructor() {
    this.connect();
  }

  private connect(): void {
    // Connexion au serveur WebSocket
    this.socket = new WebSocket('/ws');

    // Événements de connexion
    this.socket.onopen = () => {
      console.log('Connecté au WebSocket');
    };

    // Événements de réception de messages
    this.socket.onmessage = (event) => {
      const messages = [...this.messagesSubject.value];
      const messageData: ChatMessage = JSON.parse(event.data);
      messages.push(messageData);
      this.messagesSubject.next(messages);
    };

    // Gestion des erreurs
    this.socket.onerror = (error) => {
      console.error('Erreur WebSocket :', error);
    };

    // Gestion de la fermeture de connexion
    this.socket.onclose = () => {
      console.warn('Connexion WebSocket fermée');
    };
  }

  // Envoyer un message au serveur
  sendMessage(content: string): void {
    if (this.socket && this.socket.readyState === WebSocket.OPEN) {
      const messageData: ChatMessage = {
        sender: 'Utilisateur', // Vous pouvez remplacer par le nom de l'utilisateur
        content: content,
        timestamp: new Date().toISOString(),
      };
      this.socket.send(JSON.stringify(messageData));
    } else {
      console.error('La connexion WebSocket n’est pas ouverte.');
    }
  }
}
