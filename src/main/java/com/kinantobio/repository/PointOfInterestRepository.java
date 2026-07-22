package com.kinantobio.repository;

import com.kinantobio.model.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

    // Trova tutti i punti di interesse attivi
    List<PointOfInterest> findByActiveTrue();

    // Trova per categoria
    List<PointOfInterest> findByCategoryAndActiveTrue(String category);

    // Cerca per nome
    List<PointOfInterest> findByNameContainingIgneCaseAndActiveTrue(String name);

    // Trova per raggio di distanza dal resort
    @Query("SELECT p FROM PointOfInterest p WHERE p.active = true AND p.distanceFromResort <= :maxDistance ORDER BY p.distanceFromResort ASC")
    List<PointOfInterest> findNearby(@Param("maxDistance") Double maxDistance);

    // Trova i migliori rating
    @Query("SELECT p FROM PointOfInterest p WHERE p.active = true ORDER BY p.rating DESC LIMIT :limit")
    List<PointOfInterest> findTopRated(@Param("limit") Integer limit);

    // Conta per categoria
    Integer countByCategoryAndActiveTrue(String category);

}