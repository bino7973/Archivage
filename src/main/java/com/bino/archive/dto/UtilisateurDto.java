package com.bino.archive.dto;
import com.bino.archive.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto {

    private Long id;

    private String nom;

    private String slug;


    private String prenom;

    private String email;

    private String numeroTelephone;

    private String password;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .slug(utilisateur.getSlug())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .numeroTelephone(utilisateur.getNumeroTelephone())
                .password(utilisateur.getPassword())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setSlug(utilisateurDto.getSlug());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setNumeroTelephone(utilisateurDto.getNumeroTelephone());
        utilisateur.setPassword(utilisateurDto.getPassword());
        return utilisateur;
    }
}
