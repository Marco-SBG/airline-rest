package org.iesfm.airline.controllers;

import org.iesfm.airline.entity.Passenger;
import org.iesfm.airline.services.AirlineService;
import org.iesfm.airline.services.exceptions.FlightNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PassengerController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping(path = "/flights/{flightId}/passengers")
    public ResponseEntity<List<Passenger>> getFlightPassengers(
            @PathVariable("flightId") int flightId
    ) {
        try {
            return ResponseEntity.ok(airlineService.listPassengers(flightId));
        } catch (FlightNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
