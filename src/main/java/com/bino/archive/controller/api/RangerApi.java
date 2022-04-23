package com.bino.archive.controller.api;

import com.bino.archive.dto.RangerDto;
import com.bino.archive.model.Ranger;
import com.bino.archive.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RangerApi {
    @PostMapping("/save")
    ResponseEntity<Response> save(@RequestBody RangerDto rangerDto);

    @GetMapping(path = "/all")
    ResponseEntity<Response> findAll();

    @GetMapping(path = "/find/{idRanger}")
    ResponseEntity<Response> findById(@PathVariable("idRanger") Long idRanger);

    @GetMapping(path = "/find/slug/{slugRanger}")
    ResponseEntity<Response> findBySlug(@PathVariable("slugRanger") String slugRanger);

    @DeleteMapping(path = "/delete/{idRanger}")
    ResponseEntity<Response> deleteArmoire(@PathVariable("idRanger") Long idRanger);

}
