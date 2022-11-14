package org.iesfm.airline.dao;

import org.iesfm.airline.entity.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PassengerDAO {
    List<Passenger> listPassengers(String flightId);

    Passenger getPassengers(String flightId, String nif);

    boolean existPassenger(String flightId, String nif);

    boolean deletePassenger(String flightId, String nif);

    boolean addPassenger(String flightId, Passenger passenger);

    boolean updatePassenger(String flightNumber, Passenger passenger);

}
