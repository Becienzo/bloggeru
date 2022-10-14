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
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="PAGE_ID",nullable = false)
    private Long pageId;

    @Column(name="PAGE_NAME")
    private String pageName;

    @Column(name="PAGE_DESC",nullable = false)
    private String pageDesc;

    @Column(name="PAGE_CREATION_DATE")
    private LocalDate pageCreationDate;

    @Column(name="PAGE_USER_CREATION",nullable = false)
    private Integer pageUserCreation;

    @Column(name="PAGE_LAST_MODIFIED")
    private LocalDate pageLastModified;

    @Column(name="PAGE_STATUS")
    @Builder.Default
    private ContentStatus pageStatus = ContentStatus.VISIBLE;
}
