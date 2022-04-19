package com.bino.archive.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "armoire")
public class Armoire extends AbstractEntity{

    @Column(name = "couleur", nullable = true, updatable = true)
    private String couleur;

    @JsonIgnore
    @OneToMany(mappedBy = "armoire")
    private List<Ranger> rangers;

    public Armoire(String couleur) {
        this.couleur = couleur;
    }

    public Armoire(Long id, String nom, String slug, LocalDateTime dateCreation, LocalDateTime dateModification, String couleur) {
        super(id, nom, slug, dateCreation, dateModification);
        this.couleur = couleur;
    }
}
