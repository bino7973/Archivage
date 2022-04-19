package com.bino.archive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document")
public class Document extends AbstractEntity{

    @Column(name = "type", nullable = false, updatable = true)
    private Type type;

    @Column(name = "nombrePage", nullable = false, updatable = true)
    private BigInteger nombrePage;

    @Column(name = "description", nullable = true, updatable = true)
    private String description;

    @Column(name = "contenu")
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "idClasseur")
    private Classeur classeur;

}
