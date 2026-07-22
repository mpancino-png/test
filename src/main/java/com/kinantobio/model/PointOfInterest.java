package com.kinantobio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "points_of_interest")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PointOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category; // Ristorante, Spiaggia, Museo, Monumento, etc.

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(length = 500)
    private String address;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String website;

    @Column(length = 50)
    private String openingHours; // es. "09:00-17:00"

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "distance_from_resort")
    private Double distanceFromResort; // in km

    @Column(name = "estimated_travel_time")
    private Integer estimatedTravelTimeMinutes; // tempo stimato in minuti

    @Column(nullable = false)
    @Builder.Default
    private Double rating = 0.0; // da 1 a 5 stelle

    @Column(nullable = false)
    @Builder.Default
    private Integer reviews = 0; // numero di recensioni

    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}