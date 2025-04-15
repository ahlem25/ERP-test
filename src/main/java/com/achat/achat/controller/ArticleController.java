package com.achat.achat.controller;

import com.achat.achat.entity.Article;
import com.achat.achat.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Article> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Article create(@RequestBody Article article) {
        return service.save(article);
    }

    @PutMapping("/{id}")
    public Article update(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        return service.save(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

