package com.bino.archive.service;

import com.bino.archive.dto.ClasseurDto;

import java.util.List;

public interface ClasseurService {
    ClasseurDto save(ClasseurDto classeurDto);
    ClasseurDto findClasseurById(Long idClasseur);
    ClasseurDto findClasseurBySlug(String slugClasseur);
    List<ClasseurDto> findAll();
    Boolean delete(Long idClasseur);
}
