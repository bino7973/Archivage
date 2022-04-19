package com.bino.archive.controller.api;

import com.bino.archive.dto.ClasseurDto;
import com.bino.archive.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClasseurApi {
    @PostMapping("/save")
    ResponseEntity<Response> save(@RequestBody ClasseurDto classeurDto);
    @GetMapping(path = "/find/{idClasseur}")
    ResponseEntity<Response> findClasseurById(@PathVariable("idClasseur") Long idClasseur);
    @GetMapping(path = "/find/slug/{slugClasseur}")
    ResponseEntity<Response> findClasseurBySlug(@PathVariable("slugClasseur") String slugClasseur);
    @GetMapping(path = "/find/all")
    ResponseEntity<Response> findAll();
    @DeleteMapping(path = "/delete/{idClasseur}")
    ResponseEntity<Response> delete(@PathVariable("idClasseur") Long idClasseur);
}
