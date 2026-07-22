package com.kinantobio.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointOfInterestDTO {

    private Long id;
    private String name;
    private String category;
    private String description;
    private Double latitude;
    private Double longitude;
    private String address;
    private String phone;
    private String website;
    private String openingHours;
    private String imageUrl;
    private Double distanceFromResort;
    private Integer estimatedTravelTimeMinutes;
    private Double rating;
    private Integer reviews;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}