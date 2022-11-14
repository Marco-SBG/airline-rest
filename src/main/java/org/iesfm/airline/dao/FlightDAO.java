package org.iesfm.airline.dao;

import org.iesfm.airline.entity.Flight;

import java.util.List;

public interface FlightDAO {
    List<Flight> list();

    boolean addFlight(Flight flight);

    Flight getFlight(int flightId);

    boolean deleteFlight(int flightId);
}
