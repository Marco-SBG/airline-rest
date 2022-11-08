package org.iesfm.airline.services;

import org.iesfm.airline.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {
    private Map<Integer, Flight> flights = new HashMap<>();

    public List<Flight> list() {
        return new LinkedList<>(
                flights.values()
        );
    }

    public boolean addFlight(Flight flight) {
        if (flights.containsKey(flight.getId())) {
            return false;
        } else {
            flights.put(flight.getId(), flight);
            return true;
        }
    }

    public Flight getFlight(int flightId) {
        return flights.get(flightId);
    }

    public boolean deleteFlight(int flightId) {
        if(flights.containsKey(flightId)) {
            flights.remove(flightId);
            return true;
        } else {
            return false;
        }
    }
}
