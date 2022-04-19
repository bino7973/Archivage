package com.bino.archive.controller;

import com.bino.archive.controller.api.RangerApi;
import com.bino.archive.dto.RangerDto;
import com.bino.archive.model.Response;
import com.bino.archive.service.implementation.RangerServiceImplementation;
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
@RequestMapping(path = "/archive/ranger")
public class RangerController implements RangerApi {
    @Autowired
    private final RangerServiceImplementation rangerServiceImplementation;

    @Override
    public ResponseEntity<Response> save(RangerDto rangerDto) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Enregistrement d'un nouveau ranger dans un armoire")
                        .data(Map.of("ranger", rangerServiceImplementation.save(rangerDto)))
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
                        .message("Extraction de la liste des rangers de la BDD !")
                        .data(Map.of("rangers", rangerServiceImplementation.findAll()))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findById(Long idRanger) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction d'un ranger de la BDD à partir de son id !")
                        .data(Map.of("ranger", rangerServiceImplementation.findRangerById(idRanger)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findBySlug(String slugRanger) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction d'un ranger de la BDD à partir de son slug !")
                        .data(Map.of("ranger", rangerServiceImplementation.findRangerBySlug(slugRanger)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> deleteArmoire(Long idRanger) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Suppression d'un ranger de la BDD à partir de son id !")
                        .data(Map.of("ranger", rangerServiceImplementation.delete(idRanger)))
                        .build()
        );
    }
}
