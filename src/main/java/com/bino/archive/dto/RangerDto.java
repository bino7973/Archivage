package com.bino.archive.dto;


import com.bino.archive.model.Armoire;
import com.bino.archive.model.Ranger;
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
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RangerDto {

    private Long id;

    private String nom;

    private String slug;

    private List<ClasseurDto> classeurDtos;

    private ArmoireDto armoireDto;

    public static RangerDto fromEntity(Ranger ranger){
        return RangerDto.builder()
                .id(ranger.getId())
                .nom(ranger.getNom())
                .slug(ranger.getSlug())
                //.classeurDtos(ranger.getClasseurs().size()>0 ? ranger.getClasseurs().stream().map(ClasseurDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>())
                .armoireDto(ArmoireDto.fromEntity(ranger.getArmoire()))
                .build();
    }

    public static Ranger toEntity(RangerDto rangerDto){
        Ranger ranger = new Ranger();
        ranger.setId(rangerDto.getId());
        ranger.setNom(rangerDto.getNom());
        ranger.setSlug(rangerDto.getSlug());
        //ranger.setClasseurs(rangerDto.getClasseurDtos().size()>0 ? rangerDto.getClasseurDtos().stream().map(ClasseurDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        ranger.setArmoire(ArmoireDto.toEntity(rangerDto.getArmoireDto()));
        return ranger;
    }
}
