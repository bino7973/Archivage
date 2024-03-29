package com.bino.archive.service.implementation;

import com.bino.archive.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UtilisateurServiceImplementation {
    @Autowired
    private final UtilisateurRepository utilisateurRepository;
}
