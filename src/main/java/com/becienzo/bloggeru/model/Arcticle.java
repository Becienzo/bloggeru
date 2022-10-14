package com.becienzo.bloggeru.model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Arcticle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ARTICLE_ID",nullable = false)
    private Long articleId;

    @Column(name="ARTICLE_NAME")
    private String articleName;

    @Column(name="ARTICLE_PATH")
    private String articlePath;

    @Column(name="ARTICLE_DESC",nullable = false)
    private String userDesc;

    @Column(name="ARTICLE_CREATION_DATE")
    private LocalDate articleCreationDate;

    @Column(name="ARTICLE_USER_CREATION",nullable = false)
    private Integer articleUserCreation;

    @Column(name="ARTICLE_LAST_MODIFIED")
    private LocalDate articleLastModified;

    @Column(name="ARTICLE_STATUS")
    @Builder.Default
    private ContentStatus articleStatus = ContentStatus.NOT_VISIBLE;
}
