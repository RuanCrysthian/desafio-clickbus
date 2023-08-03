package com.clickbus.clickbus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.clickbus.clickbus.model.Place;
import com.clickbus.clickbus.repository.PlaceRepository;

public class PlaceServiceTest {

  @Mock
  private PlaceRepository repository;

  @InjectMocks
  private PlaceService placeService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCreate() {
    // Arrange
    Place placeToCreate = new Place(1L, "Test Place", "Test City", "Test State");
    when(repository.save(any(Place.class))).thenReturn(placeToCreate);

    // Act
    Place createdPlace = placeService.create(placeToCreate);

    // Assert
    assertNotNull(createdPlace);
    assertEquals(placeToCreate, createdPlace);
  }

  @Test
  public void testFindAll() {
    // Arrange
    List<Place> placeList = new ArrayList<>();
    placeList.add(new Place(1L, "Place 1", "City 1", "State 1"));
    placeList.add(new Place(2L, "Place 2", "City 2", "State 2"));
    when(repository.findAll()).thenReturn(placeList);

    // Act
    List<Place> result = placeService.findAll();

    // Assert
    assertNotNull(result);
    assertEquals(placeList.size(), result.size());
    assertEquals(placeList, result);
  }

  @Test
  public void testFindById_existingId() {
    // Arrange
    Long existingId = 1L;
    Place existingPlace = new Place(existingId, "Test Place", "Test City", "Test State");
    when(repository.findById(existingId)).thenReturn(Optional.of(existingPlace));

    // Act
    Place foundPlace = placeService.findById(existingId);

    // Assert
    assertNotNull(foundPlace);
    assertEquals(existingId, foundPlace.getId());
  }

  @Test
  public void testFindById_nonExistingId() {
    // Arrange
    Long nonExistingId = 999L;
    when(repository.findById(nonExistingId)).thenReturn(Optional.empty());

    // Act & Assert
    assertThrows(RuntimeException.class, () -> placeService.findById(nonExistingId));
  }

  @Test
  public void testUpdate() {
    // Arrange
    Long existingId = 1L;
    Place existingPlace = new Place(existingId, "Test Place", "Test City", "Test State");
    when(repository.findById(existingId)).thenReturn(Optional.of(existingPlace));
    when(repository.save(any(Place.class))).thenReturn(existingPlace);

    Place updatedPlace = new Place(existingId, "Updated Place", "Updated City", "Updated State");

    // Act
    Place result = placeService.update(updatedPlace);

    // Assert
    assertNotNull(result);
    assertEquals(updatedPlace.getName(), result.getName());
    assertEquals(updatedPlace.getCity(), result.getCity());
    assertEquals(updatedPlace.getState(), result.getState());
  }

  @Test
  public void testDelete() {
    // Arrange
    Long existingId = 1L;
    Place existingPlace = new Place(existingId, "Test Place", "Test City", "Test State");
    when(repository.findById(existingId)).thenReturn(Optional.of(existingPlace));

    // Act
    placeService.delete(existingId);

    // Assert (verify that the delete method is called with the correct entity)
    verify(repository, times(1)).delete(existingPlace);
  }
}
