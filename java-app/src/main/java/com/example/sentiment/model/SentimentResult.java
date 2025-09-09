package com.example.sentiment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SentimentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String sentiment;
    private LocalDateTime analyzedAt;

    // Constructors
    public SentimentResult() {}

    public SentimentResult(String text, String sentiment, LocalDateTime analyzedAt) {
        this.text = text;
        this.sentiment = sentiment;
        this.analyzedAt = analyzedAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getSentiment() { return sentiment; }
    public void setSentiment(String sentiment) { this.sentiment = sentiment; }
    public LocalDateTime getAnalyzedAt() { return analyzedAt; }
    public void setAnalyzedAt(LocalDateTime analyzedAt) { this.analyzedAt = analyzedAt; }
}