package com.bino.archive.service;

import com.bino.archive.dto.ArmoireDto;

import java.util.List;

public interface ArmoireService {
    ArmoireDto save(ArmoireDto armoireDto);
    List<ArmoireDto> findAll();
    ArmoireDto findById(Long idArmoire);
    ArmoireDto findBySlug(String slugArmoire);
    Boolean deleteArmoire(Long idArmoire);
}
