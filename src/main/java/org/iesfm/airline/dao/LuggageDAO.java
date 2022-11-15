package org.iesfm.airline.dao;

import org.iesfm.airline.entity.Luggage;

import java.util.List;

public interface LuggageDAO {
    List<Luggage> listLuggage(int flightId, String nif);

    boolean existLuggage(int flightId, String nif, int luggageId);

    boolean addLuggage(int flightId, String nif, Luggage luggage);

    Luggage getLuggage(int flightId, String nif, int luggageId);

    boolean updateLuggage(int flightId, String nif, Luggage luggage);
}
