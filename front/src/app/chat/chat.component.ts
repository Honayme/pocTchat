import { Component } from '@angular/core';
import { ChatService } from '../chat.service';
import {FormsModule} from "@angular/forms";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf
  ],
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent {
  newMessage = '';
  messages: string[] = [];

  constructor(private chatService: ChatService) {
    // S'abonner aux messages pour la mise à jour en temps réel
    this.chatService.messages$.subscribe((messages) => {
      this.messages = messages;
    });
  }

  sendMessage(): void {
    if (this.newMessage.trim()) {
      this.chatService.sendMessage(this.newMessage);
      this.newMessage = ''; // Réinitialiser le champ de saisie
    }
  }
}
