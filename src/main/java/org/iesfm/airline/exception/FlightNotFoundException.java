package org.iesfm.airline.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.StandardException;

public class FlightNotFoundException extends Exception{

    private int flightId;

    public FlightNotFoundException(int flightId) {
        this.flightId = flightId;
    }

    public int getFlightId() {
        return flightId;
    }
}
