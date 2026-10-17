package com.example.news.controller;

import com.example.news.model.News;
import com.example.news.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // GET /api/news/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        News news = newsService.getById(id);
        if (news == null) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Новость с ID " + id + " не найдена.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.ok(news);
    }

    // GET /api/news
    @GetMapping
    public ResponseEntity<List<News>> getAll() {
        return ResponseEntity.ok(newsService.getAll());
    }

    // POST /api/news
    @PostMapping
    public ResponseEntity<News> create(@RequestBody News news) {
        News created = newsService.create(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT /api/news
    @PutMapping
    public ResponseEntity<?> update(@RequestBody News news) {
        News updated = newsService.update(news);
        if (updated == null) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Новость с ID " + news.getId() + " не найдена.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/news/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        boolean deleted = newsService.deleteById(id);
        if (!deleted) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Новость с ID " + id + " не найдена.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.noContent().build(); // 204
    }
}