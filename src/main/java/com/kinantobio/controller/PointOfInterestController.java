package com.kinantobio.controller;

import com.kinantobio.model.dto.PointOfInterestDTO;
import com.kinantobio.service.PointOfInterestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/points-of-interest")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class PointOfInterestController {

    private final PointOfInterestService service;

    /**
     * Recupera tutti i punti di interesse
     */
    @GetMapping
    public ResponseEntity<List<PointOfInterestDTO>> getAllPoints() {
        log.info("GET /points-of-interest - Recuperando tutti i punti");
        List<PointOfInterestDTO> points = service.getAllPointsOfInterest();
        return ResponseEntity.ok(points);
    }

    /**
     * Recupera un punto di interesse per ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<PointOfInterestDTO> getPointById(@PathVariable Long id) {
        log.info("GET /points-of-interest/{} - Recuperando punto per ID", id);
        PointOfInterestDTO point = service.getPointById(id);
        if (point == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(point);
    }

    /**
     * Recupera punti di interesse per categoria
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<PointOfInterestDTO>> getByCategory(@PathVariable String category) {
        log.info("GET /points-of-interest/category/{} - Recuperando per categoria", category);
        List<PointOfInterestDTO> points = service.getPointsByCategory(category);
        return ResponseEntity.ok(points);
    }

    /**
     * Cerca punti di interesse per nome
     */
    @GetMapping("/search")
    public ResponseEntity<List<PointOfInterestDTO>> search(@RequestParam String name) {
        log.info("GET /points-of-interest/search - Cercando: {}", name);
        List<PointOfInterestDTO> points = service.searchByName(name);
        return ResponseEntity.ok(points);
    }

    /**
     * Recupera punti di interesse nelle vicinanze
     */
    @GetMapping("/nearby")
    public ResponseEntity<List<PointOfInterestDTO>> getNearby(@RequestParam Double maxDistance) {
        log.info("GET /points-of-interest/nearby - Punti entro {} km", maxDistance);
        List<PointOfInterestDTO> points = service.getNearbyPoints(maxDistance);
        return ResponseEntity.ok(points);
    }

    /**
     * Recupera i migliori punti di interesse
     */
    @GetMapping("/top-rated")
    public ResponseEntity<List<PointOfInterestDTO>> getTopRated(@RequestParam(defaultValue = "10") Integer limit) {
        log.info("GET /points-of-interest/top-rated - Recuperando i {} migliori", limit);
        List<PointOfInterestDTO> points = service.getTopRatedPoints(limit);
        return ResponseEntity.ok(points);
    }

    /**
     * Crea un nuovo punto di interesse
     */
    @PostMapping
    public ResponseEntity<PointOfInterestDTO> createPoint(@RequestBody PointOfInterestDTO dto) {
        log.info("POST /points-of-interest - Creando nuovo punto: {}", dto.getName());
        PointOfInterestDTO created = service.createPoint(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Aggiorna un punto di interesse
     */
    @PutMapping("/{id}")
    public ResponseEntity<PointOfInterestDTO> updatePoint(@PathVariable Long id, @RequestBody PointOfInterestDTO dto) {
        log.info("PUT /points-of-interest/{} - Aggiornando punto", id);
        PointOfInterestDTO updated = service.updatePoint(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    /**
     * Elimina un punto di interesse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoint(@PathVariable Long id) {
        log.info("DELETE /points-of-interest/{} - Eliminando punto", id);
        service.deletePoint(id);
        return ResponseEntity.noContent().build();
    }

}