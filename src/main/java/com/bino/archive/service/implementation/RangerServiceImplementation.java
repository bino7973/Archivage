package com.bino.archive.service.implementation;

import com.bino.archive.dto.RangerDto;
import com.bino.archive.exception.EntityNotFoundException;
import com.bino.archive.exception.ErrorCodes;
import com.bino.archive.exception.InvalidEntityException;
import com.bino.archive.model.Ranger;
import com.bino.archive.repository.RangerRepository;
import com.bino.archive.service.RangerService;
import com.bino.archive.validateur.RangerValidateur;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class RangerServiceImplementation implements RangerService {
    @Autowired
    private final RangerRepository rangerRepository;

    @Override
    public RangerDto save(RangerDto rangerDto) {
        List<String> errors = RangerValidateur.validate(rangerDto);
        if(!errors.isEmpty()){
            log.error("Les informations que vous avez fourni sur le ranger ne sont pas valides !");
            throw new InvalidEntityException("Les informations que vous avez fourni sur le ranger ne sont pas valides !", ErrorCodes.RANGER_NOT_VALID, errors);
        }
        log.info("Enregistrement d'un nouveau ranger dans la BDD ! {}", rangerDto);
        return RangerDto.fromEntity(rangerRepository.save(RangerDto.toEntity(rangerDto)));
    }

    @Override
    public RangerDto findRangerById(Long idRanger) {
        if(idRanger == null){
            log.error("L'id du ranger fourni est null");
            return null;
        }
        log.info("Extraction d'un ranger à partir de son id ", idRanger);
        //Ranger ranger = rangerRepository.findById(idRanger).get();
        //log.info("voici le ranger {}", ranger.getArmoire().getId()+"  "+ranger.getArmoire().getSlug()+"   "+ranger.getArmoire().);
        return rangerRepository.findById(idRanger).map(RangerDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("Le ranger avec l'id "+idRanger+" n'a pas été trouvé dans la BDD !",ErrorCodes.RANGER_NOT_FOUND)
        );
    }

    @Override
    public RangerDto findRangerBySlug(String slugRanger) {
        if(!StringUtils.hasLength(slugRanger)){
            log.error("Le slug du ranger founir est null");
            return null;
        }
        log.info("Extraction d'un ranger à partir de son slug {}", slugRanger);
        return rangerRepository.findBySlug(slugRanger).map(RangerDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("Le ranger avec le slug "+slugRanger+" n'a pas été trouvé dans la BDD !", ErrorCodes.RANGER_NOT_FOUND)
        );
    }

    @Override
    public List<RangerDto> findAll() {
        log.info("Extraction de la liste des rangers de la BDD !");
        return rangerRepository.findAll().stream().map(RangerDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Long idRanger) {
        if(idRanger == null){
            log.error("L'id du ranger fourni est null");
            return null;
        }
        log.info("Suppression d'un ranger à partir de son id {}",idRanger);
        rangerRepository.deleteById(idRanger);
        return Boolean.TRUE;
    }

}
