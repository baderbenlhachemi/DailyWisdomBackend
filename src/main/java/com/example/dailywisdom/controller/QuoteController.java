package com.example.dailywisdom.controller;

import com.example.dailywisdom.model.Quote;
import com.example.dailywisdom.service.QuoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/random")
    public ResponseEntity<Quote> getRandomQuote() {
        Quote quote = quoteService.getRandomQuote();
        return ResponseEntity.ok(quote);
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<Map<String, String>> sendQuoteByEmail(@RequestBody Map<String, Object> payload) {
        // Extract the quote and email from the payload
        Quote quote = new ObjectMapper().convertValue(payload.get("quote"), Quote.class);
        String email = (String) payload.get("email");

        boolean emailSent = quoteService.sendQuoteByEmail(quote, email);
        if (emailSent) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email sent successfully!");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Failed to send email."));
        }
    }

}
