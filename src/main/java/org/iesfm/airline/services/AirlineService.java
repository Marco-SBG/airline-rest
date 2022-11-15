package org.iesfm.airline.services;

import org.iesfm.airline.dao.FlightDAO;
import org.iesfm.airline.dao.PassengerDAO;
import org.iesfm.airline.entity.Flight;
import org.iesfm.airline.entity.Passenger;
import org.iesfm.airline.services.exceptions.FlightNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    private FlightDAO flightDAO;

    @Autowired
    private PassengerDAO passengerDAO;

    public List<Flight> list() {
        return flightDAO.list();
    }

    public boolean addFlight(Flight flight) {
        return flightDAO.addFlight(flight);
    }

    public Flight getFlight(int flightId) {
        return flightDAO.getFlight(flightId);
    }

    public boolean deleteFlight(int flightId) {
        return flightDAO.deleteFlight(flightId);
    }

    public List<Passenger> listPassengers(int flightId) throws FlightNotFoundException {
        if(flightDAO.getFlight(flightId) == null) {
            throw new FlightNotFoundException(flightId);
        } else {
            return passengerDAO.listPassengers(flightId);
        }
    }
}
