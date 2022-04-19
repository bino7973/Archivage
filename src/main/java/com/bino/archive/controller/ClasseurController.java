package com.bino.archive.controller;

import com.bino.archive.controller.api.ClasseurApi;
import com.bino.archive.dto.ClasseurDto;
import com.bino.archive.model.Response;
import com.bino.archive.service.implementation.ClasseurServiceImplementation;
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
@RequestMapping(path = "/archive/classeur")
public class ClasseurController implements ClasseurApi {
    @Autowired
    private final ClasseurServiceImplementation classeurServiceImplementation;
    @Override
    public ResponseEntity<Response> save(ClasseurDto classeurDto) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Enregistrement d'un nouveau classeur dans la BDD !")
                        .data(Map.of("classeur", classeurServiceImplementation.save(classeurDto)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findClasseurById(Long idClasseur) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction d'un classeur de la BDD à partir de son id !")
                        .data(Map.of("classeur", classeurServiceImplementation.findClasseurById(idClasseur)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findClasseurBySlug(String slugClasseur) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction d'un classeur à partir de son slug")
                        .data(Map.of("classeur", classeurServiceImplementation.findClasseurBySlug(slugClasseur)))
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
                        .message("Extraction de la liste des classeurs de la BDD !")
                        .data(Map.of("classeur", classeurServiceImplementation.findAll()))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> delete(Long idClasseur) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Suppression d'un classeur à partir de son id !")
                        .data(Map.of("classeur", classeurServiceImplementation.delete(idClasseur)))
                        .build()
        );
    }
}
