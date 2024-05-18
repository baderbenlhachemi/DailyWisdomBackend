package com.example.dailywisdom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

    private String content;
    private String author;

    @Override
    public String toString() {
        return "Quote{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
