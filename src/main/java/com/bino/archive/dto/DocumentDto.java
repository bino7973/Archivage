package com.bino.archive.dto;

import com.bino.archive.model.Document;
import com.bino.archive.model.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {

    private Long id;

    private String nom;

    private String slug;

    private Type type;

    private BigInteger nombrePage;

    private String description;

    private String contenu;

    private ClasseurDto classeurDto;

    public static DocumentDto fromEntity(Document document){
        return DocumentDto.builder()
                .id(document.getId())
                .nom(document.getNom())
                .slug(document.getSlug())
                .type(document.getType())
                .nombrePage(document.getNombrePage())
                .description(document.getDescription())
                .contenu(document.getContenu())
                .classeurDto(ClasseurDto.fromEntity(document.getClasseur()))
                .build();
    }

    public static Document toEntity(DocumentDto documentDto){
        Document document = new Document();
        document.setId(documentDto.getId());
        document.setNom(documentDto.getNom());
        document.setSlug(documentDto.getSlug());
        document.setType(documentDto.getType());
        document.setNombrePage(documentDto.getNombrePage());
        document.setDescription(documentDto.getDescription());
        document.setContenu(documentDto.getContenu());
        document.setClasseur(ClasseurDto.toEntity(documentDto.getClasseurDto()));
        return document;
    }

}
