package com.clickbus.clickbus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clickbus.clickbus.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
  @Query(value = "SELECT * FROM place WHERE name = ?1", nativeQuery = true)
  Optional<Place> findByName(String name);
}