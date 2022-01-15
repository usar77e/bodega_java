package com.bodega.backend.repository;

import com.bodega.backend.model.Perfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfiles, Integer> {
}
