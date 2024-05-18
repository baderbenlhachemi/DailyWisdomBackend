package com.example.dailywisdom.service;

public interface EmailService {
    void sendQuoteByEmail(String quoteContent, String email);
}