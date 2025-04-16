package com.achat.achat.service;

import com.achat.achat.entity.Article;
import com.achat.achat.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public List<Article> getAll() {
        return repository.findAll();
    }

    public Optional<Article> getById(Long id) {
        return repository.findById(id);
    }

    public Article save(Article article) {
        return repository.save(article);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
