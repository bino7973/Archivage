package com.bino.archive.dto;

import com.bino.archive.model.Classeur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClasseurDto {

    private Long id;

    private String nom;

    private String slug;

    private String couleur;

    private RangerDto rangerDto;

    private List<DocumentDto> documentDtos;

    public static ClasseurDto fromEntity(Classeur classeur){

        return ClasseurDto.builder()
                .id(classeur.getId())
                .nom(classeur.getNom())
                .slug(classeur.getSlug())
                .couleur(classeur.getCouleur())
                .rangerDto(RangerDto.fromEntity(classeur.getRanger()))
                .documentDtos(classeur.getDocuments() != null ? classeur.getDocuments().stream().map(DocumentDto::fromEntity).collect(Collectors.toList()): new ArrayList<>())
                .build();
    }

    public static Classeur toEntity(ClasseurDto classeurDto){
        Classeur classeur = new Classeur();
        classeur.setId(classeurDto.getId());
        classeur.setNom(classeurDto.getNom());
        classeur.setSlug(classeurDto.getSlug());
        classeur.setCouleur(classeurDto.getCouleur());
        classeur.setRanger(RangerDto.toEntity(classeurDto.getRangerDto()));
        classeur.setDocuments(classeurDto.getDocumentDtos()!= null ? classeurDto.getDocumentDtos().stream().map(DocumentDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        return classeur;
    }
}
