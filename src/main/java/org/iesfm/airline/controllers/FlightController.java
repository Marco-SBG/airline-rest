package org.iesfm.airline.controllers;

import org.iesfm.airline.entity.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class FlightController {

    private Map<Integer, Flight> flights = new HashMap<>();

    @GetMapping(path = "/flights")
    public List<Flight> list() {
        return new LinkedList<>(
                flights.values()
        );
    }

    @PostMapping(path = "/flights")
    public void addFlight(@RequestBody Flight flight) {
        flights.put(flight.getId(), flight);
    }
}
