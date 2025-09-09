package com.example.sentiment.controller;

import com.example.sentiment.model.SentimentResult;
import com.example.sentiment.repository.SentimentResultRepository;
import com.example.sentiment.service.SentimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class SentimentController {

    @Autowired
    private SentimentService sentimentService;

    @Autowired
    private SentimentResultRepository resultRepository;

    @GetMapping("/sentiment")
    public String home(Model model) {
        List<SentimentResult> history = resultRepository.findAll();
        model.addAttribute("history", history);
        return "home";
    }

    @PostMapping("/analyze")
    public String analyze(@RequestParam("text") String text, Model model) {
        String sentiment = sentimentService.analyzeSentiment(text);
        SentimentResult result = new SentimentResult(text, sentiment, LocalDateTime.now());
        resultRepository.save(result);

        List<SentimentResult> history = resultRepository.findAll();
        model.addAttribute("sentiment", sentiment);
        model.addAttribute("text", text);
        model.addAttribute("history", history);
        return "home";
    }
}