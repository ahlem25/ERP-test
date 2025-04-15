package com.achat.achat.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    private String code_article;
    private String nom_article;
    private String groupe_article;
    private String unite_de_mesure;
    private Boolean maintenir_stock;
    private Double prix_de_vente_standard;


}
