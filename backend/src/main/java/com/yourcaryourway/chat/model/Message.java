package com.yourcaryourway.chat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String expediteur;
    private String contenu;
    private Instant dateEnvoi;

    public Message() {
    }

    public Message(String expediteur, String contenu, Instant dateEnvoi) {
        this.expediteur = expediteur;
        this.contenu = contenu;
        this.dateEnvoi = dateEnvoi;
    }

    public Long getId() {
        return id;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Instant getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Instant dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
}