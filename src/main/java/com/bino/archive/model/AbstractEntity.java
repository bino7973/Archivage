package com.bino.archive.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false, updatable = true)
    private String nom;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @CreatedDate
    @Column(name = "dateCreation", updatable = false)
    @JsonIgnore
    private LocalDateTime dateCreation;

    @LastModifiedDate
    @Column(name = "dateModification", updatable = true)
    @JsonIgnore
    private LocalDateTime dateModification;

    public AbstractEntity(Long id, String nom, String slug, LocalDateTime dateCreation, LocalDateTime dateModification) {
        this.id = id;
        this.nom = nom;
        this.slug = slug;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }
}
