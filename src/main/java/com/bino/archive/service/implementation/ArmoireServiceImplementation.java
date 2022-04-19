package com.bino.archive.service.implementation;

import com.bino.archive.dto.ArmoireDto;
import com.bino.archive.exception.EntityNotFoundException;
import com.bino.archive.exception.ErrorCodes;
import com.bino.archive.exception.InvalidEntityException;
import com.bino.archive.repository.ArmoireRepository;
import com.bino.archive.service.ArmoireService;
import com.bino.archive.validateur.ArmoireValidateur;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ArmoireServiceImplementation implements ArmoireService {
    @Autowired
    private final ArmoireRepository armoireRepository;

    @Override
    public ArmoireDto save(ArmoireDto armoireDto) {
        List<String> errors = ArmoireValidateur.validate(armoireDto);
        if(!errors.isEmpty()){
            log.error("Les informations de l'armoire fournies ne sont pas valides !");
            throw new InvalidEntityException("Les informations de l'armoire fournies ne sont pas valides !", ErrorCodes.ARMOIRE_NOT_VALID, errors);
        }
        log.info("Ajout d'un nouveau armoire dans la BDD {}", armoireDto);
        return ArmoireDto.fromEntity(armoireRepository.save(ArmoireDto.toEntity(armoireDto)));
    }

    @Override
    public List<ArmoireDto> findAll() {
        log.info("Extraction de la liste des armoires dans la BDD");
        return armoireRepository.findAll().stream().map(ArmoireDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public ArmoireDto findById(Long idArmoire) {
        if(idArmoire == null){
            log.error("L'id de l'armoire précisé est null");
            return null;
        }
        log.info("Extraction d'un armoire dans la BDD à partir de son id {}", idArmoire);
        return ArmoireDto.fromEntity(armoireRepository.findById(idArmoire).orElseThrow(
                ()-> new EntityNotFoundException("L'armoire avec l'id "+idArmoire+" n'a pas été trouvé dans la BDD !")
        ));
    }

    @Override
    public ArmoireDto findBySlug(String slugArmoire) {
        if(slugArmoire.length() == 0){
            log.error("Le slug de l'armoire précisé est null");
            return null;
        }
        log.info("Extraction d'un armoire dans la BDD à partir de son slug {}", slugArmoire);
        return ArmoireDto.fromEntity(armoireRepository.findBySlug(slugArmoire).orElseThrow(
                ()-> new EntityNotFoundException("L'armoire avec le slug "+slugArmoire+" n'a pas été trouvé dans la BDD !")
        ));
    }

    @Override
    public Boolean deleteArmoire(Long idArmoire) {
        if(idArmoire == null){
            log.error("L'id de l'armoire précisé est null");
            return Boolean.FALSE;
        }
        log.info("Suppression d'un armoire de la BDD à partir de son id {}", idArmoire);
        armoireRepository.deleteById(idArmoire);
        return Boolean.TRUE;
    }
}
