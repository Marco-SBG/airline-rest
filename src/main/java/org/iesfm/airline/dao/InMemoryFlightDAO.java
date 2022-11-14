package org.iesfm.airline.dao;

import org.iesfm.airline.entity.Flight;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryFlightDAO implements FlightDAO {
    private Map<Integer, Flight> flights = new HashMap<>();

    @Override
    public List<Flight> list() {
        return new LinkedList<>(
                flights.values()
        );
    }
    @Override
    public boolean addFlight(Flight flight) {
        if (flights.containsKey(flight.getId())) {
            return false;
        } else {
            flights.put(flight.getId(), flight);
            return true;
        }
    }
    @Override
    public Flight getFlight(int flightId) {
        return flights.get(flightId);
    }
    @Override
    public boolean deleteFlight(int flightId) {
        if(flights.containsKey(flightId)) {
            flights.remove(flightId);
            return true;
        } else {
            return false;
        }
    }
}
