package com.yourcaryourway.chat.controller;

import com.yourcaryourway.chat.model.Message;
import com.yourcaryourway.chat.repository.MessageRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageRestController {

    private final MessageRepository messageRepository;

    public MessageRestController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public List<Message> history() {
        return messageRepository.findAllByOrderByDateEnvoiAsc();
    }
}