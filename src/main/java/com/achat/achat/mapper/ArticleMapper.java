package com.achat.achat.mapper;

import com.achat.achat.dto.ArticleDTO;
import com.achat.achat.entity.Article;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleDTO toDto(Article article); // Convertit DTO → Entité

    Article toEntity(ArticleDTO articleDTO); // Convertit Entité → DTO

    List<ArticleDTO> toDtoList(List<Article> articles); // Liste Entités

}
