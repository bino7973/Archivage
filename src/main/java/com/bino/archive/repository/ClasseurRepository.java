package com.bino.archive.repository;

import com.bino.archive.model.Classeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClasseurRepository extends JpaRepository<Classeur, Long> {
    Optional<Classeur> findClasseurBySlug(String slugClasseur);
}
