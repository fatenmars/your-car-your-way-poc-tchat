import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client, IMessage } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { Observable, Subject } from 'rxjs';
import { Message } from './message.model';

@Injectable({ providedIn: 'root' })
export class ChatService {
  private client!: Client;
  private messages$ = new Subject<Message>();
  private readonly apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  connect(): void {
    this.client = new Client({
      webSocketFactory: () => new SockJS(`${this.apiUrl}/ws`),
      reconnectDelay: 5000,
      onConnect: () => {
        this.client.subscribe('/topic/messages', (message: IMessage) => {
          this.messages$.next(JSON.parse(message.body));
        });
      },
    });
    this.client.activate();
  }

  onMessage(): Observable<Message> {
    return this.messages$.asObservable();
  }

  send(expediteur: string, contenu: string): void {
    this.client.publish({
      destination: '/app/chat.send',
      body: JSON.stringify({ expediteur, contenu }),
    });
  }

  history(): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.apiUrl}/api/messages`);
  }
}
