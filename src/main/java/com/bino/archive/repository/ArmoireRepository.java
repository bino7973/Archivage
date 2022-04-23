package com.bino.archive.repository;

import com.bino.archive.model.Armoire;
import com.bino.archive.model.Ranger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArmoireRepository extends JpaRepository<Armoire, Long> {
    Optional<Armoire> findBySlug(String slug);

}
