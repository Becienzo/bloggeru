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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="USER_ID",nullable = false)
    private Long userId;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="USER_EMAIL",nullable = false)
    private String userEmail;

    @Column(name="USER_LAST_ACCESS")
    private Long userLastAccess;

    @Column(name="USER_REGISTRATION_DATE",nullable = false)
    private LocalDate userRegistrationDate;

    @Column(name="USER_STATUS")
    @Builder.Default
    private ContentStatus status = ContentStatus.NOT_APPROVED;

}
