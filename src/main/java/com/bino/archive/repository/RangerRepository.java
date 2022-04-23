package com.bino.archive.repository;

import com.bino.archive.model.Ranger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RangerRepository extends JpaRepository<Ranger, Long> {
    Optional<Ranger> findBySlug(String slug);

    List<Ranger> findRangerByArmoireId(Long armoireId);
}
