package com.bino.archive.validateur;

import com.bino.archive.dto.DocumentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DocumentValidateur {

    public static List<String> validate(DocumentDto documentDto){
        List<String> errors = new ArrayList<>();
        if(documentDto == null){
            errors.addAll(
                    List.of("Le slug du document ne doit être vide !","Le nom du document ne doit pas être vide !",
                    "Le type de document ne doit pas être vide !","Le nombre de page du document ne doit pas être vide !",
                    "Le contenu du document ne doit pas être vide !","Le classeur à laquelle le document appartient ne doit pas être vide !")
            );
        }
        if(!StringUtils.hasLength(documentDto.getSlug())){
            errors.add("Le slug du document ne doit être vide !");
        }
        if(!StringUtils.hasLength(documentDto.getNom())){
            errors.add("Le nom du document ne doit être vide !");
        }
        if(!StringUtils.hasLength(documentDto.getType().toString())){
            errors.add("Le type de document ne doit pas être vide !");
        }
        if(!StringUtils.hasLength(documentDto.getNombrePage()+"")){
            errors.add("Le nombre de page du document ne doit pas être vide !");
        }
        if(!StringUtils.hasLength(documentDto.getContenu())){
            errors.add("Le contenu du document ne doit pas être vide !");
        }

        errors.addAll(ClasseurValidateur.validate(documentDto.getClasseurDto()));
        return errors;
    }
}
