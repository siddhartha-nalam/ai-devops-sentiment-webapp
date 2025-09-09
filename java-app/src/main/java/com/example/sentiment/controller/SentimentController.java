package com.example.sentiment.controller;

import com.example.sentiment.service.SentimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SentimentController {

    @Autowired
    private SentimentService sentimentService;

    @GetMapping("/sentiment")
    public String home() {
        return "home";
    }

    @PostMapping("/analyze")
    public String analyze(@RequestParam("text") String text, Model model) {
        String sentiment = sentimentService.analyzeSentiment(text);
        model.addAttribute("sentiment", sentiment);
        model.addAttribute("text", text);
        return "home";
    }
}