package alokhin.flight.interfaces;

import alokhin.flight.entities.Objects.Reservation;

public interface Check {
    Reservation checkReservation(String code);
}
