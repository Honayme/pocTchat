import { Component } from '@angular/core';
import { ChatService } from '../chat.service';
import {FormsModule} from "@angular/forms";
import {DatePipe, NgForOf} from "@angular/common";

interface ChatMessage {
  sender: string;
  content: string;
  timestamp: string;
}

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    DatePipe
  ],
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent {
  messages: ChatMessage[] = [];
  newMessage: string = '';

  constructor(private chatService: ChatService) {
    // S'abonner aux messages du service
    this.chatService.messages$.subscribe((msgs) => {
      this.messages = msgs;
    });
  }

  sendMessage() {
    if (this.newMessage.trim()) {
      this.chatService.sendMessage(this.newMessage.trim());
      this.newMessage = '';
    }
  }
}
