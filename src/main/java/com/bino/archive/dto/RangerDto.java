package com.bino.archive.dto;


import com.bino.archive.model.Ranger;
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
                .classeurDtos(ranger.getClasseurs()!= null ? ranger.getClasseurs().stream().map(ClasseurDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>())
                .armoireDto(ArmoireDto.fromEntity(ranger.getArmoire()))
                .build();
    }

    public static Ranger toEntity(RangerDto rangerDto){
        Ranger ranger = new Ranger();
        ranger.setId(rangerDto.getId());
        ranger.setNom(rangerDto.getNom());
        ranger.setSlug(rangerDto.getSlug());
        ranger.setClasseurs(rangerDto.getClasseurDtos()!= null ? rangerDto.getClasseurDtos().stream().map(ClasseurDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        ranger.setArmoire(ArmoireDto.toEntity(rangerDto.getArmoireDto()));
        return ranger;
    }
}
