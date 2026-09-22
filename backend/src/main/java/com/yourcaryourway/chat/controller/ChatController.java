package com.yourcaryourway.chat.controller;

import com.yourcaryourway.chat.dto.ChatMessagePayload;
import com.yourcaryourway.chat.model.Message;
import com.yourcaryourway.chat.repository.MessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.time.Instant;

@Controller
public class ChatController {

    private final MessageRepository messageRepository;

    public ChatController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/messages")
    public Message send(ChatMessagePayload payload) {
        Message message = new Message(payload.expediteur(), payload.contenu(), Instant.now());
        return messageRepository.save(message);
    }
}