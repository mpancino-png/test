package com.kinantobio.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Servizio per calcoli geografici e mappe
 */
@Service
@Slf4j
public class MapCalculationService {

    /**
     * Calcola la distanza tra due coordinate usando la formula di Haversine
     * @param lat1 Latitudine punto 1
     * @param lon1 Longitudine punto 1
     * @param lat2 Latitudine punto 2
     * @param lon2 Longitudine punto 2
     * @return Distanza in chilometri
     */
    public Double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        final int EARTH_RADIUS = 6371; // Raggio della Terra in km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        log.debug("Distanza calcolata: {} km", distance);
        return Math.round(distance * 100.0) / 100.0; // Arrotonda a 2 decimali
    }

    /**
     * Stima il tempo di viaggio in auto (approssimativo)
     * Assume una velocità media di 60 km/h
     * @param distanceKm Distanza in km
     * @return Tempo stimato in minuti
     */
    public Integer estimateTravelTime(Double distanceKm) {
        if (distanceKm == null || distanceKm <= 0) {
            return 0;
        }
        // Velocità media: 60 km/h
        double travelTimeHours = distanceKm / 60.0;
        return (int) Math.ceil(travelTimeHours * 60); // Converti in minuti
    }

}