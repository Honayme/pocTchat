import { Component } from '@angular/core';
import {ChatComponent} from "./chat/chat.component";

@Component({
  selector: 'app-root',
  template: `
    <app-chat></app-chat>`,
  imports: [
    ChatComponent
  ],
  standalone: true
})
export class AppComponent {}
