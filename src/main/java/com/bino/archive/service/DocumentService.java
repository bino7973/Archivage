package com.bino.archive.service;

import com.bino.archive.dto.DocumentDto;

import java.util.List;

public interface DocumentService {
    DocumentDto save(DocumentDto documentDto);
    List<DocumentDto> findAll();
    DocumentDto findDocumentById(Long idDocument);
    DocumentDto findDocumentBySlug(String slugDocument);
    Boolean delete(Long idDocument);
}
