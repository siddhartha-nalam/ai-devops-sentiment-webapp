package com.example.sentiment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class SentimentService {

    @Autowired
    private RestTemplate restTemplate;

    public String analyzeSentiment(String text) {
        String pythonServiceUrl = "http://localhost:5000/sentiment";
        Map<String, String> request = new HashMap<>();
        request.put("text", text);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                pythonServiceUrl, HttpMethod.POST, entity, Map.class);
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return (String) response.getBody().get("sentiment");
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return "unknown";
    }
}