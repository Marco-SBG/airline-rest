package org.iesfm.airline.controllers;

import org.iesfm.airline.entity.Flight;
import org.iesfm.airline.entity.Passenger;
import org.iesfm.airline.exception.FlightNotFoundException;
import org.iesfm.airline.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PassengerController {
    @Autowired
    private AirlineService airlineService;

    @GetMapping(path = "/flights/{flightId}/passengers")
    public ResponseEntity<List<Passenger>> getPassengersFromFlight(@PathVariable("flightId") int flightId){
        try {
            return ResponseEntity.ok(airlineService.listPassengersFromFlight(flightId));
        } catch (FlightNotFoundException e) {
           return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(path = "/flights/{flightId}/passengers")
    public ResponseEntity<Void> addPassenger(@PathVariable("flightId") int flightId, @Valid @RequestBody Passenger passenger){
        try {
            if(!airlineService.addPassenger(passenger, flightId)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            } else {
                return ResponseEntity.ok().build();
            }
        } catch (FlightNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
