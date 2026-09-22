import { Component, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ChatService } from './chat.service';
import { Message } from './message.model';

@Component({
  selector: 'app-chat',
  imports: [FormsModule],
  templateUrl: './chat.html',
  styleUrl: './chat.css',
})
export class Chat implements OnInit {
  messages = signal<Message[]>([]);
  expediteur = '';
  contenu = '';

  constructor(private chatService: ChatService) {}

  ngOnInit(): void {
    this.chatService.history().subscribe((history) => this.messages.set(history));
    this.chatService.connect();
    this.chatService.onMessage().subscribe((message) =>
      this.messages.update((list) => [...list, message]),
    );
  }

  envoyer(): void {
    if (!this.expediteur.trim() || !this.contenu.trim()) {
      return;
    }
    this.chatService.send(this.expediteur, this.contenu);
    this.contenu = '';
  }
}
