package com.example.sentiment.repository;

import com.example.sentiment.model.SentimentResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentimentResultRepository extends JpaRepository<SentimentResult, Long> {
}