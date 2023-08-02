package com.clickbus.clickbus.model;

import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.github.slugify.Slugify;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "place")
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "slug", nullable = false, length = 80)
    private String slug;

    @Column(name = "city", nullable = false, length = 80)
    private String city;

    @Column(name = "state", nullable = false, length = 80)
    private String state;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, length = 80)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, length = 80)
    private LocalDateTime updatedAt;

    public Place() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        final Slugify slg = Slugify.builder().build();
        this.slug = slg.slugify(name);
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Place)) {
            return false;
        }
        Place place = (Place) o;
        return Objects.equals(id, place.id) && Objects.equals(name, place.name) && Objects.equals(slug, place.slug)
                && Objects.equals(city, place.city) && Objects.equals(state, place.state)
                && Objects.equals(createdAt, place.createdAt) && Objects.equals(updatedAt, place.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slug, city, state, createdAt, updatedAt);
    }

}
