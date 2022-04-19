package com.bino.archive.validateur;

import com.bino.archive.dto.ArmoireDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArmoireValidateur {

    public static List<String> validate(ArmoireDto armoireDto){
        List<String> errors = new ArrayList<>();
        if(armoireDto == null){
            errors.addAll(List.of("Le slug de l'armoire ne doit pas être vide !","Le nom de l'armoire ne doit pas être vide !"));
        }

        if(!StringUtils.hasLength(armoireDto.getNom())){
            errors.add("Le nom de l'armoire ne doit pas être vide !");
        }

        if(!StringUtils.hasLength(armoireDto.getSlug())){
            errors.add("Le slug de l'armoire ne doit pas être vide !");
        }

        //To do la validation de la liste des rangers
        return errors;
    }
}
