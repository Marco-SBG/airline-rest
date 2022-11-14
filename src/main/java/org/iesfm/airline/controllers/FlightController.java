package org.iesfm.airline.controllers;

import org.iesfm.airline.entity.Flight;
import org.iesfm.airline.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping(path = "/flights")
    public ResponseEntity<List<Flight>> list() {
        return ResponseEntity.ok(airlineService.list());
    }

    @PostMapping(path = "/flights")
    public ResponseEntity<Void> addFlight(@Valid @RequestBody Flight flight) {
        if(!airlineService.addFlight(flight)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping(path = "/flights/{flightId}")
    public ResponseEntity<Flight> getFlight(@PathVariable("flightId") int flightId) {
        Flight flight = airlineService.getFlight(flightId);
        if(flight != null) {
            return ResponseEntity.ok(flight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/flights/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") int flightId) {
        if(airlineService.deleteFlight(flightId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
