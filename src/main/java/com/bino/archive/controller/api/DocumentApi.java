package com.bino.archive.controller.api;

import com.bino.archive.dto.DocumentDto;
import com.bino.archive.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DocumentApi {
    @PostMapping(path = "/save")
    ResponseEntity<Response> save(@RequestBody DocumentDto documentDto);

    @GetMapping(value = "/find/all")
    ResponseEntity<Response> findAll();

    @GetMapping(value = "/find/{idDocument}")
    ResponseEntity<Response> findDocumentById(@PathVariable("idDocument") Long idDocument);

    @GetMapping(value = "/find/{slugDocument}")
    ResponseEntity<Response> findDocumentBySlug(@PathVariable("slugDocument") String slugDocument);

    @DeleteMapping(value = "/delete/{idDocument}")
    ResponseEntity<Response> delete(@PathVariable("idDocument") Long idDocument);
}
