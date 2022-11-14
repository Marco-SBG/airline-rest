package org.iesfm.airline.dao;

import org.iesfm.airline.entity.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PassengerDAO {
    List<Passenger> listPassengers(int flightId);

    Passenger getPassengers(int flightId, String nif);

    boolean existPassenger(int flightId, String nif);

    boolean deletePassenger(int flightId, String nif);

    boolean addPassenger(int flightId, Passenger passenger);

    boolean updatePassenger(int flightId, Passenger passenger);

}
