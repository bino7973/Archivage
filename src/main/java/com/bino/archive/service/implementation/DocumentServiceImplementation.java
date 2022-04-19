package com.bino.archive.service.implementation;

import com.bino.archive.dto.DocumentDto;
import com.bino.archive.exception.EntityNotFoundException;
import com.bino.archive.exception.ErrorCodes;
import com.bino.archive.exception.InvalidEntityException;
import com.bino.archive.repository.DocumentRepository;
import com.bino.archive.service.DocumentService;
import com.bino.archive.validateur.DocumentValidateur;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DocumentServiceImplementation implements DocumentService {
    @Autowired
    private final DocumentRepository documentRepository;

    @Override
    public DocumentDto save(DocumentDto documentDto) {
        List<String> errors = DocumentValidateur.validate(documentDto);
        if(!errors.isEmpty()){
            log.error("Les informations du document fournies ne sont pas valides ! {}", documentDto);
            throw new InvalidEntityException("Les informations du document fournies ne sont pas valides !", ErrorCodes.DOCUMENT_NOT_VALID, errors);
        }
        log.info("Enregistrement d'un nouveau document dans la BDD ! {}", documentDto);
        return DocumentDto.fromEntity(documentRepository.save(DocumentDto.toEntity(documentDto)));
    }

    @Override
    public List<DocumentDto> findAll() {
        log.info("Extraction de la liste des document de la BDD !");
        return documentRepository.findAll().stream().map(DocumentDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public DocumentDto findDocumentById(Long idDocument) {
        if(idDocument == null){
            log.error("L'id du document fourni est null");
            return null;
        }
        log.info("Extraction d'un document à partir de son id {}", idDocument);
        return documentRepository.findById(idDocument).map(DocumentDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("Le document avec l'id "+idDocument+" n'existe pas dans la BDD !", ErrorCodes.DOCUMENT_NOT_FOUND)
        );
    }

    @Override
    public DocumentDto findDocumentBySlug(String slugDocument) {
        if(slugDocument == null){
            log.error("Le slug du document fourni est null");
            return null;
        }
        log.info("Extraction d'un document à partir de son slug {}", slugDocument);
        return documentRepository.findDocumentBySlug(slugDocument).map(DocumentDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("Le document avec le slug "+slugDocument+" n'existe pas dans la BDD !", ErrorCodes.DOCUMENT_NOT_FOUND)
        );
    }

    @Override
    public Boolean delete(Long idDocument) {
        if(idDocument == null){
            log.error("L'id du document fourni est null");
            return false;
        }
        documentRepository.deleteById(idDocument);
        return Boolean.TRUE;
    }
}
