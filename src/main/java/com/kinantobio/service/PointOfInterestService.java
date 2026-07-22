package com.kinantobio.service;

import com.kinantobio.model.PointOfInterest;
import com.kinantobio.model.dto.PointOfInterestDTO;
import com.kinantobio.repository.PointOfInterestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PointOfInterestService {

    private final PointOfInterestRepository repository;
    private final MapCalculationService mapService;

    /**
     * Recupera tutti i punti di interesse attivi
     */
    public List<PointOfInterestDTO> getAllPointsOfInterest() {
        log.info("Recuperando tutti i punti di interesse attivi");
        return repository.findByActiveTrue()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recupera punti di interesse per categoria
     */
    public List<PointOfInterestDTO> getPointsByCategory(String category) {
        log.info("Recuperando punti di interesse per categoria: {}", category);
        return repository.findByCategoryAndActiveTrue(category)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Cerca punti di interesse per nome
     */
    public List<PointOfInterestDTO> searchByName(String name) {
        log.info("Cercando punti di interesse per nome: {}", name);
        return repository.findByNameContainingIgneCaseAndActiveTrue(name)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recupera punti di interesse nelle vicinanze
     */
    public List<PointOfInterestDTO> getNearbyPoints(Double maxDistance) {
        log.info("Recuperando punti di interesse entro {} km", maxDistance);
        return repository.findNearby(maxDistance)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recupera i migliori punti di interesse per rating
     */
    public List<PointOfInterestDTO> getTopRatedPoints(Integer limit) {
        log.info("Recuperando i {} punti di interesse con migliore rating", limit);
        return repository.findTopRated(limit)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recupera un singolo punto di interesse
     */
    @Transactional(readOnly = true)
    public PointOfInterestDTO getPointById(Long id) {
        log.info("Recuperando punto di interesse con ID: {}", id);
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    /**
     * Crea un nuovo punto di interesse
     */
    public PointOfInterestDTO createPoint(PointOfInterestDTO dto) {
        log.info("Creando nuovo punto di interesse: {}", dto.getName());
        PointOfInterest poi = convertToEntity(dto);
        PointOfInterest saved = repository.save(poi);
        return convertToDTO(saved);
    }

    /**
     * Aggiorna un punto di interesse
     */
    public PointOfInterestDTO updatePoint(Long id, PointOfInterestDTO dto) {
        log.info("Aggiornando punto di interesse con ID: {}", id);
        return repository.findById(id)
                .map(poi -> {
                    updateEntity(poi, dto);
                    PointOfInterest updated = repository.save(poi);
                    return convertToDTO(updated);
                })
                .orElse(null);
    }

    /**
     * Elimina un punto di interesse (soft delete)
     */
    public void deletePoint(Long id) {
        log.info("Eliminando punto di interesse con ID: {}", id);
        repository.findById(id)
                .ifPresent(poi -> {
                    poi.setActive(false);
                    repository.save(poi);
                });
    }

    /**
     * Calcola la distanza da un punto a un altro utilizzando la formula di Haversine
     */
    public Double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        return mapService.calculateDistance(lat1, lon1, lat2, lon2);
    }

    /**
     * Converte un'entità PointOfInterest in DTO
     */
    private PointOfInterestDTO convertToDTO(PointOfInterest poi) {
        return PointOfInterestDTO.builder()
                .id(poi.getId())
                .name(poi.getName())
                .category(poi.getCategory())
                .description(poi.getDescription())
                .latitude(poi.getLatitude())
                .longitude(poi.getLongitude())
                .address(poi.getAddress())
                .phone(poi.getPhone())
                .website(poi.getWebsite())
                .openingHours(poi.getOpeningHours())
                .imageUrl(poi.getImageUrl())
                .distanceFromResort(poi.getDistanceFromResort())
                .estimatedTravelTimeMinutes(poi.getEstimatedTravelTimeMinutes())
                .rating(poi.getRating())
                .reviews(poi.getReviews())
                .active(poi.getActive())
                .createdAt(poi.getCreatedAt())
                .updatedAt(poi.getUpdatedAt())
                .build();
    }

    /**
     * Converte un DTO in un'entità PointOfInterest
     */
    private PointOfInterest convertToEntity(PointOfInterestDTO dto) {
        return PointOfInterest.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .website(dto.getWebsite())
                .openingHours(dto.getOpeningHours())
                .imageUrl(dto.getImageUrl())
                .distanceFromResort(dto.getDistanceFromResort())
                .estimatedTravelTimeMinutes(dto.getEstimatedTravelTimeMinutes())
                .rating(dto.getRating() != null ? dto.getRating() : 0.0)
                .reviews(dto.getReviews() != null ? dto.getReviews() : 0)
                .active(true)
                .build();
    }

    /**
     * Aggiorna i campi di un'entità
     */
    private void updateEntity(PointOfInterest poi, PointOfInterestDTO dto) {
        if (dto.getName() != null) poi.setName(dto.getName());
        if (dto.getCategory() != null) poi.setCategory(dto.getCategory());
        if (dto.getDescription() != null) poi.setDescription(dto.getDescription());
        if (dto.getLatitude() != null) poi.setLatitude(dto.getLatitude());
        if (dto.getLongitude() != null) poi.setLongitude(dto.getLongitude());
        if (dto.getAddress() != null) poi.setAddress(dto.getAddress());
        if (dto.getPhone() != null) poi.setPhone(dto.getPhone());
        if (dto.getWebsite() != null) poi.setWebsite(dto.getWebsite());
        if (dto.getOpeningHours() != null) poi.setOpeningHours(dto.getOpeningHours());
        if (dto.getImageUrl() != null) poi.setImageUrl(dto.getImageUrl());
        if (dto.getDistanceFromResort() != null) poi.setDistanceFromResort(dto.getDistanceFromResort());
        if (dto.getEstimatedTravelTimeMinutes() != null) poi.setEstimatedTravelTimeMinutes(dto.getEstimatedTravelTimeMinutes());
        if (dto.getRating() != null) poi.setRating(dto.getRating());
        if (dto.getReviews() != null) poi.setReviews(dto.getReviews());
    }

}