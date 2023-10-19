package com.tp1_techno_web.serietemporelle.repository;

import com.tp1_techno_web.serietemporelle.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieEventRepository extends JpaRepository<Serie,Long> {
}