package com.example.news.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(nullable = false)
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public News() {}

    public News(Long id, String title, String text, Instant date, Category category) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.category = category;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Instant getDate() { return date; }
    public void setDate(Instant date) { this.date = date; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}