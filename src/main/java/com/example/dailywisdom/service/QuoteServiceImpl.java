package com.example.dailywisdom.service;

import com.example.dailywisdom.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final JavaMailSender javaMailSender;
    private final RestTemplate restTemplate;
    private final String quotableApiBaseUrl;

    @Autowired
    public QuoteServiceImpl(JavaMailSender javaMailSender, RestTemplate restTemplate,
                            @Value("${quotable.api.base-url}") String quotableApiBaseUrl) {
        this.javaMailSender = javaMailSender;
        this.restTemplate = restTemplate;
        this.quotableApiBaseUrl = quotableApiBaseUrl;
    }

    @Override
    public boolean sendQuoteByEmail(Quote quote, String email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Quote of the Day");
            message.setText(quote.getContent() + " - " + quote.getAuthor());

            javaMailSender.send(message);
            return true; // Email sent successfully
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Failed to send email
        }
    }

    @Override
    public Quote getRandomQuote() {
        String url = quotableApiBaseUrl + "/random";
        ResponseEntity<Quote> responseEntity = restTemplate.getForEntity(url, Quote.class);
        return responseEntity.getBody();
    }
}
