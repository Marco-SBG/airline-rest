package org.iesfm.airline.services.exceptions;

public class FlightNotFoundException extends Exception {
    private final int flightId;

    public FlightNotFoundException(int flightId) {
        this.flightId = flightId;
    }

    public int getFlightId() {
        return flightId;
    }
}
