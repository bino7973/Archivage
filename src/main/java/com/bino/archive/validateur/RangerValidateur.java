package com.bino.archive.validateur;

import com.bino.archive.dto.RangerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RangerValidateur {
    public static List<String> validate(RangerDto rangerDto){
        List<String> errors = new ArrayList<>();
        if(rangerDto == null){
            errors.addAll(List.of("Le slug du ranger ne doit pas être vide !","Le nom de la ranger ne doit pas être vide !","L'armoire de la ranger ne doit pas être vide !"));
        }
        if(!StringUtils.hasLength(rangerDto.getSlug())){
            errors.add("Le slug du ranger ne doit pas être vide !");
        }
        if(!StringUtils.hasLength(rangerDto.getNom())){
            errors.add("Le nom de la ranger ne doit pas être vide !");
        }
        errors.addAll(ArmoireValidateur.validate(rangerDto.getArmoireDto()));
        return errors;
    }
}
