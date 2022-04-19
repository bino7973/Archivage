package com.bino.archive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@Table(name = "utilisateur")
@NoArgsConstructor
public class Utilisateur extends AbstractEntity{
    @Column(name = "prenom", nullable = false, updatable = true)
    private String prenom;
    @Column(name = "email", nullable = false, updatable = true, unique = true)
    private String email;
    @Column(name = "numeroTelephone", nullable = false, updatable = true, unique = true)
    private String numeroTelephone;
    @Column(name = "password", nullable = false, updatable = true)
    private String password;
}
