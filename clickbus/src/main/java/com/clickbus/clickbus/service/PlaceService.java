package com.clickbus.clickbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickbus.clickbus.model.Place;
import com.clickbus.clickbus.repository.PlaceRepository;

@Service
public class PlaceService {
    @Autowired
    PlaceRepository repository;

    public Place create(Place place) {
        return repository.save(place);
    }

    public List<Place> findAll() {
        return repository.findAll();
    }

    public Place findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Place not found!"));
    }

    public Place update(Place place) {
        Place entity = repository.findById(place.getId()).orElseThrow(() -> new RuntimeException("Place not Found!"));
        entity.setName(place.getName());
        entity.setCity(place.getCity());
        entity.setState(place.getState());
        return repository.save(entity);
    }

    public void delete(Long id) {
        Place entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Place not Found!"));
        repository.delete(entity);
    }

}
