package com.bino.archive.service;

import com.bino.archive.dto.RangerDto;
import com.bino.archive.model.Ranger;

import java.util.List;

public interface RangerService {
    RangerDto save(RangerDto rangerDto);
    RangerDto findRangerById(Long idRanger);
    RangerDto findRangerBySlug(String slugRanger);
    List<RangerDto> findAll();
    Boolean delete(Long idRanger);
}
