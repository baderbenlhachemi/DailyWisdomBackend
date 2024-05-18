package com.example.dailywisdom.service;

import com.example.dailywisdom.model.Quote;

public interface QuoteService {
    Quote getRandomQuote();
    boolean sendQuoteByEmail(Quote quote, String email);
}

