package org.iesfm.airline.dao;

import org.iesfm.airline.entity.Luggage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryLuggageDAO implements LuggageDAO {
    private Map<Integer, Map<String, Map<Integer, Luggage>>> luggage = new HashMap<>();


    @Override
    public List<Luggage> listLuggage(int flightId, String nif) {
        return new ArrayList<>(getLuggage(flightId, nif).values());
    }


    @Override
    public boolean existLuggage(int flightId, String nif, int luggageId) {
        return getLuggage(flightId, nif).containsKey(luggageId);
    }


    @Override
    public boolean addLuggage(int flightId, String nif, Luggage luggage) {
        if (existLuggage(flightId, nif, luggage.getId())) {
            return false;
        } else {
            getLuggage(flightId, nif).put(luggage.getId(), luggage);
            return true;
        }
    }

    @Override
    public Luggage getLuggage(int flightId, String nif, int luggageId) {
        return getLuggage(flightId, nif).get(luggageId);
    }


    @Override
    public boolean updateLuggage(int flightId, String nif, Luggage luggage) {
        if (existLuggage(flightId, nif, luggage.getId())) {
            getLuggage(flightId, nif).put(luggage.getId(), luggage);
            return true;
        } else {
            return false;
        }
    }

    private Map<Integer, Luggage> getLuggage(int flightId, String nif) {
        luggage.putIfAbsent(flightId, new HashMap<>());
        luggage.get(flightId).putIfAbsent(nif, new HashMap<>());
        return luggage.get(flightId).get(nif);
    }
}
