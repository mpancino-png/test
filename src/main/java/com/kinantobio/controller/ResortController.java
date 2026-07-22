package com.kinantobio.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/resort")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class ResortController {

    @Value("${kinantobio.resort.name}")
    private String resortName;

    @Value("${kinantobio.resort.location}")
    private String resortLocation;

    @Value("${kinantobio.resort.latitude}")
    private Double resortLatitude;

    @Value("${kinantobio.resort.longitude}")
    private Double resortLongitude;

    @Value("${kinantobio.resort.description}")
    private String resortDescription;

    /**
     * Ottiene informazioni generali del resort
     */
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getResortInfo() {
        log.info("GET /resort/info - Recuperando informazioni del resort");
        
        Map<String, Object> resortInfo = new HashMap<>();
        resortInfo.put("name", resortName);
        resortInfo.put("location", resortLocation);
        resortInfo.put("description", resortDescription);
        resortInfo.put("latitude", resortLatitude);
        resortInfo.put("longitude", resortLongitude);

        return ResponseEntity.ok(resortInfo);
    }

    /**
     * Ottiene le coordinate del resort
     */
    @GetMapping("/coordinates")
    public ResponseEntity<Map<String, Double>> getResortCoordinates() {
        log.info("GET /resort/coordinates - Recuperando coordinate del resort");
        
        Map<String, Double> coordinates = new HashMap<>();
        coordinates.put("latitude", resortLatitude);
        coordinates.put("longitude", resortLongitude);

        return ResponseEntity.ok(coordinates);
    }

    /**
     * Health check
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        log.info("GET /resort/health - Health check");
        
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("message", "Kinantobio Resort Guest Guide is running");

        return ResponseEntity.ok(health);
    }

}