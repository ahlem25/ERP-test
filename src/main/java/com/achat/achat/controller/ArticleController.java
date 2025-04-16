package com.achat.achat.controller;

import com.achat.achat.dto.ArticleDTO;
import com.achat.achat.entity.Article;
import com.achat.achat.mapper.ArticleMapper;
import com.achat.achat.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin
public class ArticleController {

    private final ArticleService service;
    private final ArticleMapper mapper;

    public ArticleController(ArticleService service, ArticleMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ArticleDTO> getAll() {
        return mapper.toDtoList(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(article -> ResponseEntity.ok(mapper.toDto(article)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> create(@RequestBody ArticleDTO dto) {
        Article saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> update(@PathVariable Long id, @RequestBody ArticleDTO dto) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        dto.setId(id);
        Article updated = service.save(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
