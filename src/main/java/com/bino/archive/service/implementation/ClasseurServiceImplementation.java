package com.bino.archive.service.implementation;

import com.bino.archive.dto.ClasseurDto;
import com.bino.archive.exception.EntityNotFoundException;
import com.bino.archive.exception.ErrorCodes;
import com.bino.archive.exception.InvalidEntityException;
import com.bino.archive.repository.ClasseurRepository;
import com.bino.archive.service.ClasseurService;
import com.bino.archive.validateur.ClasseurValidateur;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ClasseurServiceImplementation implements ClasseurService {
    @Autowired
    private final ClasseurRepository classeurRepository;

    @Override
    public ClasseurDto save(ClasseurDto classeurDto) {
        List<String> errors = ClasseurValidateur.validate(classeurDto);
        if(!errors.isEmpty()){
            log.error("Les informations du classeur fournies ne sont pas valides {}", classeurDto);
            throw new InvalidEntityException("Les informations du classeur fournies ne sont pas valides !", ErrorCodes.CLASSEUR_NOT_VALID, errors);
        }
        log.info("Enregistrement d'un nouveau classeur dans la BDD {}", classeurDto);
        return ClasseurDto.fromEntity(classeurRepository.save(ClasseurDto.toEntity(classeurDto)));
    }

    @Override
    public ClasseurDto findClasseurById(Long idClasseur) {
        if(idClasseur == null){
            log.error("L'id du classeur fournie est null");
            return null;
        }
        log.info("Extraction d'un classeur de la BDD à partir de son id {}", idClasseur);
        return classeurRepository.findById(idClasseur).map(ClasseurDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("Le classeur avec l'id "+idClasseur+" n'existe pas dans la BDD !", ErrorCodes.CLASSEUR_NOT_FOUND)
        );
    }

    @Override
    public ClasseurDto findClasseurBySlug(String slugClasseur) {
        if(slugClasseur == null){
            log.error("Le slug du classeur fournie est null");
            return null;
        }
        log.info("Extraction d'un classeur de la BDD à partir de son slug {}", slugClasseur);
        return classeurRepository.findClasseurBySlug(slugClasseur).map(ClasseurDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("Le classeur avec le slug "+slugClasseur+" n'existe pas dans la BDD !", ErrorCodes.CLASSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<ClasseurDto> findAll() {
        log.info("Extraction de la liste des classeurs de la BDD !");
        return classeurRepository.findAll().stream().map(ClasseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Long idClasseur) {
        if(idClasseur == null){
            log.error("L'id du classeur fournie est null");
            return null;
        }
        log.info("Suppression d'un classeur à partir de son id {}", idClasseur);
        classeurRepository.deleteById(idClasseur);
        return Boolean.TRUE;
    }
}
