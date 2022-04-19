package com.bino.archive.validateur;

import com.bino.archive.dto.ClasseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClasseurValidateur {

    public static List<String> validate(ClasseurDto classeurDto){
        List<String> errors = new ArrayList<>();
        if(classeurDto==null){
            errors.addAll(List.of("Le slug du classeur ne doit être vide !","Le nom du classeur ne doit pas être vide !","Le ranger du classeur ne doit pas être vide !"));
        }
        if(!StringUtils.hasLength(classeurDto.getSlug())){
            errors.add("Le slug du classeur ne doit être vide !");
        }
        if(!StringUtils.hasLength(classeurDto.getNom())){
            errors.add("Le nom du classeur ne doit pas être vide !");
        }
        errors.addAll(RangerValidateur.validate(classeurDto.getRangerDto()));
        return errors;
    }
}
