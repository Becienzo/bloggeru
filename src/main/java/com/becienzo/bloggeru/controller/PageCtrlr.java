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

import com.becienzo.bloggeru.model.Page;

import com.becienzo.bloggeru.service.PageServ;

public class PageCtrlr {
    private static final Logger logger = LogManager.getLogger(UserCtrlr.class);

    @Autowired
    private PageServ pageService;

    @GetMapping("/pages")
    public ResponseEntity<Iterable<Page>> getAllPages() {
        try {
            return ResponseEntity.ok()
                    .location((new URI("/pages")))
                    .body(pageService.findAll());
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/pages/{pageId}")
    public ResponseEntity<?> getPage(@PathVariable Long userId) throws Exception {
        return pageService.findById(userId)
                .map(page -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .location(new URI("/pages/" + page.getPageId()))
                                .body(page);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/pages")
    public ResponseEntity<?> createPage(@RequestBody Page page) {
        logger.info("New page: pageName: " + page.getPageName());
        logger.info("New page: Email: " + page.getPageDesc());
        Page newpage = pageService.save(page);
        try {
            return ResponseEntity
                    .created(new URI("/pages/" + newpage.getPageId()))
                    .body(newpage);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
