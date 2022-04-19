package com.bino.archive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Classeur")
public class Classeur extends AbstractEntity{

    @Column(name = "couleur", updatable = false, nullable = true)
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "idRanger")
    private Ranger ranger;

    @OneToMany(mappedBy = "classeur")
    private List<Document> documents;
}
