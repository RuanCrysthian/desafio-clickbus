package com.clickbus.clickbus.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.clickbus.clickbus.model.Place;
import com.clickbus.clickbus.service.PlaceService;

public class PlaceControllerTest {
  @Mock
  private PlaceService placeService;

  @InjectMocks
  private PlaceController placeController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testCreate() {
    // Mock data
    Place place = new Place();
    place.setName("Test Place");

    when(placeService.create(any(Place.class))).thenReturn(place);

    // Perform the test
    Place createdPlace = placeController.create(place);

    // Assertions
    assertEquals("Test Place", createdPlace.getName());
    verify(placeService, times(1)).create(any(Place.class));
  }

  @Test
  public void testFindAll() {
    // Mock data
    Place place1 = new Place();
    place1.setName("Place 1");
    Place place2 = new Place();
    place2.setName("Place 2");
    List<Place> places = Arrays.asList(place1, place2);

    when(placeService.findAll()).thenReturn(places);

    // Perform the test
    List<Place> result = placeController.findAll();

    // Assertions
    assertEquals(2, result.size());
    assertEquals("Place 1", result.get(0).getName());
    assertEquals("Place 2", result.get(1).getName());
    verify(placeService, times(1)).findAll();
  }

  @Test
  public void testFindById() throws Exception {
    // Mock data
    Long id = 1L;
    Place place = new Place();
    place.setId(id);
    place.setName("Test Place");

    when(placeService.findById(id)).thenReturn(place);

    // Perform the test
    Place foundPlace = placeController.findById(id);

    // Assertions
    assertEquals(id, foundPlace.getId());
    assertEquals("Test Place", foundPlace.getName());
    verify(placeService, times(1)).findById(id);
  }

  @Test
  public void testFindByName() throws Exception {
    // Mock data
    String name = "test name";
    Place place = new Place();
    place.setName(name);
    when(placeService.findByName(name)).thenReturn(place);

    // Perform the test
    Place foundPlace = placeController.findByName(name);

    // Assertions
    assertEquals(name, foundPlace.getName());
    assertEquals("test name", foundPlace.getName());
    verify(placeService, times(1)).findByName(name);
  }

  @Test
  public void testUpdate() {
    // Mock data
    Place place = new Place();
    place.setName("Test Place");

    when(placeService.update(any(Place.class))).thenReturn(place);

    // Perform the test
    Place updatedPlace = placeController.update(place);

    // Assertions
    assertEquals("Test Place", updatedPlace.getName());
    verify(placeService, times(1)).update(any(Place.class));
  }

  @Test
  public void testDelete() {
    // Mock data
    Long id = 1L;

    // Perform the test
    ResponseEntity<?> response = placeController.delete(id);

    // Assertions
    assertEquals(HttpStatus.OK, response.getStatusCode());
    verify(placeService, times(1)).delete(id);
  }
}
