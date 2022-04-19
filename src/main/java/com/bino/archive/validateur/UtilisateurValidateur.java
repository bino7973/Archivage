package com.bino.archive.validateur;

import com.bino.archive.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidateur {

    public List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();
        if(utilisateurDto == null){
            errors.addAll(
                    List.of("Le slug de l'utilisateur ne doit pas être vide !","Le nom de l'utilisateur ne doit pas être vide !",
                            "Le prénom de l'utilisateur ne doit pas être vide !","L'email de l'utilisateur ne doit pas être vide !",
                            "Le numéro de téléphone de l'utilisateur ne doit pas être vide !","Le mot de passe de l'utilisateur ne doit pas être vide !")
            );
        }
        if(!StringUtils.hasLength(utilisateurDto.getSlug())){
            errors.add("Le slug de l'utilisateur ne doit pas être vide !");
        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Le nom de l'utilisateur ne doit pas être vide !");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Le prénom de l'utilisateur ne doit pas être vide !");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("L'email de l'utilisateur ne doit pas être vide !");
        }
        if(!StringUtils.hasLength(utilisateurDto.getNumeroTelephone())){
            errors.add("Le numéro de l'utilisateur ne doit pas être vide !");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPassword())){
            errors.add("Le mot de passe de l'utilisateur ne doit pas être vide !");
        }
        return errors;
    }
}
