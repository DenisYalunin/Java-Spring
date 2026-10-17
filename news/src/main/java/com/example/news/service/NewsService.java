package com.example.news.service;

import com.example.news.model.News;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NewsService {

    private final Map<Long, News> newsMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public News getById(Long id) {
        return newsMap.get(id);
    }

    public List<News> getAll() {
        return new ArrayList<>(newsMap.values());
    }

    public News create(News news) {
        Long id = idGenerator.getAndIncrement();
        news.setId(id);
        if (news.getDate() == null) {
            news.setDate(Instant.now());
        }
        newsMap.put(id, news);
        return news;
    }

    public News update(News news) {
        if (!newsMap.containsKey(news.getId())) {
            return null;
        }
        if (news.getDate() == null) {
            news.setDate(Instant.now());
        }
        newsMap.put(news.getId(), news);
        return news;
    }

    public boolean deleteById(Long id) {
        return newsMap.remove(id) != null;
    }
}