package com.bino.archive.controller.api;

import com.bino.archive.dto.RangerDto;
import com.bino.archive.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RangerApi {
    @PostMapping("/save")
    ResponseEntity<Response> save(@RequestBody RangerDto rangerDto);

    @GetMapping(path = "/all")
    ResponseEntity<Response> findAll();

    @GetMapping(path = "/find/{idArmoire}")
    ResponseEntity<Response> findById(@PathVariable("idArmoire") Long idRanger);

    @GetMapping(path = "/find/slug/{slugArmoire}")
    ResponseEntity<Response> findBySlug(@PathVariable("slugArmoire") String slugRanger);

    @DeleteMapping(path = "/delete/{idArmoire}")
    ResponseEntity<Response> deleteArmoire(@PathVariable("idArmoire") Long idRanger);
}
