package com.bino.archive.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ranger")
public class Ranger extends AbstractEntity{

    @OneToMany(mappedBy = "ranger")
    @JsonIgnore
    private List<Classeur> classeurs;

    @ManyToOne
    @JoinColumn(name = "idArmoire")
    private Armoire armoire;
}
