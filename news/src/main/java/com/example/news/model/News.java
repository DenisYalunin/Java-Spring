package com.example.news.model;

import java.time.Instant;

public class News {
    private Long id;
    private String title;
    private String text;
    private Instant date;

    public News() {}

    public News(Long id, String title, String text, Instant date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    // getters и setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Instant getDate() { return date; }
    public void setDate(Instant date) { this.date = date; }
}