package com.achat.achat.dto;

import lombok.Data;

@Data
public class ArticleDTO {
    private Long id;
    private String code_article;
    private String nom_article;
    private String groupe_article;
    private String unite_de_mesure;
    private Boolean maintenir_stock;
    private Double prix_de_vente_standard;
}
