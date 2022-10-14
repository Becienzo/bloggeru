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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="COMMENT_ID",nullable = false)
    private Long pageId;

    @Column(name="COMMENT_ARTICLE_REFERENCE")
    private String commentArticleReference;

    @Column(name="COMMENT_TEXT",nullable = false)
    private String commentText;

    @Column(name="COMMENT_CREATION_DATE")
    private LocalDate pageCreationDate;

    @Column(name="COMMENT_USER_CREATION",nullable = false)
    private Integer pageUserCreation;

    @Column(name="COMMENT_STATUS")
    @Builder.Default
    private ContentStatus commentStatus = ContentStatus.VISIBLE;
}
