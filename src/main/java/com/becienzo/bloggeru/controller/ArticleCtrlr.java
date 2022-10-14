package com.becienzo.bloggeru.controller;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.becienzo.bloggeru.model.Arcticle;

import com.becienzo.bloggeru.service.ArticleServ;

public class ArticleCtrlr {
    private static final Logger logger = LogManager.getLogger(UserCtrlr.class);

    @Autowired
    private ArticleServ articleService;

    @GetMapping("/articles")
    public ResponseEntity<Iterable<Arcticle>> getAllArticles() {
        try {
            return ResponseEntity.ok()
                    .location((new URI("/articles")))
                    .body(articleService.findAll());
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/articles/{articleId}")
    public ResponseEntity<?> getArticle(@PathVariable Long articleId) throws Exception {
        return articleService.findById(articleId)
                .map(article -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .location(new URI("/articles/" + article.getArticleId()))
                                .body(article);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/articles")
    public ResponseEntity<?> createArticle(@RequestBody Arcticle article) {
        logger.info("New article: articleName: " + article.getArticleName());
        logger.info("New article: Email: " + article.getArticlePath());
        Arcticle newarticle = articleService.save(article);
            try {
                return ResponseEntity
                        .created(new URI("/orders/" + newarticle.getArticleId()))
                        .body(newarticle);
            } catch (URISyntaxException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
      

    }
}
