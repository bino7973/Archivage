package com.bino.archive.controller;

import com.bino.archive.controller.api.DocumentApi;
import com.bino.archive.dto.DocumentDto;
import com.bino.archive.model.Response;
import com.bino.archive.service.implementation.DocumentServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/archive/documents")
public class DocumentController implements DocumentApi {
    @Autowired
    private final DocumentServiceImplementation documentServiceImplementation;
    @Override
    public ResponseEntity<Response> save(DocumentDto documentDto) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Enregistrement d'un nouveau document éffectué !")
                        .data(Map.of("document", documentServiceImplementation.save(documentDto)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction de la liste des documents de la BDD !")
                        .data(Map.of("documents", documentServiceImplementation.findAll()))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findDocumentById(Long idDocument) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction d'un document à partir de son id")
                        .data(Map.of("document", documentServiceImplementation.findDocumentById(idDocument)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findDocumentBySlug(String slugDocument) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction d'un document à partir de son slug !")
                        .data(Map.of("document", documentServiceImplementation.findDocumentBySlug(slugDocument)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> delete(Long idDocument) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Suppression d'un document à partir de son id")
                        .data(Map.of("document", documentServiceImplementation.delete(idDocument)))
                        .build()
        );
    }
}
