package com.bino.archive.controller;

import com.bino.archive.controller.api.ArmoireApi;
import com.bino.archive.dto.ArmoireDto;
import com.bino.archive.model.Response;
import com.bino.archive.service.implementation.ArmoireServiceImplementation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/archive/armoires")
@Slf4j
public class ArmoireController implements ArmoireApi {
    @Autowired
    private final ArmoireServiceImplementation armoireServiceImplementation;

    @Override
    public ResponseEntity<Response> save(ArmoireDto armoireDto) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Enrégistrement d'un nouveau armoire dans la BDD !")
                        .data(Map.of("armoire", armoireServiceImplementation.save(armoireDto)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findAll() {
        //return armoireServiceImplementation.findAll();
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction de la liste des armoires dans la BDD !")
                        .data(Map.of("armoires", armoireServiceImplementation.findAll()))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findById(Long idArmoire) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction d'un armoire à partir de son id "+idArmoire)
                        .data(Map.of("armoire", armoireServiceImplementation.findById(idArmoire)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> findBySlug(String slugArmoire) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Extraction d'un armoire à partir de son slug "+slugArmoire)
                        .data(Map.of("armoire", armoireServiceImplementation.findBySlug(slugArmoire)))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> deleteArmoire(Long idArmoire) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Suppression d'un armoire à partir de son id = "+idArmoire+" éffectuée avec succes !")
                        .data(Map.of("armoire", armoireServiceImplementation.deleteArmoire(idArmoire)))
                        .build()
        );
    }
}
