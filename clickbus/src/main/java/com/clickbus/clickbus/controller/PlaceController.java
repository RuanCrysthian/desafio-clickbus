package com.clickbus.clickbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickbus.clickbus.model.Place;
import com.clickbus.clickbus.service.PlaceService;

@RestController
@RequestMapping("/places")
@Qualifier("placeController")
public class PlaceController {

    @Autowired
    private PlaceService service;

    @PostMapping
    public Place create(@RequestBody Place place) {
        return service.create(place);
    }

    @GetMapping
    public List<Place> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Place findById(@PathVariable(value = "id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    public Place findByName(@PathVariable(value = "name") String name) throws Exception {
        return service.findByName(name);
    }

    @PutMapping
    public Place update(@RequestBody Place place) {
        return service.update(place);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
