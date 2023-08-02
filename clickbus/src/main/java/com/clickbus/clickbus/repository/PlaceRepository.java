package com.clickbus.clickbus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickbus.clickbus.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}