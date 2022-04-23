package com.bino.archive.dto;

import com.bino.archive.model.Armoire;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArmoireDto {

    private Long id;

    private String nom;

    private String slug;

    private String couleur;

    private List<RangerDto> rangerDtos;

    public static ArmoireDto fromEntity(Armoire armoire){
        return ArmoireDto.builder()
                .id(armoire.getId())
                .nom(armoire.getNom())
                .slug(armoire.getSlug())
                .couleur(armoire.getCouleur())
                //.rangerDtos(armoire.getRangers().size()>0 ? armoire.getRangers().stream().map(RangerDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>())
                .build();
    }

    public static Armoire toEntity(ArmoireDto armoireDto){
        Armoire armoire = new Armoire();
        armoire.setId(armoireDto.getId());
        armoire.setNom(armoireDto.getNom());
        armoire.setSlug(armoireDto.getSlug());
        armoire.setCouleur(armoireDto.getCouleur());
        //armoire.setRangers(armoireDto.getRangerDtos().size()>0 ? armoireDto.getRangerDtos().stream().map(RangerDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        return armoire;
    }
}
