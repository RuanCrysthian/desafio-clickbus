package com.clickbus.clickbus.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlaceTest {
  private Place place;

  @BeforeEach
  public void setUp() {
    place = new Place();
    place.setId(1L);
    place.setName("Sample Place");
    place.setCity("Sample City");
    place.setState("Sample State");
    place.setCreatedAt(LocalDateTime.now());
    place.setUpdatedAt(LocalDateTime.now());
  }

  @Test
  public void testGettersAndSetters() {
    assertEquals(1L, place.getId());
    assertEquals("Sample Place", place.getName());
    assertEquals("sample-place", place.getSlug());
    assertEquals("Sample City", place.getCity());
    assertEquals("Sample State", place.getState());
    assertNotNull(place.getCreatedAt());
    assertNotNull(place.getUpdatedAt());
  }

  @Test
  public void testEqualsAndHashCode() {
    Place samePlace = new Place();
    samePlace.setId(1L);
    samePlace.setName("Sample Place");
    samePlace.setCity("Sample City");
    samePlace.setState("Sample State");
    samePlace.setCreatedAt(place.getCreatedAt());
    samePlace.setUpdatedAt(place.getUpdatedAt());

    Place differentPlace = new Place();
    differentPlace.setId(2L);
    differentPlace.setName("Different Place");
    differentPlace.setCity("Different City");
    differentPlace.setState("Different State");
    differentPlace.setCreatedAt(LocalDateTime.now());
    differentPlace.setUpdatedAt(LocalDateTime.now());

    assertTrue(place.equals(samePlace));
    assertFalse(place.equals(differentPlace));
    assertEquals(place.hashCode(), samePlace.hashCode());
    assertNotEquals(place.hashCode(), differentPlace.hashCode());
  }
}
