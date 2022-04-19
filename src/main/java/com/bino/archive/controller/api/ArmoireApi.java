package com.bino.archive.controller.api;

import com.bino.archive.dto.ArmoireDto;
import com.bino.archive.model.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ArmoireApi {
    @PostMapping(value = "/save")
    ResponseEntity<Response> save(@RequestBody ArmoireDto armoireDto);

    @GetMapping(path = "/all")
    ResponseEntity<Response> findAll();

    @GetMapping(value = "/find/{idArmoire}")
    ResponseEntity<Response> findById(@PathVariable("idArmoire") Long idArmoire);

    @GetMapping(value = "/find/slug/{slugArmoire}")
    ResponseEntity<Response> findBySlug(@PathVariable("slugArmoire") String slugArmoire);

    @DeleteMapping(value = "/delete/{idArmoire}")
    ResponseEntity<Response> deleteArmoire(Long idArmoire);
}
